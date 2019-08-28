package com.meritamerica.banking.app.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	//
	@Size(min = 2, message = "Please enter a valid first name of at least 2 characters")
    private String firstName;
	
	@Column
	@Size(min = 3, message = "Please enter a valid last name of at least 3 characters")
    private String lastName;
	
	@Column
	@Email(message = "Please enter a valid email format")
    private String email;
	
	@Column
	@Size(min = 6, max = 12, message = "Username must be between 6 and 12 characters")
    private String userName;
	
	@Column
	@Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String password;
	
	@Column
	@NotNull(message = "Birthday can not be empty")
	@DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDate dateOfBirth;
	
	@Column
	@Size(min = 9, max = 9, message = "A valid SSN must consist of 10 numbers")
    private String ssn;
	
	@Column
	// in case we want to validate phone numbers at a later time
	// @Pattern(regexp="(^$|[0-9]{10})")   
    private String primaryPhone;
	
	@Column
	// in case we want to validate phone numbers at a later time
	// @Pattern(regexp="(^$|[0-9]{10})")   
    private String secondaryPhone;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @Column
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
	
	public User() {}

    public User(String firstName, String lastName, String email, String userName, String password,
    		LocalDate dateOfBirth, String ssn, String primaryPhone, String secondaryPhone) {
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
	
	public LocalDate getDateOfBirth() {return dateOfBirth;}
	public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}
	
	public String getSsn() {return ssn;}
	public void setSsn(String ssn) {this.ssn = ssn;}
	
	public String getPrimaryPhone() {return primaryPhone;}
	public void setPrimaryPhone(String primaryPhone) {this.primaryPhone = primaryPhone;}
	
	public String getSecondaryPhone() {return secondaryPhone;}
	public void setSecondaryPhone(String secondaryPhone) {this.secondaryPhone = secondaryPhone;}
	
	public LocalDateTime getCreatedAt() {return createdAt;}
	public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
	
	public LocalDateTime getUpdatedAt() {return updatedAt;}
	public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}

	@PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
    

}
