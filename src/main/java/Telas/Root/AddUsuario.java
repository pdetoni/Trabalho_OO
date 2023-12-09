package Telas.Root;

import Classes.DAO.UsuarioDAO;
import Classes.Usuario;

import javax.swing.*;
import java.awt.*;

public class AddUsuario extends JFrame {

    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField sexoField;
    private JTextField idadeField;
    private JTextField emailField;
    private JTextField senhaField;
    private JTextField cargoField;
    private JButton addButton;
    private JButton backButton;
    private UsuarioDAO usuarioDAO;

    public AddUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        usuarioDAO = new UsuarioDAO();
    }

    private void initComponents() {

        nomeField = new JTextField();
        cpfField = new JTextField();
        sexoField = new JTextField();
        idadeField = new JTextField();
        emailField = new JTextField();
        senhaField = new JTextField();
        cargoField = new JTextField();
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
        add(new JLabel("Senha:"), gbc);
        gbc.gridy++;
        add(senhaField, gbc);

        gbc.gridy++;
        add(new JLabel("Cargo:"), gbc);
        gbc.gridy++;
        add(cargoField, gbc);

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
        String nome = nomeField.getText();
        String cpf = cpfField.getText();
        String sexo = sexoField.getText();
        String idadeStr = idadeField.getText();
        String email = emailField.getText();
        String senha = senhaField.getText();
        String cargo = cargoField.getText();

        if (nome.isEmpty() || cpf.isEmpty() || sexo.isEmpty() || idadeStr.isEmpty() || email.isEmpty() || senha.isEmpty() || cargo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!");
            return;
        }

        if (nome.equalsIgnoreCase("root")) {
            JOptionPane.showMessageDialog(this, "'root' é reservado do sistema e não pode ser modificado!");
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "A idade deve ser um número!");
            return;
        }

        int id = usuarioDAO.getUltimoId();
        Usuario usuario = new Usuario(id, nome, cpf, sexo.charAt(0), idade, email, senha, cargo);
        usuarioDAO.insert(usuario);

        JOptionPane.showMessageDialog(this, "Usuário adicionado com sucesso!");
        backButtonActionPerformed();
    }

    private void backButtonActionPerformed() {
        this.dispose();
        new HomeROOT().setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new AddUsuario().setVisible(true));
    }
}