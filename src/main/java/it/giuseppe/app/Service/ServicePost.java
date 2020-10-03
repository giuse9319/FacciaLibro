package it.giuseppe.app.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.giuseppe.app.Entity.Post;
import it.giuseppe.app.Entity.Utente;
import it.giuseppe.app.Repository.RepositoryPost;
import it.giuseppe.app.Repository.RepositoryUtente;

@Service
public class ServicePost {

	@Autowired
	RepositoryPost postRepository;
	@Autowired
	RepositoryUtente utenteRepository;

	public List<Post> leggiPost() {
		List<Post> listaPost = (List<Post>) postRepository.findAll();
		listaPost.sort((o1, o2) -> o1.getIstanteCreazione().compareTo(o2.getIstanteCreazione()));
		return listaPost;
	}

	public void creaNuovoPost(Post post, Utente utente) {

		List<Utente> listaUtenti = (List<Utente>) utenteRepository.findAll();

		List<Post> listaPost = new ArrayList();

		List<Post> listaPostTutti = (List<Post>) postRepository.findAll();

		post.getIstanteCreazione().now();

		for (Utente u : listaUtenti) {
			if (utente.getNome().equalsIgnoreCase(u.getNome())
					&& (utente.getCognome().equalsIgnoreCase(u.getCognome()))) {

				listaUtenti.add(u);
				listaPost.add(post);
				utenteRepository.save(u);
				postRepository.save(post);
			}
		}

	}

	public Post mostraDettagliPostById(Long id) {
		return postRepository.findById(id).get();
	}

	public void rimuoviPost(Long id) {
		postRepository.deleteById(id);

	}

}
