package br.com.bytebank.banco.jdbc;

import br.com.bytebank.banco.jdbc.dao.MunicipioDAO;
import br.com.bytebank.banco.jdbc.entity.Municipio;

public class Main {

	public static void main(String[] args) {

		MunicipioDAO dao = new MunicipioDAO();

		dao.findByNome("abadi").stream().forEach(System.out::println);

		Municipio municipio = dao.get(16721L);

		System.out.println(municipio);

		System.out.println(municipio.getUf().getNome());
	}

}
