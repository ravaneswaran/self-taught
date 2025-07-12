package rave.code.spring.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rave.code.spring.webflux.entity.Employee;
import rave.code.spring.webflux.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findEmployeeById(String id) {
        return this.employeeRepository.findBy(id);
    }

    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAllEmployees();
    }
}
