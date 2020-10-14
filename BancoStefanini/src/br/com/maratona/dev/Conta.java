package br.com.maratona.dev;

public class Conta {

	private Integer conta;
	private Integer agencia;
	private Double saldo;
	private Boolean status;
	
	public Integer getConta() {
		return conta;
	}
	public void setConta(Integer conta) {
		this.conta = conta;
	}
	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void depositar(Double valorDeposito) {
		this.saldo = saldo + valorDeposito;
	}
	
	public void sacar(Double valorSaque) {
		if (saldo <= valorSaque) {
			this.saldo = saldo - valorSaque;
		} else {
			System.out.println("Valor Não disponível");
		}
	}
}
