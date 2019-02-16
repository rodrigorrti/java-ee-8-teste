package br.com.bytebank.banco.jdbc.dao;

import java.util.List;

import br.com.bytebank.banco.jdbc.entity.Municipio;
import br.com.bytebank.banco.jdbc.entity.UF;

public class MunicipioDAO extends GenericDAO<Municipio> {

	private ResultSetMapper<Municipio> mapper = (rs) -> {

		final Long idUF = rs.getLong("uf_id");
		
		Municipio municipio = new Municipio() {
			
			private DAO<UF> ufDAO = new UFDAO();
			
			public UF getUf() {
				
				if (super.getUf() == null) {
					
					try {
						
						this.setUf(this.ufDAO.get(idUF));
						
					} catch (Exception e) {
						
						// ignore
					}
				}
				
				return super.getUf();
			}
		};

		municipio.setId(rs.getLong("id"));

		municipio.setStatus(rs.getString("status"));

		municipio.setCodigoIBGE(rs.getString("cod_ibge"));

		municipio.setNome(rs.getString("nm_municipio"));

		return municipio;
	};
	
	@Override
	public List<Municipio> listAll() {

		String sql = "select * from organizacional.tb_municipio";

		return this.listBySQL(sql, this.mapper);
	}
	
	public List<Municipio> findByNome(String nome) {
		
		String sql = "select * from organizacional.tb_municipio "
				+ "where lower(nm_municipio) like lower(?)";

		return this.listBySQL(sql, this.mapper, "%" + nome + "%");		
	}

	@Override
	public void persist(Municipio municipio) {

		try {

			String sql = "INSERT INTO PASSAPORTE.organizacional.tb_municipio "
					+ "(status, cod_ibge, nm_municipio, uf_id) VALUES(?, ?, ?, ?)";

			Object[] params = new Object[] {

					municipio.getStatus(),

					municipio.getCodigoIBGE(),

					municipio.getNome(),

					municipio.getUf().getId() };

			this.execute(sql, params);

		} catch (Exception e) {

			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public Municipio get(Long id) {

		String sql = "select * from organizacional.tb_municipio where id = ?";

		try {

			return this.listBySQL(sql, this.mapper, id).get(0);

		} catch (IndexOutOfBoundsException e) {

			return null;
		}
	}

	@Override
	public void update(Municipio municipio) {

		String sql = "UPDATE organizacional.tb_municipio "
				+ "SET status=?, cod_ibge=?, nm_municipio=?, uf_id=? WHERE id=?";

		Object[] params = new Object[] {

				municipio.getStatus(),

				municipio.getCodigoIBGE(),

				municipio.getNome(),

				municipio.getUf().getId(),

				municipio.getId() };

		this.execute(sql, params);
	}

}
