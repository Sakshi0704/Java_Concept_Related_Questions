package com.usecases;

import javax.persistence.EntityManager;
import com.dao.PostTagDao;
import com.dao.PostTagDaoImpl;
import com.entities.Post;
import com.exceptions.PostNotFoundException;
import com.utility.EMUtil;

public class GetPostAlongWithTags {
	public static void main(String args[]) {
		
		EntityManager em = EMUtil.getConnection();
		
		
		PostTagDao ptDao = new PostTagDaoImpl();
		
		try {
			Post post = ptDao.getPost(1);
			System.out.println(post);
			post.getList().forEach(l -> System.out.println(l));
		} catch (PostNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}
