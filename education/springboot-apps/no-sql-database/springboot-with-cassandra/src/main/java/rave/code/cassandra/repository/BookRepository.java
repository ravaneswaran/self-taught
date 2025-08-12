package rave.code.cassandra.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import rave.code.cassandra.table.Book;

@Repository
public interface BookRepository extends CassandraRepository<Book, Integer> {
}
