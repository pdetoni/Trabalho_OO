/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Agenda;
import Classes.DAO.AgendaDAO;
import Controller.Helper.RegistrosH;
import Telas.Registros;
import java.util.ArrayList;

/**
 *
 * @author pdper
 */
public class RegistrosC {
    private final Registros view;
    private final RegistrosH helper;

    public RegistrosC(Registros view) {
        this.view = view;
        this.helper = new RegistrosH(view);
    }
    
    public void atualizaTabela(){
        AgendaDAO ag = new AgendaDAO();
        
        ArrayList<Agenda> registros = ag.selectAll();
        
        helper.preenche(registros);
    }
}
