package co.mz.ibi.backenddeveloperchallenge.paisesApp.api;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.PaisDTO;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.RequisicaoPais;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ManterPaisWsTest {

	@MockBean
	private IManterPaisWs manterPaisWs;

	@MockBean
	private IConsultarPaisWs consultarPaisWs;

	@Test
	public void registarPais() {

		final RequisicaoPais requisicaoPais = new RequisicaoPais();

		final Pais pais = new Pais();
		pais.setNome("Zimbabwe");
		pais.setCapital("Harare");
		pais.setRegiao("Africa");
		pais.setSubRegiao("Africa Austral");
		pais.setArea(Double.parseDouble("750000"));

		PaisDTO dto = requisicaoPais.converterParaPaisDTO(pais);

		ResponseEntity<PaisDTO> response = new ResponseEntity<PaisDTO>(dto, HttpStatus.OK);

		when(manterPaisWs.registarPais(requisicaoPais)).thenReturn(response);

		assertEquals(HttpStatus.OK, manterPaisWs.registarPais(requisicaoPais).getStatusCode());

	}

	@Test
	public void actualizarPais() {

		final Pais pais = new Pais();
		pais.setId(1L);
		pais.setNome("Mozambique");
		pais.setCapital("Maputo");
		pais.setRegiao("Africa");
		pais.setSubRegiao("Africa Austral");
		pais.setArea(Double.parseDouble("815000"));

		final RequisicaoPais requisicaoPais = new RequisicaoPais();
		requisicaoPais.setId(pais.getId());
		requisicaoPais.setNome(pais.getNome());
		requisicaoPais.setCapital(pais.getCapital());
		requisicaoPais.setRegiao(pais.getRegiao());
		requisicaoPais.setSubRegiao(pais.getSubRegiao());
		requisicaoPais.setArea(pais.getArea());

		PaisDTO paisDTO = requisicaoPais.converterParaPaisDTO(pais);
		assertNotNull(paisDTO);

		List<PaisDTO> paisDTOs = new ArrayList<PaisDTO>(0);
		paisDTOs.add(paisDTO);
		assertFalse(paisDTOs.isEmpty());

		ResponseEntity<List<PaisDTO>> responseOk = new ResponseEntity<List<PaisDTO>>(paisDTOs, HttpStatus.OK);
		assertNotNull(responseOk);

		when(consultarPaisWs.ordenarPaisesPorId()).thenReturn(responseOk);

		// Dados por actualizar
		pais.setSubRegiao("Africa Ocidental");
		pais.setArea(Double.parseDouble("955555"));
		
		PaisDTO dto = requisicaoPais.converterParaPaisDTO(pais);

		ResponseEntity<PaisDTO> response = new ResponseEntity<PaisDTO>(dto, HttpStatus.OK);

		when(manterPaisWs.actualizarPais(requisicaoPais)).thenReturn(response);
		
		assertEquals(HttpStatus.OK, manterPaisWs.actualizarPais(requisicaoPais).getStatusCode());
		assertEquals("Africa Ocidental", manterPaisWs.actualizarPais(requisicaoPais).getBody().getSubRegiao());
		assertEquals(Double.parseDouble("955555"), manterPaisWs.actualizarPais(requisicaoPais).getBody().getArea());

	}

	@Test
	public void removerPais() {
		
		final Pais pais = new Pais();
		pais.setId(1L);
		pais.setNome("Mozambique");
		pais.setCapital("Maputo");
		pais.setRegiao("Africa");
		pais.setSubRegiao("Africa Austral");
		pais.setArea(Double.parseDouble("815000"));

		final RequisicaoPais requisicaoPais = new RequisicaoPais();
		requisicaoPais.setId(pais.getId());
		requisicaoPais.setNome(pais.getNome());
		requisicaoPais.setCapital(pais.getCapital());
		requisicaoPais.setRegiao(pais.getRegiao());
		requisicaoPais.setSubRegiao(pais.getSubRegiao());
		requisicaoPais.setArea(pais.getArea());

		PaisDTO paisDTO = requisicaoPais.converterParaPaisDTO(pais);
		assertNotNull(paisDTO);

		List<PaisDTO> paisDTOs = new ArrayList<PaisDTO>(0);
		paisDTOs.add(paisDTO);
		assertFalse(paisDTOs.isEmpty());

		ResponseEntity<List<PaisDTO>> responseOk = new ResponseEntity<List<PaisDTO>>(paisDTOs, HttpStatus.OK);
		assertNotNull(responseOk);

		when(consultarPaisWs.ordenarPaisesPorId()).thenReturn(responseOk);
		
		ResponseEntity response = new ResponseEntity(HttpStatus.OK);
		
		when(manterPaisWs.removerPais(1L)).thenReturn(response);
		assertEquals(HttpStatus.OK, manterPaisWs.removerPais(1L).getStatusCode());

	}

}
