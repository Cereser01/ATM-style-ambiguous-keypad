package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.dao;

import org.springframework.data.jpa.domain.Specification;
import br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.Usuario;

public class SpecificationUsuario {
    public static Specification<Usuario> nome(String nome){
		return (root, criteriaQuery, criteriaBuilder) ->
				criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
}
