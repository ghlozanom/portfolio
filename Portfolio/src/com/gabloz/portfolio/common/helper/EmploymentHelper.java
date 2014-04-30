package com.gabloz.portfolio.common.helper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.gabloz.common.helper.DescriptionHelper;
import com.gabloz.controler.jpa.EMF;
import com.gabloz.portfolio.common.exceptions.PortfolioBusinessException;
import com.gabloz.portfolio.common.exceptions.PortfolioBusinessWarningException;
import com.gabloz.portfolio.model.Work;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Provides helper methods to work with Employment 
 * 
 * @author      Gabriel Lozano
 * */
public class EmploymentHelper {
	
	private static final String OWNER_USER_PARAMETER = "ownerUser";
	private static final String WORKS_QUERY = "SELECT w FROM Work w where user = :" + OWNER_USER_PARAMETER + " ORDER BY initialDate DESC";
	private static final String GABRIEL = "Gabriel";
	private static final String USER = "User";
	private static final String EXISTS_CURRENT_WORK_QUERY = "SELECT w FROM Work w where user = :" + OWNER_USER_PARAMETER 
			+ " and current = :current";
	
	private static EmploymentHelper instance;
	
	public static EmploymentHelper getInstance() {
		if(instance == null ){
			instance = new EmploymentHelper();
		}
		return instance;
	}

	public List<Work> getWorks() {
		
		EntityManager em = null;
		
		em = EMF.get().createEntityManager();
		Query worksQuery = em.createQuery(WORKS_QUERY);
		worksQuery.setParameter(OWNER_USER_PARAMETER, KeyFactory.createKeyString(USER, GABRIEL) );
		
		@SuppressWarnings("unchecked")
		List<Work> works = (List<Work>)worksQuery.getResultList();
		
		//sets the first work as the latest user work
		if(works != null && works.size() > 0 ){
			Work latestUserWork = works.get(0);
			latestUserWork.setLatestUserWork(true);
		}
		return works;
	}
	
	public boolean existsCurrentWork(){
		EntityManager em = EMF.get().createEntityManager();
		Query existsCurrentWorkQuery = em.createQuery(EXISTS_CURRENT_WORK_QUERY);
		existsCurrentWorkQuery.setParameter("current", true);
		existsCurrentWorkQuery.setParameter(OWNER_USER_PARAMETER, KeyFactory.createKeyString(USER, GABRIEL) );
		existsCurrentWorkQuery.setMaxResults(1);
		
		//Why not getSingleResult() see http://sysout.be/2011/03/09/why-you-should-never-use-getsingleresult-in-jpa/
		@SuppressWarnings("unchecked")
		List<Work> currentWorks = existsCurrentWorkQuery.getResultList();
		if( currentWorks != null && !currentWorks.isEmpty() ){
			return true;
		}
		return false;
	}	


