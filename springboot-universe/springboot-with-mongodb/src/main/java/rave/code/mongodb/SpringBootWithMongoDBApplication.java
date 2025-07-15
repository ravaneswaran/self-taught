package rave.code.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.query.FluentQuery;
import rave.code.mongodb.documents.User;
import rave.code.mongodb.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class SpringBootWithMongoDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithMongoDBApplication.class, args);
    }

}
