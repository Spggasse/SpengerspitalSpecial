package at.spg.model;

import at.spg.model.Period;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Entity
@Table(name="a_address")
public class Address extends Element {
	
	public Address()
	{super();}
public enum UseCode {home,  work, temp, old, billing}
	
	@Enumerated(EnumType.STRING)
	@Column (name ="a_usecode")
	private UseCode usecode;
	
public enum UseType {postal, physical, both}
	
	@Enumerated(EnumType.STRING)
	@Column (name ="a_usetype")
	private UseType usetype;
	
	@Column (name ="a_text")
	private String text;
	@Column (name ="a_line")
	private String line;
	@Column (name ="a_city")
	private String city;
	@Column (name ="a_district")
	private String district;
	@Column (name ="a_state")
	private String state;
	@Column (name ="a_postalcode")
	private String postalCode;
	@Column (name ="a_country")
	private String country;
	@Column (name ="a_period")
	@Embedded //die daten die ich bei period eingetragen haben, werden dann auch automatisch hier eingedragen
	private Period period;
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	public UseCode getUsecode() {
		return usecode;
	}
	public void setUsecode(UseCode usecode) {
		this.usecode = usecode;
	}
	public UseType getUsetype() {
		return usetype;
	}
	public void setUsetype(UseType usetype) {
		this.usetype = usetype;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address(UseCode usecode, UseType usetype, String text, String line, String city, String district,
			String state, String postalCode, String country, Period period) {
		super();
		this.usecode = usecode;
		this.usetype = usetype;
		this.text = text;
		this.line = line;
		this.city = city;
		this.district = district;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.period = period;
	}

	

}
