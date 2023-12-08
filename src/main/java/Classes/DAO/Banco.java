/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DAO;

import Classes.Agenda;
import Classes.Exception.AgendaException;
import Classes.Paciente;
import Classes.Consulta;
import Classes.Usuario;
import java.util.ArrayList;

/**
 *
 * @author pdper
 */
public class Banco {
    public static ArrayList<Usuario> usuario;
    public static ArrayList<Paciente> Paciente;
    public static ArrayList<Consulta> Consulta;
    public static ArrayList<Agenda> Agenda;
    
    
    public static void inicia(){
    
        //Instancia os Objetos
        usuario = new ArrayList<Usuario>();
        Paciente = new ArrayList<Paciente>();
        Consulta = new ArrayList<Consulta>();
        Agenda = new ArrayList<Agenda>();
        
        //criando elementos
        Usuario usuario1 = new Usuario(1, "Gleiph", "123.456.789-10", 'M', 36, "Gleiph@gmail.com", "senha", "Dentista");
        Usuario usuario2 = new Usuario(2, "Lúcia", "165.786.909-50", 'F', 22, "lucia@gmail.com", "senha", "Secretária");
         
        Paciente paciente1 = new Paciente(1, "Leo", "335.676.769-58", 'M', 16, "leo@gmail.com", "51420-487", "Rua Patos, 32");
        Paciente paciente2 = new Paciente(2, "Marta", "763.876.087-88", 'F', 22, "marta@gmail.com", "13430-490", "Rua Garças, 45");
        Paciente paciente3 = new Paciente(3, "Felipe", "142.539.089-56", 'M', 30, "felipe@gmail.com", "49420-932", "Rua Joana, 17");
        Paciente paciente4 = new Paciente(4, "Vanda", "461.892.652-99", 'F', 32, "vanda@gmail.com", "78990-787", "Rua Lambari, 12");
        
        Consulta consulta1 = new Consulta(1, "Dentista");
        Consulta consulta2 = new Consulta(2, "Oftalmologista");
        Consulta consulta3 = new Consulta(3, "Ortopedista");
        Consulta consulta4 = new Consulta(4, "Pediatra");
        Consulta consulta5 = new Consulta(5, "Cardiologista");
        Consulta consulta6 = new Consulta(6, "Dematologista");


        //Refatoração da criação do objeto Agenda pós uso da classe AgendaException
        Agenda Agenda1 = null;
        Agenda Agenda2 = null;
        Agenda Agenda3 = null;
        try {
            Agenda1 = new Agenda(1,"22/12/2023 14:30", paciente4, consulta1);
            Agenda2 = new Agenda(2,"18/12/2023 09:30", paciente3, consulta4);
            Agenda3 = new Agenda(3,"14/12/2023 07:30", paciente1, consulta3);
        } catch (AgendaException e) {
            System.out.println(e.getMessage());
        }

        //Adiciona Elementos na lista
        usuario.add(usuario1);
        usuario.add(usuario2);
        
        Paciente.add(paciente1);
        Paciente.add(paciente2);
        Paciente.add(paciente3);
        Paciente.add(paciente4);
        
        
        Consulta.add(consulta1);
        Consulta.add(consulta2);
        Consulta.add(consulta3);
        Consulta.add(consulta4);
        Consulta.add(consulta5);
        Consulta.add(consulta6);
        
        Agenda.add(Agenda1);
        Agenda.add(Agenda2);
        Agenda.add(Agenda3);
        
    }
    
}
