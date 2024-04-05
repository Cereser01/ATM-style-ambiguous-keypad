package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.Usuario;
@Repository
public interface NewRepository extends CrudRepository<Usuario, Long>{
    
}
