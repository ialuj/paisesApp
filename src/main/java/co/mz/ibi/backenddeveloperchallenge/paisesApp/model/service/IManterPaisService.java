package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.service;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.RequisicaoPais;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Interface que disponibiliza servicos de registo, actualizacao e remocao de paises
 *
 */
public interface IManterPaisService {
	
	public Pais registarPais(final RequisicaoPais requisicaoPais);
	
	public Pais actualizarPais(final RequisicaoPais requisicaoPais);
	
	public void removerPais(final Long id);

}
