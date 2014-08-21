package me.business.model;

import java.io.Serializable;

import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "PERSON_ADDRESS" )
public class PersonAddress implements Serializable {

	@Column( name = "CREATED_ON", nullable = false )
	@Temporal( TemporalType.TIMESTAMP )
	@Basic
	private Date createdOn;

	@Column( name = "MODIFIED_ON" )
	@Temporal( TemporalType.TIMESTAMP )
	@Basic
	private Date modifiedOn;

	@Column( name = "PERSON_ADDRESS_ID", nullable = false, precision = 20 )
	@Id
	private BigDecimal personAddressId;

	@ManyToOne( optional = false, targetEntity = Person.class )
	@JoinColumn( name = "PERSON_ID", referencedColumnName = "PERSON_ID", insertable = true, nullable = true, unique = false, updatable = true )
	private Person personId;

	@ManyToOne( optional = false, targetEntity = Address.class )
	@JoinColumn( name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", insertable = true, nullable = true, unique = false, updatable = true )
	private Address addressId;

	public PersonAddress() {

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

	public BigDecimal getPersonAddressId() {
		return this.personAddressId;
	}

	public void setPersonAddressId( BigDecimal personAddressId ) {
		this.personAddressId = personAddressId;
	}

	public Person getPersonId() {
		return this.personId;
	}

	public void setPersonId( Person personId ) {
		this.personId = personId;
	}

	public Address getAddressId() {
		return this.addressId;
	}

	public void setAddressId( Address addressId ) {
		this.addressId = addressId;
	}

}
