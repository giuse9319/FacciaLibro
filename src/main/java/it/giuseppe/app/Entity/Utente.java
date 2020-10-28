package it.giuseppe.app.Entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String cognome;
	private String annoDiNascita;
	private String indirizzoResidenza;

	private LocalDateTime istanteCreazione = LocalDateTime.now();

	@OneToMany
	private List<Telefono> numeroTelefono;

	@OneToMany
	private List<Post> post;

	public List<Post> getPost() {
		return post;
	}

	public Utente() {

	}

	public String getAnnoDiNascita() {
		return annoDiNascita;
	}

	public void setAnnoDiNascita(String annoDiNascita) {
		this.annoDiNascita = annoDiNascita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEta() {
		return annoDiNascita;
	}

	public void setEta(String eta) {
		this.annoDiNascita = eta;
	}

	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}

	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}

	public LocalDateTime getIstanteCreazione() {
		return istanteCreazione;
	}

	public void setIstanteCreazione(LocalDateTime istanteCreazione) {
		this.istanteCreazione = istanteCreazione;
	}

	public List<Telefono> getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(List<Telefono> numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + annoDiNascita
				+ ", indirizzoResidenza=" + indirizzoResidenza + ", istanteCreazione=" + istanteCreazione
				+ ", numeroTelefono=" + numeroTelefono + "]";
	}

	public void setPost(List<Post> postUtente) {
		// TODO Auto-generated method stub

	}

}
