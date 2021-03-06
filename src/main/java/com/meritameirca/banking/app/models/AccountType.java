package com.meritameirca.banking.app.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="account_types")
public class AccountType {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(columnDefinition = "VARCHAR(45)")
	// For now don't think validation rule is needed here until we build an admin portal where bank employees would be permitted to add new account types
    private String accTypeName;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
	
    @OneToMany(mappedBy="accountType", fetch = FetchType.LAZY)
    private List<AccountInternal> accountInternal;
    
	public AccountType() {}
    
    public AccountType(String accTypeName) {
		this.accTypeName = accTypeName;
	}

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

	public String getAccTypeName() {return accTypeName;}
	public void setAccTypeName(String accTypeName) {this.accTypeName = accTypeName;}

	public LocalDateTime getCreatedAt() {return createdAt;}
	public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

	public LocalDateTime getUpdatedAt() {return updatedAt;}
	public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}

	public List<AccountInternal> getAccountInternal() {	return accountInternal;	}
	public void setAccountInternal(List<AccountInternal> accountInternal) {	this.accountInternal = accountInternal;	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
	
}
