package at.spg.model;

import java.time.LocalDateTime;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="at_attachment")
public class Attachment extends Element{
	
	public enum contentType {eins,zwei,drei}
	
	@Enumerated(EnumType.STRING)
	@Column (name ="at_contenttype")
	private contentType contentType;
	

	public enum Language {de,e,sp,it,fr}
	
	@Enumerated(EnumType.STRING)
	@Column (name ="at_language")
	private Language language;
	@Column (name ="at_data")
	private String data;
	@Column (name ="at_url")
	private String url;
	@Column (name ="at_size")
	private int size;
	@Column (name ="at_hash")
	private String hash;
	@Column (name ="at_title")
	private String title;
	@Column (name ="at_creation")
	private LocalDateTime creation;
	
	public contentType getContentType() {
		return contentType;
	}
	public void setContentType(contentType contentType) {
		this.contentType = contentType;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getCreation() {
		return creation;
	}
	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}
	public Attachment(at.spg.model.Attachment.contentType contentType, Language language, String data, String url, int size,
			String hash, String title, LocalDateTime creation) {
		super();
		this.contentType = contentType;
		this.language = language;
		this.data = data;
		this.url = url;
		this.size = size;
		this.hash = hash;
		this.title = title;
		this.creation = creation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((creation == null) ? 0 : creation.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + size;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Attachment other = (Attachment) obj;
		if (contentType != other.contentType)
			return false;
		if (creation == null) {
			if (other.creation != null)
				return false;
		} else if (!creation.equals(other.creation))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (language != other.language)
			return false;
		if (size != other.size)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	

}
