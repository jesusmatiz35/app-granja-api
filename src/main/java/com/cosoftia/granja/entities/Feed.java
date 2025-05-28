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
import lombok.Data;

/**
 * Entidad para registrar el consumo de alimentos
 */
@Data
@Entity
@Table(name = "feeds", indexes = {
		@Index(name = "feed_id_idx", columnList = "feed_id"),
		@Index(name = "shed_id_idx", columnList = "shed_id"),
})
public class Feed implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@UuidGenerator
	@Column(name = "feed_id")
	private UUID id;
	@Column(name = "amount", nullable = false)
	private int amount;
	@ManyToOne
	@JoinColumn(name = "shed_id", nullable = false)
	private Shed shed;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_consumed", nullable = false)
	private Date dateConsumed;
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
