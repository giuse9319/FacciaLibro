package it.giuseppe.app.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titolo;
	private String testo;
	private LocalDateTime istanteCreazione = LocalDateTime.now();

	@ManyToOne
	Utente utenteCreazione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public LocalDateTime getIstanteCreazione() {
		return istanteCreazione;
	}

	public void setIstanteCreazione(LocalDateTime istanteCreazione) {
		this.istanteCreazione = istanteCreazione;
	}

	public Utente getUtenteCreazione() {
		return utenteCreazione;
	}

	public void setUtenteCreazione(Utente utenteCreazione) {
		this.utenteCreazione = utenteCreazione;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", titolo=" + titolo + ", testo=" + testo + ", istanteCreazione=" + istanteCreazione
				+ ", utenteCreazione=" + utenteCreazione + "]";
	}

}
