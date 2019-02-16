package br.com.bytebank.banco.jdbc.dao;

import br.com.bytebank.banco.jdbc.entity.UF;

import java.util.List;

public class UFDAO extends GenericDAO<UF> {

	private ResultSetMapper<UF> mapper = (rs) -> {
		
		UF uf = new UF();
		
		uf.setId(rs.getLong("id"));
		
		uf.setStatus(rs.getString("status"));
		
		uf.setNome(rs.getString("ds_uf"));
		
		uf.setSigla(rs.getString("ds_sigla"));
		
		return uf;
	};

	@Override
	public UF get(Long id) {

		String sql = "SELECT id, status, ds_uf, ds_sigla " + "FROM PASSAPORTE.organizacional.tb_uf where id = ?";

		return this.listBySQL(sql, mapper, id).get(0);
	}

	@Override
	public List<UF> listAll() {

		String sql = "SELECT id, status, ds_uf, ds_sigla " + "FROM PASSAPORTE.organizacional.tb_uf";

		return this.listBySQL(sql, mapper);
	}

	@Override
	public void persist(UF uf) {

		String sql = "INSERT INTO PASSAPORTE.organizacional.tb_uf (status, ds_uf, ds_sigla) VALUES(?, ?, ?)";

		this.execute(sql, uf.getStatus(), uf.getNome(), uf.getSigla());
	}

	@Override
	public void update(UF uf) {

		String sql = "UPDATE PASSAPORTE.organizacional.tb_uf " + "SET status=?, " + "ds_uf=?, " + "ds_sigla=? "
				+ " WHERE id=?";

		this.execute(sql, uf.getStatus(), uf.getNome(), uf.getSigla(), uf.getId());
	}

}
