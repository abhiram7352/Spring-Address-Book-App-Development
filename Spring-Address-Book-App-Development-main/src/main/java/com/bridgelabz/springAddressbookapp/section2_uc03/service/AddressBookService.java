package com.bridgelabz.springAddressbookapp.section2_uc03.service;

import com.bridgelabz.springAddressbookapp.section2_uc03.model.AddressBook;
import com.bridgelabz.springAddressbookapp.section2_uc03.dto.AddressBookDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    // In-memory storage for AddressBook
    private List<AddressBook> addressBookList = new ArrayList<>();
    private Long nextId = 1L;

    // Get all address book entries
    public List<AddressBook> getAllEntries() {
        return addressBookList;
    }

    // Get an address book entry by ID
    public AddressBook getEntryById(Long id) {
        for (AddressBook addressBook : addressBookList) {
            if (addressBook.getId().equals(id)) {
                return addressBook;
            }
        }
        return null;  // Return null if not found
    }

    // Save or update address book entry
    public AddressBook saveOrUpdateEntry(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook();
        addressBook.setId(nextId++);
        addressBook.setName(addressBookDTO.getName());
        addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
        addressBook.setEmail(addressBookDTO.getEmail());

        addressBookList.add(addressBook);
        return addressBook;
    }

    // Update address book entry by ID
    public AddressBook updateEntry(Long id, AddressBookDTO addressBookDTO) {
        AddressBook existingAddressBook = getEntryById(id);
        if (existingAddressBook != null) {
            existingAddressBook.setName(addressBookDTO.getName());
            existingAddressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
            existingAddressBook.setEmail(addressBookDTO.getEmail());
            return existingAddressBook;
        }
        return null;
    }

    // Delete address book entry by ID
    public boolean deleteEntry(Long id) {
        AddressBook addressBook = getEntryById(id);
        if (addressBook != null) {
            addressBookList.remove(addressBook);
            return true;
        }
        return false;
    }
}