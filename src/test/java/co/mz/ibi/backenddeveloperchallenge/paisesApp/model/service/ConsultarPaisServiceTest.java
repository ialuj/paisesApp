package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ConsultarPaisServiceTest {
	
	@Autowired
	private IConsultarPaisService consultarPaisService;
	
	@Test
	public void listarPaises() {
		List<Pais> paises = consultarPaisService.listarPaises();
		assertFalse(paises.isEmpty());
	}
	
	@Test
	public void ordenarPaisesPorId() {
		List<Pais> paises = consultarPaisService.ordenarPaisesPorId();
		assertFalse(paises.isEmpty());
		assertEquals(3, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(1, pais.getId());
		assertEquals("Mozambique", pais.getNome());
		assertEquals("Maputo", pais.getCapital());
	}
	
	@Test
	public void ordenarPaisesPorNome() {
		List<Pais> paises = consultarPaisService.ordenarPaisesPorNome();
		assertFalse(paises.isEmpty());
		assertEquals(3, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(3, pais.getId());
		assertEquals("Africa do Sul", pais.getNome());
		assertEquals("Pretoria", pais.getCapital());
	}
	
	@Test
	public void ordenarPaisesPorCapital() {
		List<Pais> paises = consultarPaisService.ordenarPaisesPorCapital();
		assertFalse(paises.isEmpty());
		assertEquals(3, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(2, pais.getId());
		assertEquals("Angola", pais.getNome());
		assertEquals("Luanda", pais.getCapital());
	}
	
	@Test
	public void ordenarPaisesPorRegiao() {
		List<Pais> paises = consultarPaisService.ordenarPaisesPorRegiao();
		assertFalse(paises.isEmpty());
		assertEquals(3, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(1, pais.getId());
		assertEquals("Mozambique", pais.getNome());
		assertEquals("Maputo", pais.getCapital());
	}
	
	@Test
	public void ordenarPaisesPorSubRegiao() {
		List<Pais> paises = consultarPaisService.ordenarPaisesPorSubRegiao();
		assertFalse(paises.isEmpty());
		assertEquals(3, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(1, pais.getId());
		assertEquals("Mozambique", pais.getNome());
		assertEquals("Maputo", pais.getCapital());
	}
	
	@Test
	public void ordenarPaisesPorArea() {
		List<Pais> paises = consultarPaisService.ordenarPaisesPorSubRegiao();
		assertFalse(paises.isEmpty());
		assertEquals(3, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(1, pais.getId());
		assertEquals("Mozambique", pais.getNome());
		assertEquals("Maputo", pais.getCapital());
	}
}
