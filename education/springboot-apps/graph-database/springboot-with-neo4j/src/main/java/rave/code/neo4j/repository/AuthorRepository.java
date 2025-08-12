package rave.code.neo4j.repository;

import rave.code.neo4j.nodes.Author;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends Neo4jRepository<Author, String> {
}