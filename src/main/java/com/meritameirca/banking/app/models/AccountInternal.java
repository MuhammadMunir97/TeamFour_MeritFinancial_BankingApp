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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.meritameirca.banking.app.service.transactions.Transaction;

@Entity
@Table(name="account_internals")
public class AccountInternal {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	// Don't think we will need a validation here because this shouldn't be subject to user entry (should be programmatically set)
	// #Muhammad they would require the validations as all of them need to be unique
	@Column(unique=true)
    private Long accountNumber;
	
	// Don't think we will need a validation here because this shouldn't be subject to user entry (should be programmatically set)
    private Double presentBalance;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="activity_status_id")
    private ActivityStatus activityStatus;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_type_id")
    private AccountType accountType;
    
    @OneToMany(mappedBy="accountInternal", fetch = FetchType.LAZY)
    private List<TransactionLog> transactionLogs;
    
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
	
	public User getUser() {	return user;}
	public void setUser(User user) {this.user = user;}

	public ActivityStatus getActivityStatus() {return activityStatus;}
	public void setActivityStatus(ActivityStatus activityStatus) {this.activityStatus = activityStatus;}

	public AccountType getAccountType() {return accountType;}
	public void setAccountType(AccountType accountType) {this.accountType = accountType;}

	public List<TransactionLog> getTransactionLogs() {return transactionLogs;}
	public void setTransactionLogs(List<TransactionLog> transactionLogs) {this.transactionLogs = transactionLogs;}

	public void transaction(Double money , Transaction process) {
		presentBalance = process.processingMoney(money, presentBalance);
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
	
}
