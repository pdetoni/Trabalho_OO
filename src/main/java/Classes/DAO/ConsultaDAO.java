/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DAO;

import Classes.Consulta;
import java.util.ArrayList;

/**
 *
 * @author pdper
 */
public class ConsultaDAO {
    public void insert(Consulta consulta){
        Banco.Consulta.add(consulta);
    }
    
    
    public boolean update(Consulta consulta){
        
        for (int i = 0; i < Banco.Consulta.size(); i++) {
            if(idSaoIguais(Banco.Consulta.get(i),consulta)){
                Banco.Consulta.set(i, consulta);
                return true;
            }
        }
        return false;      

    }
    
    
    public boolean delete(Consulta Consulta){
        for (Consulta ConsultaLista : Banco.Consulta) {
            if(idSaoIguais(ConsultaLista,Consulta)){
                Banco.Consulta.remove(ConsultaLista);
                return true;
            }
        }
        return false;
    }
    
    
    public ArrayList<Consulta> selectAll(){
        return Banco.Consulta;
    }
    
    
    private boolean idSaoIguais(Consulta consulta, Consulta consultaC) {
        return consulta.getId() ==  consultaC.getId();
    }
}
