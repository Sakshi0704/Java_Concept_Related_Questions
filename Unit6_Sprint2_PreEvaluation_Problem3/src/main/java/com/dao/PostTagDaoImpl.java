package com.dao;

import javax.persistence.EntityManager;
import com.entities.Post;
import com.entities.Tags;
import com.exceptions.PostNotFoundException;
import com.exceptions.TagNotFoundException;
import com.utility.EMUtil;

public class PostTagDaoImpl implements PostTagDao{

	@Override
	public void addPost(Post post) throws PostNotFoundException {
		if(post == null) {
			throw new PostNotFoundException("Post is not null");
		}
		
		EntityManager em = EMUtil.getConnection();
		
		Post perPost = em.find(Post.class, post.getPostId());
		if(perPost!=null) {
			throw new PostNotFoundException("Post is already added");
		}
		em.getTransaction().begin();
		
		em.persist(post);
		
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Override
	public Post getPost(int postId) throws PostNotFoundException {
		
		EntityManager em = EMUtil.getConnection();
		
		Post post = em.find(Post.class, postId);
		if(post==null) {
			throw new PostNotFoundException("Post doesn't not exit");
		}
		
		return post;
	}

	@Override
	public Tags getTags(int tagId) throws TagNotFoundException {
		EntityManager em = EMUtil.getConnection();
		
		Tags tags = em.find(Tags.class, tagId);
		if(tags==null) {
			throw new TagNotFoundException("Tag doesn't not exit");
		}
		
		return tags;
	}

}
