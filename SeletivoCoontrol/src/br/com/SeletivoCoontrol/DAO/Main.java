package br.com.SeletivoCoontrol.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.SeletivoCoontrol.conexao.Conexao;
import br.com.SeletivoCoontrol.domain.Empresas;
import br.com.SeletivoCoontrol.domain.Regiao;

public class Main {

	public static void main(String [] args) {
		
		
		try {
			Connection conn = Conexao.getConnection();
			RegiaoDAO DAO = new RegiaoDAO();
			ArrayList<Regiao>  emp = DAO.buscaRegiao();
			System.out.println(emp.toString());
			
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
}
