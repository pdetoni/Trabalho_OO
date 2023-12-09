package Telas.Root;

import javax.swing.*;
import java.awt.*;

public class HomeROOT extends JFrame {

    private JMenuBar menuBar;
    private JMenu cadastrarMenu;
    private JMenu removerMenu;
    private JMenu editarMenu;
    private JMenuItem cadastrarConsultaItem;
    private JMenuItem cadastrarUsuarioItem;
    private JMenuItem removerConsultaItem;
    private JMenuItem removerUsuarioItem;
    private JMenuItem editarConsultaItem;
    private JMenuItem editarUsuarioItem;

    public HomeROOT() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
    }

    private void initComponents() {

        menuBar = new JMenuBar();
        cadastrarMenu = new JMenu("Cadastrar");
        removerMenu = new JMenu("Remover");
        editarMenu = new JMenu("Editar");
        cadastrarConsultaItem = new JMenuItem("Consulta");
        cadastrarUsuarioItem = new JMenuItem("Usuario");
        removerConsultaItem = new JMenuItem("Consulta");
        removerUsuarioItem = new JMenuItem("Usuario");
        editarConsultaItem = new JMenuItem("Consulta");
        editarUsuarioItem = new JMenuItem("Usuario");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cadastrarMenu.add(cadastrarConsultaItem);
        cadastrarMenu.add(cadastrarUsuarioItem);
        removerMenu.add(removerConsultaItem);
        removerMenu.add(removerUsuarioItem);
        editarMenu.add(editarConsultaItem);
        editarMenu.add(editarUsuarioItem);

        menuBar.add(cadastrarMenu);
        menuBar.add(removerMenu);
        menuBar.add(editarMenu);

        setJMenuBar(menuBar);

        cadastrarConsultaItem.addActionListener(evt -> cadastrarConsultaItemActionPerformed());
        cadastrarUsuarioItem.addActionListener(evt -> cadastrarUsuarioItemActionPerformed());
        removerConsultaItem.addActionListener(evt -> removerConsultaItemActionPerformed());
        removerUsuarioItem.addActionListener(evt -> removerUsuarioItemActionPerformed());
        editarConsultaItem.addActionListener(evt -> editarConsultaItemActionPerformed());
        editarUsuarioItem.addActionListener(evt -> editarUsuarioItemActionPerformed());

        pack();
    }

    private void cadastrarConsultaItemActionPerformed() {
        new AddConsulta().setVisible(true);
        this.dispose();
    }

    private void cadastrarUsuarioItemActionPerformed() {
        new AddUsuario().setVisible(true);
        this.dispose();
    }

    private void removerConsultaItemActionPerformed() {
//        new DeleteConsulta().setVisible(true);
        this.dispose();
    }

    private void removerUsuarioItemActionPerformed() {
//        new DeleteUsuario().setVisible(true);
        this.dispose();
    }

    private void editarConsultaItemActionPerformed() {
//        new EditConsulta().setVisible(true);
        this.dispose();
    }

    private void editarUsuarioItemActionPerformed() {
//        new EditUsuario().setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new HomeROOT().setVisible(true));
    }
}