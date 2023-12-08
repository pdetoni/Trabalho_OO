package Telas;

import Classes.DAO.PacienteDAO;
import Classes.Paciente;
import javax.swing.table.DefaultTableModel;

public class VisualizarPacientes extends javax.swing.JFrame {

    private PacienteDAO pacienteDAO;

    public VisualizarPacientes() {
        initComponents();
        pacienteDAO = new PacienteDAO();
        loadClientTable();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clientTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "ID", "Nome", "Email", "Endereço"
                }
        ));
        jScrollPane1.setViewportView(clientTable);

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

    private void loadClientTable() {
        DefaultTableModel model = (DefaultTableModel) clientTable.getModel();
        model.setRowCount(0); // Clear the table
        for (Paciente paciente : pacienteDAO.selectAll()) {
            model.addRow(new Object[]{paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getEndereco()});
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarPacientes().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable clientTable;
}