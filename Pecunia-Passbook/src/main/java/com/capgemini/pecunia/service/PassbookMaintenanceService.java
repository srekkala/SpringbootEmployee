package com.capgemini.pecunia.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.pecunia.entities.Transactions;
import com.capgemini.pecunia.exceptions.IdNotFound;

public interface PassbookMaintenanceService {

	public List<Transactions> updatePassbook(String accountId) throws IdNotFound;
	
	public void updatelastUpdated(String accountId);

	public List<Transactions> accountSummary(String accountId, Date startDate, Date endDate) throws IdNotFound;
	
	public boolean accountValidation(String accountId);

}
