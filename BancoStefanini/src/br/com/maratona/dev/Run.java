package br.com.maratona.dev;

public class Run {
	public static void main(String[] args) {

		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setAgencia(0001);
		contaCorrente.setConta(0001);
		
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		contaPoupanca.setAgencia(0001);
		contaPoupanca.setConta(0001);
	}
}
