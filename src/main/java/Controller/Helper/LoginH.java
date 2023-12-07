/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Classes.Usuario;
import Telas.Login;

/**
 *
 * @author pdper
 */
public class LoginH implements IHelper{
    
    private final Login view;

    public LoginH(Login view) {
        this.view = view;
    }
    
    public Usuario getUser(){
       String nome = view.getUser().getText();
       String senha = view.getSenha().getText();
        
       Usuario usuario = new Usuario(0, nome, senha); 
       
       return usuario;
    }
    
    public void setUser(Usuario user){
        String nome = user.getNome();
        String senha = user.getSenha();
        
        view.getUser().setText(nome);
        view.getSenha().setText(senha);
        
    }
    
    public void limpar(){
        view.getUser().setText("");
        view.getSenha().setText("");
    }

    @Override
    public Usuario obterModelo() {
        String nome = view.getUser().getText();
        String senha = view.getSenha().getText();
        Usuario user = new Usuario(0, nome, senha);
        
        return user;
    }

    @Override
    public void limpa() {
        
    }
    
    
    
}
