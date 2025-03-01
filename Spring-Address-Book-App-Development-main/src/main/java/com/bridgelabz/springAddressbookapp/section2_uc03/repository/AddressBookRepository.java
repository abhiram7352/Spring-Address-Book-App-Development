package com.bridgelabz.springAddressbookapp.section2_uc03.repository;
import com.bridgelabz.springAddressbookapp.section2_uc03.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
    // Custom query methods can be added if needed
}
