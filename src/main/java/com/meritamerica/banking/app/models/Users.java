package com.meritamerica.banking.app.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	// Joses Validations
    private String firstName;
	
	@Column
	// Joses Validations
    private String lastName;
	
	@Column
	// Joses Validations
    private String email;
	
	@Column
	// Joses Validations
    private String userName;
	
	@Column
	// Joses Validations
    private String password;
	
	@Column
	// Joses Validations
    private Date dateOfBirth;
	
	@Column
	// Joses Validations
    private String ssn;
	
	@Column
	// Joses Validations
    private String primaryPhone;
	
	@Column
	// Joses Validations
    private String secondaryPhone;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    // Joses Validations
    private Date createdAt;
    
    @Column
    // Joses Validations
    private Date updatedAt;
	
	public Users() {}

    public Users(String firstName, String lastName, String email, String userName, String password,
			Date dateOfBirth, String ssn, String primaryPhone, String secondaryPhone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.ssn = ssn;
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
	}

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public Date getDateOfBirth() {return dateOfBirth;}
	public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth;}
	
	public String getSsn() {return ssn;}
	public void setSsn(String ssn) {this.ssn = ssn;}
	
	public String getPrimaryPhone() {return primaryPhone;}
	public void setPrimaryPhone(String primaryPhone) {this.primaryPhone = primaryPhone;}
	
	public String getSecondaryPhone() {return secondaryPhone;}
	public void setSecondaryPhone(String secondaryPhone) {this.secondaryPhone = secondaryPhone;}
	
	public Date getCreatedAt() {return createdAt;}
	public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}
	
	public Date getUpdatedAt() {return updatedAt;}
	public void setUpdatedAt(Date updatedAt) {this.updatedAt = updatedAt;}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    

}
