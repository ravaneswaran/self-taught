package rave.code.spring.webflux.repository;

import org.springframework.stereotype.Repository;
import rave.code.spring.webflux.entity.Employee;

import java.util.List;

@Repository
public class EmployeeRepository extends SpringWebFluxRepository<Employee>{

    public  EmployeeRepository(){
        super(Employee.class);
    }

    public Employee findEmployeeById(String id) {
        return this.findBy(id);
    }

    public List<Employee> findAllEmployees() {
        return null;
    }
}
