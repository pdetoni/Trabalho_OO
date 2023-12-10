/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Classes;

public class Paciente extends Perfil {

    private String cep;
    private String endereco;

    public Paciente(int id, String nome, String cpf, char sexo, int idade, String email, String cep, String endereco) {
        super(id, nome, cpf, sexo, idade, email);
        this.cep = cep;
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    //Ajuste no toString para exibir o ID também, além do nome (ultil classe Delete)
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Idade: " + idade;
    }
}
