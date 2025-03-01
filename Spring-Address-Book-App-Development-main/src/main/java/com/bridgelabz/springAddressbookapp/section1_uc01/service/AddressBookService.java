package com.bridgelabz.springAddressbookapp.section1_uc01.service;

import com.bridgelabz.springAddressbookapp.section1_uc01.model.AddressBookEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    // In-memory storage for address book entries
    private List<AddressBookEntry> addressBookEntries = new ArrayList<>();

    // Add a new address book entry
    public AddressBookEntry addAddressBookEntry(AddressBookEntry entry) {
        addressBookEntries.add(entry);
        return entry;
    }

    // Get all address book entries
    public List<AddressBookEntry> getAllAddressBookEntries() {
        return addressBookEntries;
    }

    // Get a specific address book entry by name
    public AddressBookEntry getAddressBookEntryByName(String name) {
        Optional<AddressBookEntry> entry = addressBookEntries.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .findFirst();
        return entry.orElse(null);
    }

    // Delete an address book entry by name
    public boolean deleteAddressBookEntry(String name) {
        return addressBookEntries.removeIf(e -> e.getName().equalsIgnoreCase(name));
    }

    // Update an existing address book entry
    public AddressBookEntry updateAddressBookEntry(String name, AddressBookEntry updatedEntry) {
        AddressBookEntry existingEntry = getAddressBookEntryByName(name);
        if (existingEntry != null) {
            existingEntry.setPhoneNumber(updatedEntry.getPhoneNumber());
            existingEntry.setEmail(updatedEntry.getEmail());
            existingEntry.setAddress(updatedEntry.getAddress());
            return existingEntry;
        }
        return null;
    }
}
