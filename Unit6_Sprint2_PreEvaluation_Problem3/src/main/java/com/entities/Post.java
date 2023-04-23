package com.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	private String title;
	private String description;
	private Timestamp postedAt;
	private Timestamp lastUpdatedAt;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Post_Tags" , joinColumns = @JoinColumn(name = "post_id") , inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tags> tagsList = new ArrayList<>();

	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", description=" + description + ", postedAt=" + postedAt
				+ ", lastUpdatedAt=" + lastUpdatedAt + "]";
	}


	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Timestamp getPostedAt() {
		return postedAt;
	}


	public void setPostedAt(Timestamp postedAt) {
		this.postedAt = postedAt;
	}


	public Timestamp getLastUpdatedAt() {
		return lastUpdatedAt;
	}


	public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}


	public List<Tags> getList() {
		return tagsList;
	}


	public void setList(List<Tags> list) {
		this.tagsList = list;
	}
	
	
	
}
