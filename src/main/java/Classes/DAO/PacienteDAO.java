package Classes.DAO;

import Classes.Data.Persistencia;
import Classes.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteDAO extends GenericDAO<Paciente>{

    //ID que será incrementado para identificar cada paciente como um novo, mudar caso necessário
    protected static int ultimoId = 4;

    //Construtor que inicia banco para garantir que retorno não seja nulo
    public PacienteDAO() {
        Persistencia persistencia = new Persistencia();
        List<Paciente> pacientes = persistencia.lerArquivoPaciente("src/main/java/Classes/Data/pacientes.json");
        if (pacientes == null) {
            pacientes = new ArrayList<>();
        }
        Banco.Paciente = pacientes;
        for (Paciente paciente : pacientes) {
            ultimoId = Math.max(ultimoId, paciente.getId() + 1);
        }
    }

    public void insert(Paciente paciente) {
        paciente.setId(ultimoId++);
        Banco.Paciente.add(paciente);
    }

    public void update(Paciente paciente) {
        for (int i = 0; i < Banco.Paciente.size(); i++) {
            if (Banco.Paciente.get(i).getId() == paciente.getId()) {
                Banco.Paciente.set(i, paciente);
                break;
            }
        }
        Persistencia persistencia = new Persistencia();
        persistencia.escreverArquivoPaciente("src/main/java/Classes/Data/pacientes.json", Banco.Paciente);
    }

    // Atualização para deletar do JSON, além de só remover do banco
    public boolean delete(int id) {
        for (Paciente pacienteLista : Banco.Paciente) {
            if (pacienteLista.getId() == id) {
                Banco.Paciente.remove(pacienteLista);
                Persistencia persistencia = new Persistencia();
                persistencia.escreverArquivoPaciente("src/main/java/Classes/Data/pacientes.json", Banco.Paciente);
                return true;
            }
        }
        return false;
    }

    //Reajuste para que o retorno seja uma lista de pacientes, não nulo
    public List<Paciente> selectAll() {
        Persistencia persistencia = new Persistencia();
        List<Paciente> pacientes = persistencia.lerArquivoPaciente("src/main/java/Classes/Data/pacientes.json");
        if (pacientes == null) {
            return new ArrayList<>();
        }
        return pacientes;
    }

    private boolean idIguais(Paciente paciente, Paciente pacienteC) {
        return paciente.getId() == pacienteC.getId();
    }

    private int proximoId() {

        int maiorId = 0;

        for (Paciente paciente : Banco.Paciente) {
            int id = paciente.getId();

            if (maiorId < id) {
                maiorId = id;
            }

        }

        return maiorId + 1;
    }

    public boolean cpfExiste(String cpf) {
        for (Paciente paciente : Banco.Paciente) {
            if (paciente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public Paciente getPaciente(int id) {
        for (Paciente paciente : Banco.Paciente) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }
    public int getUltimoId() {
        return ultimoId;
    }
}
