package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ContactService;
import com.entity.Address;
import com.entity.Communication;
import com.entity.Contact;
import com.entity.Identification;

@RestController
@RequestMapping(value = "/contact-service")
public class ContactRestController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/contact")
	public ResponseEntity<List<Contact>> getContacts() {
		return new ResponseEntity<List<Contact>>(contactService.getAllContacts(), HttpStatus.OK);
	}

	@GetMapping("/contact/{id}")
	public ResponseEntity<Contact> getContact(@PathVariable Integer id) {
		Optional<Contact> contact = contactService.getContact(id);
		if (contact.isPresent())
			return new ResponseEntity<Contact>(contact.get(), HttpStatus.OK);
		return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/contact/{id}/identification")
	public ResponseEntity<Contact> updateContact(@PathVariable Integer id, @RequestBody Identification identification) {
		Optional<Contact> result = contactService.updateContact(id, identification);
		if (result.isPresent()) {
			return new ResponseEntity<Contact>(result.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/contact")
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
		return new ResponseEntity<Contact>(contactService.addContact(contact), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/contact/{id}")
	public ResponseEntity<Contact> deleteContact(@PathVariable Integer id) {
		Optional<Contact> order = contactService.deleteById(id);
		if (!order.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(order.get(), HttpStatus.OK);
	}

	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddress(@PathVariable Integer id) {
		Optional<Address> address = contactService.getAddress(id);
		if (!address.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Address>(address.get(), HttpStatus.OK);

	}

	@PostMapping("/contact/{contactId}/address")
	public ResponseEntity<Contact> addAddress(@PathVariable Integer contactId, @RequestBody Address address) {
		Optional<Contact> contact = contactService.addAddress(contactId, address);
		if (!contact.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(contact.get(), HttpStatus.CREATED);
	}

	@PutMapping("/contact/{contactId}/address")
	public ResponseEntity<Contact> updateAddress(@PathVariable Integer contactId, @RequestBody Address address) {
		Optional<Contact> contact = contactService.updateAddress(contactId, address);
		if (!contact.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(contact.get(), HttpStatus.OK);
	}

	@DeleteMapping("/contact/{contactId}/address/{id}")
	public ResponseEntity<Contact> deleteAddress(@PathVariable Integer contactId, @PathVariable Integer id) {
		Optional<Contact> contact = contactService.deleteAddress(contactId, id);
		if (!contact.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(contact.get(), HttpStatus.OK);
	}

	@GetMapping("/communication/{id}")
	public ResponseEntity<Communication> getCommunication(@PathVariable Integer id) {
		Optional<Communication> communication = contactService.getCommunication(id);
		if (!communication.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Communication>(communication.get(), HttpStatus.OK);

	}

	@PostMapping("/contact/{contactId}/communication")
	public ResponseEntity<Contact> addCommunication(@PathVariable Integer contactId,
			@RequestBody Communication communication) {
		Optional<Contact> contact = contactService.addCommunication(contactId, communication);
		if (!contact.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(contact.get(), HttpStatus.CREATED);
	}

	@PutMapping("/contact/{contactId}/communication")
	public ResponseEntity<Contact> updateCommunication(@PathVariable Integer contactId,
			@RequestBody Communication communication) {
		Optional<Contact> contact = contactService.updateCommunication(contactId, communication);
		if (!contact.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(contact.get(), HttpStatus.OK);
	}

	@DeleteMapping("/contact/{contactId}/communication/{id}")
	public ResponseEntity<Contact> deleteCommunication(@PathVariable Integer contactId, @PathVariable Integer id) {
		Optional<Contact> contact = contactService.deleteCommunication(contactId, id);
		if (!contact.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(contact.get(), HttpStatus.CREATED);
	}

}
