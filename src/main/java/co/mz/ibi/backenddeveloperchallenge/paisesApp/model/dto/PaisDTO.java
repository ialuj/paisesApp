package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Objecto de Transferencia de Dados - Vamos retornar este na Response (resposta) as 
 * requisicoes de clientes - consultas, registo, actulizacao de Paises
 *
 */
public class PaisDTO {
	
	private Long id;
	
	private String nome;
	
	private String capital;
	
	private String regiao;
	
	private String subRegiao;
	
	private Double area;

	public PaisDTO() {
		super();
	}

	public PaisDTO(final Pais pais) {
		setId(pais.getId());
		setNome(pais.getNome());
		setCapital(pais.getCapital());
		setRegiao(pais.getRegiao());
		setSubRegiao(pais.getSubRegiao());
		setArea(pais.getArea());
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
