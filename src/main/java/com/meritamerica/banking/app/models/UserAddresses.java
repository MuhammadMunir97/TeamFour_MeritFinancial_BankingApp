package com.meritamerica.banking.app.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user_addresses")
public class UserAddresses {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	@NotNull
    private String street;
	
	@Column
	@NotNull
    private String street2;
	
	@Column
	@NotNull
    private String city;
	
	@Column
	@NotNull
	@Size(min = 2, max = 2)
    private String state;
	
	@Column
	@NotNull
	@Max(11)
    private String zipcode;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @Column
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
    
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
