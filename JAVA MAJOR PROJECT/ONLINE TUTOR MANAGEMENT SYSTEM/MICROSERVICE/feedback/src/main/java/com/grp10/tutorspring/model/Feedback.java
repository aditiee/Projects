package com.grp10.tutorspring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	int feedbackId;

	@Column(nullable=true)
	int adminId;

	@Column(nullable=true)
	int userId;

	@Column(nullable=true)
	String remarks;

	@Column(nullable=true)
	int rating;
	
	@Column(nullable=true)
	LocalDateTime  created_on;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDateTime getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", adminId=" + adminId + ", userId=" + userId + ", remarks="
				+ remarks + ", rating=" + rating + ", created_on=" + created_on + "]";
	}

	public Feedback( int adminId, int userId, String remarks, int rating, LocalDateTime created_on) {
		super();
		
		this.adminId = adminId;
		this.userId = userId;
		this.remarks = remarks;
		this.rating = rating;
		this.created_on = created_on;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
