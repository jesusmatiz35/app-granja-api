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
@Table(name = "sales", indexes = {
		@Index(name = "sale_id_idx", columnList = "sale_id"),
		@Index(name = "farm_id_idx", columnList = "farm_id"),
		@Index(name = "date_register_idx", columnList = "date_register"),
		@Index(name = "farm_id_date_register_idx", columnList = "farm_id,date_register"),
})
public class Sale implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@UuidGenerator
	@Column(name = "sale_id")
	private UUID id;
	@Column(name = "categoryEgg", nullable = false, columnDefinition = "VARCHAR(30)")
	private String categoryEgg;
	@Column(name = "egg_baskets", nullable = false, columnDefinition = "INT(7) DEFAULT 0")
	private int eggBaskets;	
	@Column(name = "price", nullable = false, columnDefinition = "INT(7) DEFAULT 0")
	private int price;
	@Column(name = "total_sale", nullable = false, columnDefinition = "INT(10) DEFAULT 0")
	private int totalSale;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_register", nullable = false)
	private Date dateRegister;
	@ManyToOne
	@JoinColumn(name = "farm_id", nullable = false)
	private Farm farm;
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
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
