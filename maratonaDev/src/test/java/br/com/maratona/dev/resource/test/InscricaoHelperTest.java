package br.com.maratona.dev.resource.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.maratona.dev.resource.InscricaoHelper;
import br.com.maratona.dev.resource.Pessoa;

public class InscricaoHelperTest {
	
	InscricaoHelper InscricaoHelper = new InscricaoHelper();
	
	public static final long LIMIT = 20000;
	
	@Before
	public void configTeste() {
		System.out.println("Teste iniciado");
	}
	
	@After
	public void finishTeste() {
		System.out.println("Teste finalizado");
	}
	
	@BeforeClass
	public static void config() {
		System.out.println("Classe de Teste iniciado");
	}
	
	@AfterClass
	public static void finish() {
		System.out.println("Classe de Teste finalizado");
	}

	// Caso de Teste
	@Test(timeout = LIMIT)
	public void findPessoaCaminhoCerto() {
		Pessoa retornoFind = InscricaoHelper.findPessoa(1);
		assertEquals(Integer.valueOf(1), retornoFind.getMatricula());
	}
	
	@Test
	public void findPessoaCaminhoComError() {
		Pessoa retornoFind = InscricaoHelper.findPessoa(10);
		assertEquals(null, retornoFind);
	}
}
