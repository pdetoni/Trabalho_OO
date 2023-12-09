package Classes;

public class Medico implements MedicoResponsavel {
    private String nome;
    private String cpf;

    public Medico(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCpf() {
        return cpf;
    }
}