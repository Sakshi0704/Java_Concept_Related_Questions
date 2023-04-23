package com.usecases;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.dao.PostTagDao;
import com.dao.PostTagDaoImpl;
import com.entities.Post;
import com.entities.Tags;
import com.exceptions.PostNotFoundException;
import com.exceptions.TagNotFoundException;
import com.utility.EMUtil;

public class Demo {
		public static void main(String args[]) {
			
			EntityManager em = EMUtil.getConnection();
			
			
		
			
			try {
				
			} catch ( Exception e) {
				System.out.println(e.getMessage());
			}
	
		}

}
