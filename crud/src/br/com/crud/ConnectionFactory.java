package br.com.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//usuario mysql
	private static final String USERNAME = "root";
	
	//senha mysql
	private static final String PASSWORD = "root";
	
	//dados da conexao do banco de dados
	private static final String DATABASE_URL =
			"jdbc:mysql://localhost:3306/crud";
	
	/** cria uma conexao com o banco de dados Mysql */
	
	public static Connection createConectionToMySQL() throws 
	Exception{
		Class.forName("com.mysql.cj.jdbc.Driver"); //faz com que a classe seja carregada pela JVM
		
		//Criaa conexão com o banco de Dados
		
		Connection connection = 
				DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
		}
	
		public static void main(String[] args) throws Exception{
			//recupera uma conexao com o banco de dados
			Connection con = createConectionToMySQL();
			
			// testa se a conexao e nula
			if(con != null) {
			System.out.println("Conexao obtida com sucesso!" + con);
			
				con.close();
				
			}
			
	}
}
