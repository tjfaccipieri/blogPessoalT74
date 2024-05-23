package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity //essa classe vai virar uma entidade (tabela do banco de dados)
@Table(name="tb_postagens") //vai nomear a tabela como tb_postagens lá no banco de dados
public class Postagem {
	
	@Id //define que esse campo vai ser a chave primaria da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // define como a chave primaria vai ser implementada
	//nesse caso, será criada de forma sequencial (1, 2, 3, 4 ...)
	private Long id;
	
	//validando o campo para que ele não possa ficar em branco
	@NotBlank(message = "O atributo titulo é obrigatório")
	//validando o tamanho minimo e maximo do campo
	@Size(min = 5, max = 100, message = "O campo titulo deve ter entre 5 e 100 caracteres")
	private String titulo;
	
	//validando o campo para que ele não possa ficar em branco
	@NotBlank(message = "O atributo titulo é obrigatório")
	//validando o tamanho minimo e maximo do campo
	@Size(min = 10, max = 1000, message = "O campo titulo deve ter entre 10 e 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp // vai pegar a hora do banco de dados, e colocar automaticamente no campo
	private LocalDateTime data; //LocalDateTime é um tipo de dado que já vem com o padrão de data configurado

	@ManyToOne // criar o relacionamento de que muitas postagens pode pertencer a um tema
	@JsonIgnoreProperties("postagem") // ignorando as postagens na lista de tema, pra não dar um loop infinito
	private Tema tema;
	
	//Criando todos os Getters e Setters para a nossa model
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
}
