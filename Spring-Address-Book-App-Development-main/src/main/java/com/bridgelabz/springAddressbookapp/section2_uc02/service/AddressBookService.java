package com.bridgelabz.springAddressbookapp.section2_uc02.service;

import com.bridgelabz.springAddressbookapp.section2_uc02.model.AddressBook;
import com.bridgelabz.springAddressbookapp.section2_uc02.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    // Get all address book entries
    public List<AddressBook> getAllEntries() {
        return addressBookRepository.findAll();
    }

    // Get an address book entry by ID
    public AddressBook getEntryById(Long id) {
        Optional<AddressBook> addressBook = addressBookRepository.findById(id);
        return addressBook.orElse(null);  // Return null if not found
    }

    // Save or update address book entry
    public AddressBook saveOrUpdateEntry(AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }

    // Delete address book entry by ID
    public void deleteEntry(Long id) {
        addressBookRepository.deleteById(id);
    }
}
