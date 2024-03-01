package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.dto;
import br.edu.catolicasc.algoritmosAvancados.Usuario;
import br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.dao.NewRepository;

public class RequisicaoNovoUsuario {
    private Long usuarioId;
    private String usuarioNome;
    private String usuarioPassword;
    private String usuarioDados;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public Usuario toUsuario(NewRepository usuario){
        Usuario a = new Usuario();
        a.setNome(usuarioNome);
        a.setPassword(usuarioPassword);
        return a;
    }
}
