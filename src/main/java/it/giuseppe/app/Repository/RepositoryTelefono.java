package it.giuseppe.app.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.giuseppe.app.Entity.Telefono;

@Repository
public interface RepositoryTelefono extends CrudRepository<Telefono, Long> {

}
