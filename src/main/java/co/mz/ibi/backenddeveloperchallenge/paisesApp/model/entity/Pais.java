package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Classe Pais
 *
 */
@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Indique o Nome do País")
	private String nome;
	
	@NotBlank(message = "Indique a Capital do País")
	private String capital;
	
	@NotBlank(message = "Indique a Região do País")
	private String regiao;
	
	private String subRegiao;
	
	@NotNull(message = "Indique a área do País")
	private Double area;

	public Pais() {
		super();
	}

	public Pais(String nome, String capital, String regiao, String subRegiao, Double area) {
		super();
		this.nome = nome;
		this.capital = capital;
		this.regiao = regiao;
		this.subRegiao = subRegiao;
		this.area = area;
	}

	public Pais(Long id, String nome, String capital, String regiao, String subRegiao, Double area) {
		super();
		this.id = id;
		this.nome = nome;
		this.capital = capital;
		this.regiao = regiao;
		this.subRegiao = subRegiao;
		this.area = area;
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

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getSubRegiao() {
		return subRegiao;
	}

	public void setSubRegiao(String subRegiao) {
		this.subRegiao = subRegiao;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}
}
