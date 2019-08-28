package com.meritameirca.banking.app.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="account_internals")
public class AccountInternal {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	//
	// Don't think we will need a validation here because this shouldn't be subject to user entry (should be programmatically set)
    private Long accountNumber;
	
	@Column
	// Don't think we will need a validation here because this shouldn't be subject to user entry (should be programmatically set)
    private Double presentBalance;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @Column
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
	
    public AccountInternal() {}
    
    public AccountInternal(Long accountNumber, Double presentBalance) {
		this.accountNumber = accountNumber;
		this.presentBalance = presentBalance;
	}

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

	public Long getAccountNumber() {return accountNumber;}
	public void setAccountNumber(Long accountNumber) {this.accountNumber = accountNumber;}

	public Double getPresentBalance() {return presentBalance;}
	// For security there will be NO setters (balance can only be modified through the deposit/withdraw methods

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
