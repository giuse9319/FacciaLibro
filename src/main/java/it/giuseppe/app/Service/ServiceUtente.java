package it.giuseppe.app.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.giuseppe.app.Entity.Utente;
import it.giuseppe.app.Repository.RepositoryUtente;

@Service
public class ServiceUtente {

	@Autowired
	RepositoryUtente repositoryUtente;
	@Autowired
	ServicePost servicePost;

	public List<Utente> leggiListaUtenti() {
		return (List<Utente>) repositoryUtente.findAll();

	}

	public Utente creaNuovoUtente(Utente utente) {

		utente.setIstanteCreazione(LocalDateTime.now());
		return repositoryUtente.save(utente);

	}

	public Utente mostraUtenteById(Long id) {
		return repositoryUtente.findById(id).get();

	}

	public void rimuoviUtente(Long id) {
		repositoryUtente.deleteById(id);

	}

}
