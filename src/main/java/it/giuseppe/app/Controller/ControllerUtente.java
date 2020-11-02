package it.giuseppe.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.giuseppe.app.Entity.Post;
import it.giuseppe.app.Entity.Utente;
import it.giuseppe.app.Service.ServicePost;
import it.giuseppe.app.Service.ServiceTelefono;
import it.giuseppe.app.Service.ServiceUtente;

@Controller
@RequestMapping("/utenti")
public class ControllerUtente {

	@Autowired
	ServiceUtente serviceUtente;
	@Autowired
	ServiceTelefono serviceTelefono;
	@Autowired
	ServicePost servicePost;

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
		List<Post> postUtenti = servicePost.leggiPost();

		for (Post p : postUtenti) {
			if (p.getUtenteCreazione().getId().equals(id)) {
				utente.getPost().add(p);
			}
		}

		List<Post> listaPostUtente = utente.getPost();

		model.addAttribute("utenteSelezionato", utente);
		model.addAttribute("listaPostUtente", postUtenti);
		model.addAttribute("listaPostUtente", listaPostUtente);
		return "dettagli-utente";
	}

	@PostMapping("/{id}/delete")
	public String deleteUtente(@PathVariable Long id) {
		serviceUtente.rimuoviUtente(id);
		return "redirect:/utenti/";

	}
}
