package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.service;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.exception.NegocioException;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.repository.ManterPaisRepository;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Implementa a interface que disponibiliza servicos de registo,
 *         actualizacao e remocao de paises
 *
 */
@Service
public class ManterPaisService implements IManterPaisService {

	@Autowired
	private ManterPaisRepository manterPaisRepository;

	@Override
	public Pais registarPais(final Pais pais) {
		try {
			return manterPaisRepository.save(pais);
		} catch (final ConstraintViolationException constraintViolationException) {
			throw new NegocioException("Verifique a informação submetida, "
					+ constraintViolationException.getConstraintViolations().iterator().next().getMessage());
		}
	}

	@Override
	public Pais actualizarPais(final Pais pais) {
		if (!verificarExistenciaDePais(pais.getId())) {
			throw new NegocioException("País com ID: " + pais.getId() + " não existe!");
		}
		try {
			return manterPaisRepository.save(pais);
		} catch (final ConstraintViolationException constraintViolationException) {
			throw new NegocioException("Verifique a informação submetida, "
					+ constraintViolationException.getConstraintViolations().iterator().next().getMessage());
		} 
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
