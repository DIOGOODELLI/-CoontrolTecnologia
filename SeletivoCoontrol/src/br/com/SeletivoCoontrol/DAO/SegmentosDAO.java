package br.com.SeletivoCoontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.SeletivoCoontrol.conexao.Conexao;
import br.com.SeletivoCoontrol.domain.Segmentos;

public class SegmentosDAO {
		
	public ArrayList<Segmentos> buscaSetor() throws SQLException {
			
		String comando = "select cod_setor, des_setor from setor ";
		Segmentos set = new Segmentos();
		
		Connection conn = null;
		ResultSet rs = null; 
		ArrayList<Segmentos> listSet = new ArrayList<Segmentos>();
		try {
			conn  = Conexao.getConnection();
			PreparedStatement stm = conn.prepareStatement(comando);	
			rs = stm.executeQuery();
				
			while (rs.next()) {
				set = new Segmentos();
				set.setCod_setor( rs.getString(1) );
				set.setDes_setor( rs.getString(2)  );
				listSet.add(set);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
			
		return listSet;
	}

}
