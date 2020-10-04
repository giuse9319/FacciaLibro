package it.giuseppe.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.giuseppe.app.Entity.Post;
import it.giuseppe.app.Entity.Utente;
import it.giuseppe.app.Service.ServicePost;
import it.giuseppe.app.Service.ServiceUtente;

@Controller
@RequestMapping("/faccialibro")
public class ControllerFacciaLibro {

	@Autowired
	ServicePost postService;
	ServiceUtente serviceUtente;

	@GetMapping("/")
	public String paginaPrincipale(Model model, Post post) {
		List<Post> listaPost = postService.leggiPost(post);
		model.addAttribute("listaPost", listaPost);
		return "index-faccialibro";
	}

	@GetMapping("/{utenteCreazione}")
	public String showUtente(@PathVariable Long utenteCreazione, Model model) {
		Utente utenteSelezionato = serviceUtente.mostraUtenteById(utenteCreazione);
		model.addAttribute("utenteSelezionato", utenteSelezionato);
		return "dettagli-utente";
	}

}
