package com;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Address;
import com.entity.Communication;
import com.entity.Contact;
import com.entity.Identification;
import com.repo.AddressRepository;
import com.repo.CommunicationRepository;
import com.repo.ContactRepository;
import com.repo.IdentificationRepository;

@Service("contactService")
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CommunicationRepository communicationRepository;

	@Autowired
	private IdentificationRepository identificationRepository;

	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	public Optional<Contact> getContact(int id) {
		return contactRepository.findById(id);
	}

	public Contact addContact(Contact contact) {
		return contactRepository.save(contact);
	}

	public Optional<Contact> updateContact(Integer contactId, Identification identification) {
		Optional<Identification> oldIdentification = identificationRepository.findById(identification.getId());
		if (oldIdentification.isPresent()) {
			identification.setContact(contactRepository.findById(contactId).get());
			Optional.of(identificationRepository.save(identification));
			return contactRepository.findById(contactId);
		} else {
			return Optional.empty();
		}
	}

	public Optional<Contact> deleteById(Integer id) {
		Optional<Contact> order = contactRepository.findById(id);
		if (order.isPresent()) {
			contactRepository.delete(order.get());
			return order;
		}
		return Optional.empty();
	}

	public Optional<Address> getAddress(Integer id) {
		return addressRepository.findById(id);
	}

	public Optional<Contact> addAddress(Integer contactId, Address address) {
		Optional<Contact> existingContact = contactRepository.findById(contactId);
		if (existingContact.isPresent()) {
			Contact contact = existingContact.get();
			address.setContact(contact);
			if (null != contact.getAddress()) {
				contact.getAddress().add(address);
			} else {
				List<Address> addressList = Arrays.asList(address);
				contact.setAddress(addressList);
			}
			return Optional.of(contactRepository.save(contact));
		} else {
			return Optional.empty();
		}
	}

	public Optional<Contact> updateAddress(Integer contactId, Address address) {
		Optional<Contact> existingContact = contactRepository.findById(contactId);
		Optional<Address> oldAddress = addressRepository.findById(address.getId());
		if (oldAddress.isPresent()) {
			address.setContact(existingContact.get());
			addressRepository.save(address);
			return contactRepository.findById(contactId);
		} else {
			return Optional.empty();
		}
	}

	public Optional<Contact> deleteAddress(Integer contactId, Integer id) {
		Optional<Address> address = addressRepository.findById(id);
		if (address.isPresent()) {
			addressRepository.deleteById(id);
			return contactRepository.findById(contactId);
		}
		return Optional.empty();
	}

	public Optional<Communication> getCommunication(Integer id) {
		return communicationRepository.findById(id);
	}

	public Optional<Contact> addCommunication(Integer contactId, Communication communication) {
		Optional<Contact> existingContact = contactRepository.findById(contactId);
		if (existingContact.isPresent()) {
			Contact contact = existingContact.get();
			communication.setContact(contact);
			if (null != contact.getCommunication()) {
				contact.getCommunication().add(communication);
			} else {
				List<Communication> communicationList = Arrays.asList(communication);
				contact.setCommunication(communicationList);
			}
			return Optional.of(contactRepository.save(contact));
		} else {
			return Optional.empty();
		}
	}

	public Optional<Contact> updateCommunication(Integer contactId, Communication communication) {
		Optional<Contact> existingContact = contactRepository.findById(contactId);
		Optional<Communication> oldCommunication = communicationRepository.findById(communication.getId());
		if (oldCommunication.isPresent()) {
			communication.setContact(existingContact.get());
			communicationRepository.save(communication);
			return contactRepository.findById(contactId);
		} else {
			return Optional.empty();
		}
	}

	public Optional<Contact> deleteCommunication(Integer contactId, Integer id) {
		Optional<Communication> address = communicationRepository.findById(id);
		if (address.isPresent()) {
			communicationRepository.deleteById(id);
			return contactRepository.findById(contactId);
		}
		return Optional.empty();
	}

}
