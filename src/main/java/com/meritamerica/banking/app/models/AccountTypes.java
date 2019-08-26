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
    private LocalDateTime createdAt;
    
    @Column
    // Joses Validations
    private LocalDateTime updatedAt;
	
	public AccountTypes() {}
    
    public AccountTypes(String accTypeName) {
		this.accTypeName = accTypeName;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getAccTypeName() {return accTypeName;}
	public void setAccTypeName(String accTypeName) {this.accTypeName = accTypeName;}

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
