package Telas;

import Classes.Data.Persistencia;
import Classes.Paciente;
import Classes.DAO.PacienteDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EditPaciente extends JFrame {

    private JTextField idField;
    private JButton editButton;
    private JButton backButton;
    private JList<Paciente> pacienteList;
    private PacienteDAO pacienteDAO;

    public EditPaciente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        pacienteDAO = new PacienteDAO();
        updatePacienteList();
    }

    private void initComponents() {

        idField = new JTextField();
        editButton = new JButton();
        backButton = new JButton();
        pacienteList = new JList<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(new JLabel("Pacientes:"), gbc);
        gbc.gridy++;
        add(new JScrollPane(pacienteList), gbc);

        gbc.gridy++;
        add(new JLabel("ID para editar:"), gbc);
        gbc.gridy++;
        add(idField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(backButton, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST;
        add(editButton, gbc);

        editButton.setText("Editar");
        editButton.addActionListener(evt -> editButtonActionPerformed());

        backButton.setText("Voltar");
        backButton.addActionListener(evt -> backButtonActionPerformed());

        pack();
    }

    private void editButtonActionPerformed() {
        String idStr = idField.getText();
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O ID deve ser um número!");
            return;
        }

        Paciente paciente = pacienteDAO.getPaciente(id);
        if (paciente != null) {
            new AddPaciente(paciente).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Paciente com ID " + id + " não encontrado!");
        }
    }

    private void backButtonActionPerformed() {
        this.dispose();
        new Home().setVisible(true);
    }

    private void updatePacienteList() {
        List<Paciente> pacientes = pacienteDAO.selectAll();
        pacienteList.setListData(pacientes.toArray(new Paciente[0]));
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new EditPaciente().setVisible(true));
    }
}