package Telas.Root;

import Classes.DAO.Banco;
import Classes.DAO.UsuarioDAO;
import Classes.Data.Persistencia;
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

    private Usuario usuario = null;

    public AddUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        usuarioDAO = new UsuarioDAO();
    }
    //Construtor para uso de edição de usuário existente em EditUsuario
    public AddUsuario(Usuario usuario) {
        this();
        this.usuario = usuario;
        nomeField.setText(usuario.getNome());
        cpfField.setText(usuario.getCpf());
        sexoField.setText(String.valueOf(usuario.getSexo()));
        idadeField.setText(String.valueOf(usuario.getIdade()));
        emailField.setText(usuario.getEmail());
        senhaField.setText(usuario.getSenha());
        cargoField.setText(usuario.getCargo());
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
        String sexo = sexoField.getText().trim().toUpperCase();
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

        if (!cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
            JOptionPane.showMessageDialog(this, "O CPF deve estar no formato 000.000.000-00!");
            return;
        }

        if (usuarioDAO.cpfExiste(cpf)) {
            JOptionPane.showMessageDialog(this, "O CPF já está em uso!");
            return;
        }

        if (!sexo.equals("M") && !sexo.equals("F")) {
            JOptionPane.showMessageDialog(this, "O sexo deve ser 'M' ou 'F'!");
            return;
        }

        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "O email deve ser um formato válido!");
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeStr);
            if (idade < 0 || idade > 150) {
                JOptionPane.showMessageDialog(this, "A idade deve ser um número entre 0 e 150!");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "A idade deve ser um número!");
            return;
        }

        if (usuario != null) {
            usuario.setNome(nome);
            usuario.setCpf(cpf);
            usuario.setSexo(sexo.charAt(0));
            usuario.setIdade(idade);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setCargo(cargo);
            usuarioDAO.update(usuario);
        } else {
            int id = usuarioDAO.getUltimoId();
            Usuario newUsuario = new Usuario(id, nome, cpf, sexo.charAt(0), idade, email, senha, cargo);
            usuarioDAO.insert(newUsuario);
        }

        Persistencia persistencia = new Persistencia();
        persistencia.escreverArquivoUsuario("src/main/java/Classes/Data/usuarios.json", Banco.usuario);

        JOptionPane.showMessageDialog(this, "Usuário atualizado com sucesso!");
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