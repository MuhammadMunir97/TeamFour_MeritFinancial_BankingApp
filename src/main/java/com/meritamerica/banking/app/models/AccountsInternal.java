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
@Table(name="accountsInternal")
public class AccountsInternal {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	// Joses Validations
    private Long accountNumber;
	
	@Column
	// Joses Validations
    private Double presentBalance;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    // Joses Validations
    private Date createdAt;
    
    @Column
    // Joses Validations
    private Date updatedAt;
	
    public AccountsInternal() {}
    
    public AccountsInternal(Long accountNumber, Double presentBalance) {
		this.accountNumber = accountNumber;
		this.presentBalance = presentBalance;
	}

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

	public Long getAccountNumber() {return accountNumber;}
	public void setAccountNumber(Long accountNumber) {this.accountNumber = accountNumber;}

	public Double getPresentBalance() {return presentBalance;}
	// For security there will be NO setters (balance can only be modified through the deposit/withdraw methods

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
