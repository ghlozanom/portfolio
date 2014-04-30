package com.gabloz.description.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabloz.common.helper.DescriptionHelper;
import com.gabloz.description.common.helper.DescriptionMessageHelper;
import com.gabloz.description.web.helper.DescriptionWebHelper;
import com.gabloz.portfolio.web.helper.WebHelper;

@SuppressWarnings("serial")
public class DescriptionServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String descriptionId = req.getParameter(WebHelper.ID);
		resp.getWriter().write(DescriptionHelper.getInstance().loadDescriptionValue(descriptionId));
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String descriptionId = req.getParameter(WebHelper.ID);
		String description = req.getParameter(WebHelper.VALUE);
		String operation = req.getParameter(WebHelper.OPERATION);
		String parentId = req.getParameter(DescriptionWebHelper.ParentId);
		
		String[] descriptionIds = req.getParameterValues("listItem[]");
		
		if(WebHelper.ADD.equals(operation)){
			DescriptionHelper.getInstance().addDescription(parentId);
			resp.getWriter().write(DescriptionMessageHelper.DESC_UPDATED_SUCCESS);
		}else if( WebHelper.UPDATE.equals(operation)){
			resp.getWriter().write(DescriptionHelper.getInstance().saveDescription(descriptionId, description));
		}else if( DescriptionWebHelper.UPDATE_ORDER.equals(operation)){
			DescriptionHelper.getInstance().updateOrder(descriptionIds);
		}else if( DescriptionWebHelper.REMOVE_DESCRIPTION.equals(operation)){
			DescriptionHelper.getInstance().removeDescription(descriptionId);
		}
		
	}		
	
}
