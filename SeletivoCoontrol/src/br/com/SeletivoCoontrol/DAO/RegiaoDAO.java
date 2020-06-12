package br.com.SeletivoCoontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.SeletivoCoontrol.conexao.Conexao;
import br.com.SeletivoCoontrol.domain.Regiao;

public class RegiaoDAO {
		
	public ArrayList<Regiao> buscaRegiao() throws SQLException {
			
		String comando = "select cod_regiao, des_regicao from regiao ";
		Regiao reg = new Regiao();
		
		Connection conn = null;
		ResultSet rs = null; 
		ArrayList<Regiao> listReg = new ArrayList<Regiao>();
		try {
			conn  = Conexao.getConnection();
			PreparedStatement stm = conn.prepareStatement(comando);	
			rs = stm.executeQuery();
	
			while (rs.next()) {
				reg = new Regiao();
				
				reg.setCod_regiao(rs.getString(1));
				reg.setDes_regiao(rs.getString(2));
				
				listReg.add(reg);
			}
		} catch (Exception e2) {}
			
		return listReg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
