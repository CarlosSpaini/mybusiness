package me.business.model;

import java.io.Serializable;
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
@Table( name = "BIRTH" )
public class Birth implements Serializable {

	@ManyToOne( targetEntity = Country.class )
	@JoinColumn( name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", insertable = true, nullable = true, unique = false, updatable = true )
	private Country country;

	@Column( name = "CREATED_ON", table = "BIRTH", nullable = false )
	@Temporal( TemporalType.TIMESTAMP )
	@Basic
	private Date createdOn;

	@Column( name = "BIRTH_CITY", table = "BIRTH", length = 250 )
	@Basic
	private String birthCity;

	@Column( name = "MODIFIED_ON", table = "BIRTH" )
	@Temporal( TemporalType.TIMESTAMP )
	@Basic
	private Date modifiedOn;

	@Column( name = "BIRTH_ID", table = "BIRTH", nullable = false, precision = 20 )
	@Id
	private BigDecimal birthId;

	@Column( name = "BIRTH_DATE", table = "BIRTH", length = 10 )
	@Basic
	private String birthDate;

	public Birth() {

	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry( Country country ) {
		this.country = country;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn( Date createdOn ) {
		this.createdOn = createdOn;
	}

	public String getBirthCity() {
		return this.birthCity;
	}

	public void setBirthCity( String birthCity ) {
		this.birthCity = birthCity;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn( Date modifiedOn ) {
		this.modifiedOn = modifiedOn;
	}

	public BigDecimal getBirthId() {
		return this.birthId;
	}

	public void setBirthId( BigDecimal birthId ) {
		this.birthId = birthId;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate( String birthDate ) {
		this.birthDate = birthDate;
	}

}
