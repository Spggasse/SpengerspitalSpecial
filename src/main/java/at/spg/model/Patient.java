package at.spg.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import at.spg.model.Identifier;

@Entity //sagt Java Presistens(Hypernate) es soll diese Klasse beachten und in der db umsetzen
@Table(name="p_patient")
public class Patient extends DomainResource {
	
	@Column(name="p_active") //gibt an wie viele spalten es gibt und wie sie heißen soll
	private boolean active;
	
	
	public enum GenderCode{
		male, female, other, unknown
	}
	
	@Enumerated (EnumType.STRING)//Enumerated alleine gibt nur an an welcher position der wert steht, also statt unknowen --> 4, mit EnymType steht das der String wert dort
	private GenderCode code;
	
	@Enumerated (EnumType.STRING)
	@Column (name="p_gender")
	private GenderCode gender;
	
	@Column(name="p_birthdate")
	private LocalDate birthdate;
	@Column(name="p_deceasedBoolean")
	private boolean deceasedBoolean;
	

	@OneToMany(cascade = CascadeType.ALL,targetEntity = Identifier.class) 
	@JoinColumn(name = "i_patient_fk", referencedColumnName = "id")
	private Set<Identifier> identifier = new HashSet<>(); //<> Collection braucht man, damit man mehrere Daten benutzen kann (enum)
	@OneToMany(cascade = CascadeType.ALL,targetEntity = HumanName.class,fetch = FetchType.EAGER) 
	@JoinColumn(name = "hn_patient_fk", referencedColumnName = "id")
	private Set<HumanName> humanname = new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL,targetEntity = ContactPoint.class) 
	@JoinColumn(name = "cp_patient_fk", referencedColumnName = "id")
	private Set<ContactPoint> contactpoint = new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Address.class) 
	@JoinColumn(name = "a_patient_fk", referencedColumnName = "id")
	private Set<Address> address = new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Attachment.class) 
	@JoinColumn(name = "at_patient_fk", referencedColumnName = "id")
	private Set<Attachment> attachment = new HashSet<>();
	
	
	public Set<Identifier> getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Set<Identifier> identifier) {
		this.identifier = identifier;
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


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public GenderCode getGender() {
		return gender;
	}

	public void setGender(GenderCode gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthdate;
	}

	public void setBirthDate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public boolean isDeceasedBoolean() {
		return deceasedBoolean;
	}

	public void setDeceasedBoolean(boolean deceasedBoolean) {
		this.deceasedBoolean = deceasedBoolean;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Set<Attachment> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<Attachment> attachment) {
		this.attachment = attachment;
	}

	public Patient(boolean active,  GenderCode gender, LocalDate birthdate, boolean deceasedBoolean, Set<Identifier> identifier, Set<HumanName> name, Set<ContactPoint> contactpoint,Set<Address> address, Set<Attachment>attachment) {
		super();
		this.active = active;
		//GenderCode code,
		//this.code = code;
		this.gender = gender;
		this.birthdate = birthdate;
		this.deceasedBoolean = deceasedBoolean;
		this.identifier = identifier;
		this.humanname = name;
		this.contactpoint = contactpoint;
		this.address = address;
		this.attachment = attachment;
	}

	public Patient()
	{
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((contactpoint == null) ? 0 : contactpoint.hashCode());
		result = prime * result + (deceasedBoolean ? 1231 : 1237);
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((humanname == null) ? 0 : humanname.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
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
		Patient other = (Patient) obj;
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
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (code != other.code)
			return false;
		if (contactpoint == null) {
			if (other.contactpoint != null)
				return false;
		} else if (!contactpoint.equals(other.contactpoint))
			return false;
		if (deceasedBoolean != other.deceasedBoolean)
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
		return true;
	}
	
	
	

}
