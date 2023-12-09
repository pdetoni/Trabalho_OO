/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DAO;

import Classes.Agenda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pdper
 */
public class AgendaDAO {
    public void insert(Agenda agenda){
          
        if(agenda.getId() == 0){
            agenda.setId(proximoId());
            Banco.Agenda.add(agenda);
        }
        
        
    }

    public boolean update(Agenda Agenda){
        
        for (int i = 0; i < Banco.Agenda.size(); i++) {
            if(idSaoIguais(Banco.Agenda.get(i),Agenda)){
                Banco.Agenda.set(i, Agenda);
                return true;
            }
        }
        return false;      

    }
    
    public boolean delete(Agenda Agenda){
        for (Agenda AgendaLista : Banco.Agenda) {
            if(idSaoIguais(AgendaLista,Agenda)){
                Banco.Agenda.remove(AgendaLista);
                return true;
            }
        }
        return false;
    }

    public List<Agenda> selectAll(){
        return Banco.Agenda;
    }

    private boolean idSaoIguais(Agenda agenda, Agenda agendaC) {
        return agenda.getId() ==  agendaC.getId();
    }
    
    private int proximoId(){
        
        int maiorId = 0;
        
        for (Agenda agenda : Banco.Agenda) {           
           int id = agenda.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
            
        }
        
        return maiorId + 1;
    }
}
