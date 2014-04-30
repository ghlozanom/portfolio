package com.gabloz.portfolio.web.helper;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabloz.portfolio.common.PortfolioConstants;
import com.gabloz.portfolio.common.exceptions.PortfolioBusinessException;
import com.gabloz.portfolio.common.exceptions.PortfolioBusinessWarningException;
import com.gabloz.portfolio.common.helper.EmploymentHelper;
import com.gabloz.portfolio.common.helper.MessageHelper;
import com.gabloz.portfolio.model.Work;
import com.google.appengine.api.datastore.KeyFactory;


/**
 * Web helper to manage Emplyment
 * 
 * @author Gabriel Lozano
 *
 */
public class EmploymentWebHelper {
	
	private static final String WORKS = "works";
	private static final String COMPANY = "company";
	private static final String INITIAL_DATE = "initialDate";
	private static final String FINAL_DATE = "finalDate";
	private static final String POSITION = "position";
	private static final String CURRENT = "current";
	private static EmploymentWebHelper instance = null;
	
	private EmploymentWebHelper(){
	}

	public static EmploymentWebHelper getInstance() {
		if(instance == null ){
			instance =new EmploymentWebHelper();
		}
		return instance;
	}

	public void getEmployment(HttpServletRequest request) {
		
		//Sets the works in the datastore in the corresponding attribute
		request.setAttribute(WORKS, EmploymentHelper.getInstance().getWorks());
	}

	public void saveWork(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Work work = new Work();
		String idString = request.getParameter(WebHelper.ID);
		if( idString != null ){
			work.setId(KeyFactory.stringToKey(idString));
		}
		
		work.setCompany(request.getParameter(COMPANY));
		try {
			String initialDateInputParam = request.getParameter(INITIAL_DATE);
			if( initialDateInputParam != null && !"".equals(initialDateInputParam) ){
				work.setInitialDate(PortfolioConstants.simpleDateFormatter.parse(initialDateInputParam));
			}
			String current = request.getParameter(CURRENT);
			if(current != null && current.equals(CURRENT)){
				work.setCurrent(true);
			}else {
				String finalDateInputParam = request.getParameter(FINAL_DATE);
				if( finalDateInputParam != null && !"".equals(finalDateInputParam) ){
					work.setFinalDate(PortfolioConstants.simpleDateFormatter.parse(finalDateInputParam));
				}
			}
			work.setPosition(request.getParameter(POSITION));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			EmploymentHelper.getInstance().saveWork(work);
			response.getWriter().write(MessageHelper.WORK_UPDATED_SUCCESS);
		} catch (PortfolioBusinessWarningException e) {
			response.getWriter().write(e.getMessageKey());
		} catch (PortfolioBusinessException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write(MessageHelper.getInstance().getMessageForKey(e.getMessageKey()));
			response.flushBuffer();	
		}
		
	}

	public void deleteWork(HttpServletRequest request,
			HttpServletResponse response) {
		
		String idString = request.getParameter(WebHelper.ID);
		EmploymentHelper.getInstance().deleteWork(idString);
		
	}

}
