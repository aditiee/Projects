package com.cybage.tms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="trainingMaterial")
public class TrainingMaterial {

	@Id
	@Column(name="materialId", insertable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer materialId;
	
	private String fileName;
	private String fileType;
	@Lob
	private byte[] fileData;
	
	
	//many materilas belongs to one tutor
	@ManyToOne 
	@JoinColumn(name="_tutorId",nullable = false) 
	private GenericUser belongsToTutor;
	
	
	//many materilas belongs to one technology
	@ManyToOne 
	@JoinColumn(name="technologyId",nullable = false) 
	private Technology belongsTechnology;
	
	
	
	public TrainingMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrainingMaterial(Integer materialId, GenericUser belongsToTutor, Technology belongsTechnology, String fileName,
			String fileType, byte[] fileData) {
		super();
		this.materialId = materialId;
		this.belongsToTutor = belongsToTutor;
		this.belongsTechnology = belongsTechnology;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileData = fileData;
	}
	public Integer getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
	public GenericUser getBelongsToTutor() {
		return belongsToTutor;
	}
	public void setBelongsToTutor(GenericUser belongsToTutor) {
		this.belongsToTutor = belongsToTutor;
	}
	public Technology getBelongsTechnology() {
		return belongsTechnology;
	}
	public void setBelongsTechnology(Technology belongsTechnology) {
		this.belongsTechnology = belongsTechnology;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "TrainingMaterial [materialId=" + materialId + ", fileName=" + fileName + ", fileType=" + fileType
				+ "]";
	}
	
}
