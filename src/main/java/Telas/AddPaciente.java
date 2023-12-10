package Telas;

import Classes.Data.Persistencia;
import Classes.Paciente;
import Classes.DAO.PacienteDAO;

import java.util.ArrayList;
import java.util.List;
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
    private PacienteDAO pacienteDAO;

    private Paciente paciente = null;

    public AddPaciente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        pacienteDAO = new PacienteDAO();
    }

    //Situação para edição de paciente existente em EditPaciente
    public AddPaciente(Paciente paciente) {
        this();
        this.paciente = paciente;
        nomeField.setText(paciente.getNome());
        cpfField.setText(paciente.getCpf());
        sexoField.setText(String.valueOf(paciente.getSexo()));
        idadeField.setText(String.valueOf(paciente.getIdade()));
        emailField.setText(paciente.getEmail());
        cepField.setText(paciente.getCep());
        enderecoField.setText(paciente.getEndereco());
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

        int idade;
        try { // Validação de idade, para que não seja inserido um valor negativo ou maior que 150 no campo, assumindo que o ser humano que viveu mais tempo foi 122 anos
            idade = Integer.parseInt(idadeStr);
            if (idade <= 0 || idade > 130) {
                JOptionPane.showMessageDialog(this, "A idade deve ser um número entre 0 e 150!");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "A idade deve ser um número!");
            return;
        }

        if (!email.contains("@")) { //Validação simples de email, para que seja inserido um email válido
            JOptionPane.showMessageDialog(this, "O email deve ser um formato válido!");
            return;
        }
        if (!cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {//Uso de expessão regular para validar o CPF inserido esta no formato correto
            JOptionPane.showMessageDialog(this, "O CPF deve estar no formato 000.000.000-00!");
            return;
        }
        if (pacienteDAO.cpfExiste(cpf)) {
            JOptionPane.showMessageDialog(this, "O CPF já está em uso!");
            return;
        }
        if (!cep.matches("^\\d{5}-\\d{3}$")) {//Uso de expessão regular para validar o CEP inserido esta no formato correto
            JOptionPane.showMessageDialog(this, "O CEP deve estar no formato 00000-000!");
            return;
        }

        if (paciente != null) {
            paciente.setNome(nome);
            paciente.setCpf(cpf);
            paciente.setSexo(sexo.charAt(0));
            paciente.setIdade(idade);
            paciente.setEmail(email);
            paciente.setCep(cep);
            paciente.setEndereco(endereco);
            pacienteDAO.update(paciente);
        } else {
            int id = pacienteDAO.getUltimoId();
            Paciente newPaciente = new Paciente(id, nome, cpf, sexo.charAt(0), idade, email, cep, endereco);
            Persistencia persistencia = new Persistencia();
            List<Paciente> pacientes = persistencia.lerArquivoPaciente("src/main/java/Classes/Data/pacientes.json");
            if (pacientes == null) {
                pacientes = new ArrayList<>();
            }
            pacientes.add(newPaciente);
            persistencia.escreverArquivoPaciente("src/main/java/Classes/Data/pacientes.json", pacientes);
        }

        JOptionPane.showMessageDialog(this, "Paciente atualizado com sucesso!");
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
