package com.bridgelabz.springAddressbookapp.section2_uc01.repository;
import com.bridgelabz.springAddressbookapp.section2_uc01.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
    // Additional custom queries can be added here if necessary
}
