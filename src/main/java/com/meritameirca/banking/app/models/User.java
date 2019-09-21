package com.meritameirca.banking.app.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(columnDefinition = "VARCHAR(65)")
	@Size(min = 2, message = "Please enter a valid first name of at least 2 characters")
	@NotBlank(message = "Please enter your first name")
    private String firstName;
	
	@Column(columnDefinition = "VARCHAR(65)")
	@Size(min = 2, message = "Please enter a valid last name of at least 2 characters")
	@NotBlank(message = "Please enter your last name")
    private String lastName;
	
	@Column(columnDefinition = "VARCHAR(100)")
	@Email(message = "Please enter a valid email format")
	@NotBlank(message = "Please enter your email")
    private String email;
	
	@Column(columnDefinition = "VARCHAR(65)", unique=true)
	@Size(min = 6, max = 12, message = "Username must be between 6 and 12 characters")
	@NotBlank(message = "Please enter a valid username")
    private String userName;
	
	@Column(columnDefinition = "VARCHAR(65)")
	@Size(message = "Password must be between 8 and 16 characters")
	@NotBlank(message = "Please enter a valid password")
    private String password;
	
	@Transient
	@Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String passwordConfirmation;
	
	//@NotNull(message = "Birthday can not be empty")
	//@DateTimeFormat(pattern="mm-dd-yyyy")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
	
	@Column(columnDefinition = "VARCHAR(11)")
	@Size(min = 11, max = 11, message = "A valid SSN must consist of 9 numbers")
	@NotBlank(message = "Please enter your SSN")
    private String ssn;
	
	@Column(columnDefinition = "VARCHAR(12)")
	// in case we want to validate phone numbers at a later time
	// @Pattern(regexp="(^$|[0-9]{12})")   
    private String primaryPhone;
	
	@Column(columnDefinition = "VARCHAR(12)")
	// in case we want to validate phone numbers at a later time
	// @Pattern(regexp="(^$|[0-9]{12})")   
    private String secondaryPhone;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
	
    @OneToOne(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    private UserAddress userAddress;
    
    @OneToMany(mappedBy="user", cascade = CascadeType.PERSIST, orphanRemoval=true, fetch = FetchType.LAZY)
    private List<AccountInternal> accountInternals;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="activity_status_id")
    private ActivityStatus activityStatus;

	public User() {
	}

    public User(String firstName, String lastName, String email, String userName, String password,
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
	
	public LocalDateTime getCreatedAt() {return createdAt;}
	public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
	
	public LocalDateTime getUpdatedAt() {return updatedAt;}
	public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}

	public String getPasswordConfirmation() {return passwordConfirmation;}
	public void setPasswordConfirmation(String passwordConfirmation) {this.passwordConfirmation = passwordConfirmation;}

	public UserAddress getUserAddress() {return userAddress;}
	public void setUserAddress(UserAddress userAddress) {this.userAddress = userAddress;}

	public List<AccountInternal> getAccountInternals() {return accountInternals;}
	public void setAccountInternals(List<AccountInternal> accountInternals) {this.accountInternals = accountInternals;}

	public ActivityStatus getActivityStatus() {return activityStatus;}
	public void setActivityStatus(ActivityStatus activityStatus) {this.activityStatus = activityStatus;}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
    

}
