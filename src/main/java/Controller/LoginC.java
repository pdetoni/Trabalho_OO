/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Controller;

import Classes.DAO.UsuarioDAO;
import Classes.Usuario;
import Controller.Helper.LoginH;
import Telas.Home;
import Telas.Login;

public class LoginC {

    private final Login view;
    private LoginH helper;

    public LoginC(Login view) {
        this.view = view;
        this.helper = new LoginH(view);
    }

    //Modificações ao entrar para implementação do user root e possivelmente mais no futuro
    public Usuario entrar(){
        Usuario usuario = helper.getUser();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);

        if (usuarioAutenticado != null){
            return usuarioAutenticado;
        }
        return null;
    }
    
    public void acao(){
        System.out.println("Fiz algo");
        this.view.msgm("Alguma ação foi feita.");
    }
    
}
