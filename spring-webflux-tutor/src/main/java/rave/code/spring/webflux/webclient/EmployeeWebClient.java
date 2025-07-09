package rave.code.spring.webflux.webclient;

import org.springframework.web.reactive.function.client.WebClient;
import rave.code.spring.webflux.entity.Employee;
import reactor.core.publisher.Mono;

public class EmployeeWebClient {

    WebClient webClient = WebClient.create("http://localhost:8080/");

    public void getEmployee() {
        Mono<Employee> employeeMono = webClient.get()
                .uri("/employees/{id}", "1")
                .retrieve()
                .bodyToMono(Employee.class);

        employeeMono.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        new EmployeeWebClient().getEmployee();
    }
}
