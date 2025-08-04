package rave.code.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.config.EnableNeo4jAuditing;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jAuditing
@EnableNeo4jRepositories(basePackages = {"rave.code.neo4j.repository"})
public class SpringBootWithNeo4JApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithNeo4JApplication.class, args);
    }
}
