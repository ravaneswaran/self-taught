package rave.code.spring.webflux.service;

import rave.code.spring.webflux.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService<T> {

    public void create(Employee T);

    public Mono<T> findById(Integer id);

    public Flux<T> findByName(String name);

    public Mono<T> update(Employee e);

    public Mono<Void> delete(Integer id);
}
