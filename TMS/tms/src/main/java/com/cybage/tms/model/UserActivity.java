package com.cybage.tms.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.userdetails.User;

@Entity
@Table(name = "user_activity")
public class UserActivity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_id")
	private Integer activityId;

	@NotNull(message = "Activity Content cannot be Null")
	@Column(name = "activity_content", length = 300)
	private String activityContent;

	@NotNull(message = "Activity Time cannot be Null")
	@Column(name = "activity_time")
	private LocalDateTime activityTime;

	// Unidirectional Mapping
	@ManyToOne(targetEntity = GenericUser.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private GenericUser user;

	public UserActivity() {
		// Default Constructor
	}

	public UserActivity(@NotNull(message = "Activity Content cannot be Null") String activityContent,
			@NotNull(message = "Activity Time cannot be Null") LocalDateTime activityTime, GenericUser user) {
		this.activityContent = activityContent;
		this.activityTime = activityTime;
		this.user = user;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public LocalDateTime getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(LocalDateTime activityTime) {
		this.activityTime = activityTime;
	}

	public GenericUser getUser() {
		return user;
	}

	public void setUser(GenericUser user2) {
		this.user = user2;
	}

	@Override
	public String toString() {
		return "UserActivity [activityId=" + activityId + ", activityContent=" + activityContent + ", activityTime="
				+ activityTime + "]";
	}
}
