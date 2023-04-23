package com.dao;

import com.entities.Post;
import com.entities.Tags;
import com.exceptions.PostNotFoundException;
import com.exceptions.TagNotFoundException;

public interface PostTagDao {

	public void addPost(Post post) throws PostNotFoundException;
	public Post getPost(int postId) throws PostNotFoundException;
	public Tags getTags(int tagId) throws TagNotFoundException;
	
	
}
