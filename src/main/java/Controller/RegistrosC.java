/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
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
import java.util.List;


public class RegistrosC {
    private final Registros view;
    private final RegistrosH helper;

    public RegistrosC(Registros view) {
        this.view = view;
        this.helper = new RegistrosH(view);
    }
    
    public void attPaciente(){
        PacienteDAO paciente = new PacienteDAO();
        List<Paciente> pacientes = paciente.selectAll();
        helper.preencherPac(pacientes);
    }
    
    public void attConsulta(){
       ConsultaDAO consulta = new ConsultaDAO();
        List<Consulta> consultas = consulta.selectAll();
       helper.preencherCons(consultas);
    }
    
    public void atualizaTabela(){
        AgendaDAO ag = new AgendaDAO();
        List<Agenda> registros = ag.selectAll();
        helper.preenche(registros);
    }
    
    public void registrar(){
        Agenda agenda = helper.obterModelo();
        
        new AgendaDAO().insert(agenda);
        
        atualizaTabela();
        
        helper.limpa();
    }
    
    
}
