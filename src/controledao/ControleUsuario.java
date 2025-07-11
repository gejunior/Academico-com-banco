/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;
import modelo.exceptions.NotExistException;

/**
 *
 * @author Genilson Junior
 */
public class ControleUsuario {
    public void inserir(Usuario c) throws SQLException{
        // criar a string contendo o SQL
        try (Connection conexao = GerenteConexao.getConexao()) {
            // criar a string contendo o SQL
            String comandoSQL = "insert into usuario (user, senha, papel)"
                    + " values(?, ?, ?)";
            // Preparar a string para execução do SQL
            PreparedStatement execSQL;
            // Preparar a string para execução do SQL
            execSQL = conexao.prepareStatement(comandoSQL);
            // passar os parametros para o SQL
            execSQL.setString(1, c.getUsuario());
            execSQL.setString(2, c.getSenha());
            execSQL.setString(3, c.getPapel());
            // executar o comando SQL montado
            execSQL.executeUpdate();
            // fazer o commit na conexao
            conexao.commit();
            //finaliza a execução do SQL
            execSQL.close();
            // finaliza a conexão com o banco de dados
        }
    }
    
    public Usuario pesquisar (String user, String passWord) throws SQLException, NotExistException{
        Usuario a = null;
        
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "select * from usuario where user = ? and senha = ?";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setString(1, user);
        execSQL.setString(2, passWord);
        
        ResultSet resultadoConsulta;
        
        resultadoConsulta = execSQL.executeQuery();
        resultadoConsulta.last();
        
        if(resultadoConsulta.getRow() > 0){
            a = new Usuario();
            a.setUsuario(resultadoConsulta.getString("user"));
            a.setSenha(resultadoConsulta.getString("senha"));
            a.setPapel(resultadoConsulta.getString("papel"));
        }else {
            throw new NotExistException("Usuario não foi encontrado");
        }
        
        execSQL.close();
        conexao.close();
        return a;
    }
    
    public boolean verificarSenha(Usuario u) throws SQLException{
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "select * from usuario where usuario = ?";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setString(1, u.getUsuario());
        
        ResultSet resultadoConsulta;
        
        resultadoConsulta = execSQL.executeQuery();
        resultadoConsulta.last();
        return true;
        
    }
}
