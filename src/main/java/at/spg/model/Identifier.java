package at.spg.model;

import at.spg.model.Period;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="i_identifier")
public class Identifier extends Element {
	
	public Identifier()
	{super();}
	
	public enum UseCode {usual, official, temp, second}
	
	@Enumerated(EnumType.STRING)
	@Column (name ="i_code")
	private UseCode code;
	
	@OneToOne(cascade = CascadeType.ALL) //codeableconcept erbt von element und deswegen braucht man id dort wie bei element
	@JoinColumn(name = "i_codeableconcept_fk", referencedColumnName = "id") 
	private CodeableConcept type;
	
	@Column(name="i_system")
	private String system;
	@Column(name="i_value")
	private String value;
	
	@Embedded //die daten die ich bei period eingetragen haben, werden dann auch automatisch hier eingedragen
	private Period period;

	public UseCode getCode() {
		return code;
	}

	public void setCode(UseCode code) {
		this.code = code;
	}

	public CodeableConcept getType() {
		return type;
	}

	public void setType(CodeableConcept type) {
		this.type = type;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Identifier(UseCode code, CodeableConcept type, String system, String value, Period period) {
		super();
		this.code = code;
		this.type = type;
		this.system = system;
		this.value = value;
		this.period = period;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + ((system == null) ? 0 : system.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Identifier other = (Identifier) obj;
		if (code != other.code)
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (system == null) {
			if (other.system != null)
				return false;
		} else if (!system.equals(other.system))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	

	
}
