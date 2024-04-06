package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.Usuario;

@Path("/validar")
public class UsuarioController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response validarSenha(@QueryParam("nome") String nome, @QueryParam("password") String senhaFornecida) {
        String senhaUsuario = null;

        // Configuração da conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/ATMcode";
        String username = "root";
        String password = "";

        try {
            // Estabelece a conexão com o banco de dados
            Connection conn = DriverManager.getConnection(url, username, password);

            // Prepara a consulta SQL
            String sql = "SELECT password FROM usuario WHERE nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);

            // Executa a consulta e obtém a senha do usuário
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                senhaUsuario = rs.getString("senha");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Compara a senha fornecida com a senha do usuário
        if (senhaFornecida.equals(senhaUsuario)) {
            return Response.status(Response.Status.OK).entity("Senha validada com sucesso!").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Senha inválida!").build();
        }
    }
}


