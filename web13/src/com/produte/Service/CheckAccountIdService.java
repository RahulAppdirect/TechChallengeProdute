package com.produte.Service;

import com.produte.Domain.TableData;
import com.produte.dao.CheckAccountIdDao;
import com.produte.dao.InsertData;

public class CheckAccountIdService {
	
	public int checkAccountIdService(TableData tb)
	{
		if(new CheckAccountIdDao().checkAccountIdDao(tb)==0)
		{
		  new InsertData().insertDataDao(tb);
		  return 0;
		}
		
		return 1;
		
	}

}
