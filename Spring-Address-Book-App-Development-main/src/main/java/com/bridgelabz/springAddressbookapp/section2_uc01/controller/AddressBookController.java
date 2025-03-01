package com.bridgelabz.springAddressbookapp.section2_uc01.controller;

import com.bridgelabz.springAddressbookapp.section2_uc01.dto.AddressBookDTO;
import com.bridgelabz.springAddressbookapp.section2_uc01.model.AddressBook;
import com.bridgelabz.springAddressbookapp.section2_uc01.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Get all address book entries (GET)
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllEntries() {
        List<AddressBook> addressBooks = addressBookService.getAllEntries();
        return new ResponseEntity<>(addressBooks, HttpStatus.OK);
    }

    // Get address book entry by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getEntryById(@PathVariable Long id) {
        AddressBook addressBook = addressBookService.getEntryById(id);
        if (addressBook != null) {
            return new ResponseEntity<>(addressBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create or update an address book entry (POST)
    @PostMapping
    public ResponseEntity<AddressBook> createOrUpdateEntry(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook();
        addressBook.setName(addressBookDTO.getName());
        addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
        addressBook.setEmail(addressBookDTO.getEmail());

        AddressBook savedEntry = addressBookService.saveOrUpdateEntry(addressBook);
        return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
    }

    // Update address book entry by ID (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook addressBook = addressBookService.getEntryById(id);
        if (addressBook != null) {
            addressBook.setName(addressBookDTO.getName());
            addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
            addressBook.setEmail(addressBookDTO.getEmail());

            AddressBook updatedEntry = addressBookService.saveOrUpdateEntry(addressBook);
            return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete address book entry by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        addressBookService.deleteEntry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
