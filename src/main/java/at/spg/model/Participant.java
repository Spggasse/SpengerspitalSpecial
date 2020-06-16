package at.spg.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Participant extends BackboneElement {
	
	public Participant(Set<CodeableConcept> cc, Period period2, Reference r1) {
		super();
	}
	
	public Participant(Set<Extension> modifierExtension, Set<CodeableConcept> type, Period period,
			Set<Reference> individual) {
		super();
		this.type = type;
		this.period = period;
		this.individual = individual;
	}

	@OneToMany(cascade = CascadeType.ALL, targetEntity = CodeableConcept.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "cc_participant_fk", referencedColumnName = "id")
	private Set<CodeableConcept> type = new HashSet<>();
	
	@Embedded
	private Period period;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Reference.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "r_individual_participant_fk", referencedColumnName = "id")
	private Set<Reference> individual = new HashSet<>();
	
	public Set<CodeableConcept> getType() {
		return type;
	}

	public void setType(Set<CodeableConcept> type) {
		this.type = type;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Set<Reference> getIndividual() {
		return individual;
	}

	public void setIndividual(Set<Reference> individual) {
		this.individual = individual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((individual == null) ? 0 : individual.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Participant other = (Participant) obj;
		if (individual == null) {
			if (other.individual != null)
				return false;
		} else if (!individual.equals(other.individual))
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
    
}
