package Telas;

import Classes.Data.Persistencia;
import Classes.Paciente;
import Classes.DAO.PacienteDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DeletePaciente extends JFrame {

    private JTextField idField;
    private JButton deleteButton;
    private JButton backButton;
    private JList<Paciente> pacienteList;
    private PacienteDAO pacienteDAO;

    public DeletePaciente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        pacienteDAO = new PacienteDAO();
        updatePacienteList();
    }

    private void initComponents() {

        idField = new JTextField();
        deleteButton = new JButton();
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
        add(new JLabel("ID para deletar:"), gbc);
        gbc.gridy++;
        add(idField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(backButton, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST;
        add(deleteButton, gbc);

        deleteButton.setText("Deletar");
        deleteButton.addActionListener(evt -> deleteButtonActionPerformed());

        backButton.setText("Voltar");
        backButton.addActionListener(evt -> backButtonActionPerformed());

        pack();
    }

    private void deleteButtonActionPerformed() {
        String idStr = idField.getText();
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O ID deve ser um número!");
            return;
        }

        boolean deleted = pacienteDAO.delete(id);
        if (deleted) {
            JOptionPane.showMessageDialog(this, "Paciente deletado com sucesso!");
            backButtonActionPerformed();
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
        EventQueue.invokeLater(() -> new DeletePaciente().setVisible(true));
    }
}