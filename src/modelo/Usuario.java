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
    private String usuario;
    private String senha;
    private String papel;

    public Usuario(String usuario, String senha, String papel) {
        this.usuario = usuario;
        this.senha = senha;
        this.papel = papel;
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