	public void saveWork(Work work) throws PortfolioBusinessException, PortfolioBusinessWarningException {
		
		Work latestUserWork = getLatestUserWork();
		
		if(work.isCurrent()){
			
			if(existsCurrentWork()){
				throw new PortfolioBusinessException(MessageHelper.CURRENT_WORK_EXISTS);
			}			
			
			if( work.getId() == null && work.getInitialDate().before(latestUserWork.getInitialDate()) ){
				throw new PortfolioBusinessException(MessageHelper.CURRENT_WORK_EXISTS);
			}
			if( work.getId() != null && !work.getId().equals(latestUserWork.getId() ) ) 
			{
				//Solo el ultimo puede ser el current
				throw new PortfolioBusinessException(MessageHelper.CURRENT_WORK_EXISTS);
			}
			if( work.getId() != null && work.getId().equals(latestUserWork.getId() ) 
					&& work.getInitialDate().before(latestUserWork.getInitialDate()) ) 
			{
				//Si la fecha del ultimo cambio, entonces hay que buscar que aun sea el ultimo
				Work nextWork = getWorkAfter(work.getInitialDate());
				if(nextWork != null && !nextWork.getId().equals(latestUserWork.getId()) ){
					throw new PortfolioBusinessException(MessageHelper.CURRENT_WORK_EXISTS);
				}
			}			
			
		}else {
			if(work.getFinalDate() == null ){
				// If the work is not the current one, must have a final date
				// TODO PONER VALIDACION QUE ES
				throw new PortfolioBusinessException(MessageHelper.FINAL_DATE_CAN_NOT_EMPTY);
			}
		}
		if(work.getFinalDate() != null ){
			if( !work.getFinalDate().after(work.getInitialDate() ) ){
				throw new PortfolioBusinessException(MessageHelper.FINAL_DATE_NOT_AFTER_INIT_DATE);
			}
		}
		
		if( latestUserWork != null && !work.getInitialDate().before(latestUserWork.getInitialDate()) ){
			throw new PortfolioBusinessException(MessageHelper.INIT_DATE_NOT_BEFORE_INITIAL_DATE_CURRENT_WORK);
		}
		
		boolean newWork = false; 
		if(work.getId() == null){
			//This is called only with new works
			newWork = true;
			work.setUser( KeyFactory.createKeyString(USER, GABRIEL)  );
		}
		
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		try{
			em.persist(work);
			
			if(newWork){
				//I need the Id of the new work to add a description, see:
				//http://stackoverflow.com/questions/9649515/how-to-get-id-of-last-persisted-entity-using-jpa
				em.flush();
				DescriptionHelper.getInstance().saveEmptyDescription(em, work.getId());
			}
			txn.commit();
		} finally {
			if(txn.isActive()){
				txn.rollback();
			}			
			if(em != null ){
				em.close();
			}
		}
		
		//This is here because it is a warning. The job was saved even with in this conditions
		
		Work previousWork = getWorkBefore(work.getInitialDate());
		
		if(previousWork != null ){
			if( work.getInitialDate().before(previousWork.getFinalDate()) ){
				throw new PortfolioBusinessWarningException(MessageHelper.INITIAL_DATE_BEFORE_PREVIOUS_WORK_FINAL_DATE);
			}
		}
		
		Work nextWork = getWorkAfter(work.getInitialDate());
		if(nextWork != null ){
			if( work.getFinalDate().after(nextWork.getInitialDate()) ){
				throw new PortfolioBusinessWarningException(MessageHelper.FINAL_DATE_AFTER_NEXT_WORK_INITIAL_DATE);
			}
		}
		
	}

	private Work getLatestUserWork() {
			
		EntityManager em = null;
		
		em = EMF.get().createEntityManager();
		Query worksQuery = em.createQuery(WORKS_QUERY);
		worksQuery.setParameter(OWNER_USER_PARAMETER, KeyFactory.createKeyString(USER, GABRIEL) );
		worksQuery.setMaxResults(1);
		
		@SuppressWarnings("unchecked")
		List<Work> works = (List<Work>)worksQuery.getResultList();
		
		//sets the first work as the latest user work
		if(works != null && works.size() > 0 ){
			return works.get(0);
		}
		return null;
	}

	private Work getWorkAfter(Date initialDate) {
		
		EntityManager em = null;
		
		em = EMF.get().createEntityManager();
		Query nextWorkQuery = em.createQuery("select w from Work w "
				+ "where initialDate > :initialDateParam "
				+ " and user = :ownerUser "
				+ " ORDER BY initialDate ASC ");
		nextWorkQuery.setParameter("ownerUser",  KeyFactory.createKeyString(USER, GABRIEL) );
		nextWorkQuery.setParameter("initialDateParam", initialDate);
		nextWorkQuery.setMaxResults(1);
		
		@SuppressWarnings("unchecked")
		List<Work> works = (List<Work>)nextWorkQuery.getResultList();
		if(works == null || works.size() == 0 ){
			return null;
		}
		return (Work)works.get(0);
		
	}

	private Work getWorkBefore(Date initialDate) {
		
		EntityManager em = null;
		
		em = EMF.get().createEntityManager();
		Query previousWorkQuery = em.createQuery("select w from Work w "
				+ "where initialDate < :initialDateParam "
				+ " and user = :ownerUser "
				+ " ORDER BY initialDate DESC ");
		previousWorkQuery.setParameter("ownerUser",  KeyFactory.createKeyString(USER, GABRIEL) );
		previousWorkQuery.setParameter("initialDateParam", initialDate);
		previousWorkQuery.setMaxResults(1);
		
		@SuppressWarnings("unchecked")
		List<Work> works = (List<Work>)previousWorkQuery.getResultList();
		if(works == null || works.size() == 0 ){
			return null;
		}
		return (Work)works.get(0);
		
	}

	public void deleteWork(String idString) {
		
		EntityManager em = EMF.get().createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		try {
			DescriptionHelper.getInstance().deleteDescriptionsWithParent(em, idString);
			
			Work work = loadWork(em, idString);
			em.remove(work);
			
			txn.commit();
		} finally {
			if(txn.isActive()){
				txn.rollback();
			}			
			if(em != null ){
				em.close();
			}
		}	
		
	}
	
	private Work loadWork(EntityManager em, String workId) {
		
		return em.find(Work.class, workId);
		
	}	
	
	
}
