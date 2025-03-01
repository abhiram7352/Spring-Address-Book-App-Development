package com.bridgelabz.springAddressbookapp.section2_uc02.repository;
import com.bridgelabz.springAddressbookapp.section2_uc02.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
    // Additional custom queries can be added here if needed
}
