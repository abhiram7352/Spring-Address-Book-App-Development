package com.bridgelabz.springAddressbookapp.section1_uc02.service;


import com.bridgelabz.springAddressbookapp.section1_uc02.model.Employee;
import com.bridgelabz.springAddressbookapp.section1_uc02.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    // Create or update employee
    public Employee createOrUpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Delete employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
