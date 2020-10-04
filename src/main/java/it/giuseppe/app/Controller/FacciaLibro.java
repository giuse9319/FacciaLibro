package it.giuseppe.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.giuseppe.app.Entity.Post;
import it.giuseppe.app.Service.ServicePost;

@Controller
@RequestMapping("/faccialibro")
public class FacciaLibro {

	@Autowired
	ServicePost postService;

	@GetMapping("/")
	public String paginaPrincipale(Model model) {
		List<Post> listaPost = postService.leggiPost();
		model.addAttribute("listaPost", listaPost);
		return "index-faccialibro";
	}
}
