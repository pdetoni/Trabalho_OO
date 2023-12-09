package Classes;

public class Usuario extends Perfil {
    
    /*public Usuario(int id, String nome, String cpf, char sexo, int idade, String email) {
        super(id, nome, cpf, sexo, idade, email);
    }*/
    
    private String senha;
    private String cargo;

    public Usuario(int id, String nome, String senha) {
        super(id, nome);
        this.senha = senha;
    }
    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    

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
