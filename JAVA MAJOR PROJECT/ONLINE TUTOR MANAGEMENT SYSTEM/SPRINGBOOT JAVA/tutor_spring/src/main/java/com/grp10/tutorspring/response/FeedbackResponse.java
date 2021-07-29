package com.grp10.tutorspring.response;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.grp10.tutorspring.model.Feedback;
import com.grp10.tutorspring.model.UserInfo;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedbackResponse {
	
	private UserInfo userinfo;
	private List<Feedback> feedbacks;
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	@Override
	public String toString() {
		return "FeedbackResponse [userinfo=" + userinfo + ", feedbacks=" + feedbacks + "]";
	}
	public FeedbackResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
