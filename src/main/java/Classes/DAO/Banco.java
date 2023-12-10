/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Classes.DAO;

import Classes.Agenda;
import Classes.Data.Persistencia;
import Classes.Paciente;
import Classes.Consulta;
import Classes.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    public static List<Usuario> usuario;
    public static List<Paciente> Paciente;
    public static List<Consulta> Consulta;
    public static List<Agenda> Agenda;

    public static void inicia() {
        Persistencia persistencia = new Persistencia();
        Paciente = persistencia.lerArquivoPaciente("src/main/java/Classes/Data/pacientes.json");
        for (Paciente paciente : Paciente) {
            PacienteDAO.ultimoId = Math.max(PacienteDAO.ultimoId, paciente.getId() + 1);
        }

        usuario = persistencia.lerArquivoUsuario("src/main/java/Classes/Data/usuarios.json");

        Consulta = persistencia.lerArquivoConsulta("src/main/java/Classes/Data/consultas.json");
        Agenda = persistencia.lerArquivoAgenda("src/main/java/Classes/Data/agendas.json");
    }
}