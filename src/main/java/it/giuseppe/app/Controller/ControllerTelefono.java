package it.giuseppe.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.giuseppe.app.Entity.Telefono;
import it.giuseppe.app.Entity.Utente;
import it.giuseppe.app.Service.ServiceTelefono;

@Controller
@RequestMapping("/telefono")
public class ControllerTelefono {

	@Autowired
	ServiceTelefono serviceTelefono;

	@GetMapping("/")
	public String index(Model model) {

		List<Telefono> listaTelefoni = serviceTelefono.leggiListaUtenti();

		model.addAttribute("listaTelefoni", listaTelefoni);
		return "index-utenti";
	}

	@PostMapping("/")
	public String creaUtente(Telefono telefono, Utente utente) {
		serviceTelefono.creaNuovoTelefono(telefono, utente);
		return "redirect:/utenti/";
	}

}
