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
@Table(name="activity_statusses")
public class ActivityStatus {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(columnDefinition = "VARCHAR(45)")
    private String status;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy="activityStatus", fetch = FetchType.LAZY)
    private List<User> users;
    
    @OneToMany(mappedBy="activityStatus", fetch = FetchType.LAZY)
    private List<AccountInternal> accountsInternal;
    
    public ActivityStatus() {}

    public ActivityStatus(String status) {
		this.status = status;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}

	public LocalDateTime getCreatedAt() {return createdAt;}
	public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

	public LocalDateTime getUpdatedAt() {return updatedAt;}
	public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}
	
	public List<User> getUsers() {	return users;	}
	public void setUsers(List<User> users) {	this.users = users;	}

	public List<AccountInternal> getAccountsInternal() {	return accountsInternal;	}
	public void setAccountsInternal(List<AccountInternal> accountsInternal) {	this.accountsInternal = accountsInternal;	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
    
	
}
