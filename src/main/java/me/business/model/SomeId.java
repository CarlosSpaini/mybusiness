package me.business.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "SOME_ID" )
public class SomeId {

	@Column( name = "SOME_ID_ID", unique = true, nullable = false, precision = 20, scale = 0 )
	@Id
	@SequenceGenerator( name = "SomeIdSeq", sequenceName = "SOME_ID_ID_SEQ", allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SomeIdSeq" )
	private Long someIdId;

	@ManyToOne( optional = false, targetEntity = Address.class, fetch = FetchType.EAGER)
	@JoinColumn( name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", insertable = true, nullable = true, unique = false, updatable = true )
	private Address address;

	@Column( name = "CREATED_ON", nullable = false )
	@Temporal( TemporalType.TIMESTAMP )
	private Date createdOn;

	@Column( name = "MODIFIED_ON" )
	@Temporal( TemporalType.TIMESTAMP )
	private Date modifiedOn;

	@Column( name = "SOME_ID", nullable = false, length = 100 )
	private String someId;

	public SomeId() {
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress( Address address ) {
		this.address = address;
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

	public Long getSomeIdId() {
		return someIdId;
	}

	public void setSomeIdId( Long someIdId ) {
		this.someIdId = someIdId;
	}

	public String getSomeId() {
		return someId;
	}

	public void setSomeId( String someId ) {
		this.someId = someId;
	}

}
