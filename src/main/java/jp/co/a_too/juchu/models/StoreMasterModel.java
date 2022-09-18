package jp.co.a_too.juchu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="tool", name="store_master") 
public class StoreMasterModel {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type_id")
	private int typeId;
	
	@Column(name="tenpo_code")
	private String  tenpoCode;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTypeId() {
		return typeId;
	}
	
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public String getTenpoCode() {
		return tenpoCode;
	}
	
	public void setTenpoCode(String tenpoCode) {
		this.tenpoCode = tenpoCode;
	}
	
	
	

}
