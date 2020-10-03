package it.giuseppe.app.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.giuseppe.app.Entity.Utente;

@Repository
public interface RepositoryUtente extends CrudRepository<Utente, Long> {

}
