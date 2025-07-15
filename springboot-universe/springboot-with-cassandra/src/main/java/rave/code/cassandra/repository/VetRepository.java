package rave.code.cassandra.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import rave.code.cassandra.table.Vet;

public interface VetRepository extends CrudRepository<Vet, UUID> {
	public Vet findByFirstName(String username);
}