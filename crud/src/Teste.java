import java.util.Date;

import br.com.crud.dao.ContatoDAO;
import br.com.crud.model.Contato;



public class Teste {

	public static void main(String args[]) {
	
		ContatoDAO contatoDAO = new ContatoDAO();
	
	// Cria um novo Contato e salva no banco
	
	Contato contato = new Contato();
	contato.setNome("Eduardo");
	contato.setIdade(16);
	contato.setDataCadastro(new Date());
	
	contatoDAO.save(contato);
	
	//Atualia o contato com id =2 com os dados do objeto contato1
	
	Contato contato1 = new Contato();
	contato1.setId(1);
	contato1.setNome("NOME NOVO");
	contato1.setIdade(32);
	contato1.setDataCadastro(new Date());
	
	//Remove o contato com o id = 1
	
	contatoDAO.removeById(1);
	
	// Lista todos os contatos do banco de dados 
	
	for(Contato c : contatoDAO.getContatos()) {
		System.out.println("NOME: " + c.getNome());
	}
	
	}
}
