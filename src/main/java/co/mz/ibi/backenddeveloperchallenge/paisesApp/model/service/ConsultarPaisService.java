package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.exception.NegocioException;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.repository.ConsultarPaisRepository;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Implementacao da interface de servicos de consulta de paises
 *
 */
@Service
public class ConsultarPaisService implements IConsultarPaisService {

	@Autowired
	private ConsultarPaisRepository consultarPaisRepository;

	@Override
	public List<Pais> listarPaises() {
		final List<Pais> pais = consultarPaisRepository.findAll();
		return pais;
	}

	@Override
	public Pais pesquisarPaisPorId(Long id) {
		final Optional<Pais> optPais = consultarPaisRepository.findById(id);
		if (!optPais.isPresent()) {
			throw new NegocioException("Pais com ID: " + id + " nao existe!");
		}
		final Pais pais = optPais.get();
		return pais;
	}

	@Override
	public List<Pais> ordenarPaisesPorPropriedade(String propriedade) {
		final List<Pais> pais = consultarPaisRepository.findAll(Sort.by(Sort.Direction.ASC, propriedade));
		return pais;
	}
}
