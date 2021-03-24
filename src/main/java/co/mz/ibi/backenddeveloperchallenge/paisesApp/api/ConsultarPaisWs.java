package co.mz.ibi.backenddeveloperchallenge.paisesApp.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.PaisDTO;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.exception.NegocioException;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.service.IConsultarPaisService;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Classe (Web Service) que implementa a interface com os metodos de
 *         consulta de Paises Retorna uma Response (JSON) com um status HTTP
 *
 */
@RestController
@RequestMapping("api/v1/paises")
public class ConsultarPaisWs implements IConsultarPaisWs {

	@Autowired
	private IConsultarPaisService consultarPaisService;

	@Override
	@GetMapping
	public ResponseEntity<List<PaisDTO>> listarPaises() {
		try {
			final List<Pais> paises = consultarPaisService.listarPaises();
			final List<PaisDTO> dtos = paises.stream().map(PaisDTO::new).collect(Collectors.toList());
			ResponseEntity<List<PaisDTO>> response = ResponseEntity.ok(dtos);
			return response;
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	@GetMapping("/ordenarPorId")
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorId() {
		try {
			final List<Pais> paises = consultarPaisService.ordenarPaisesPorPropriedade("id");
			final List<PaisDTO> dtos = paises.stream().map(PaisDTO::new).collect(Collectors.toList());
			ResponseEntity<List<PaisDTO>> response = ResponseEntity.ok(dtos);
			return response;
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	@GetMapping("/ordenarPorNome")
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorNome() {
		try {
			final List<Pais> paises = consultarPaisService.ordenarPaisesPorPropriedade("nome");
			final List<PaisDTO> dtos = paises.stream().map(PaisDTO::new).collect(Collectors.toList());
			ResponseEntity<List<PaisDTO>> response = ResponseEntity.ok(dtos);
			return response;
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	@GetMapping("/ordenarPorCapital")
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorCapital() {
		try {
			final List<Pais> paises = consultarPaisService.ordenarPaisesPorPropriedade("capital");
			final List<PaisDTO> dtos = paises.stream().map(PaisDTO::new).collect(Collectors.toList());
			ResponseEntity<List<PaisDTO>> response = ResponseEntity.ok(dtos);
			return response;
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	@GetMapping("/ordenarPorRegiao")
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorRegiao() {
		try {
			final List<Pais> paises = consultarPaisService.ordenarPaisesPorPropriedade("regiao");
			final List<PaisDTO> dtos = paises.stream().map(PaisDTO::new).collect(Collectors.toList());
			ResponseEntity<List<PaisDTO>> response = ResponseEntity.ok(dtos);
			return response;
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	@GetMapping("/ordenarPorSubRegiao")
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorSubRegiao() {
		final List<Pais> paises = consultarPaisService.ordenarPaisesPorPropriedade("subRegiao");
		final List<PaisDTO> dtos = paises.stream().map(PaisDTO::new).collect(Collectors.toList());
		ResponseEntity<List<PaisDTO>> response = ResponseEntity.ok(dtos);
		return response;
	}

	@Override
	@GetMapping("/ordenarPorArea")
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorArea() {
		try {
			final List<Pais> paises = consultarPaisService.ordenarPaisesPorPropriedade("area");
			final List<PaisDTO> dtos = paises.stream().map(PaisDTO::new).collect(Collectors.toList());
			ResponseEntity<List<PaisDTO>> response = ResponseEntity.ok(dtos);
			return response;
		} catch (final NegocioException negocioException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
