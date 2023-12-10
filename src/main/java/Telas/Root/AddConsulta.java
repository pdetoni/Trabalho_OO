package Telas.Root;

import Classes.Consulta;
import Classes.DAO.Banco;
import Classes.DAO.ConsultaDAO;
import Classes.Medico;
import Classes.Data.Persistencia;

import javax.swing.*;
import java.awt.*;

public class AddConsulta extends JFrame {

    private JTextField tipoField;
    private JTextField medicoNomeField;
    private JTextField medicoCpfField;
    private JButton addButton;
    private JButton backButton;
    private ConsultaDAO consultaDAO;

    private Consulta consulta = null;

    public AddConsulta() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        consultaDAO = new ConsultaDAO();
    }

    //Construtor para uso de edição de consulta existente em EditConsulta
    public AddConsulta(Consulta consulta) {
        this();
        this.consulta = consulta;
        tipoField.setText(consulta.getTipo());
        medicoNomeField.setText(consulta.getMedicoResponsavel().getNome());
        medicoCpfField.setText(consulta.getMedicoResponsavel().getCpf());
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
        add(new JLabel("Tipo (Dentista, Oftalmologista...):"), gbc);
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

        if (!medicoCpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
            JOptionPane.showMessageDialog(this, "O CPF do médico deve estar no formato 000.000.000-00!");
            return;
        }

        if (consultaDAO.cpfMedicoExiste(medicoCpf)) {
            JOptionPane.showMessageDialog(this, "O CPF do médico já está em uso!");
            return;
        }

        Medico medico = new Medico(medicoNome, medicoCpf);
        if (consulta != null) {
            consulta.setTipo(tipo);
            consulta.setMedicoResponsavel(medico);
            consultaDAO.update(consulta);
        } else {
            int id = consultaDAO.getUltimoId();
            Consulta newConsulta = new Consulta(id, tipo, medico);
            consultaDAO.insert(newConsulta);
        }

        Persistencia persistencia = new Persistencia();
        persistencia.escreverArquivoConsulta("src/main/java/Classes/Data/consultas.json", Banco.Consulta);

        JOptionPane.showMessageDialog(this, "Consulta atualizada com sucesso!");
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