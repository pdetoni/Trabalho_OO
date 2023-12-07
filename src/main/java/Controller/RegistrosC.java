/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Agenda;
import Classes.Consulta;
import Classes.DAO.AgendaDAO;
import Classes.DAO.ConsultaDAO;
import Classes.DAO.PacienteDAO;
import Classes.Paciente;
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
    
    public void attPaciente(){
        PacienteDAO paciente = new PacienteDAO();
        
        ArrayList<Paciente> pacientes = paciente.selectAll();
        
        helper.preencherPac(pacientes);
    }
    
    public void attConsulta(){
       ConsultaDAO consulta = new ConsultaDAO();
       
       ArrayList<Consulta> consultas = consulta.selectAll();
       
       helper.preencherCons(consultas);
    }
    
    public void atualizaTabela(){
        AgendaDAO ag = new AgendaDAO();
        
        ArrayList<Agenda> registros = ag.selectAll();
        
        helper.preenche(registros);
    }
    
    public void registrar(){
        Agenda agenda = helper.obterModelo();
        
        new AgendaDAO().insert(agenda);
        
        atualizaTabela();
        
        helper.limpa();
    }
    
    
}
