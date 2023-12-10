package Telas;

import Classes.Consulta;
import Classes.DAO.ConsultaDAO;
import Classes.Data.Persistencia;
import Telas.Root.HomeROOT;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VisualizarConsulta extends javax.swing.JFrame {

    private ConsultaDAO consultaDAO;

    public VisualizarConsulta() {
        initComponents();
        this.setLocationRelativeTo(null);
        consultaDAO = new ConsultaDAO();
        loadConsultaTable();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        consultaTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        consultaTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "ID", "Tipo", "Médico Responsável", "CPF do Médico"
                }
        ));
        jScrollPane1.setViewportView(consultaTable);

        backButton.setText("Voltar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(backButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new HomeROOT().setVisible(true);
    }

    private void loadConsultaTable() {
        DefaultTableModel model = (DefaultTableModel) consultaTable.getModel();
        model.setRowCount(0);
        Persistencia persistencia = new Persistencia();
        List<Consulta> consultas = persistencia.lerArquivoConsulta("src/main/java/Classes/Data/consultas.json");
        for (Consulta consulta : consultas) {
            model.addRow(new Object[]{consulta.getId(), consulta.getTipo(), consulta.getMedicoResponsavel().getNome(), consulta.getMedicoResponsavel().getCpf()});
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarConsulta().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable consultaTable;
    private javax.swing.JButton backButton;
}