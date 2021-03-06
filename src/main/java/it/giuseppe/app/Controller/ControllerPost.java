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
import it.giuseppe.app.Service.ServicePost;

@Controller
@RequestMapping("/post")
public class ControllerPost {

	@Autowired
	ServicePost postService;

	@GetMapping("/")
	public String leggiPost(Model model) {
		List<Post> listaPost = postService.leggiPost();
		model.addAttribute("listaPost", listaPost);
		return "index-faccialibro";
	}

	@GetMapping("/new")
	public String nuovoPost() {
		return "form-nuovo-post";
	}

	@PostMapping("/")
	public String creaNuovoPost(Post post) {
		postService.creaNuovoPost(post);
		return "redirect:/faccialibro/";

	}

	@GetMapping("/{id}")
	public String mostraDettaglioPost(@PathVariable Long id, Model model) {
		Post listaPost = postService.mostraDettagliPostById(id);
		model.addAttribute("listaPost", listaPost);
		return "index-faccialibro";
	}

	@GetMapping("/{id}/delete")
	public String rimuoviPost(@PathVariable Long id) {
		postService.rimuoviPost(id);
		return "redirect:/faccialibro/";
	}
}