package at.spg.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@MappedSuperclass
@Entity
@Table(name="qu_qualification")
public class Qualification extends BackboneElement{

	
	public Qualification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Identifier.class) 
	@JoinColumn(name = "i_qualification_fk", referencedColumnName = "id")
	private Set<Identifier> identifier = new HashSet<>(); //<> Collection braucht man, damit man mehrere Daten benutzen kann (enum)
	
	@OneToOne(cascade = CascadeType.ALL) //codeableconcept erbt von element und deswegen braucht man id dort wie bei element
	@JoinColumn(name = "qu_codeableconcept_fk", referencedColumnName = "id") 
	private CodeableConcept code;
	
	@Embedded //die daten die ich bei period eingetragen haben, werden dann auch automatisch hier eingedragen
	private Period period;

	

	public CodeableConcept getCode() {
		return code;
	}

	
	public void setCode(CodeableConcept code) {
		this.code = code;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
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
		Qualification other = (Qualification) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		return true;
	}

	public Qualification(Set<Identifier> identifier, CodeableConcept code, Period period) {
		super();
		this.identifier = identifier;
		this.code = code;
		this.period = period;
	}

	
	
	
}
