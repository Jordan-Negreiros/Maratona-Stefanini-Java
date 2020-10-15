package br.com.maratona.dev;

import java.util.ArrayList;
import java.util.List;

public class Run {
	public static void main(String[] args) {

		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setAgencia(0001);
		contaCorrente.setConta(0001);
		
		Conta conta = new ContaPoupanca();
		
		// Cast
		if (conta instanceof ContaPoupanca) {
			((ContaPoupanca)conta).setAgencia(0001);
		} else if (conta instanceof ContaCorrente) {
			((ContaCorrente)conta).setAgencia(0002);
			System.out.println(conta.getAgencia());
		}
		
		// Especifico
		ArrayList<ContaCorrente> lista = new ArrayList<ContaCorrente>();
		lista.add(contaCorrente);
		// Generico - diminui o acoplamento
		List<Conta> listas = new ArrayList<Conta>();
		listas.add(conta);
	}
}
