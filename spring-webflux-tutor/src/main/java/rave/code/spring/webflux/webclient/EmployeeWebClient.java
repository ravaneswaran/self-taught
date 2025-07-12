package rave.code.spring.webflux.webclient;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import rave.code.spring.webflux.entity.Employee;
import reactor.core.publisher.Mono;

public class EmployeeWebClient {

    public static void main(String args[]) {
        WebClient client = WebClient.create("https://localhost:8080");
        Mono<ClientResponse> result = client.get()
                .uri("/employees/1")
                .retrieve()
                .bodyToMono(ClientResponse.class);

        result.cast(Employee.class).block();
    }
}
