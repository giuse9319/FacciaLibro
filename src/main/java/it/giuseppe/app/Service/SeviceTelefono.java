package it.giuseppe.app.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.giuseppe.app.Entity.Telefono;
import it.giuseppe.app.Entity.Utente;
import it.giuseppe.app.Repository.RepositoryTelefono;

@Service
public class SeviceTelefono {

	@Autowired
	RepositoryTelefono telefonoRepository;

	public List<Telefono> creaTelefono(Utente utente) {

		List<Telefono> listaNumeri = new ArrayList<>();

		for (Telefono t : utente.getNumeroTelefono()) {
			telefonoRepository.save(t);
			listaNumeri.add(t);

		}
		return listaNumeri;
	}
}
