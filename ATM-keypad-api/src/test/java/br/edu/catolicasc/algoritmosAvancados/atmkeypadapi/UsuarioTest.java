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
	
	}
    
}
