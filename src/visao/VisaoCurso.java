/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controledao.ControleCurso;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import modelo.Curso;
import modelo.exceptions.NotExistException;

/**
 *
 * @author Aluno
 */
public class VisaoCurso {

    private Scanner ler = new Scanner(System.in);
    private ControleCurso controle = new ControleCurso();
    
    public void cadastrarCurso()
    {
        Curso c = new Curso();
        
        System.out.println("Sigla.........: ");
        c.setSigla(ler.nextLine());       
        System.out.println("Nome..........: ");
        c.setNome(ler.nextLine());
        System.out.println("Coordenador...: ");
        c.setCoordenador(ler.nextLine());
        
        try {
            controle.inserir(c);
            System.out.println("Curso cadastrado.");
        } catch(SQLException e)
        {
            System.out.println("Não possível cadastrar esse curso");
            System.out.println(e.getMessage());
        }
        
    }
    
    public void apresentarDadosCurso(Curso c)
    {
        System.out.println("Sigla.........: " + c.getSigla());
        System.out.println("Nome..........: " + c.getNome());
        System.out.println("Coordenador...: " + c.getCoordenador());
    }
    
    public void excluirCurso()
    {
        String sigla;
        Curso c;
        System.out.print("Digite a sigla do curso a excluir..:");
        sigla = ler.nextLine();
        try {
            c = controle.pesquisar(sigla);
            apresentarDadosCurso(c);
            System.out.println("Confirma a exclusão??");
            String confirma = ler.nextLine();
            if (confirma.equals("S"))
            {
                controle.excluir(sigla);
            }
        } catch (NotExistException e)
        {
            System.out.println(e.getMessage());
        } catch (SQLException e)
        {
            System.out.println("Erro na exclusão: "+ e.getMessage());
        }
 
    }
    
    public void listarCursos()
    {
        List<Curso> listaCursos;
        try {
            listaCursos = controle.listarTodos();
            for(Curso c: listaCursos)
            {
                System.out.println(c.getSigla()+"-"+c.getNome()+"-"+c.getCoordenador());
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar os cursos.");
        }
        

    }
    
    
    public static void main(String[] args) {
        
        try {
            // Carregar o driver para acesso ao bando de dados MySql
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            
            // o driver não foi encontrado
            System.out.println("Driver não encontrado: com.mysql.jdbc.Driver");
            System.exit(0);
        }
        // driver já foi carregado, dessa forma é possível fazer a conexão 
        // com o banco de dados Mysql
        
        VisaoCurso tela = new VisaoCurso();
        
          tela.cadastrarCurso();
//        
//        tela.excluirCurso();

          tela.listarCursos();
        
    }
    
    
    
}
