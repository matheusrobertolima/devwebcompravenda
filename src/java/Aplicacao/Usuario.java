/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

/**
 *
 * @author Matheus
 */
public class Usuario {
    
    private int idusuario;
    private String nome;
    private String cpf;
    private String senha;
    private String tipo;
    private boolean isValid;
    
    public Usuario(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
 
    }
    
    public Usuario() {
        
    }
    
    public Usuario(int idusuario, String nome, String cpf, String senha, String tipo) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.tipo = tipo;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    
    
    
    
    
}
