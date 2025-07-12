package rave.code.spring.webflux.repository;

import rave.code.spring.webflux.entity.Employee;

import java.util.List;

public interface IEmployeeRepository {

    public void create(Employee e);

    public Employee findById(Integer id);

    public List<Employee> findAll();

    public Employee findByName(String name);

    public Employee update(Employee e);

}
