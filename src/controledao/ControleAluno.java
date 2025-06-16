/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;
import modelo.exceptions.NotExistException;

/**
 *
 * @author Genilson Junior
 */
public class ControleAluno {
    public void inserir(Aluno a) throws SQLException{
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "insert into aluno (pront, nome, ano_ingresso, sigla_curso)" 
                + "values (?, ?, ?, ?)";
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setString(1, a.getProntuario());
        execSQL.setString(2, a.getNome());
        execSQL.setInt(3, a.getAno_ingresso());
        execSQL.setString(4, a.getSigla_curso());
        
        
        execSQL.executeUpdate();
        
        conexao.commit();
        
        execSQL.close();
        
        conexao.close();
    }
    
    public void excluir(String pront) throws SQLException, NotExistException{
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "delete from aluno where pront = ?";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setString(1, pront);
        
        int linhas = execSQL.executeUpdate();
        
        conexao.commit();
        execSQL.close();
        conexao.close();
        
        if(linhas == 0){
            throw new NotExistException("Aluno com o prontuario" + pront + "não existe");
            
        }
    }
    
    public void alterar (Aluno a) throws SQLException, NotExistException{
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "update aluno set pront = ?, nome = ?, ano_ingresso = ?, sigla_curso = ?";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setString(1, a.getProntuario());
        execSQL.setString(2, a.getNome());
        execSQL.setInt(3, a.getAno_ingresso());
        execSQL.setString(4, a.getSigla_curso());
        
        int quantAlterados = execSQL.executeUpdate();
        
        conexao.commit();
        
        execSQL.close();
        
        conexao.close();
        
        if( quantAlterados == 0){
            throw new NotExistException("Aluno não foi encontrado");
        }
    }
    
    public Aluno pesquisar(String pront) throws SQLException, NotExistException{
        Aluno a = null;
        
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "select * from aluno where pront = ?";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setString(1, pront);
        
        ResultSet resultadoConsulta;
        
        resultadoConsulta = execSQL.executeQuery();
        resultadoConsulta.last();
        
        if(resultadoConsulta.getRow() > 0){
            a = new Aluno();
            a.setProntuario(pront);
            a.setNome(resultadoConsulta.getString("nome"));
            a.setAno_ingresso(resultadoConsulta.getInt("ano_ingresso"));
            a.setSigla_curso(resultadoConsulta.getString("sigla_curso"));
        }else {
            throw new NotExistException("Aluno não foi encontrado");
        }
        
        execSQL.close();
        conexao.close();
        return a;
    }
    
    public List<Aluno> listarTodos() throws SQLException{
        List<Aluno> listaAlunos = new ArrayList<>();
        
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "select * from aluno";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        ResultSet resultadoConsulta;
        
        resultadoConsulta = execSQL.executeQuery();
        
        Aluno a;
        
        while(resultadoConsulta.next()){
            a = new Aluno();
            a.setProntuario(resultadoConsulta.getString("pront"));
            a.setNome(resultadoConsulta.getString("nome"));
            a.setAno_ingresso(resultadoConsulta.getShort("ano_ingresso"));
            a.setSigla_curso(resultadoConsulta.getString("sigla_curso"));
            
            listaAlunos.add(a);
        }
        return listaAlunos;
    }
}
