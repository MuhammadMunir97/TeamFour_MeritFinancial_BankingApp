package com.meritameirca.banking.app.models;

import java.time.LocalDateTime;
import java.util.List;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user_addresses")
public class UserAddress {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String street;
	
	@Column(columnDefinition = "VARCHAR(45)")
    private String street2;
	
	@Column(columnDefinition = "VARCHAR(45)")
    private String city;
	
	@Column(columnDefinition = "VARCHAR(2)")
	@Size(min = 2, max = 2, message = "Please enter a valid US state abbreviation")
    private String state;
	
	@Column(columnDefinition = "VARCHAR(11)")
	@Size(min = 5, max = 11, message = "Please enter a valid US zicode of at least 5 numbers ")
    private String zipcode;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
    
    @OneToOne(mappedBy="userAddress", fetch = FetchType.LAZY)
    private User user;
    
	public UserAddress() {}
    
    public UserAddress(String street, String street2, String city, String state, String zipcode) {
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getStreet() {return street;}
	public void setStreet(String street) {this.street = street;}
	
	public String getStreet2() {return street2;}
	public void setStreet2(String street2) {this.street2 = street2;}
	
	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}
	
	public String getState() {return state;}
	public void setState(String state) {this.state = state;}
	
	public String getZipcode() {return zipcode;}
	public void setZipcode(String zipcode) {this.zipcode = zipcode;}
	
	public LocalDateTime getCreatedAt() {return createdAt;}
	public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
	
	public LocalDateTime getUpdatedAt() {return updatedAt;}
	public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}
	
	public User getUser() {	return user;	}
	public void setUser(User user) {	this.user = user;	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
	
}
