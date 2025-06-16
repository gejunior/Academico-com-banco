/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aluno
 */
public class Aluno {
    private String pront;
    private String nome;
    private int ano_ingresso;
    private String sigla_curso;

    public Aluno(){}
    
    public Aluno(String prontuario, String nome, int ano_ingresso, Curso curso) {
        this.pront = prontuario;
        this.nome = nome;
        this.ano_ingresso = ano_ingresso;
        this.sigla_curso = curso.getSigla();
    }

    public String getProntuario() {
        return pront;
    }

    public void setProntuario(String prontuario) {
        this.pront = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno_ingresso() {
        return ano_ingresso;
    }

    public void setAno_ingresso(int ano_ingresso) {
        this.ano_ingresso = ano_ingresso;
    }

    public String getSigla_curso() {
        return sigla_curso;
    }

    public void setSigla_curso(String sigla_curso) {
        this.sigla_curso = sigla_curso;
    }
    
    @Override
    public String toString() {
        return "Aluno{" + "prontuario=" + pront + ", nome=" + nome + ", ano_ingresso=" + ano_ingresso + ", sigla_curso=" + sigla_curso + '}';
    }
}
