package com.meritameirca.banking.app.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="transaction_logs")
public class TransactionLog {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	// Don't think we will need a validation here because this shouldn't be subject to user entry (should be programmatically set)
    private String description;
	
	// Don't think we will need a validation here because this shouldn't be subject to user entry (should be programmatically set)
    private Double amount;
	
	// Don't think we will need a validation here because this shouldn't be subject to user entry (should be programmatically set)
    private Timestamp postDate;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_internal_id")
    private AccountInternal accountInternal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="transaction_type_id")
    private TransactionType transactionType;
    
    public TransactionLog() {}
	
    public TransactionLog(String description, Double amount, Timestamp postDate) {
		this.description = description;
		this.amount = amount;
		this.postDate = postDate;
	}

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	public Double getAmount() {return amount;}
	public void setAmount(Double amount) {this.amount = amount;}

	public Timestamp getPostDate() {return postDate;}
	public void setPostDate(Timestamp postDate) {this.postDate = postDate;}

	public LocalDateTime getCreatedAt() {return createdAt;}
	public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

	public LocalDateTime getUpdatedAt() {return updatedAt;}
	public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}
	
	public AccountInternal getAccountInternal() {	return accountInternal;	}
	public void setAccountInternal(AccountInternal accountInternal) {	this.accountInternal = accountInternal;	}

	public TransactionType getTransactionType() {	return transactionType;	}
	public void setTransactionType(TransactionType transactionType) {	this.transactionType = transactionType;	}


	@PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
	
}
