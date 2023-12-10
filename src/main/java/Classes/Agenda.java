/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Classes;

import Classes.Exception.AgendaException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agenda {
    private int id;
    private Date data;
    private Paciente paciente;
    private Consulta consulta;

    public Agenda(int id, String data, Paciente paciente, Consulta consulta) throws AgendaException {
        this.id = id;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
        } catch (ParseException ex) {
            throw new AgendaException("Data informada está no formato inválido. O formato correto é dd/MM/yyyy HH:mm");
        }
        this.paciente = paciente;
        this.consulta = consulta;
    }

    public Agenda() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }


    public void setData(Date data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        return "Agenda ID: " + id + ", Data: " + dataForm() + ", Paciente: " + paciente.getNome() + ", Consulta: " + consulta.getTipo();
    }

    public String dataForm() {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

    public String horaForm() {
        return new SimpleDateFormat("HH:mm").format(data);
    }

}
