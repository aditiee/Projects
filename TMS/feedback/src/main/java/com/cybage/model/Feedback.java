package com.cybage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int feedbackId;
	@Column(unique=true,nullable = false)
	int appointmentId;
	@Column(nullable = true)
	int patientId;
	@Column(nullable = true)
	int doctorId;
	@Column(nullable = true)
	String remarks;
	@Column(nullable = true)
	String complaints;
	@Column(nullable = true)
	int rating;
	@Column(nullable = true)
	boolean prescriptionAvailability;
	@Column(nullable = true)
	boolean unhygienicSurroundings;
	@Column(nullable = true)
	boolean notAdheringToAppointmentTime;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getComplaints() {
		return complaints;
	}
	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public boolean isPrescriptionAvailability() {
		return prescriptionAvailability;
	}
	public void setPrescriptionAvailability(boolean prescriptionAvailability) {
		this.prescriptionAvailability = prescriptionAvailability;
	}
	public boolean isUnhygienicSurroundings() {
		return unhygienicSurroundings;
	}
	public void setUnhygienicSurroundings(boolean unhygienicSurroundings) {
		this.unhygienicSurroundings = unhygienicSurroundings;
	}
	public boolean isNotAdheringToAppointmentTime() {
		return notAdheringToAppointmentTime;
	}
	public void setNotAdheringToAppointmentTime(boolean notAdheringToAppointmentTime) {
		this.notAdheringToAppointmentTime = notAdheringToAppointmentTime;
	}
	public Feedback(int feedbackId, int appointmentId, int patientId, int doctorId, String remarks, String complaints,
			int rating, boolean prescriptionAvailability, boolean unhygienicSurroundings,
			boolean notAdheringToAppointmentTime) {
		super();
		this.feedbackId = feedbackId;
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.remarks = remarks;
		this.complaints = complaints;
		this.rating = rating;
		this.prescriptionAvailability = prescriptionAvailability;
		this.unhygienicSurroundings = unhygienicSurroundings;
		this.notAdheringToAppointmentTime = notAdheringToAppointmentTime;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", appointmentId=" + appointmentId + ", patientId=" + patientId
				+ ", doctorId=" + doctorId + ", remarks=" + remarks + ", complaints=" + complaints + ", rating="
				+ rating + ", prescriptionAvailability=" + prescriptionAvailability + ", unhygienicSurroundings="
				+ unhygienicSurroundings + ", notAdheringToAppointmentTime=" + notAdheringToAppointmentTime + "]";
	}
	
}
