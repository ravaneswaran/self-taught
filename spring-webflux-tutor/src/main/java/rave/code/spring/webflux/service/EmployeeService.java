package rave.code.spring.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rave.code.spring.webflux.entity.Employee;
import rave.code.spring.webflux.repository.EmployeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void initializeEmployees(List<Employee> employees) {
        Flux<Employee> savedEmployees = this.employeeRepository.saveAll(employees);
        savedEmployees.subscribe();
    }

    public Flux<Employee> getAllEmployees() {
        Flux<Employee> employees =  this.employeeRepository.findAll();
        return employees;
    }

    public Flux<Employee> getEmployeesFilterByAge(int age) {
        return this.employeeRepository.findByAgeGreaterThan(age);
    }

    public Mono<Employee> getEmployeeById(int id) {
        return this.employeeRepository.findById(id);
    }
}