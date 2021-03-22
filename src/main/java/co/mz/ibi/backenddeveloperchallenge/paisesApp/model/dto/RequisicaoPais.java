package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Objecto esperado no Request - Quando um cliente (app, browser, etc) solicitar
 * registar ou actualizar um Pais
 *
 */
public class RequisicaoPais {

	private Long id;

	private String nome;

	private String capital;

	private String regiao;

	private String subRegiao;

	private Double area;

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

	public Pais converterParaPais() {
		final Pais pais = new Pais();
		pais.setId(this.getId());
		pais.setNome(this.getNome());
		pais.setCapital(this.getCapital());
		pais.setRegiao(this.getRegiao());
		pais.setSubRegiao(this.getSubRegiao());
		pais.setArea(this.getArea());
		return pais;
	}

	public PaisDTO converterParaPaisDTO(final Pais pais) {
		final PaisDTO dto = new PaisDTO(pais);
		this.setId(pais.getId());
		this.setNome(pais.getNome());
		this.setCapital(pais.getCapital());
		this.setRegiao(pais.getRegiao());
		this.setSubRegiao(pais.getSubRegiao());
		this.setArea(pais.getArea());
		return dto;
	}

}
