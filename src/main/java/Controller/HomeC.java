/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Controller;

import Classes.Agenda;
import Telas.CriaPaciente;
import Telas.Home;
import Telas.Registros;

public class HomeC {
    private final Home view;

    public HomeC(Home view) {
        this.view = view;
    }
    
    public void irPRegistros(){
        Registros registros = new Registros();
        
        registros.setVisible(true);
        
    }
    
    public void irPCriaPacientes(){
        CriaPaciente pacientes = new CriaPaciente();
        
        pacientes.setVisible(true);
        
    }
}
