package br.com.bytebank.banco.jdbc.entity;

public class Municipio extends EntidadeAbstrata<Long> {

	private String codigoIBGE;
	private String nome;
	private UF uf;

	public String getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(String codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		
		return "Municipio [codigoIBGE=" + codigoIBGE + ", nome=" + nome + ", uf=" + uf + "]";
	}
}
