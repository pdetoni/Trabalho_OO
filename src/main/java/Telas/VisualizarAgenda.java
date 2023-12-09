package Telas;

import Classes.Agenda;
import Classes.DAO.AgendaDAO;
import Classes.Data.Persistencia;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VisualizarAgenda extends javax.swing.JFrame {

    private AgendaDAO agendaDAO;

    public VisualizarAgenda() {
        initComponents();
        this.setLocationRelativeTo(null);
        agendaDAO = new AgendaDAO();
        loadAgendaTable();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        agendaTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        agendaTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "ID", "Data", "Paciente", "Consulta"
                }
        ));
        jScrollPane1.setViewportView(agendaTable);

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
        new Home().setVisible(true);
    }

    private void loadAgendaTable() {
        DefaultTableModel model = (DefaultTableModel) agendaTable.getModel();
        model.setRowCount(0);
        Persistencia persistencia = new Persistencia();
        List<Agenda> agendas = persistencia.lerArquivoAgenda("src/main/java/Classes/Data/agendas.json");
        for (Agenda agenda : agendas) {
            model.addRow(new Object[]{agenda.getId(), agenda.getData(), agenda.getPaciente().getNome(), agenda.getConsulta().getTipo()});
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarAgenda().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable agendaTable;
    private javax.swing.JButton backButton;
}