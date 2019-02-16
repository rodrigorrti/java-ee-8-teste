package br.com.bytebank.banco.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bytebank.banco.jdbc.ConnectionFactory;
import br.com.bytebank.banco.jdbc.entity.EntidadeAbstrata;

/**
 * 
 * @author cezar_a
 *
 * @param <E>
 */
public abstract class GenericDAO<E extends EntidadeAbstrata<Long>> implements DAO<E> {

	/**
	 * 
	 * @author cezar_a
	 *
	 * @param <E>
	 */
	@FunctionalInterface
	protected interface ResultSetMapper<E extends EntidadeAbstrata<Long>> {
		
		E map(ResultSet rs) throws SQLException;
	}

	/**
	 * 
	 * @param sql
	 * @param params
	 */
	protected void execute(String sql, Object... params) {

		try {

			Connection conexao = ConnectionFactory.getConnection();

			PreparedStatement ps = conexao.prepareStatement(sql);

			for (int indice = 1; indice <= params.length; indice++) {

				ps.setObject(indice, params[indice - 1]);
			}

			ps.execute();

			ps.close();

			conexao.close();
			
		} catch (Exception e) {

			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * 
	 * @param sql
	 * @param mapper
	 * @param params
	 * @return
	 */
	protected List<E> listBySQL(String sql, ResultSetMapper<E> mapper, Object... params) {

		List<E> retorno = new ArrayList<>();

		try {

			Connection conexao = ConnectionFactory.getConnection();

			PreparedStatement ps = conexao.prepareStatement(sql);

			for (int indice = 1; indice <= params.length; indice++) {

				ps.setObject(indice, params[indice - 1]);
			}

			ResultSet rs = ps.executeQuery();

			E entidade;

			while (rs.next()) {

				entidade = mapper.map(rs);

				retorno.add(entidade);
			}

			rs.close();

			ps.close();

			conexao.close();

		} catch (Exception e) {

			e.printStackTrace();

			throw new RuntimeException(e.getMessage(), e);
		}
		return retorno;
	}
}
