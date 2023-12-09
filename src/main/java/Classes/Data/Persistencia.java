package Classes.Data;

import Classes.Agenda;
import Classes.Consulta;
import Classes.Exception.AgendaException;
import Classes.Paciente;
import Classes.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Persistencia {

    private Gson gson = new Gson();

    public Persistencia() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new GsonDateAdapter());
        gson = gsonBuilder.create();
    }


    public List<Usuario> lerArquivoUsuario(String arquivoUsuario) {
        List<Usuario> usuarios = new ArrayList<>();
        try (FileReader reader = new FileReader(arquivoUsuario)) {
            Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
            usuarios = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public List<Paciente> lerArquivoPaciente(String arquivoPaciente) {
        List<Paciente> pacientes = new ArrayList<>();
        try (FileReader reader = new FileReader(arquivoPaciente)) {
            Type listType = new TypeToken<ArrayList<Paciente>>(){}.getType();
            pacientes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public List<Consulta> lerArquivoConsulta(String arquivoConsulta) {
        List<Consulta> consultas = new ArrayList<>();
        try (FileReader reader = new FileReader(arquivoConsulta)) {
            Type listType = new TypeToken<ArrayList<Consulta>>(){}.getType();
            consultas = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public List<Agenda> lerArquivoAgenda(String arquivoAgenda) {
        List<Agenda> agendas = new ArrayList<>();
        try (FileReader reader = new FileReader(arquivoAgenda)) {
            Type listType = new TypeToken<ArrayList<Agenda>>(){}.getType();
            agendas = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return agendas;
    }
    public void escreverArquivoUsuario(String arquivoUsuario, Usuario novoUsuario) {
        List<Usuario> usuarios = lerArquivoUsuario(arquivoUsuario);
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }
        usuarios.add(novoUsuario);
        try (FileWriter writer = new FileWriter(arquivoUsuario)) {
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void escreverArquivoPaciente(String arquivoPaciente, List<Paciente> pacientes) {
        try (FileWriter writer = new FileWriter(arquivoPaciente)) {
            gson.toJson(pacientes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void escreverArquivoAgenda(String arquivoAgenda, List<Agenda> agendas) {
        try (FileWriter writer = new FileWriter(arquivoAgenda)) {
            System.out.println("Writing " + agendas.size() + " agendas to " + arquivoAgenda); // Proposito de debug
            gson.toJson(agendas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}