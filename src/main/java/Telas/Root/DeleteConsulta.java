package Telas.Root;

import Classes.Consulta;
import Classes.DAO.Banco;
import Classes.DAO.ConsultaDAO;
import Classes.Data.Persistencia;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DeleteConsulta extends JFrame {

    private JComboBox<Consulta> consultaComboBox;
    private JButton deleteButton;
    private JButton backButton;
    private ConsultaDAO consultaDAO;

    public DeleteConsulta() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        consultaDAO = new ConsultaDAO();
        updateConsultaComboBox();
    }

    private void initComponents() {

        consultaComboBox = new JComboBox<>();
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
        add(deleteButton, gbc);

        deleteButton.setText("Deletar");
        deleteButton.addActionListener(evt -> deleteButtonActionPerformed());

        backButton.setText("Voltar");
        backButton.addActionListener(evt -> backButtonActionPerformed());

        pack();
    }

    private void deleteButtonActionPerformed() {
        Consulta consulta = (Consulta) consultaComboBox.getSelectedItem();
        if (consulta == null) {
            JOptionPane.showMessageDialog(this, "Nenhuma consulta selecionada!");
            return;
        }

        boolean deleted = consultaDAO.delete(consulta);
        if (deleted) {
            Persistencia persistencia = new Persistencia();
            persistencia.escreverArquivoConsulta("src/main/java/Classes/Data/consultas.json", Banco.Consulta);

            JOptionPane.showMessageDialog(this, "Consulta deletada com sucesso!");
            backButtonActionPerformed();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao deletar a consulta!");
        }
    }
    private void backButtonActionPerformed() {
        this.dispose();
        new HomeROOT().setVisible(true);
    }

    private void updateConsultaComboBox() {
        List<Consulta> consultas = consultaDAO.selectAll();
        DefaultComboBoxModel<Consulta> model = new DefaultComboBoxModel<>();
        for (Consulta consulta : consultas) {
            model.addElement(consulta);
        }
        consultaComboBox.setModel(model);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new DeleteConsulta().setVisible(true));
    }
}