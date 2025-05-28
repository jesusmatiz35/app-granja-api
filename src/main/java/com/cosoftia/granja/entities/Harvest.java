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

@Data
@Entity
@Table(name = "harvests", indexes = {
		@Index(name = "harvest_id_idx", columnList = "harvest_id"),
		@Index(name = "shed_id_idx", columnList = "shed_id"),
		@Index(name = "date_register_idx", columnList = "date_register"),
		@Index(name = "shed_id_date_register_idx", columnList = "shed_id,date_register"),
})
public class Harvest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@UuidGenerator
	@Column(name = "harvest_id")
	private UUID id;
	
	@Column(name = "category_c", nullable = false, columnDefinition = "INT(6) DEFAULT 0")
	private int categoryC;
	@Column(name = "category_b", nullable = false, columnDefinition = "INT(6) DEFAULT 0")
	private int categoryB;
	@Column(name = "category_a", nullable = false, columnDefinition = "INT(6) DEFAULT 0")
	private int categoryA;
	@Column(name = "category_aa", nullable = false, columnDefinition = "INT(6) DEFAULT 0")
	private int categoryAA;
	@Column(name = "category_aaa", nullable = false, columnDefinition = "INT(6) DEFAULT 0")
	private int categoryAAA;
	@Column(name = "category_extra", nullable = false, columnDefinition = "INT(6) DEFAULT 0")
	private int categoryExtra;
	@Column(name = "broken_eggs", nullable = false, columnDefinition = "INT(6) DEFAULT 0")
	private int brokenEggs;
	@Column(name = "total_eggs", nullable = false, columnDefinition = "INT(7) DEFAULT 0")
	private int totalEggs;	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_register", nullable = false)
	private Date dateRegister;
	@ManyToOne
	@JoinColumn(name = "shed_id", nullable = false)
	private Shed shed;
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
