package com.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "communication")
public class Communication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String type;
	private String value;
	private String preferred;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id",insertable=true, updatable=true, nullable = false, referencedColumnName = "id")
	private Contact contact;
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPreferred() {
		return preferred;
	}

	public void setPreferred(String preferred) {
		this.preferred = preferred;
	}

	public Communication() {

	}
}
