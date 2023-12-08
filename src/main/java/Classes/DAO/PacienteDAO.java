/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DAO;

import Classes.Paciente;
import java.util.ArrayList;

/**
 *
 * @author pdper
 */
public class PacienteDAO {

    //Construtor que inicia banco para garantir que retorno não seja nulo
    public PacienteDAO() {
        Banco.inicia();
    }
    
    public void insert(Paciente paciente){
        Banco.Paciente.add(paciente);
    }
    
    
    public boolean update(Paciente paciente){
        
        for (int i = 0; i < Banco.Paciente.size(); i++) {
            if(idIguais(Banco.Paciente.get(i),paciente)){
                Banco.Paciente.set(i, paciente);
                return true;
            }
        }
        return false;      

    }
    
    
    public boolean delete(Paciente paciente){
        for (Paciente pacienteLista : Banco.Paciente) {
            if(idIguais(pacienteLista,paciente)){
                Banco.Paciente.remove(pacienteLista);
                return true;
            }
        }
        return false;
    }


    public ArrayList<Paciente> selectAll(){
        return Banco.Paciente;
    }
    
    
    private boolean idIguais(Paciente paciente, Paciente pacienteC) {
        return paciente.getId() ==  pacienteC.getId();
    }
}
