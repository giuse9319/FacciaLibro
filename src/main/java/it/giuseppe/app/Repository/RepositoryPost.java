package it.giuseppe.app.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.giuseppe.app.Entity.Post;

@Repository
public interface RepositoryPost extends CrudRepository<Post, Long> {

}
