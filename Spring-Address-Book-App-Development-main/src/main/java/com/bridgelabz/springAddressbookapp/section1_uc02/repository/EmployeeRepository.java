package com.bridgelabz.springAddressbookapp.section1_uc02.repository;
import com.bridgelabz.springAddressbookapp.section1_uc02.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
