package com.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="USERDETAILS")
public class User {
	@Id
	@Column(name="id", unique = true, nullable = false)
	private Integer id;
	
	@Size(min=2, max=30)
	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@Size(min=2, max=30)
	@Column(name="last_name", nullable = false)
	private String lastName;
	
	@Column(name="address", nullable = false)
	private String address;
	
	@Column(name="telephone", nullable = false)
	@Pattern(regexp = "(\\+91|0)[0-9]{9}")
	private String telephone;
	
	@Email(message = "Email should be valid")
	@Column(name="email", nullable = false)
	private String email;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getAddress() {
		return address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



}
