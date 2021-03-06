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

@Entity
@Table(name="transaction_types")
public class TransactionType {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(columnDefinition = "VARCHAR(45)")
    private String transactionTypeName;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
	
    @OneToMany(mappedBy="transactionType", fetch = FetchType.LAZY)
    private List<TransactionLog> transactionLogs;
    
    public TransactionType() {}
	
    public TransactionType(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
	}

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

	public String getTransactionTypeName() {return transactionTypeName;}
	public void setTransactionTypeName(String transactionTypeName) {this.transactionTypeName = transactionTypeName;}

	public LocalDateTime getCreatedAt() {return createdAt;}
	public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

	public LocalDateTime getUpdatedAt() {return updatedAt;}
	public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}

	public List<TransactionLog> getTransactionLogs() {	return transactionLogs;	}
	public void setTransactionLogs(List<TransactionLog> transactionLogs) {	this.transactionLogs = transactionLogs;	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
	
}
