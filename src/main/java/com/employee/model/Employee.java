package com.employee.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.employee.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="employee")
@JsonIgnoreProperties("skill")
public class Employee 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
		
	@Column(name="COMPANYEMAIL")
	private String companyEmail;
	
	@Column(name="BIRTHDATE")
	private String birthDate;
	
	@Column(name="HIREDDATE")
	private String hiredDate;
	
	@Column(name="ROLE", columnDefinition = "varchar(255)")
	private String role = Role.TECHICALCONSULTANT.getRole();
	
	@Column(name="BUSINESSUNIT", columnDefinition = "varchar(255)")
	private String businessUnit;
	
	@OneToMany(mappedBy = "employee",cascade=CascadeType.ALL)
	private List<Skill> Skill = new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public List<Skill> getSkill() {
		return Skill;
	}

	public void setSkill(List<Skill> skill) {
		Skill = skill;
	}
}
