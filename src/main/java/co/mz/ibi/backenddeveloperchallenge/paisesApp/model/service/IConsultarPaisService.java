package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.service;

import java.util.List;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Interface de servico de consulta de paises
 *
 */
public interface IConsultarPaisService {

	public List<Pais> listarPaises();

	public Pais pesquisarPaisPorId(final Long id);

	public List<Pais> ordenarPaisesPorPropriedade(final String propriedade);

}
