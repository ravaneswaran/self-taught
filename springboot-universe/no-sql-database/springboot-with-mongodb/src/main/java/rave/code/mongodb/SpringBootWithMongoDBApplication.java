package rave.code.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import rave.code.mongodb.repository.UserRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class SpringBootWithMongoDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithMongoDBApplication.class, args);
    }

}
