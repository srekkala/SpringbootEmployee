package com.capgemini.pecunia.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.capgemini.pecunia.entities.Transactions;
import com.capgemini.pecunia.service.PassbookMaintenanceService;

public class PassbookController {
	
	@Autowired
	private PassbookMaintenanceService service;

	
	//Fetching the transactions till last updated date
	@GetMapping("/updatePassbook/{accountId}")
	public  ResponseEntity<List<Transactions>> updatePassbook(@PathVariable("accountId") String accountId)
	{
		List<Transactions> list = service.updatePassbook(accountId);
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	//Fetching transactions between two dates
	@GetMapping("/accountSummary/{accountId}/{startDate}/{endDate}")
	public ResponseEntity<List<Transactions>> accountSummary(@PathVariable String accountId, @PathVariable Date startDate, @PathVariable Date endDate) 
	{
		List<Transactions> list = service.accountSummary(accountId, startDate, endDate);
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}
		
	//Exception handler for wrong input
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Please enter Valid details")
	@ExceptionHandler({Exception.class})
	public void handleException() {
		
	}
}
