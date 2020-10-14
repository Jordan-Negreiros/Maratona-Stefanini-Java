package br.com.maratona.dev;

import java.math.BigDecimal;
import java.util.Date;

public class Pessoa {

	// Atributos
	private String nome;
	private char sexo;
	private int idade;
	private Long cpf;
	private Boolean vivo;
	private Date dataNascimento;
	private BigDecimal saldo;
	
	// Construtor
	public Pessoa() {
	}

	
	// Metodos de acessos
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if (idade > 100) {
			System.out.println("Idade Inválida! Insira uma idade menor que 100");
		} else {
			this.idade = idade;
		}
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Boolean getVivo() {
		return vivo;
	}

	public void setVivo(Boolean vivo) {
		this.vivo = vivo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
}
