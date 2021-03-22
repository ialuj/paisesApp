package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.service;

import java.util.List;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Interface de servico de consulta de paises
 *
 */
public interface IConsultarPaisService {
	
	public List<Pais> listarPaises();
	
	public List<Pais> ordenarPaisesPorId();
	
	public List<Pais> ordenarPaisesPorNome();
	
	public List<Pais> ordenarPaisesPorCapital();
	
	public List<Pais> ordenarPaisesPorRegiao();
	
	public List<Pais> ordenarPaisesPorSubRegiao();
	
	public List<Pais> ordenarPaisesPorArea();
	
	public Pais pesquisarPaisPorId(final Long id);

}
