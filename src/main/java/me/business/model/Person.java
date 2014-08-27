package me.business.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

	@Column(name = "PERSON_ID", nullable = false, precision = 20)
	@Id
	private Long personId;

	@OneToMany(targetEntity = PersonAddress.class, mappedBy = "personId")
	private Collection<PersonAddress> personAddressCollection;

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

	public Collection<PersonAddress> getPersonAddressCollection() {
		return this.personAddressCollection;
	}

	public void setPersonAddressCollection(Collection<PersonAddress> personAddressCollection) {
		this.personAddressCollection = personAddressCollection;
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

}
