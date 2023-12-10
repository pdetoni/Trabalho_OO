package Telas.Root;

import Classes.DAO.Banco;
import Classes.Usuario;
import Classes.DAO.UsuarioDAO;
import Classes.Data.Persistencia;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DeleteUsuario extends JFrame {

    private JComboBox<Usuario> usuarioComboBox;
    private JButton deleteButton;
    private JButton backButton;
    private UsuarioDAO usuarioDAO;

    public DeleteUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        usuarioDAO = new UsuarioDAO();
        updateUsuarioComboBox();
    }

    private void initComponents() {

        usuarioComboBox = new JComboBox<>();
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
        add(new JLabel("Usuários:"), gbc);
        gbc.gridy++;
        add(usuarioComboBox, gbc);

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
        Usuario usuario = (Usuario) usuarioComboBox.getSelectedItem();
        if (usuario == null) {
            JOptionPane.showMessageDialog(this, "Nenhum usuário selecionado!");
            return;
        }

        boolean deleted = usuarioDAO.delete(usuario);
        if (deleted) {
            Persistencia persistencia = new Persistencia();
            persistencia.escreverArquivoUsuario("src/main/java/Classes/Data/usuarios.json", Banco.usuario);

            JOptionPane.showMessageDialog(this, "Usuário deletado com sucesso!");
            backButtonActionPerformed();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao deletar o usuário!");
        }
    }

    private void backButtonActionPerformed() {
        this.dispose();
        new HomeROOT().setVisible(true);
    }

    private void updateUsuarioComboBox() {
        List<Usuario> usuarios = usuarioDAO.selectAll();
        DefaultComboBoxModel<Usuario> model = new DefaultComboBoxModel<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getId() != 0) { // Não inclui o usuário root
                model.addElement(usuario);
            }
        }
        usuarioComboBox.setModel(model);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new DeleteUsuario().setVisible(true));
    }
}