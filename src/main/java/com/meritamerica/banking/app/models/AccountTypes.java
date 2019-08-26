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
@Table(name="accountTypes")
public class AccountTypes {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column
	// Joses Validations
    private String accTypeName;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    // Joses Validations
    private Date createdAt;
    
    @Column
    // Joses Validations
    private Date updatedAt;
	
	public AccountTypes() {}
    
    public AccountTypes(String accTypeName) {
		this.accTypeName = accTypeName;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getAccTypeName() {return accTypeName;}
	public void setAccTypeName(String accTypeName) {this.accTypeName = accTypeName;}

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
