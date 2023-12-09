package Classes.DAO;

import Classes.Agenda;
import java.util.ArrayList;
import java.util.List;

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

    //Ajuste para não ocorrer de retorno null ao criar o visualizar agenda
    public List<Agenda> selectAll() {
        List<Agenda> agendas = Banco.Agenda;
        if (agendas == null) {
            agendas = new ArrayList<>();
        }
        return agendas;
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
