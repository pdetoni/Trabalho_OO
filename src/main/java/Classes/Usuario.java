/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author pdper
 */
public class Usuario extends Perfil {
    
    /*public Usuario(int id, String nome, String cpf, char sexo, int idade, String email) {
        super(id, nome, cpf, sexo, idade, email);
    }*/
    
    private String senha;
    private String cargo;

    public Usuario(int id, String nome, String cpf, char sexo, int idade, String email, String senha, String cargo) {
        super(id, nome, cpf, sexo, idade, email);
        this.senha = senha;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString() + ", senha=" + senha + ", cargo=" + cargo + '}';
    }
    
    
    
    
    
}
