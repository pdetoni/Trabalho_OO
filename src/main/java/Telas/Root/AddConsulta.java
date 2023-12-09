package Telas.Root;

import Classes.Consulta;
import Classes.DAO.ConsultaDAO;
import Classes.Medico;

import javax.swing.*;
import java.awt.*;

public class AddConsulta extends JFrame {

    private JTextField tipoField;
    private JTextField medicoNomeField;
    private JTextField medicoCpfField;
    private JButton addButton;
    private JButton backButton;
    private ConsultaDAO consultaDAO;

    public AddConsulta() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        consultaDAO = new ConsultaDAO();
    }

    private void initComponents() {

        tipoField = new JTextField();
        medicoNomeField = new JTextField();
        medicoCpfField = new JTextField();
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
        add(new JLabel("Tipo:"), gbc);
        gbc.gridy++;
        add(tipoField, gbc);

        gbc.gridy++;
        add(new JLabel("Nome do Médico:"), gbc);
        gbc.gridy++;
        add(medicoNomeField, gbc);

        gbc.gridy++;
        add(new JLabel("CPF do Médico:"), gbc);
        gbc.gridy++;
        add(medicoCpfField, gbc);

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

    private void addButtonActionPerformed() {
        String tipo = tipoField.getText();
        String medicoNome = medicoNomeField.getText();
        String medicoCpf = medicoCpfField.getText();

        if (tipo.isEmpty() || medicoNome.isEmpty() || medicoCpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!");
            return;
        }

        Medico medico = new Medico(medicoNome, medicoCpf);
        int id = consultaDAO.getUltimoId();
        Consulta consulta = new Consulta(id, tipo, medico);
        consultaDAO.insert(consulta);

        JOptionPane.showMessageDialog(this, "Consulta adicionada com sucesso!");
        backButtonActionPerformed();
    }

    private void backButtonActionPerformed() {
        this.dispose();
        new HomeROOT().setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new AddConsulta().setVisible(true));
    }
}