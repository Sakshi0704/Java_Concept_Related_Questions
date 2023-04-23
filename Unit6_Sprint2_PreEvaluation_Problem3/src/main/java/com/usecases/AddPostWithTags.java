package com.usecases;

import java.sql.Timestamp;
import javax.persistence.EntityManager;
import com.dao.PostTagDao;
import com.dao.PostTagDaoImpl;
import com.entities.Post;
import com.entities.Tags;
import com.exceptions.PostNotFoundException;
import com.utility.EMUtil;

public class AddPostWithTags {
	public static void main(String args[]) {
		
		EntityManager em = EMUtil.getConnection();
		
		Post post = new Post();
		post.setTitle("Sleepy");
		post.setDescription("In Exam I am feeling sleepy beacause of length question");
		post.setPostedAt(new Timestamp(System.currentTimeMillis()));
		post.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
	
		Tags tag1 = new Tags();
		tag1.setTagName("#Sleepy");
		tag1.getPostList().add(post);
		post.getList().add(tag1);
		
		Tags tag2 = new Tags();
		tag2.setTagName("#Gotala");
		tag2.getPostList().add(post);
		post.getList().add(tag2);
		
		Tags tag3 = new Tags();
		tag3.setTagName("#Atiyachar");
		tag3.getPostList().add(post);
		post.getList().add(tag3);
		
		Tags tag4 = new Tags();
		tag4.setTagName("#hala bol");
		tag4.getPostList().add(post);
		post.getList().add(tag4);
		
		
		Tags tag5 = new Tags();
		tag5.setTagName("#Fully ready");
		tag5.getPostList().add(post);
		post.getList().add(tag5);
		
		
		
		
		PostTagDao ptDao = new PostTagDaoImpl();
		
		try {
			ptDao.addPost(post);
			System.out.println("Add Succussfully");
		} catch (PostNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}
