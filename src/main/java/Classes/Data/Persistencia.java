package Classes.Data;

import Classes.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

    public Usuario criaUsuario(String linha) {
        String[] campos = linha.split(";");
        int id = Integer.parseInt(campos[0]);
        String nome = campos[1];
        String cpf = campos[2];
        char sexo = campos[3].charAt(0);
        int idade = Integer.parseInt(campos[4]);
        String email = campos[5];
        String senha = campos[6];
        String cargo = campos[7];

        return new Usuario(id, nome, cpf, sexo, idade, email, senha, cargo);
    }

    //Leitura do arquivo de usuários e eventual criação de um ArrayList de usuários
    public ArrayList<Usuario> lerArquivo(String arquivoUsuario) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoUsuario))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Usuario usuario = criaUsuario(linha);
                usuarios.add(usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}