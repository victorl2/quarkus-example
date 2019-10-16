package br.com.govbr.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Autor extends PanacheEntity{
	private String nome;
	
	@ManyToMany
	private List<Noticia> noticiasPublicadas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Noticia> getNoticiasPublicadas() {
		return noticiasPublicadas;
	}

	public void setNoticiasPublicadas(List<Noticia> noticiasPublicadas) {
		this.noticiasPublicadas = noticiasPublicadas;
	}
}
