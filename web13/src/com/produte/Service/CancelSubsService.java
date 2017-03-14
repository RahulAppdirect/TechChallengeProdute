package com.produte.Service;

import com.produte.Domain.TableData;
import com.produte.dao.DeleteData;

public class CancelSubsService {
	
	public int cancelSub(TableData tb)
	{
		int i = new DeleteData().deleteInfo(tb);
		return i;
	}

}
