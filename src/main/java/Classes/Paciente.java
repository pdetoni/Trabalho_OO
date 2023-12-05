/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author pdper
 */
public class Paciente extends Perfil {
    
    public Paciente(int id, String nome, String cpf, char sexo, int idade, String email, String cep, String endereco) {
        super(id, nome, cpf, sexo, idade, email);
        this.cep = cep;
        this.endereco = endereco;
    }
    
    private String cep;
    private String endereco;

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
    
    @Override
    public String toString() {
        return super.toString() + ", CEP:"+ cep + ", Endereço:"+ endereco +'}';
    }
    
}
