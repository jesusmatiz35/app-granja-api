package com.cosoftia.granja.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "users", 
indexes = { 
		@Index(name = "user_id_idx", columnList = "user_id"),
		@Index(name = "farm_idx", columnList = "farm_id"),
		@Index(name = "email_idx", columnList = "email"),
		@Index(name = "email_farm_id_idx", columnList = "email,farm_id"), }, 
uniqueConstraints = {
				@UniqueConstraint(columnNames = { "farm_id", "email" }),
})
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	@Column(name = "user_id")
	private UUID userId;
	@Column(name = "firstname", nullable = false, columnDefinition = "VARCHAR(255)")
	private String firstname;
	@Column(name = "lastname", nullable = false, columnDefinition = "VARCHAR(255)")
	private String lastname;
	@Column(name = "email", nullable = false, columnDefinition = "VARCHAR(255)")
	private String email;
	@Column(name = "pwd", nullable = false, columnDefinition = "VARCHAR(255)")
	private String pwd;
	@ManyToOne
	@JoinColumn(name = "farm_id", nullable = false)
	private Farm farm;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", updatable = false, nullable = false)
	private Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;
	
	@PrePersist
	private void prePersist() {
		this.createdAt = new Date();
		this.updatedAt = this.createdAt;
	}

	@PreUpdate
	private void preUpdate() {
		this.updatedAt = new Date();
	}

}
