package com.cybage.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "technology")
public class Technology {

	@Id
	@Column(name = "technologyId", insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer technologyId;
	
	@Column(name = "name")
	private String technologyName;
	
	
	//many technology can teach one user
	@ManyToOne
	@JoinColumn(name = "tutorId", nullable = false)
	private GenericUser belongsToTutors;
	
    //one tech have many materials
	@OneToMany(mappedBy = "belongsTechnology", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<TrainingMaterial> materials = new ArrayList<TrainingMaterial>();
	
	
	//
	// @ManyToMany(cascade = { CascadeType.ALL })
	// @JoinTable(
	// name = "StudTechDetails",
	// joinColumns = { @JoinColumn(name = "technologyId") },
	// inverseJoinColumns = { @JoinColumn(name = "studCourseId") }
	// )
	// private List<StudentCourseDetail> studCourseDetails = new
	// ArrayList<StudentCourseDetail>();

	
	//one tech have many couser materials
	@OneToMany(mappedBy = "technologies", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<StudentCourseDetail> studCourseDetails = new ArrayList<>();
	
	

	public Technology() {
		super();
	}

	public Technology(Integer technologyId, GenericUser belongsToTutors, String technologyName,
			List<TrainingMaterial> materials, List<StudentCourseDetail> studCourseDetails) {
		super();
		this.technologyId = technologyId;
		this.belongsToTutors = belongsToTutors;
		this.technologyName = technologyName;
		this.materials = materials;
		this.studCourseDetails = studCourseDetails;
	}

	public Integer getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

	public GenericUser getBelongsToTutors() {
		return belongsToTutors;
	}

	public void setBelongsToTutors(GenericUser belongsToTutors) {
		this.belongsToTutors = belongsToTutors;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public List<TrainingMaterial> getMaterials() {
		return materials;
	}

	public void setMaterials(List<TrainingMaterial> materials) {
		this.materials = materials;
	}

	public List<StudentCourseDetail> getStudCourseDetails() {
		return studCourseDetails;
	}

	public void setStudCourseDetails(List<StudentCourseDetail> studCourseDetails) {
		this.studCourseDetails = studCourseDetails;
	}

	@Override
	public String toString() {
		return "Technology [technologyId=" + technologyId + ", belongsToTutors=" + belongsToTutors + ", technologyName="
				+ technologyName + ", materials=" + materials + ", studCourseDetails=" + studCourseDetails + "]";
	}

	
	
}
