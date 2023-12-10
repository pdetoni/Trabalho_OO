/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Telas;

import Classes.Agenda;
import Classes.DAO.AgendaDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EditAgenda extends JFrame {

    private JComboBox<Agenda> agendaComboBox;
    private JButton editButton;
    private JButton backButton;
    private AgendaDAO agendaDAO;

    public EditAgenda() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        agendaDAO = new AgendaDAO();
        updateAgendaComboBox();
    }

    private void initComponents() {

        agendaComboBox = new JComboBox<>();
        editButton = new JButton();
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
        add(editButton, gbc);

        editButton.setText("Editar");
        editButton.addActionListener(evt -> editButtonActionPerformed());

        backButton.setText("Voltar");
        backButton.addActionListener(evt -> backButtonActionPerformed());

        pack();
    }

    private void editButtonActionPerformed() {
        Agenda agenda = (Agenda) agendaComboBox.getSelectedItem();
        if (agenda != null) {
            new AddAgenda(agenda).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma agenda selecionada!");
        }
    }

    private void backButtonActionPerformed() {
        this.dispose();
        new Home().setVisible(true);
    }

    private void updateAgendaComboBox() {
        List<Agenda> agendas = agendaDAO.selectAll();
        for (Agenda agenda : agendas) {
            agendaComboBox.addItem(agenda);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new EditAgenda().setVisible(true));
    }
}