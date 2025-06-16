package controledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Curso;
import modelo.exceptions.NotExistException;

/**
 * Classe responsável pelo acesso aos dados dos cursos
 * armazenado no banco de dados
 * @author Aluno
 */
public class ControleCurso {
    public void inserir(Curso c) throws SQLException{
        Connection conexao = GerenteConexao.getConexao();
        // criar a string contendo o SQL
        String comandoSQL = "insert into curso (sigla, nome, coordenador)"
                          + " values(?, ?, ?)";
        
        // Preparar a string para execução do SQL
        PreparedStatement execSQL;
     
        // Preparar a string para execução do SQL
        execSQL = conexao.prepareStatement(comandoSQL);
            
        // passar os parametros para o SQL
        execSQL.setString(1, c.getSigla());
        execSQL.setString(2, c.getNome());
        execSQL.setString(3, c.getCoordenador());

        // executar o comando SQL montado
        execSQL.executeUpdate();
            
        // fazer o commit na conexao
        conexao.commit();

        //finaliza a execução do SQL
        execSQL.close();
            
        // finaliza a conexão com o banco de dados
        conexao.close();
    }
    
    public void excluir(String sigla) throws SQLException, NotExistException{
        Connection conexao = GerenteConexao.getConexao();
        
        // criar a string contendo o SQL
        String comandoSQL = "DELETE FROM curso WHERE sigla = ?";
        
        // Preparar a string para execução do SQL
        PreparedStatement execSQL;
     
        // Preparar a string para execução do SQL
        execSQL = conexao.prepareStatement(comandoSQL);
            
        // passar os parametros para o SQL
        execSQL.setString(1, sigla);
        
        // executar o comando SQL montado
        int linhas = execSQL.executeUpdate();
            
        // fazer o commit na conexao
        conexao.commit();

        //finaliza a execução do SQL
        execSQL.close();
            
        // finaliza a conexão com o banco de dados
        conexao.close();
        
        if (linhas == 0)
        {
            throw new NotExistException("Curso com a sigla " 
                    + sigla + " não existe");
        }
    }
    
    public void alterar(Curso c) throws SQLException, NotExistException{
        Connection conexao = GerenteConexao.getConexao();
        // criar a string contendo o SQL
        String comandoSQL = "update curso set nome = ?, coordenador = ? "
                          + " where sigla = ?";
        
        // Preparar a string para execução do SQL
        PreparedStatement execSQL;
     
        // Preparar a string para execução do SQL
        execSQL = conexao.prepareStatement(comandoSQL);
            
        // passar os parametros para o SQL
        execSQL.setString(3, c.getSigla());
        execSQL.setString(1, c.getNome());
        execSQL.setString(2, c.getCoordenador());

        // executar o comando SQL montado retornando o número de linhas afetadas
        int quantAlterados = execSQL.executeUpdate();
            
        // fazer o commit na conexao
        conexao.commit();

        //finaliza a execução do SQL
        execSQL.close();
            
        // finaliza a conexão com o banco de dados
        conexao.close();
        
        if (quantAlterados == 0)
        {
            throw new NotExistException("Curso não foi encontrado");
        }
        
    }
    
    public Curso pesquisar(String sigla) throws SQLException, NotExistException
    {
        // curso a ser retornado
        Curso c = null;
        
        // pega uma conexao
        Connection conexao = GerenteConexao.getConexao();

        // criar a string contendo o SQL
        String comandoSQL = "SELECT * FROM curso WHERE sigla = ?";
        
        // Preparar a string para execução do SQL
        PreparedStatement execSQL;
     
        // Preparar a string para execução do SQL
        execSQL = conexao.prepareStatement(comandoSQL);
            
        // passar os parametros para o SQL
        execSQL.setString(1, sigla);
        
        // Objeto para armazenar o resuldado de uma consulta SQL
        ResultSet resultadoConsulta;
        
        // executa a consulta
        resultadoConsulta = execSQL.executeQuery();
        
//        resultadoConsulta.first();
//        resultadoConsulta.next();

        // avança para a última linha
        resultadoConsulta.last();
        // Pega o número da última linha (para esse caso)
        if (resultadoConsulta.getRow() > 0)
        {
            c = new Curso();
            c.setSigla(sigla);
            c.setNome(resultadoConsulta.getString("nome"));
            c.setCoordenador(resultadoConsulta.getString("coordenador"));
        }
        else
        {
            throw new NotExistException("Curso não foi encontrado");
        }
        
        //finaliza a execução do SQL
        execSQL.close();
            
        // finaliza a conexão com o banco de dados
        conexao.close();                   
        
        return c;
    }
    
    public List<Curso> listarTodos() throws SQLException
    {
        // lista contendo os cursos
        List<Curso> listaCursos = new ArrayList<>();
        
        // pega uma conexao
        Connection conexao = GerenteConexao.getConexao();

        // criar a string contendo o SQL
        String comandoSQL = "SELECT * FROM curso";
        
        // Preparar a string para execução do SQL
        PreparedStatement execSQL;
     
        // Preparar a string para execução do SQL
        execSQL = conexao.prepareStatement(comandoSQL);
                   
        // Objeto para armazenar o resuldado de uma consulta SQL
        ResultSet resultadoConsulta;
        
        // executa a consulta
        resultadoConsulta = execSQL.executeQuery();
        
        Curso c;
        // verifica se tem mais registros no resultadoConsulta
        while(resultadoConsulta.next())
        {
            // preencher o objeto curso com os dados do banco
            c = new Curso();
            c.setSigla(resultadoConsulta.getString("sigla"));
            c.setNome(resultadoConsulta.getString("nome"));
            c.setCoordenador(resultadoConsulta.getString("coordenador"));
            
            // adicionar na lista de cursos
            listaCursos.add(c);
        }   
        return listaCursos;
    }
    
}
