package Controller;

import Classes.DAO.PacienteDAO;
import Classes.Paciente;
import Controller.Helper.PacienteH;

import Telas.CriaPaciente;
import javax.swing.JOptionPane;

public class PacienteC {
    private final CriaPaciente view;
    private final PacienteH helper;

    public PacienteC(CriaPaciente view) {
        this.view = view;
        this.helper = new PacienteH(view);
    }
    
    public void registrar(){
        Paciente paciente = helper.obterModelo();
        
        if(paciente != null){
            new PacienteDAO().insert(paciente);
            JOptionPane.showMessageDialog(null, "Paciente adicionado");
        }else{
            JOptionPane.showMessageDialog(null, "Paciente não adicionado");
        }
        
        helper.limpa();
    }
}
