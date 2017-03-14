package com.produte.Domain;

public class ReturnData {
	//String success;
	boolean success;
	String accountIdentifier;
	String errorCode;
	String message;
//	public String getSuccess() {
//		return success;
//	}
//	public void setSuccess(String success) {
//		this.success = success;
//	}
	public String getAccountIdentifier() {
		return accountIdentifier;
	}
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
