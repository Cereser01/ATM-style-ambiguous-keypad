package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.edu.catolicasc.algoritmosAvancados.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {
    @Query("SELECT f FROM Usuario f WHERE f.nome = :nome "	
			+ " AND f.password = :password ")
	List<Usuario> login(String nome, String password);
}
