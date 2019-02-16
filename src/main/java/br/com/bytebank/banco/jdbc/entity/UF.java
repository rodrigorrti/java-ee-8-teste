package br.com.bytebank.banco.jdbc.entity;

public class UF extends EntidadeAbstrata<Long> {

	private String nome;
	private String sigla;

	public UF() {
		super();
	}
	
	public UF(Long id) {
		this.setId(id);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
