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
@Table(name="addressTypes")
public class AddressTypes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column
	// Joses Validations
    private String businessTypeName;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    // Joses Validations
    private Date createdAt;
    
    @Column
    // Joses Validations
    private Date updatedAt;
	
	public AddressTypes() {}
	
    public AddressTypes(String businessTypeName) {
		this.businessTypeName = businessTypeName;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getBusinessTypeName() {return businessTypeName;}
	public void setBusinessTypeName(String businessTypeName) {this.businessTypeName = businessTypeName;}

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
