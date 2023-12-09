package Classes.DAO;

import Classes.Agenda;
import Classes.Data.Persistencia;
import Classes.Paciente;
import Classes.Consulta;
import Classes.Usuario;

import java.util.ArrayList;

public class Banco {
    public static ArrayList<Usuario> usuario;
    public static ArrayList<Paciente> Paciente;
    public static ArrayList<Consulta> Consulta;
    public static ArrayList<Agenda> Agenda;

    public static void inicia() {
        Persistencia persistencia = new Persistencia();
        usuario = persistencia.lerArquivoUsuario("src/main/java/Classes/Data/usuarios.json");
        Paciente = persistencia.lerArquivoPaciente("src/main/java/Classes/Data/pacientes.json");
        Consulta = persistencia.lerArquivoConsulta("src/main/java/Classes/Data/consultas.json");
        Agenda = persistencia.lerArquivoAgenda("src/main/java/Classes/Data/agendas.json");
    }
}