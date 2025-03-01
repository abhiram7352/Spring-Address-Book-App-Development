package com.bridgelabz.springAddressbookapp.section1_uc01.controller;

import com.bridgelabz.springAddressbookapp.section1_uc01.model.AddressBookEntry;
import com.bridgelabz.springAddressbookapp.section1_uc01.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Add a new address book entry (POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressBookEntry addAddressBookEntry(@RequestBody AddressBookEntry addressBookEntry) {
        return addressBookService.addAddressBookEntry(addressBookEntry);
    }

    // Get all address book entries (GET)
    @GetMapping
    public List<AddressBookEntry> getAllAddressBookEntries() {
        return addressBookService.getAllAddressBookEntries();
    }

    // Get an address book entry by name (GET)
    @GetMapping("/{name}")
    public AddressBookEntry getAddressBookEntryByName(@PathVariable String name) {
        return addressBookService.getAddressBookEntryByName(name);
    }

    // Update an existing address book entry (PUT)
    @PutMapping("/{name}")
    public AddressBookEntry updateAddressBookEntry(@PathVariable String name,
                                                   @RequestBody AddressBookEntry updatedEntry) {
        return addressBookService.updateAddressBookEntry(name, updatedEntry);
    }

    // Delete an address book entry by name (DELETE)
    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddressBookEntry(@PathVariable String name) {
        addressBookService.deleteAddressBookEntry(name);
    }
}
