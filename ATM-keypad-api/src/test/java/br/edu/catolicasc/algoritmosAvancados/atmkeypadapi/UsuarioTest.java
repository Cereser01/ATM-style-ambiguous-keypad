package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.dao.NewRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UsuarioTest {    
    @Autowired
	private NewRepository repository;
    @Test
    public void usuarioSalvaTest() {
		Usuario user = new Usuario();
		user.setNome("Eduardo_Morias");
		user.setPassword("1231");
		repository.save(user);
		System.out.println(user.getNome());
		System.out.println(user.getPassword());
		Usuario user2 = new Usuario();
		user2.setNome("Julio_Spezzia");
		user2.setPassword("1231");
		repository.save(user2);
		System.out.println(user2.getNome());
		System.out.println(user2.getPassword());
	
	}
    
}
