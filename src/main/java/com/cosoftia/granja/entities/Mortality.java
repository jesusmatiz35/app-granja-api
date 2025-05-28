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
@Table(name = "mortalities", indexes = {
		@Index(name = "mortality_id_idx", columnList = "mortality_id"),
		@Index(name = "shed_id_idx", columnList = "shed_id"),
})
public class Mortality implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@UuidGenerator
	@Column(name = "mortality_id")
	private UUID id;
	@Column(name = "amount", nullable = false, columnDefinition = "INT(4)")
	private int amount;
	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_mortality", nullable = false)
	private Date dateMortality;
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
