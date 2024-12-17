package br.com.silbeckpro.hotelcontinentaljpa.persistencia;

import br.com.silbeckpro.hotelcontinentaljpa.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioBD {
    //Método para validar o tipo de usuario
    public static Usuario ValidarUsuario(Usuario usuario) {
     
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Usuario usuarioEncontrado = null;
    
        try{
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelcontinentaljpa", "root", "");
            PreparedStatement statement = conexao.prepareStatement(sql);
        
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());
        
            ResultSet rs = statement.executeQuery();
        
            if (rs.next()) {
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));  
            }
        }catch(SQLException ex){
            System.out.println("Sintaxe de comando inválida!" + ex.getMessage());
        }
        return usuarioEncontrado;
    }
}
