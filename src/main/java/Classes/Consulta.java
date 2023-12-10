/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Classes;

public class Consulta {

    private int id;
    private String tipo;
    private Medico medicoResponsavel;


    public Consulta(int id, String tipo, Medico medicoResponsavel) {
        this.id = id;
        this.tipo = tipo;
        this.medicoResponsavel = medicoResponsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    @Override
    public String toString() {
        return "Consulta: " + getTipo() + ", Médico Responsável: " + medicoResponsavel.getNome();
    }

}
