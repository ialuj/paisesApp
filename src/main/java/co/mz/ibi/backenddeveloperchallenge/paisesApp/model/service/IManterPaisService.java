package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.service;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Interface que disponibiliza servicos de registo, actualizacao e remocao de paises
 *
 */
public interface IManterPaisService {
	
	public Pais registarPais(final Pais pais);
	
	public Pais actualizarPais(final Pais pais);
	
	public void removerPais(final Long id);

}
