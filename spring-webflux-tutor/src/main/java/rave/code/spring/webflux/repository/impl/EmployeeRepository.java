package rave.code.spring.webflux.repository.impl;

import org.springframework.stereotype.Repository;
import rave.code.spring.webflux.entity.Employee;
import rave.code.spring.webflux.repository.IEmployeeRepository;
import rave.code.spring.webflux.repository.SpringWebFluxRepository;

import java.util.List;

@Repository
public class EmployeeRepository extends SpringWebFluxRepository<Employee> implements IEmployeeRepository {

    public EmployeeRepository() {
        super(Employee.class);
    }

    @Override
    public void create(Employee e) {
        this.save(e);
    }

    @Override
    public Employee findById(Integer id) {
        return this.findBy(String.valueOf(id));
    }

    @Override
    public Employee findByName(String name) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return super.findAll();
    }
}
