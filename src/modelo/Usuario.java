/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author Genilson Junior
 */
public class Usuario {
    private static int contador = 0;
    private int ID;
    private String usuario;
    private String senha;
    private String papel;

    public Usuario() {}

    public Usuario(String usuario, String senha) {
        contador += 1;
        ID = contador;
        this.usuario = usuario;
        this.senha = senha;
        this.papel = "simples";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
            
    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", senha=" + senha + ", papel=" + papel + '}';
    }
    
}
