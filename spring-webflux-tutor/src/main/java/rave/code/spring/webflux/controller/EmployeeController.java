package rave.code.spring.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rave.code.spring.webflux.entity.Employee;
import rave.code.spring.webflux.service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable String id) {
        return Mono.just(this.employeeService.findEmployeeById(id));
    }

    @GetMapping
    public Flux<Employee> getAllEmployees() {
        return Flux.create(new Consumer<FluxSink<Employee>>() {
            @Override
            public void accept(FluxSink<Employee> employeeFluxSink) {
                employeeService.findAllEmployees().forEach(employee -> employeeFluxSink.next(employee));
            }
        });
    }
}
