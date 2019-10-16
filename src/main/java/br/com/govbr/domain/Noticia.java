package br.com.govbr.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Noticia extends PanacheEntity{
	private String titulo;
	
	private String descricao;
	
	private String texto;
	
	@ManyToMany
	private List<Autor> autores;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
}
