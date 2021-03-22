package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.RequisicaoPais;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.exception.NegocioException;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.repository.ManterPaisRepository;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Implementa a interface que disponibiliza servicos de 
 * registo, actualizacao e remocao de paises
 *
 */
@Service
public class ManterPaisService implements IManterPaisService {

	@Autowired
	private ManterPaisRepository manterPaisRepository;

	@Override
	public Pais registarPais(final RequisicaoPais requisicaoPais) {
		final Pais pais = requisicaoPais.converterParaPais();
		return manterPaisRepository.save(pais);
	}

	@Override
	public Pais actualizarPais(final RequisicaoPais requisicaoPais) {
		final Pais pais = requisicaoPais.converterParaPais();
		if (!verificarExistenciaDePais(pais.getId())) {
			throw new NegocioException("País com ID: " + pais.getId() + " não existe!");
		}
		return manterPaisRepository.save(pais);
	}

	@Override
	public void removerPais(final Long id) {
		if (!verificarExistenciaDePais(id)) {
			throw new NegocioException("País com ID: " + id + " não existe!");
		}
		Optional<Pais> optPais = manterPaisRepository.findById(id);
		final Pais pais = optPais.get();
		manterPaisRepository.delete(pais);
	}

	private boolean verificarExistenciaDePais(final Long id) {
		Optional<Pais> optPais = manterPaisRepository.findById(id);
		return optPais.isPresent();
	}

}
