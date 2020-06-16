package at.spg.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable 
public class Period {
	
	@Column(name="pe_start")
	private LocalDateTime start;
	
	@Column(name="pe_ende")
	private LocalDateTime ende;

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnde() {
		return ende;
	}

	public void setEnde(LocalDateTime ende) {
		this.ende = ende;
	}

	public Period(LocalDateTime start, LocalDateTime ende) {
		super();
		this.start = start;
		this.ende = ende;
	}

	public Period() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ende == null) ? 0 : ende.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		Period other = (Period) obj;
		if (ende == null) {
			if (other.ende != null)
				return false;
		} else if (!ende.equals(other.ende))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}
	
	

}
