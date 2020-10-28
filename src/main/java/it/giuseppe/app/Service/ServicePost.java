package it.giuseppe.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.giuseppe.app.Entity.Post;
import it.giuseppe.app.Repository.RepositoryPost;
import it.giuseppe.app.Repository.RepositoryUtente;

@Service
public class ServicePost {

	@Autowired
	RepositoryPost postRepository;
	@Autowired
	RepositoryUtente utenteRepository;

//	public List<Post> leggiPost() {
//		List<Post> listaPost = (List<Post>) postRepository.findAll();
//		listaPost.sort((o1, o2) -> o1.getIstanteCreazione().compareTo(o2.getIstanteCreazione()));
//		return listaPost;
//	}
	public List<Post> leggiPost() {

		return (List<Post>) postRepository.findAll();

	}

	public void creaNuovoPost(Post post) {

		post.getIstanteCreazione().now();
		postRepository.save(post);
	}

	public Post mostraDettagliPostById(Long id) {
		return postRepository.findById(id).get();
	}

	public void rimuoviPost(Long id) {
		postRepository.deleteById(id);

	}

}
