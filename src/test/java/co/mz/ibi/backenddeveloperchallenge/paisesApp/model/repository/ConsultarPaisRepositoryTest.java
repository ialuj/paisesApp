package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.repository;

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
public class ConsultarPaisRepositoryTest {
	
	@Autowired
	private ConsultarPaisRepository consultarPaisRepository;
	
	@Test
	public void listarTodosPaises() {
		List<Pais> paises = consultarPaisRepository.findAll();
		assertFalse(paises.isEmpty());
		assertEquals(4,paises.size());		
	}
	
	
	@Test
	public void ordenarPorId() {
		List<Pais> paises = consultarPaisRepository.ordenarPaisesPorId();
		assertFalse(paises.isEmpty());
		assertEquals(4, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(1, pais.getId());
		assertEquals("Mozambique", pais.getNome());
		assertEquals("Maputo", pais.getCapital());
	}
	
	@Test
	public void ordenarPorNome() {
		List<Pais> paises = consultarPaisRepository.ordenarPaisesPorNome();
		assertFalse(paises.isEmpty());
		assertEquals(4, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(3, pais.getId());
		assertEquals("Africa do Sul", pais.getNome());
		assertEquals("Pretoria", pais.getCapital());
	}
	
	@Test
	public void ordenarPorCapital() {
		List<Pais> paises = consultarPaisRepository.ordenarPaisesPorCapital();
		assertFalse(paises.isEmpty());
		assertEquals(4, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(4, pais.getId());
		assertEquals("Eswathini", pais.getNome());
		assertEquals("Lesotho", pais.getCapital());
	}
	
	@Test
	public void ordenarPorRegiao() {
		List<Pais> paises = consultarPaisRepository.ordenarPaisesPorRegiao();
		assertFalse(paises.isEmpty());
		assertEquals(4, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(1, pais.getId());
		assertEquals("Mozambique", pais.getNome());
		assertEquals("Maputo", pais.getCapital());
	}
	
	@Test
	public void ordenarPorSubRegiao() {
		List<Pais> paises = consultarPaisRepository.ordenarPaisesPorSubRegiao();
		assertFalse(paises.isEmpty());
		assertEquals(4, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(1, pais.getId());
		assertEquals("Mozambique", pais.getNome());
		assertEquals("Maputo", pais.getCapital());
	}
	
	@Test
	public void ordenarPorArea() {
		List<Pais> paises = consultarPaisRepository.ordenarPaisesPorSubRegiao();
		assertFalse(paises.isEmpty());
		assertEquals(4, paises.size());
		final Pais pais = paises.get(0);
		assertEquals(1, pais.getId());
		assertEquals("Mozambique", pais.getNome());
		assertEquals("Maputo", pais.getCapital());
	}
}
