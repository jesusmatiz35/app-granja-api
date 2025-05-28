package com.cosoftia.granja.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "clients", indexes = {
		@Index(name = "client_id_idx", columnList = "client_id"),
		@Index(name = "nit_idx", columnList = "nit"),
})
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@UuidGenerator
	@Column(name = "client_id")
	private UUID id;
	@Column(name = "social_reason", nullable = false, columnDefinition = "VARCHAR(255)")
	private String socialReason;
	@Column(name = "nit", nullable = false, columnDefinition = "VARCHAR(20)")
	private String nit;
	@Column(name = "address", nullable = false, columnDefinition = "VARCHAR(255)")
	private String address;
	@Column(name = "email", unique = true, nullable = false, columnDefinition = "VARCHAR(255)")
	private String email;
	@OneToMany(mappedBy = "client")
	private List<Sale> sales;
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
