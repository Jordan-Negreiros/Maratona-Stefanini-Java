package br.com.maratona.dev.resource.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.maratona.dev.resource.InscricaoHelper;
import br.com.maratona.dev.resource.InscricaoMaratonaResource;
import br.com.maratona.dev.resource.Pessoa;

@RunWith(MockitoJUnitRunner.class) // Testes serão gerenciados pelo Mockito
public class InscricaoMaratonaResourceTest {
	
	public static final long LIMIT = 20000;

	/**
	 * @InjectMocks Injeta uma classe mockada
	 */
	@InjectMocks
	InscricaoMaratonaResource maratonaResource = new InscricaoMaratonaResource();
	
	/**
	 * @Mock Cria um mock de uma classe
	 */
	@Mock
	InscricaoHelper incricaoHelper;
	
	Pessoa pessoa;
	
	@Test(timeout = LIMIT)
	public void matriculaPorId() {
		when(incricaoHelper.findPessoa(1)).thenReturn(pessoa);
		Response retornoTeste = maratonaResource.matriculaPorId("1");
		
		assertEquals(200, retornoTeste.getStatus());
	}
	
	@Test(timeout = LIMIT)
	public void matriculaPorIdNull() {
		when(incricaoHelper.findPessoa(1)).thenReturn(pessoa);
		Response retornoTeste = maratonaResource.matriculaPorId("2");
		
		assertEquals(null, retornoTeste.getEntity());
	}
	
	/**
	 * Inicio de Cada teste
	 */
	@Before
	public void configTeste() {
		System.out.println("Teste iniciado");
		pessoa = new Pessoa();
		pessoa.setMatricula(1);
		pessoa.setNome("Kleber");
	}
	
	/**
	 * Final de Cada teste
	 */
	@After
	public void finishTeste() {
		System.out.println("Teste finalizado");
	}
	
	/**
	 * Inicio da classe de teste
	 */
	@BeforeClass
	public static void config() {
		System.out.println("Classe de Teste iniciado");
	}
	
	/**
	 * Final da classe de teste
	 */
	@AfterClass
	public static void finish() {
		System.out.println("Classe de Teste finalizado");
	}
	
}
