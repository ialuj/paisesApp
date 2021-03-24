package co.mz.ibi.backenddeveloperchallenge.paisesApp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.PaisDTO;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.exception.NegocioException;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.service.IManterPaisService;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Classe que implementa a interface que disponiliza web services de 
 * registo, actualizacao e remocao de Paises
 *
 */
@RestController
@RequestMapping("api/v1/paises")
public class ManterPaisWs implements IManterPaisWs {

	@Autowired
	private IManterPaisService manterPaisService;

	@Override
	@PostMapping
	public ResponseEntity<PaisDTO> registarPais(final PaisDTO paisDTO) {
		try {
			Pais pais = new Pais(paisDTO.getNome(), paisDTO.getCapital(), paisDTO.getRegiao(), paisDTO.getSubRegiao(), paisDTO.getArea());
			manterPaisService.registarPais(pais);
			ResponseEntity<PaisDTO> response = ResponseEntity.ok(new PaisDTO(pais));
			return response;
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<PaisDTO> actualizarPais(final PaisDTO paisDTO) {
		try {
			Pais pais = new Pais(paisDTO.getId(), paisDTO.getNome(), paisDTO.getCapital(), paisDTO.getRegiao(), paisDTO.getSubRegiao(), paisDTO.getArea());
			manterPaisService.actualizarPais(pais);
			ResponseEntity<PaisDTO> response = ResponseEntity.ok(paisDTO);
			return response;
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity removerPais(Long id) {
		try {
			manterPaisService.removerPais(id);
			return ResponseEntity.ok(id);
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
