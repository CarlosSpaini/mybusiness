package me.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

	@Column(name = "PERSON_ID", nullable = false, precision = 20)
	@Id
	private Long personId;

	@ManyToMany
    @JoinTable(name="PERSON_ADDRESS", 
                joinColumns={@JoinColumn(name="PERSON_ID")}, 
                inverseJoinColumns={@JoinColumn(name="ADDRESS_ID")})
	private Set<Address> address = new HashSet<Address>();
	
	@Column(name = "CREATED_ON", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "MODIFIED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;

	public Person() {

	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress( Set<Address> address ) {
		this.address = address;
	}

}
