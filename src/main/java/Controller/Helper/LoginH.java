/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Controller.Helper;

import Classes.Usuario;
import Telas.Login;

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
