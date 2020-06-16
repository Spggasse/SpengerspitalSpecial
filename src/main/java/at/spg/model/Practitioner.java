package at.spg.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import at.spg.model.Patient.GenderCode;

@Entity
@Table(name="pr_practicioner")
public class Practitioner extends DomainResource {
	
	public Practitioner() { super();	}
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Identifier.class) 
	@JoinColumn(name = "i_practitioner_fk", referencedColumnName = "id")
	private Set<Identifier> identifier = new HashSet<>(); //<> Collection braucht man, damit man mehrere Daten benutzen kann (enum)
	
	@Column(name="pr_active") //gibt an wie viele spalten es gibt und wie sie heißen soll
	private boolean active;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = HumanName.class) 
	@JoinColumn(name = "h_practitioner_fk", referencedColumnName = "id")
	private Set<HumanName> humanname = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = ContactPoint.class) 
	@JoinColumn(name = "c_practitioner_fk", referencedColumnName = "id")
	private Set<ContactPoint> contactpoint = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Address.class) 
	@JoinColumn(name = "a_practitioner_fk", referencedColumnName = "id")
	private Set<Address> address = new HashSet<>();
	
	@Enumerated(EnumType.STRING)
	@Column (name="pr_gender")
	private GenderCode gender;
	@Column(name="pr_birthdate")
	private LocalDate birthDate;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Attachment.class) 
	@JoinColumn(name = "at_practitioner_fk", referencedColumnName = "id")
	private Set<Attachment> attachment = new HashSet<>();
	
	@Embedded //die daten die ich bei period eingetragen haben, werden dann auch automatisch hier eingedragen
	private Period period;

	
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Qualification.class) 
	@JoinColumn(name = "qu_practitioner_fk", referencedColumnName = "id")
	private Set<Qualification> qualification= new HashSet<>();
	
	
	
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = CodeableConcept.class) 
	@JoinColumn(name = "cc_practitioner_fk", referencedColumnName = "id")
	private Set<CodeableConcept> communication = new HashSet<>();

	public Set<Identifier> getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Set<Identifier> identifier) {
		this.identifier = identifier;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<HumanName> getHumanname() {
		return humanname;
	}

	public void setHumanname(Set<HumanName> humanname) {
		this.humanname = humanname;
	}

	public Set<ContactPoint> getContactpoint() {
		return contactpoint;
	}

	public void setContactpoint(Set<ContactPoint> contactpoint) {
		this.contactpoint = contactpoint;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public GenderCode getGender() {
		return gender;
	}

	public void setGender(GenderCode gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Set<Attachment> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<Attachment> attachment) {
		this.attachment = attachment;
	}

	public Set<Qualification> getQualification() {
		return qualification;
	}

	public void setQualification(Set<Qualification> qualification) {
		this.qualification = qualification;
	}

	public Set<CodeableConcept> getCommunication() {
		return communication;
	}

	public void setCommunication(Set<CodeableConcept> communication) {
		this.communication = communication;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Practitioner(Set<Identifier> identifier, boolean active, Set<HumanName> humanname,
			Set<ContactPoint> contactpoint, Set<Address> address, GenderCode gender, LocalDate birthDate,
			Set<Attachment> attachment, Period period, Set<Qualification> qualification,
			Set<CodeableConcept> communication) {
		super();
		this.identifier = identifier;
		this.active = active;
		this.humanname = humanname;
		this.contactpoint = contactpoint;
		this.address = address;
		this.gender = gender;
		this.birthDate = birthDate;
		this.attachment = attachment;
		this.period = period;
		this.qualification = qualification;
		this.communication = communication;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((communication == null) ? 0 : communication.hashCode());
		result = prime * result + ((contactpoint == null) ? 0 : contactpoint.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((humanname == null) ? 0 : humanname.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
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
		Practitioner other = (Practitioner) obj;
		if (active != other.active)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (attachment == null) {
			if (other.attachment != null)
				return false;
		} else if (!attachment.equals(other.attachment))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (communication == null) {
			if (other.communication != null)
				return false;
		} else if (!communication.equals(other.communication))
			return false;
		if (contactpoint == null) {
			if (other.contactpoint != null)
				return false;
		} else if (!contactpoint.equals(other.contactpoint))
			return false;
		if (gender != other.gender)
			return false;
		if (humanname == null) {
			if (other.humanname != null)
				return false;
		} else if (!humanname.equals(other.humanname))
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
		if (qualification == null) {
			if (other.qualification != null)
				return false;
		} else if (!qualification.equals(other.qualification))
			return false;
		return true;
	}


	
}
