/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;
/**
 *
 * @author Aluno
 */
public class VisaoCurso {    
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
        Home tela = new Home();
        tela.setVisible(true);
    }
}
