package ravi.model;

public class ReturnData {
	
	boolean success;
	long acctID;
	
	public ReturnData()
	{
		success = false;
		acctID = 678L;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getAcctID() {
		return acctID;
	}

	public void setAcctID(long acctID) {
		this.acctID = acctID;
	}

}
