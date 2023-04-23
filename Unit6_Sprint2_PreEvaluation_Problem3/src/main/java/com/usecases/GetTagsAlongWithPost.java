package com.usecases;

import javax.persistence.EntityManager;
import com.dao.PostTagDao;
import com.dao.PostTagDaoImpl;
import com.entities.Tags;
import com.exceptions.TagNotFoundException;
import com.utility.EMUtil;

public class GetTagsAlongWithPost {
	public static void main(String args[]) {
		
		EntityManager em = EMUtil.getConnection();
		
		PostTagDao ptDao = new PostTagDaoImpl();
		
		try {
			Tags tag = ptDao.getTags(1);
			System.out.println(tag);
			tag.getPostList().forEach(l -> System.out.println(l));
		} catch ( TagNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}
