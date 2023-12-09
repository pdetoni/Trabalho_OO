package Classes;

public class Consulta {

    private int id;
    private String tipo;
    private MedicoResponsavel medicoResponsavel;

    public Consulta(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
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

    public MedicoResponsavel getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(MedicoResponsavel medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }


    @Override
    public String toString() {
        return getTipo();
    }

}
