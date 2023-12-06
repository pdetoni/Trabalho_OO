/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Agenda;
import Telas.Home;
import Telas.Registros;

/**
 *
 * @author pdper
 */
public class HomeC {
    private final Home view;

    public HomeC(Home view) {
        this.view = view;
    }
    
    public void irPRegistros(){
        Registros registros = new Registros();
        
        registros.setVisible(true);
        
    }
}
