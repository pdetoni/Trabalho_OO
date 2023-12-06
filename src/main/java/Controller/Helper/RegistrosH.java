/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Classes.Agenda;
import Telas.Registros;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pdper
 */
public class RegistrosH {
    private final Registros view;

    public RegistrosH(Registros view) {
        this.view = view;
    }

    public void preenche(ArrayList<Agenda> registros) {
        DefaultTableModel table = (DefaultTableModel) view.getjTable1().getModel();
        
        table.setNumRows(0);
        
        for (Agenda registro : registros) {
            table.addRow(new Object[]{registro.getId(), registro.getPaciente().getNome(), registro.getConsulta().getTipo(), registro.dataForm(), registro.horaForm()});
        }
    }
}
