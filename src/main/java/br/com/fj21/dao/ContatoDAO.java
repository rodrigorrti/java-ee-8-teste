package br.com.fj21.dao;

import br.com.fj21.ConnectionFactory;
import br.com.fj21.entity.Contato;
import br.com.fj21.exception.DAOException;
import br.com.fj21.util.UtilData;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    public void delete(Contato contato) {

        if(contato!=null){
            delete(contato.getId());
            System.out.println("Deletado byContato");
        }
    }

    public void delete(Long index) {
        String sql = "delete from contatos where id=?";

        try (Connection conexao = ConnectionFactory.getConnection()) {

            PreparedStatement ps = conexao.prepareStatement(sql);
            //Where id
            ps.setInt(1, index.intValue());
            ps.execute();

            ps.close();
            conexao.close();
            System.out.println("Deletado byID");

        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    private void update(Contato contato) {
        String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=?" +
                " where id=?";

        try (Connection conexao = ConnectionFactory.getConnection()) {

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getEmail());
            ps.setString(3, contato.getEndereco());
            ps.setDate(4, Date.valueOf(contato.getDataNascimento()));

            //Where id
            ps.setInt(5, contato.getId().intValue());
            ps.execute();

            ps.close();
            conexao.close();
            System.out.println("Atualizado");

        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    private void insert(Contato contato) {
        String sql = "insert	into	contatos	" +
                "(nome,email,endereco,dataNascimento)	" +
                "values	(?,?,?,?)";

        try (Connection conexao = ConnectionFactory.getConnection()) {

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getEmail());
            ps.setString(3, contato.getEndereco());
            ps.setDate(4, Date.valueOf(contato.getDataNascimento()));

            ps.execute();

            ps.close();
            conexao.close();
            System.out.println("Gravado");

        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    public void setContato(Contato contato) {

        Contato c = this.getContato(contato.getId());

        if (c == null) {
            insert(contato);
        } else {
            update(contato);
        }
    }

    public List<Contato> getContatosAll() {
        String sql = "Select * from contatos";

        List<Contato> retorno = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConnection()) {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            Contato c;
            while (rs.next()) {
                c = new Contato(rs.getString("nome"));
                c.setId(rs.getLong("id"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setDataNascimento(UtilData.data(rs.getDate("dataNascimento")));

                retorno.add(c);
            }

            rs.close();
            ps.close();
            conexao.close();
            System.out.println("Listado Tudo");
            return retorno;

        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    public Contato getContato(Long index) {
        String sql = "Select * from contatos where id = ?";

        if (index==null){
            return null;
        }
        try (Connection conexao = ConnectionFactory.getConnection()) {

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, index.intValue());

            ResultSet rs = ps.executeQuery();

            Contato c = null;
            while (rs.next()) {
                c = new Contato(rs.getString("nome"));
                c.setId(rs.getLong("id"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setDataNascimento(UtilData.data(rs.getDate("dataNascimento")));
            }
            rs.close();
            ps.close();
            conexao.close();
            System.out.println("Listado por ID");
            return c;

        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    public List<Contato> getContatosByName(String nome) {
        String sql = "Select * from contatos where nome like ?";

        List<Contato> retorno = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConnection()) {

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");

            ResultSet rs = ps.executeQuery();

            Contato c;
            while (rs.next()) {
                c = new Contato(rs.getString("nome"));
                c.setId(rs.getLong("id"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setDataNascimento(UtilData.data(rs.getDate("dataNascimento")));

                retorno.add(c);
            }

            rs.close();
            ps.close();
            conexao.close();
            System.out.println("Listado por Nome");
            return retorno;

        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }
}
