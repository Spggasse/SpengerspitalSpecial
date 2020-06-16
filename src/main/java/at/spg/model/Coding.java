package at.spg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="c_coding")
public class Coding extends Element {
	
	public Coding() {
		super(); //wenn man das hinschreibt, wird der Konstriktor der überliegedenden klasse (element) verwendet
	};
	
	@Column(name="c_version")
	private String version;
	@Column(name="c_display")
	private String display;
	@Column(name="c_code")
	private String code;
	@Column(name="c_system")
	private String system;
	@Column(name="c_user_selected")
	private boolean userSelected;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public boolean isUserSelected() {
		return userSelected;
	}
	public void setUserSelected(boolean userSelected) {
		this.userSelected = userSelected;
	}
	public Coding(String version, String display, String code, String system, boolean userSelected) {
		super();
		this.version = version;
		this.display = display;
		this.code = code;
		this.system = system;
		this.userSelected = userSelected;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((display == null) ? 0 : display.hashCode());
		result = prime * result + ((system == null) ? 0 : system.hashCode());
		result = prime * result + (userSelected ? 1231 : 1237);
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Coding other = (Coding) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (display == null) {
			if (other.display != null)
				return false;
		} else if (!display.equals(other.display))
			return false;
		if (system == null) {
			if (other.system != null)
				return false;
		} else if (!system.equals(other.system))
			return false;
		if (userSelected != other.userSelected)
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	
}
