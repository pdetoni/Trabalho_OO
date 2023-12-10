package Telas.Root;

import Classes.Consulta;
import Classes.DAO.ConsultaDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EditConsulta extends JFrame {

    private JComboBox<Consulta> consultaComboBox;
    private JButton editButton;
    private JButton backButton;
    private ConsultaDAO consultaDAO;

    public EditConsulta() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        consultaDAO = new ConsultaDAO();
        updateConsultaComboBox();
    }

    private void initComponents() {

        consultaComboBox = new JComboBox<>();
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
        add(new JLabel("Consultas:"), gbc);
        gbc.gridy++;
        add(consultaComboBox, gbc);

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
        Consulta consulta = (Consulta) consultaComboBox.getSelectedItem();
        if (consulta != null) {
            new AddConsulta(consulta).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma consulta selecionada!");
        }
    }

    private void backButtonActionPerformed() {
        this.dispose();
        new HomeROOT().setVisible(true);
    }

    private void updateConsultaComboBox() {
        List<Consulta> consultas = consultaDAO.selectAll();
        for (Consulta consulta : consultas) {
            consultaComboBox.addItem(consulta);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new EditConsulta().setVisible(true));
    }
}