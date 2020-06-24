package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="field")
@JsonIgnoreProperties({ "skill" })
public class Field 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="TYPE")
	private String type;
	
	@OneToOne(mappedBy = "field")
	private Skill skill;
	
	public Field()
	{
		
	}

	public Field(long id, String name, String type, Skill skill) 
	{
		this.id = id;
		this.name = name;
		this.type = type;
		this.skill = skill;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
