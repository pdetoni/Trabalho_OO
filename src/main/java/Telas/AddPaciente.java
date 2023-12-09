package Telas;

import Classes.Data.Persistencia;
import Classes.Paciente;
import Classes.DAO.PacienteDAO;

import javax.swing.*;
import java.awt.*;

public class AddPaciente extends JFrame {

    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField sexoField;
    private JTextField idadeField;
    private JTextField emailField;
    private JTextField cepField;
    private JTextField enderecoField;
    private JButton avancarButton;
    private JButton voltarButton;

    public AddPaciente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
    }

    private void initComponents() {

        nomeField = new JTextField();
        cpfField = new JTextField();
        sexoField = new JTextField();
        idadeField = new JTextField();
        emailField = new JTextField();
        cepField = new JTextField();
        enderecoField = new JTextField();
        avancarButton = new JButton();
        voltarButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(new JLabel("Nome:"), gbc);
        gbc.gridy++;
        add(nomeField, gbc);

        gbc.gridy++;
        add(new JLabel("CPF:"), gbc);
        gbc.gridy++;
        add(cpfField, gbc);

        gbc.gridy++;
        add(new JLabel("Sexo:"), gbc);
        gbc.gridy++;
        add(sexoField, gbc);

        gbc.gridy++;
        add(new JLabel("Idade:"), gbc);
        gbc.gridy++;
        add(idadeField, gbc);

        gbc.gridy++;
        add(new JLabel("Email:"), gbc);
        gbc.gridy++;
        add(emailField, gbc);

        gbc.gridy++;
        add(new JLabel("CEP:"), gbc);
        gbc.gridy++;
        add(cepField, gbc);

        gbc.gridy++;
        add(new JLabel("Endereço:"), gbc);
        gbc.gridy++;
        add(enderecoField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(voltarButton, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST;
        add(avancarButton, gbc);

        avancarButton.setText("Avançar");
        avancarButton.addActionListener(evt -> avancarButtonActionPerformed());

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(evt -> voltarButtonActionPerformed());

        pack();
    }

    private void avancarButtonActionPerformed() {
        String nome = nomeField.getText();
        String cpf = cpfField.getText();
        String sexo = sexoField.getText().trim().toUpperCase();
        String idadeStr = idadeField.getText();
        String email = emailField.getText();
        String cep = cepField.getText();
        String endereco = enderecoField.getText();

        if (nome.isEmpty() || cpf.isEmpty() || sexo.isEmpty() || idadeStr.isEmpty() || email.isEmpty() || cep.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!");
            return;
        }

        if (!sexo.equals("M") && !sexo.equals("F")) {
            JOptionPane.showMessageDialog(this, "O sexo deve ser 'M' ou 'F'!");
            return;
        }

        int idade = Integer.parseInt(idadeStr);
        Paciente paciente = new Paciente(0, nome, cpf, sexo.charAt(0), idade, email, cep, endereco);
        Persistencia persistencia = new Persistencia();
        persistencia.escreverArquivoPaciente("src/main/java/Classes/Data/pacientes.json", paciente);

        JOptionPane.showMessageDialog(this, "Paciente inserido com sucesso!");
        voltarButtonActionPerformed();
    }
    private void voltarButtonActionPerformed() {
        this.dispose();
        new Home().setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new AddPaciente().setVisible(true));
    }
}