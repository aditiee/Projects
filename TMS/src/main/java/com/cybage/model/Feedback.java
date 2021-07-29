package com.cybage.model;



public class Feedback {
	   
	int feedbackId;
	int appointmentId;
	int patientId;
	int doctorId;
	String remarks;
	String complaints;
	int rating;
	boolean prescriptionAvailability;
	boolean unhygienicSurroundings;
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
