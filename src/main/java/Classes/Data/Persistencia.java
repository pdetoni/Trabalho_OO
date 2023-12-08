package Classes.Data;

import Classes.Agenda;
import Classes.Consulta;
import Classes.Exception.AgendaException;
import Classes.Paciente;
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


    public Paciente criaPaciente(String linha) {
        String[] campos = linha.split(";");
        int id = Integer.parseInt(campos[0]);
        String nome = campos[1];
        String cpf = campos[2];
        char sexo = campos[3].charAt(0);
        int idade = Integer.parseInt(campos[4]);
        String email = campos[5];
        String cep = campos[6];
        String endereco = campos[7];

        return new Paciente(id, nome, cpf, sexo, idade, email, cep, endereco);
    }

    public ArrayList<Paciente> lerArquivoPaciente(String arquivoPaciente) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoPaciente))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Paciente paciente = criaPaciente(linha);
                pacientes.add(paciente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public Consulta criaConsulta(String linha) {
        String[] campos = linha.split(";");
        int id = Integer.parseInt(campos[0]);
        String tipo = campos[1];

        return new Consulta(id, tipo);
    }

    public ArrayList<Consulta> lerArquivoConsulta(String arquivoConsulta) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoConsulta))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Consulta consulta = criaConsulta(linha);
                consultas.add(consulta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consultas;
    }
    public Agenda criaAgenda(String linha) throws AgendaException {
        String[] campos = linha.split(";");
        int id = Integer.parseInt(campos[0]);
        String data = campos[1];
        Paciente paciente = criaPaciente(campos[2]);
        Consulta consulta = criaConsulta(campos[3]);

        return new Agenda(id, data, paciente, consulta);
    }

    public ArrayList<Agenda> lerArquivoAgenda(String arquivoAgenda) {
        ArrayList<Agenda> agendas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoAgenda))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Agenda agenda = criaAgenda(linha);
                agendas.add(agenda);
            }
        } catch (IOException | AgendaException e) {
            e.printStackTrace();
        }
        return agendas;
    }
}