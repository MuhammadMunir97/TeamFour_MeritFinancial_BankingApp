package com.meritamerica.banking.app.models;

import java.sql.Timestamp;
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
@Table(name="transactionLogs")
public class TransactionLogs {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	// Joses Validations
    private String description;
	
	@Column
	// Joses Validations
    private Double amount;
	
	@Column
	// Joses Validations
    private Timestamp postDate;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    // Joses Validations
    private Date createdAt;
    
    @Column
    // Joses Validations
    private Date updatedAt;
    
    public TransactionLogs() {}
	
    public TransactionLogs(String description, Double amount, Timestamp postDate) {
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
