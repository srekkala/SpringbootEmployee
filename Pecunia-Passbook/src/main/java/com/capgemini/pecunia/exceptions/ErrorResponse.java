package com.capgemini.pecunia.exceptions;

public class ErrorResponse {
		
		private final int errorCode;
	    private final String errorMessage;
	  
		public int getErrorCode() {
			return errorCode;
		}
		public String getErrorMessage() {
			return errorMessage;
		}
		public ErrorResponse(int errorCode, String errorMessage) {
			super();
			this.errorCode = errorCode;
			this.errorMessage = errorMessage;
		}

}
