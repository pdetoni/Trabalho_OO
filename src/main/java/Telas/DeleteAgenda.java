package Telas;

import Classes.Agenda;
import Classes.DAO.AgendaDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DeleteAgenda extends JFrame {

    private JComboBox<Agenda> agendaComboBox;
    private JButton deleteButton;
    private JButton backButton;
    private AgendaDAO agendaDAO;

    public DeleteAgenda() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        agendaDAO = new AgendaDAO();
        updateAgendaComboBox();
    }

    private void initComponents() {

        agendaComboBox = new JComboBox<>();
        deleteButton = new JButton();
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
        add(new JLabel("Agendas:"), gbc);
        gbc.gridy++;
        add(agendaComboBox, gbc);

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
        Agenda agenda = (Agenda) agendaComboBox.getSelectedItem();
        if (agenda == null) {
            JOptionPane.showMessageDialog(this, "Nenhuma agenda selecionada!");
            return;
        }

        boolean deleted = agendaDAO.delete(agenda.getId());
        if (deleted) {
            JOptionPane.showMessageDialog(this, "Agenda deletada com sucesso!");
            backButtonActionPerformed();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao deletar a agenda!");
        }
    }

    private void backButtonActionPerformed() {
        this.dispose();
        new Home().setVisible(true);
    }

    private void updateAgendaComboBox() {
        List<Agenda> agendas = agendaDAO.selectAll();
        DefaultComboBoxModel<Agenda> model = new DefaultComboBoxModel<>();
        for (Agenda agenda : agendas) {
            model.addElement(agenda);
        }
        agendaComboBox.setModel(model);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new DeleteAgenda().setVisible(true));
    }
}