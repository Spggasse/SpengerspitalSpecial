package at.spg.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cc_codeableconcept")
public class CodeableConcept extends Element {
	
	public CodeableConcept() {
		super();
	}
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Coding.class) 
	@JoinColumn(name = "c_codeableconcept_fk", referencedColumnName = "id")
	private Set <Coding> coding = new HashSet<>();
	
	@Column(name="cc_text")
	private String text;

	public Set<Coding> getCoding() {
		return coding;
	}

	public void setCoding(Set<Coding> coding) {
		this.coding = coding;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public CodeableConcept(Set<Coding> coding, String text) {
		super();
		this.coding = coding;
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((coding == null) ? 0 : coding.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		CodeableConcept other = (CodeableConcept) obj;
		if (coding == null) {
			if (other.coding != null)
				return false;
		} else if (!coding.equals(other.coding))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
	
	
	

}
