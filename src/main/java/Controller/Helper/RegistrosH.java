/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Controller.Helper;

import Classes.Agenda;
import Classes.Consulta;
import Classes.Exception.AgendaException;
import Classes.Paciente;
import Telas.Registros;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class RegistrosH implements IHelper {
    private final Registros view;

    public RegistrosH(Registros view) {
        this.view = view;
    }

    public void preenche(List<Agenda> registros) {
        DefaultTableModel table = (DefaultTableModel) view.getjTable1().getModel();
        
        table.setNumRows(0);
        
        for (Agenda registro : registros) {
            table.addRow(new Object[]{registro.getId(), registro.getPaciente().getNome(), registro.getConsulta().getTipo(), registro.dataForm(), registro.horaForm()});
        }
    }

    public void preencherPac(List<Paciente> pacientes) {
        DefaultComboBoxModel combo = (DefaultComboBoxModel) view.getPacienteCombo().getModel();
        
        for (Paciente paciente : pacientes) {
            combo.addElement(paciente);
        }
    }
    

    public void preencherCons(List<Consulta> consultas) {
        DefaultComboBoxModel combo = (DefaultComboBoxModel) view.getConsultaCombo().getModel();
        
        for (Consulta consulta : consultas) {
            combo.addElement(consulta);
        }
    }

    
    @Override
    public Agenda obterModelo() {
        //String idS = view.getId().getText();
        
        //int id = Integer.parseInt(idS);
        
        Paciente paciente = retornaPaciente();
        
        Consulta consulta = retornaConsulta();
        
        String data = view.getData().getText();
        
        String hora = view.getHora().getText();
        
        String dh = data + " " + hora;

        Agenda agenda = null;
        try {
            agenda = new Agenda(0, dh, paciente, consulta);
        } catch (AgendaException ex) {
            System.out.println(ex.getMessage());
        }

        return agenda;
    }

   
    @Override
    public void limpa() {
        //view.getId().setText("");
        view.getData().setText("");
        view.getHora().setText("");
        
    }
    
    public Consulta retornaConsulta(){
        return (Consulta) view.getConsultaCombo().getSelectedItem();
        
    }
    
    public Paciente retornaPaciente(){
        return (Paciente) view.getPacienteCombo().getSelectedItem();
        
    }
}
