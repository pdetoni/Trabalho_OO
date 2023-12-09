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

public class Persistencia {

    private Gson gson = new Gson();

    public Persistencia() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new GsonDateAdapter());
        gson = gsonBuilder.create();
    }


    public ArrayList<Usuario> lerArquivoUsuario(String arquivoUsuario) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (FileReader reader = new FileReader(arquivoUsuario)) {
            Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
            usuarios = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public ArrayList<Paciente> lerArquivoPaciente(String arquivoPaciente) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try (FileReader reader = new FileReader(arquivoPaciente)) {
            Type listType = new TypeToken<ArrayList<Paciente>>(){}.getType();
            pacientes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public ArrayList<Consulta> lerArquivoConsulta(String arquivoConsulta) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try (FileReader reader = new FileReader(arquivoConsulta)) {
            Type listType = new TypeToken<ArrayList<Consulta>>(){}.getType();
            consultas = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public ArrayList<Agenda> lerArquivoAgenda(String arquivoAgenda) {
        ArrayList<Agenda> agendas = new ArrayList<>();
        try (FileReader reader = new FileReader(arquivoAgenda)) {
            Type listType = new TypeToken<ArrayList<Agenda>>(){}.getType();
            agendas = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return agendas;
    }
}