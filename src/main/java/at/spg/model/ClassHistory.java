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

@Entity
public class ClassHistory extends BackboneElement {
	
	public ClassHistory() {
		super();
	}
	
	public ClassHistory(Coding class_, Period period) {
		super();
		
		this.class_ = class_;
		this.period = period;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ch_class_coding_fk", referencedColumnName = "id")
	private Coding class_;
	
	@Embedded
	private Period period;


	public Coding getClass_() {
		return class_;
	}

	public void setClass_(Coding class_) {
		this.class_ = class_;
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
		result = prime * result + ((class_ == null) ? 0 : class_.hashCode());
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
		ClassHistory other = (ClassHistory) obj;
		if (class_ == null) {
			if (other.class_ != null)
				return false;
		} else if (!class_.equals(other.class_))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		return true;
	}
	
}
