package jp.co.a_too.juchu.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
@Table(schema="tool", name="category2_master")
@NamedEntityGraph(
		name = "category2_category1", 
		includeAllAttributes = true)
public class Category2MasterModel implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="category1_class")
	public String category1Class;

	@ManyToOne
	@JoinColumn(name= "category1_class", referencedColumnName = "value", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Category1MasterModel category1MasterModel;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory1Class() {
		return category1Class;
	}

	public void setCategory1Class(String category1Class) {
		this.category1Class = category1Class;
	}

	public Category1MasterModel getCategory1MasterModel() {
		return category1MasterModel;
	}

	public void setCategory1MasterModel(Category1MasterModel category1MasterModel) {
		this.category1MasterModel = category1MasterModel;
	}

	
	
	
}
