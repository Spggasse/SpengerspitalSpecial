package at.spg.model;

import java.time.LocalDateTime;
import at.spg.model.Period;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;



@Entity
@Table(name="cp_contactpoint")
public class ContactPoint extends Element{
	
	public ContactPoint()
	{super();}
	
public enum UseContactPoint {phone, fax, email, pager, url, sms, other}
	
	@Enumerated(EnumType.STRING)
	@Column (name ="cp_system")
	private UseContactPoint contactpoint;
	@Column (name ="cp_value")
	private String value;
	public enum UseCode {home,work,temp,old,mobile}
	
	@Enumerated(EnumType.STRING)
	@Column (name ="cp_use")
	private UseCode use;
	@Embedded //die daten die ich bei period eingetragen haben, werden dann auch automatisch hier eingedragen
	private Period period;
	
	@Column (name="cp_rank")
	private String rank;
	
	public UseContactPoint getContactpoint() {
		return contactpoint;
	}
	public void setContactpoint(UseContactPoint contactpoint) {
		this.contactpoint = contactpoint;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	public ContactPoint(UseContactPoint contactpoint, String value, UseCode use, Period period, String rank) {
		super();
		this.contactpoint = contactpoint;
		this.value = value;
		this.use = use;
		this.period = period;
		this.rank = rank;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contactpoint == null) ? 0 : contactpoint.hashCode());
		result = prime * result + ((use == null) ? 0 : use.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactPoint other = (ContactPoint) obj;
		if (contactpoint != other.contactpoint)
			return false;
		if (use != other.use)
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
	
}
