package Classes.DAO;

import Classes.Agenda;
import Classes.Data.Persistencia;

import java.util.ArrayList;
import java.util.List;

public class AgendaDAO extends GenericDAO<Agenda>{

    // Construtor para ler o arquivo e carregar a lista de Agendas
    public AgendaDAO() {
        Persistencia persistencia = new Persistencia();
        List<Agenda> agendas = persistencia.lerArquivoAgenda("src/main/java/Classes/Data/agendas.json");
        if (agendas == null) {
            agendas = new ArrayList<>();
        }
        Banco.Agenda = agendas;
    }

    public void insert(Agenda agenda){
        if(agenda.getId() == 0){
            agenda.setId(proximoId());
        }
        Banco.Agenda.add(agenda);
        Persistencia persistencia = new Persistencia();
        persistencia.escreverArquivoAgenda("src/main/java/Classes/Data/agendas.json", Banco.Agenda);
    }
    public void update(Agenda agenda) {
        for (int i = 0; i < Banco.Agenda.size(); i++) {
            if (Banco.Agenda.get(i).getId() == agenda.getId()) {
                Banco.Agenda.set(i, agenda);
                break;
            }
        }
        Persistencia persistencia = new Persistencia();
        persistencia.escreverArquivoAgenda("src/main/java/Classes/Data/agendas.json", Banco.Agenda);
    }


    public boolean delete(int id){
        for (Agenda agendaLista : Banco.Agenda) {
            if(agendaLista.getId() == id){
                Banco.Agenda.remove(agendaLista);
                Persistencia persistencia = new Persistencia();
                persistencia.escreverArquivoAgenda("src/main/java/Classes/Data/agendas.json", Banco.Agenda);
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

    //Retornar o ultimo id para uso na tela de adicionar agenda
    public int getUltimoId() {
        int maiorId = 0;
        for (Agenda agenda : Banco.Agenda) {
            maiorId = Math.max(maiorId, agenda.getId());
        }
        return maiorId + 1;
    }
}
