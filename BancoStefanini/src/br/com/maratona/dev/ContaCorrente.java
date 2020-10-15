package br.com.maratona.dev;

public class ContaCorrente extends Conta implements ContaPrivate{
	
	private Float limite;
	
	public ContaCorrente() {
	}
	
	public ContaCorrente(Float limite) {
		this.limite = limite;
	}

	public Float getLimite() {
		return limite;
	}

	public void setLimite(Float limite) {
		this.limite = limite;
	}

	@Override
	public void saqueExtra(Float taxa) {
		// 0.99
	}

	@Override
	public void emprestimo(Float valor) {
		// implementar
	}

}
