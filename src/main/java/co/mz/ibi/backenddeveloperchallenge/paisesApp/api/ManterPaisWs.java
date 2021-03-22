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
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.RequisicaoPais;
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
@RequestMapping("api/v1/manterpaises")
public class ManterPaisWs implements IManterPaisWs {

	@Autowired
	private IManterPaisService manterPaisService;

	@Override
	@PostMapping("/registarpais")
	public ResponseEntity<PaisDTO> registarPais(RequisicaoPais requisicaoPais) {
		try {
			final Pais pais = manterPaisService.registarPais(requisicaoPais);
			final PaisDTO dto = new PaisDTO(pais);
			ResponseEntity<PaisDTO> response = ResponseEntity.ok(dto);
			return response;
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	@PutMapping("/actualizarpais")
	public ResponseEntity<PaisDTO> actualizarPais(RequisicaoPais requisicaoPais) {
		try {
			final Pais pais = manterPaisService.actualizarPais(requisicaoPais);
			final PaisDTO dto = new PaisDTO(pais);
			ResponseEntity<PaisDTO> response = ResponseEntity.ok(dto);
			return response;
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Override
	@DeleteMapping("/removerpais/{id}")
	public ResponseEntity removerPais(Long id) {
		try {
			manterPaisService.removerPais(id);
			return ResponseEntity.ok(id);
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
