package br.com.maratona.dev.resource;

import java.util.ArrayList;
import java.util.List;

public class InscricaoHelper {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public void init() {
		pessoas.add(new Pessoa("Kleber", 1));
		pessoas.add(new Pessoa("Marcus", 2));
		pessoas.add(new Pessoa("Stag", 3));
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public Pessoa findPessoa(Integer id) {
		init();
		
		for (Pessoa indice : pessoas) {
			if (indice.getMatricula().equals(Integer.valueOf(id))) {
				return indice;
			}
		}
		
		return null;
	}
}
