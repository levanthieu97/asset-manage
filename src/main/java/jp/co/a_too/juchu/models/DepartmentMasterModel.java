package jp.co.a_too.juchu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="department")
public class DepartmentMasterModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	private int id;

	@Column(name="department_name")
	private String departmentName;
	
	public DepartmentMasterModel() {
		
	}
	
	public DepartmentMasterModel(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
