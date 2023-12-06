/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Usuario;
import Controller.Helper.LoginH;
import Telas.Login;

/**
 *
 * @author pdper
 */
public class LoginC {

    private final Login view;
    private LoginH helper;

    public LoginC(Login view) {
        this.view = view;
        this.helper = new LoginH(view);
    }
    
    public void entrar(){
        Usuario usuario = helper.getUser();
    }
    
    public void acao(){
        System.out.println("Fiz algo");
        this.view.msgm("Alguma ação foi feita.");
    }
    
}
