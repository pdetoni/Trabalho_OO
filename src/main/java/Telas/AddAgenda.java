/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Telas;

import Classes.Agenda;
import Classes.Consulta;
import Classes.Data.Persistencia;
import Classes.Exception.AgendaException;
import Classes.Paciente;
import Classes.DAO.AgendaDAO;
import Classes.DAO.ConsultaDAO;
import Classes.DAO.PacienteDAO;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AddAgenda extends JFrame {

    private JComboBox<Paciente> pacienteComboBox;
    private JComboBox<Consulta> consultaComboBox;
    private JTextField dataField;
    private JButton addButton;
    private JButton backButton;
    private AgendaDAO agendaDAO;
    private PacienteDAO pacienteDAO;
    private ConsultaDAO consultaDAO;

    private Agenda agenda = null;

    public AddAgenda() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        agendaDAO = new AgendaDAO();
        pacienteDAO = new PacienteDAO();
        consultaDAO = new ConsultaDAO();
        updateComboBoxes();
    }

    //Construtor para uso com o EditAgenda
    public AddAgenda(Agenda agenda) {
        this();
        this.agenda = agenda;
        pacienteComboBox.setSelectedItem(agenda.getPaciente());
        consultaComboBox.setSelectedItem(agenda.getConsulta());
        dataField.setText(agenda.dataForm());
    }

    private void initComponents() {

        pacienteComboBox = new JComboBox<>();
        consultaComboBox = new JComboBox<>();
        dataField = new JTextField();
        addButton = new JButton();
        backButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(new JLabel("Paciente:"), gbc);
        gbc.gridy++;
        add(pacienteComboBox, gbc);

        gbc.gridy++;
        add(new JLabel("Consulta:"), gbc);
        gbc.gridy++;
        add(consultaComboBox, gbc);

        gbc.gridy++;
        add(new JLabel("Data:"), gbc);
        gbc.gridy++;
        add(dataField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(backButton, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST;
        add(addButton, gbc);

        addButton.setText("Adicionar");
        addButton.addActionListener(evt -> addButtonActionPerformed());

        backButton.setText("Voltar");
        backButton.addActionListener(evt -> backButtonActionPerformed());

        pack();
    }

    //Modificação para catch o possivel erro de AgendaException
    private void addButtonActionPerformed() {
        Paciente paciente = (Paciente) pacienteComboBox.getSelectedItem();
        Consulta consulta = (Consulta) consultaComboBox.getSelectedItem();
        String dataStr = dataField.getText();

        if (paciente == null || consulta == null || dataStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        sdf.setLenient(false);
        Date data;
        try {
            data = sdf.parse(dataStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "A data deve estar no formato dd/MM/yyyy HH:mm!");
            return;
        }

        if (agenda != null) {
            agenda.setPaciente(paciente);
            agenda.setConsulta(consulta);
            agenda.setData(data);
            agendaDAO.update(agenda);
        } else {
            int id = agendaDAO.getUltimoId();
            try {
                Agenda newAgenda = new Agenda(id, dataStr, paciente, consulta);
                agendaDAO.insert(newAgenda);
            } catch (AgendaException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Agenda atualizada com sucesso!");
        backButtonActionPerformed();
    }
    private void backButtonActionPerformed() {
        this.dispose();
        new Home().setVisible(true);
    }

    private void updateComboBoxes() {
        List<Paciente> pacientes = pacienteDAO.selectAll();
        for (Paciente paciente : pacientes) {
            pacienteComboBox.addItem(paciente);
        }

        List<Consulta> consultas = consultaDAO.selectAll();
        for (Consulta consulta : consultas) {
            consultaComboBox.addItem(consulta);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new AddAgenda().setVisible(true));
    }
}