package com.capgemini.pecunia.service;

import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.pecunia.dao.PassbookMaintenanceDAO;
import com.capgemini.pecunia.entities.Account;
import com.capgemini.pecunia.entities.Transactions;

@Service
@Transactional
public class PassbookMaintenanceServiceImpl implements PassbookMaintenanceService{

	Account account=new Account();
	long millis=System.currentTimeMillis();  
	Date date=new Date(millis); 
	
	@Autowired
	private PassbookMaintenanceDAO dao;
	
	@Override
	public List<Transactions> updatePassbook(String accountId) {
		boolean res=accountValidation(accountId);
		if(res==true) {
			List<Transactions> result=dao.updatePassbook(accountId);
			updatelastUpdated(accountId);
			return result;	
		}
		else {
			return null;
		}
	}
	
	@Override
	public void updatelastUpdated(String accountId) {
		 dao.update(accountId,date);
	}
	
	@Override
	public List<Transactions> accountSummary(String accountId, Date startDate, Date endDate) {
		boolean res=accountValidation(accountId);
		if(res==true) {
			return dao.accountSummary(accountId, startDate, endDate);
		}
		else {
			return null;
		}
	}

	
	//Implementation of Account validation method. 
		@Override
		public boolean accountValidation(String accountId) {
			 account=dao.getOne(accountId);
			if(account==null) {
				return false;
			}
			else {
				return true;
			}
			
		}
	
	
}
