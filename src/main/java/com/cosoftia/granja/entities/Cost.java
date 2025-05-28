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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "costs", indexes = {
		@Index(name = "cost_id_idx", columnList = "cost_id"),
		@Index(name = "shed_id_idx", columnList = "shed_id"),
})
public class Cost implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@UuidGenerator
	@Column(name = "cost_id")
	private UUID id;
	@Column(name = "description", unique = true, nullable = false, columnDefinition = "VARCHAR(255)")
	private String name;
	@Column(name = "amount", nullable = false, columnDefinition="INT(10)")
	private int amount;
	@Column(name = "cost", nullable = false, columnDefinition="INT(10)")
	private int cost;
	@ManyToOne
	@JoinColumn(name = "shed_id", nullable = false)
	private Shed shed;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", updatable = false, nullable = false)
	private Date createdAt;
	
	@PrePersist
	private void prePersist() {
		this.createdAt = new Date();
	}

}
