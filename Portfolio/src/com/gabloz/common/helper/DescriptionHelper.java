package com.gabloz.common.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.gabloz.controler.jpa.EMF;
import com.gabloz.model.Description;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class DescriptionHelper {
	
	private static DescriptionHelper instance;
	
	private static final String OWNER_USER_PARAMETER = "ownerUser";
	private static final String DESCRIPTIONS_QUERY = "SELECT d FROM Description d where owner = :" + OWNER_USER_PARAMETER + " ORDER BY sort ASC";

	private static final int EMPTY_SORT = 0;

	private static final String EMPTY_MESSAGE = "Please insert a description !!!";

	private static final String DESCRIPTIONS_WITH_PARENT_QUERY = "DELETE FROM Description d WHERE owner = :" + 
			OWNER_USER_PARAMETER;
	
	public static DescriptionHelper getInstance() {
		if(instance == null ){
			instance = new DescriptionHelper();
		}
		return instance;
	}

	public List<Description> getDescriptions(String owner) {
		
		EntityManager em = null;
		
		em = EMF.get().createEntityManager();
		
		//I put the logic of get descriptions outside because I needed in other methods
		//and I have to pass the entity manager for managing transactions
		List<Description> descriptions = getDescriptions(em, owner);
		
		return descriptions;
	}
	
	private List<Description> getDescriptions(EntityManager em, String owner) {
		
		Query descriptionnsQuery = em.createQuery(DESCRIPTIONS_QUERY);
		descriptionnsQuery.setParameter(OWNER_USER_PARAMETER, owner );
		
		@SuppressWarnings("unchecked")
		List<Description> descriptions = (List<Description>)descriptionnsQuery.getResultList();
		
		return descriptions;
	}

	/*
	 * The 'Description' will always have an owner. That means a description will be save from outside,
	 * and for this reason I decided to receive an entity manager.
	 * 
	 */
	public void saveDescription(EntityManager em, Description description) {
			em.persist(description);
	}

	public void saveEmptyDescription(EntityManager em, Key id) {
		
		Description description = new Description();
		description.setOwner(KeyFactory.keyToString(id));
		description.setSort(EMPTY_SORT);
		description.setDescription(EMPTY_MESSAGE);
		
		saveDescription(em, description);
		
	}

	public String loadDescriptionValue(String descriptionId) {
		
		EntityManager em = EMF.get().createEntityManager();
		Description description = loadDescription(em, descriptionId);
		
		return description.getDescription();
	}

	private Description loadDescription(EntityManager em, String descriptionId) {
		
		return em.find(Description.class, descriptionId);
		
	}

	public String saveDescription(String descriptionId, String descriptionNewValue) {
		
		EntityManager em = EMF.get().createEntityManager();
		try {
			Description description = loadDescription(em, descriptionId);
			description.setDescription(descriptionNewValue);
			saveDescription(em, description);
		} finally {
			em.close();
		}
		
		return descriptionNewValue;
	}

	public void addDescription(String parentId) {
		
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		try {
			List<Description> descriptions = getDescriptions(em, parentId);
			int sort = EMPTY_SORT + 1;
			for(Description description : descriptions) {
				description.setSort(sort++);
			}
			saveEmptyDescription(em, KeyFactory.stringToKey(parentId));
			
			txn.commit();
		} finally {
			if(txn.isActive()){
				txn.rollback();
			}
			em.close();
		}
		
	}

	public String updateOrder(String[] descriptionIds) {
		
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		try{
			int order = 0;
			for(String descriptionId : descriptionIds ){
				Description description = loadDescription(em, descriptionId);
				description.setSort(order++);
				saveDescription(em, description);
			}
			txn.commit();
		} finally {
			if(txn.isActive()){
				txn.rollback();
			}
		}
		return null;
	}

	public void removeDescription(String descriptionId) {
		
		EntityManager em = EMF.get().createEntityManager();
		try{
			Description description = loadDescription(em, descriptionId);
			em.remove(description);
		} finally {
			em.close();
		}

	}

	public void deleteDescriptionsWithParent(EntityManager em, String owner) {
		
		Query deleteDescriptionsWithParentQuery = em.createQuery(DESCRIPTIONS_WITH_PARENT_QUERY);
		deleteDescriptionsWithParentQuery.setParameter(OWNER_USER_PARAMETER, owner );
		
		deleteDescriptionsWithParentQuery.executeUpdate();
		
	}	
	

}
