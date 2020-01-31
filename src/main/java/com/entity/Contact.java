package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contact_details")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
	private Identification identification;

	@OneToMany(targetEntity = Address.class, mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> address = new ArrayList<>();

	@OneToMany(targetEntity = Communication.class, mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Communication> communication = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		if (identification == null) {
			if (this.identification != null) {
				this.identification.setContact(null);
			}
		} else {
			identification.setContact(this);
		}
		this.identification = identification;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		address.forEach(i -> i.setContact(this));
		this.address = address;
	}

	public List<Communication> getCommunication() {
		return communication;
	}

	public void setCommunication(List<Communication> communication) {
		communication.forEach(i -> i.setContact(this));
		this.communication = communication;
	}

	public Contact() {

	}

}
