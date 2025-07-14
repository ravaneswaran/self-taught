package rave.code.spring.webflux.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import rave.code.spring.webflux.entity.Employee;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveCassandraRepository<Employee, Integer> {

    public Flux<Employee> findByAgeGreaterThan(int age);
}
