package me.business.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "PERSON" )
public class Person implements Serializable {

	@Column( name = "PERSON_ID", table = "PERSON", nullable = false, precision = 20 )
	@Id
	private BigDecimal personId;

	@OneToMany( targetEntity = PersonAddress.class, mappedBy = "personId" )
	private Collection<PersonAddress> personAddressCollection;

	@Column( name = "CREATED_ON", table = "PERSON", nullable = false )
	@Temporal( TemporalType.TIMESTAMP )
	@Basic
	private Date createdOn;

	@Column( name = "MODIFIED_ON", table = "PERSON" )
	@Temporal( TemporalType.TIMESTAMP )
	@Basic
	private Date modifiedOn;

	public Person() {

	}

	public BigDecimal getPersonId() {
		return this.personId;
	}

	public void setPersonId( BigDecimal personId ) {
		this.personId = personId;
	}

	public Collection<PersonAddress> getPersonAddressCollection() {
		return this.personAddressCollection;
	}

	public void setPersonAddressCollection( Collection<PersonAddress> personAddressCollection ) {
		this.personAddressCollection = personAddressCollection;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn( Date createdOn ) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn( Date modifiedOn ) {
		this.modifiedOn = modifiedOn;
	}

}
