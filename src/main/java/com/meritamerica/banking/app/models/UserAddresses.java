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
@Table(name="userAddresses")
public class UserAddresses {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	// Joses Validations
    private String street;
	
	@Column
	// Joses Validations
    private String street2;
	
	@Column
	// Joses Validations
    private String city;
	
	@Column
	// Joses Validations
    private String state;
	
	@Column
	// Joses Validations
    private String zipcode;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    // Joses Validations
    private Date createdAt;
    
    @Column
    // Joses Validations
    private Date updatedAt;
    
    public UserAddresses() {}
    
    public UserAddresses(String street, String street2, String city, String state, String zipcode) {
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
