package br.com.crud.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.ConnectionFactory;
import br.com.crud.model.Contato;

public class ContatoDAO {
	
	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome,idade,dataCadastro)" + 
		" VALUES(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexao com o banco de dados
			
			conn = ConnectionFactory.createConectionToMySQL();
			
			//cria um preparedStatement, classe usada para executar a query
			
			pstm = conn.prepareStatement(sql);
			
			//Adiciona o valor do primeiro parametro da sql
			pstm.setString(1, contato.getNome());
			
			//Adiciona o valor do segundo parametro da sql
			pstm.setInt(2, contato.getIdade());
			
			//Adiciona o valor do terceiro parametro da sql
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//executa a sql para inserção dos dados
			
			pstm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//fecha as conexoes
				try {
					if(pstm !=null) {
						pstm.close();
					}
					
					} catch(Exception e) {
						e.printStackTrace();
					}
			}
	}
					
				
	public void removeById(int id) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
		} catch (Exception e) {
			//TODO 
			
			e.printStackTrace();
			
		}finally {
			
			try {
				if(pstm !=null) {
					pstm.close();
				}
				
				if(conn !=null) {
					conn.close();
				}
				
			}catch(Exception e ) {
				e.printStackTrace();
			}
		}
	}
	
		public void update(Contato contato) {
			String sql = "UPDATE contatos SET nome = ?, idade = ?,dataCadastro = ?" +
							"WHERE id = ?";
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				// cria uma conexao com co banco 
				conn = ConnectionFactory.createConectionToMySQL();
				
				//Cria um Prepared Statement, classe usada para executar a quer
				pstm = conn.prepareStatement(sql);
				
				//adiciona o valor do primeiro parametro da sql
				pstm.setString(1, contato.getNome());
				
				//adiciona o valor do segundo parametro da sql
				pstm.setInt(2, contato.getIdade());
				
				//adiciona o valor do terceiro parametro da sql
				pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
				
				pstm.setInt(4, contato.getId());
				
				
				// executa a sql para a inserção de dados
				pstm.execute();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conexoes
			
			try {
				if(pstm != null) {
					
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				}
			}
		}
		
		public List<Contato> getContatos() {
			String sql = "SELECT * FROM contatos";
			
			List<Contato> contatos = new ArrayList<Contato>();
			
			Connection conn = null;
			
			PreparedStatement pstm = null;
			
			//Classe que vai recuperar os dados do banco de dados
			ResultSet rset = null;
			
			try {
				
				conn = ConnectionFactory.createConectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				// equanto existir dados no DB faça
				
				while(rset.next()) {
					
					Contato contato = new Contato();
					
					//Recupera o ID do Banco e atribui a ele oobjeto
					contato.setId(rset.getInt("id"));
					
					//Recuperao nome do banco e atribui ele ao objeto
					
					contato.setNome(rset.getString("nome"));
					
					//Recuperaa idade do banco e atribui ele ao objeto
					
					contato.setIdade(rset.getInt("idade"));
					
					// recupera a data do banco e atribui ele ao objeto 
					
					contato.setDataCadastro(rset.getDate("dataCadastro"));
					
					//Adiciona o contato recuperado a lista de contatos
					
					contatos.add(contato);
					
				}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						
						if(rset !=null) {
							
							rset.close();
					}
						if(pstm != null) {
						
							pstm.close();
						}
						
						if (conn !=null) {
							
							conn.close();
						}
				}catch(Exception e) {
					
					e.printStackTrace();
				}
			}
			return contatos;
		}
		
		
		
			
		}
		
	


