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
@Table(name="users")
public class Users {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	@NotNull
    private String firstName;
	
	@Column
	@NotNull
    private String lastName;
	
	@Column
	@NotNull
	@Email
    private String email;
	
	@Column
	@NotNull
	@Size(min = 6, max = 12, message = "Username must be between 6 and 12 characters")
    private String userName;
	
	@Column
	@NotNull
	@Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String password;
	
	@Column
	@NotNull
	@DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDate dateOfBirth;
	
	@Column
	@NotNull
	@Size(min = 10, max = 10)
    private String ssn;
	
	@Column
    private String primaryPhone;
	
	@Column
    private String secondaryPhone;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @Column
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
	
	public Users() {}

    public Users(String firstName, String lastName, String email, String userName, String password,
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
