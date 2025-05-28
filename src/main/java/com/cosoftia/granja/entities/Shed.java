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
@Table(name = "sheds", indexes = { @Index(name = "shed_id_idx", columnList = "shed_id"),
		@Index(name = "farm_id_idx", columnList = "farm_id"),
		@Index(name = "shed_id_farm_id_idx", columnList = "shed_id,farm_id"), })
public class Shed implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	@Column(name = "shed_id")
	private UUID id;
	@Column(name = "shed_name", unique = true, nullable = false, columnDefinition = "VARCHAR(100)")
	private String name;
	@Column(name = "type_shed", nullable = false, columnDefinition = "VARCHAR(100)")
	private String typeShed;
	@Column(name = "genetic_line", nullable = false, columnDefinition = "VARCHAR(100)")
	private String geneticLine;
	@Column(name = "amount", nullable = false)
	private int amount;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birth", nullable = false)
	private Date birth;
	@ManyToOne
	@JoinColumn(name = "farm_id", nullable = false)
	private Farm farm;
	@OneToMany(mappedBy = "shed")
	private List<Cost> costs;
	@OneToMany(mappedBy = "shed")
	private List<Mortality> mortalities;
	@OneToMany(mappedBy = "shed")
	private List<Harvest> harvests;
	@OneToMany(mappedBy = "shed")
	private List<Feed> feed;
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
