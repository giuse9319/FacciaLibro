package it.giuseppe.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.giuseppe.app.Entity.Utente;
import it.giuseppe.app.Service.ServiceUtente;

@Controller
@RequestMapping("/utenti")
public class ControllerUtente {

	@Autowired
	ServiceUtente serviceUtente;

	@GetMapping("/")
	public String index(Model model) {
		List<Utente> listaUtenti = serviceUtente.leggiListaUtenti();
		model.addAttribute("listaUtenti", listaUtenti);
		return "index-utenti";
	}

	@GetMapping("/new")
	public String nuovoUtente() {
		return "form-nuovo-utente";
	}

	@PostMapping("/")
	public String creaUtente(Utente utente) {
		serviceUtente.creaNuovoUtente(utente);
		return "redirect:/utenti/";
	}

	@GetMapping("/{id}")
	public String mostraUtente(@PathVariable Long id, Model model) {

		Utente utente = serviceUtente.mostraUtenteById(id);
		model.addAttribute("utente", utente);
		return "dettagli-utente";
	}

}
