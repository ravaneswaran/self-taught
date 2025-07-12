package rave.code.spring.webflux.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rave.code.spring.webflux.entity.Employee;
import rave.code.spring.webflux.repository.IEmployeeRepository;
import rave.code.spring.webflux.service.IEmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService<Employee> {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public void create(Employee e) {
        this.employeeRepository.create(e);
    }

    @Override
    public Mono<Employee> findById(Integer id) {
        return Mono.just(this.employeeRepository.findById(id));
    }

    public Flux<List<Employee>> listAllEmployees(){
        return Flux.just(this.employeeRepository.findAll());
    }

    @Override
    public Flux<Employee> findByName(String name) {
        return Flux.just(this.employeeRepository.findByName(name));
    }

    @Override
    public Mono<Employee> update(Employee e) {
        return Mono.just(this.employeeRepository.update(e));
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return Mono.empty();
    }
}
