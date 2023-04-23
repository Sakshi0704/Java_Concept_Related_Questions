package com.util;

import com.dao.ConsultancyDAO;
import com.dao.ConsultancyDAOJdbcImpl;
import com.dao.ConsultancyDaoOrmImpl;
import com.exceptions.SomethingWentWrong;

public class GetJob {

	public static ConsultancyDAO getInstanceofCounsultancyDAO(String approach) throws SomethingWentWrong{
	
		
			if(approach.equals("ORM")) {
				return new ConsultancyDaoOrmImpl();
			}
			else if(approach.equals("JDBC")) {
				return new ConsultancyDAOJdbcImpl();
			}
			else {
				throw new SomethingWentWrong("Wrong input given");
			}
	}
	
}
