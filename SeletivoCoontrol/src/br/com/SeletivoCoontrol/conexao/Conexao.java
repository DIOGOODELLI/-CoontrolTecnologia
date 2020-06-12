package br.com.SeletivoCoontrol.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Conexao {
	
	static Connection conexao = null;
    static Statement statement = null;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/coontrol?characterEncoding=latin1&useConfigs=maxPerformance"; //VERSÃO DO MYSQL 
    private static final String USER = "root";
    private static final String PASS = "mdb123";
		
	public static Connection getConnection() throws Exception{
		
	       try {
               if (conexao == null) {
                   Class.forName(DRIVER);
                   conexao = DriverManager.getConnection(URL,USER,PASS);
                   statement = (Statement) conexao.createStatement();
               }
               
               System.out.println("OK !");
               return conexao;
           } catch (ClassNotFoundException ex) {
               ex.printStackTrace();
               return null;
           } catch (SQLException ex) {
               ex.printStackTrace();
               return null;
           }
	}

}
