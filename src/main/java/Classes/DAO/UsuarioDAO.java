package Classes.DAO;

import Classes.Usuario;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO extends GenericDAO<Usuario>{

    //Construtor que inicia banco para garantir que retorno não seja nulo
    public UsuarioDAO() {
        Banco.inicia();
    }
    public void insert(Usuario usuario){
        //Banco.usuario.add(usuario);
        if(usuario.getId() == 0){
            usuario.setId(proximoId());
            Banco.usuario.add(usuario);
        }
    }
    
    
    public boolean update(Usuario usuario){
        
        for (int i = 0; i < Banco.usuario.size(); i++) {
            if(idSaoIguais(Banco.usuario.get(i),usuario)){
                Banco.usuario.set(i, usuario);
                return true;
            }
        }
        return false;      

    }
    
    
    public boolean delete(Usuario usuario){
        for (Usuario usuarioLista : Banco.usuario) {
            if(idSaoIguais(usuarioLista,usuario)){
                Banco.usuario.remove(usuarioLista);
                return true;
            }
        }
        return false;
    }


    public List<Usuario> selectAll(){
        return Banco.usuario;
    }
    
    
    public Usuario selectPorNomeESenha(Usuario usuario){
        for (Usuario usuarioLista : Banco.usuario) {
            if(nomeESenhaSaoIguais(usuarioLista,usuario)){
                return usuarioLista;
            }
        }
        return null;
    }

    
    private boolean nomeESenhaSaoIguais(Usuario usuario, Usuario usuarioAPesquisar) {
        return usuario.getNome().equals(usuarioAPesquisar.getNome()) && usuario.getSenha().equals(usuarioAPesquisar.getSenha());
    }

    
    private boolean idSaoIguais(Usuario usuario, Usuario usuarioAComparar) {
        return usuario.getId() ==  usuarioAComparar.getId();
    }
    
    private int proximoId(){
        
        int maiorId = 0;
        
        for (Usuario user : Banco.usuario) {           
           int id = user.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
            
        }
        
        return maiorId + 1;
    }


    public int getUltimoId() {
        int maiorId = 0;
        for (Usuario usuario : Banco.usuario) {
            maiorId = Math.max(maiorId, usuario.getId());
        }
        return maiorId + 1;
    }
}
