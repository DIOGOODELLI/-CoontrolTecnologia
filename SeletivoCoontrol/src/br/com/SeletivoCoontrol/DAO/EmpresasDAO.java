package br.com.SeletivoCoontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import br.com.SeletivoCoontrol.conexao.Conexao;
import br.com.SeletivoCoontrol.domain.Empresas;

public class EmpresasDAO {
	
	public void salvar (Empresas e) throws SQLException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO EMPRESA ");
		sb.append(" ( CNPJ_EMPRESA , NOME_EMPRESA, FUNC_EMPRESA, DATA_EMPRESA, COD_SETOR, COD_REGIAO ) ");
		sb.append("VALUES ( ? , ? , ? , ?,  ?, ? ) ");
		
		Connection conn = null;
		try {
			conn  = Conexao.getConnection();
			PreparedStatement stm = conn.prepareStatement(sb.toString());
						
		    SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
		    		    
		    java.util.Date date =  formatter.parse(e.getData()); 
            java.sql.Date d = new java.sql.Date (date.getTime());
            			
			stm.setLong(1, e.getCnpj());
			stm.setString(2 , e.getDescricao() );
			stm.setInt(3, e.getFuncionarios() );
			stm.setDate(4 , d);
			stm.setString(5 , e.getCod_setor() );
			stm.setString(6 , e.getCod_regiao() );
			stm.execute();
		} catch (Exception e2) {			
			e2.printStackTrace();
		}
	
		
	
	}
	
	
	
	
	
	public String retornoQuestao(String tipo) {
		
		String comando = "";
		if ( tipo.equals("A") ) {
			comando = "select sum(func_empresa) , cod_regiao "
					+ "from empresa group by cod_regiao order by sum(func_empresa) desc limit 1";
		}else if( tipo.equals("B") ) {
			comando = "select data_empresa, nome_empresa from empresa  order by data_empresa limit 1";
		}else if( tipo.equals("C") ) {
			comando = "select cod_regiao, count(func_empresa) "
					+ "from empresa where cod_setor = 1 group by cod_regiao limit 1";
		}else if( tipo.equals("D") ) {
			comando = "select "+
					"setor.des_setor, "+
					"sum(empresa.cod_setor) from empresa join setor on (empresa.cod_setor = setor.cod_setor) "+
					"group by empresa.cod_setor order by sum(empresa.cod_setor)";
		}else if( tipo.equals("E")) {
			comando = "	select sum(func_empresa) from empresa ";
		}
		
		Connection conn = null;
		ResultSet rs = null; 
		try {
			conn  = Conexao.getConnection();
			PreparedStatement stm = conn.prepareStatement(comando);	
			rs = stm.executeQuery();
			while (rs.next()) {
				
				if ( tipo.equals("A") ) {
					comando = rs.getInt(1) + " : " + rs.getString(2);
				}else if( tipo.equals("B") ) {
					comando = rs.getString(1) + " : " + rs.getString(2);
				}else if( tipo.equals("C") ) {
					comando = rs.getString(1) + " : " + rs.getInt(2);
				}else if( tipo.equals("D") ) {
					comando = rs.getString(1) + " : " + rs.getInt(2);
				}else if( tipo.equals("E")) {
					comando = rs.getInt(1) + " ";
				}
			}
				
		} catch (Exception e) {}
		
		return comando;
		
	}
	

	
	public ArrayList<Empresas>  buscaEmpresas() throws SQLException {
			
		String comando = "SELECT CNPJ_EMPRESA , NOME_EMPRESA, FUNC_EMPRESA, DATA_EMPRESA, COD_SETOR, COD_REGIAO FROM EMPRESA ";
	
		Connection conn = null;
		ResultSet rs = null; 
		ArrayList<Empresas> listEmp = new ArrayList<Empresas>();
		try {
			conn  = Conexao.getConnection();
			PreparedStatement stm = conn.prepareStatement(comando);	
			rs = stm.executeQuery();
			while (rs.next()) {
				
				Empresas emp = new Empresas();
				emp.setCnpj(rs.getLong(1));
				emp.setDescricao( rs.getString(2) );
				emp.setFuncionarios(rs.getInt( 3 ));
				emp.setData(String.valueOf( rs.getDate(4) ));
				emp.setCod_regiao( rs.getString(5) );
				emp.setCod_setor(rs.getString(6));
				
				listEmp.add(emp);
			}
			
		} catch (Exception e2) {
			System.out.println(e2.toString()); 
		}
			
		return listEmp;
	}

}
