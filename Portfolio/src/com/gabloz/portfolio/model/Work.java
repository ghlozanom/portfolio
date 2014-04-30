package com.gabloz.portfolio.model;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.datanucleus.api.jpa.annotations.Extension;

import com.gabloz.common.helper.DescriptionHelper;
import com.gabloz.model.Description;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Entity(name = "Work")
public class Work {
	
	private static final String PRESENT = "Present";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;
	
	private String company;
	private Date initialDate;
	private Date finalDate;
	private String position;
	private boolean current;
	
	@Basic
	@Extension(vendorName = "datanucleus",
				key = "gae.parent-pk",
				value = "true")
	private String user;
	
	@Transient
	private boolean latestUserWork = false;
	
	
	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}
	
	public String getIdString(){
		return KeyFactory.keyToString(getId());
	}

	public List<Description> getDescriptions(){
		return DescriptionHelper.getInstance().getDescriptions(getIdString());
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean isLatestUserWork() {
		return latestUserWork;
	}

	public void setLatestUserWork(boolean latestUserWork) {
		this.latestUserWork = latestUserWork;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}
	
	public String getInitialDateYear(){
		return getMonthYearDateString(initialDate);
	}
	
	public String getFinalDateYear(){
		
		//This is the case that this work represents the current job
		if(finalDate == null){
			return PRESENT;
		}
		return getMonthYearDateString(finalDate);
	}

	private String getMonthYearDateString(Date date) {
		
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		String month = months[dateCal.get(Calendar.MONTH)];
		return month + " " + dateCal.get(Calendar.YEAR);
	}
	


}
