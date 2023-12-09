package Classes.DAO;

import Classes.Consulta;
import java.util.ArrayList;
import java.util.List;

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


    public List<Consulta> selectAll(){
        return Banco.Consulta;
    }
    
    
    private boolean idSaoIguais(Consulta consulta, Consulta consultaC) {
        return consulta.getId() ==  consultaC.getId();
    }
}
