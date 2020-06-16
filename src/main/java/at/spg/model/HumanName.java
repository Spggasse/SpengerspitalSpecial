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
@Table(name="hn_humanname")
public class HumanName extends Element {

	
	public HumanName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public enum NameUseCode {usual , official , temp  ,nickname , anonymous , old , maiden}
	
	@Enumerated(EnumType.STRING)
	@Column (name ="hn_nameusecode")
	private NameUseCode code;
	
	@Column (name ="hn_text")
	private String text;
	@Column (name ="hn_family")
	private String family;
	@Column (name ="hn_given")
	private String given;
	@Column (name ="hn_prefix")
	private String prefix;
	@Column (name ="hn_suffix")
	private String suffix;
	@Embedded //die daten die ich bei period eingetragen haben, werden dann auch automatisch hier eingedragen
	private Period period;

	public NameUseCode getCode() {
		return code;
	}
	public void setCode(NameUseCode code) {
		this.code = code;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getGiven() {
		return given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	public HumanName(NameUseCode code, String text, String family, String given, String prefix, String suffix,
			Period period) {
		super();
		this.code = code;
		this.text = text;
		this.family = family;
		this.given = given;
		this.prefix = prefix;
		this.suffix = suffix;
		this.period = period;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + ((given == null) ? 0 : given.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HumanName other = (HumanName) obj;
		if (code != other.code)
			return false;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		if (given == null) {
			if (other.given != null)
				return false;
		} else if (!given.equals(other.given))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (prefix == null) {
			if (other.prefix != null)
				return false;
		} else if (!prefix.equals(other.prefix))
			return false;
		if (suffix == null) {
			if (other.suffix != null)
				return false;
		} else if (!suffix.equals(other.suffix))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	


}

