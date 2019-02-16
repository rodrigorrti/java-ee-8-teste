package br.com.fj21;

import br.com.fj21.dao.ContatoDAO;
import br.com.fj21.entity.Contato;
import br.com.fj21.util.UtilData;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexaoFJ21 {
    public static void main(String[] args) throws SQLException {

        Contato c = new Contato("Joao 3");
        c.setEmail("rodrigorrti@gmail.com");
        c.setEndereco("rua 11 de j");
        c.setDataNascimento(UtilData.data("22/12/1984"));

        System.out.println(c.getDataNascimento());

        ContatoDAO cDAO = new ContatoDAO();
        cDAO.setContato(c);

        Contato c2 = cDAO.getContato(13l);
        System.out.println(c2);
        if (c2 != null) {
            c2.setNome("Maria");
            cDAO.setContato(c2);
        }

        cDAO.delete(c2);
        cDAO.getContatosByName("Rodrigo 2").forEach(item -> System.out.println(item));
        cDAO.getContatosAll().forEach(item -> System.out.println(item));
    }
}
