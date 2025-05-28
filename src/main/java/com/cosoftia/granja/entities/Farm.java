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
@Table(name = "farms", indexes = {
		@Index(name = "farm_id_idx", columnList = "farm_id"),
})
public class Farm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@UuidGenerator
	@Column(name = "farm_id")
	private UUID id;
	@Column(name = "farm_name", nullable = false, columnDefinition = "VARCHAR(255)")
	private String farmName;
	@Column(name = "address", nullable = false, columnDefinition = "VARCHAR(255)")
	private String address;
	@Column(name = "phone", nullable = false, columnDefinition = "VARCHAR(20)")
	private String phone;
	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;
	@OneToMany(mappedBy = "farm")
	private List<Shed> sheds;
	@OneToMany(mappedBy = "farm")
	private List<User> users;
	@OneToMany(mappedBy = "farm")
	private List<Client> clients;
	@OneToMany(mappedBy = "farm")
	private List<Sale> sales;
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
