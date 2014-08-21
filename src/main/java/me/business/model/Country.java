package me.business.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "COUNTRY" )
public class Country implements Serializable {

	@Column( name = "COUNTRY_ID", nullable = false, precision = 20 )
	@Id
	@SequenceGenerator( name = "CountrySeq", sequenceName = "COUNTRY_SEQ", allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "CountrySeq" )
	private BigDecimal countryId;

	@OneToMany( targetEntity = Birth.class, mappedBy = "country" )
	private Collection<Birth> birthCollection;

	@OneToMany( targetEntity = Address.class, mappedBy = "country" )
	private Collection<Address> addressCollection;

	@Column( name = "CODE", nullable = false, length = 2 )
	@Basic
	private String code;

	@Column( name = "CREATED_ON", nullable = false )
	@Temporal( TemporalType.TIMESTAMP )
	@Basic
	private Date createdOn;

	@Column( name = "MODIFIED_ON")
	@Temporal( TemporalType.TIMESTAMP )
	@Basic
	private Date modifiedOn;

	public Country() {

	}

	public BigDecimal getCountryId() {
		return this.countryId;
	}

	public void setCountryId( BigDecimal country ) {
		this.countryId = country;
	}

	public Collection<Birth> getBirthCollection() {
		return this.birthCollection;
	}

	public void setBirthCollection( Collection<Birth> birthCollection ) {
		this.birthCollection = birthCollection;
	}

	public Collection<Address> getAddressCollection() {
		return this.addressCollection;
	}

	public void setAddressCollection( Collection<Address> addressCollection ) {
		this.addressCollection = addressCollection;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode( String code ) {
		this.code = code;
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
