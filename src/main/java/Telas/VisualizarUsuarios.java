package Telas;

import Classes.DAO.UsuarioDAO;
import Classes.Usuario;
import javax.swing.table.DefaultTableModel;

public class VisualizarUsuarios extends javax.swing.JFrame {

    private UsuarioDAO usuarioDAO;

    public VisualizarUsuarios() {
        initComponents();
        usuarioDAO = new UsuarioDAO();
        loadUserTable();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "ID", "Nome", "Email"
                }
        ));
        jScrollPane1.setViewportView(userTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void loadUserTable() {
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        model.setRowCount(0); // Clear the table
        for (Usuario usuario : usuarioDAO.selectAll()) {
            model.addRow(new Object[]{usuario.getId(), usuario.getNome(), usuario.getEmail()});
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarUsuarios().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable userTable;
}