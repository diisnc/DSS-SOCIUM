package trabalho1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observer;
import java.util.Observable;
import javax.swing.table.DefaultTableModel;

public class Trabalho1UI extends javax.swing.JFrame implements Observer {
    
    // O controller - precisamos de ter uma refêrencia ao controlador
    // para lhe podermos enviar eventos a partir da UI
    private Trabalho1 controller;

    /**
     * Creates new form trabalho1UI
     */
    public Trabalho1UI(Trabalho1 controller) {
        
        this.controller = controller;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        memberContainerTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuNew = new javax.swing.JMenu();
        newMember = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SociUM");

        jScrollPane1.setName("memberContainer"); // NOI18N

        memberContainerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Número", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        memberContainerTable.setName("memberContainerTable"); // NOI18N
        memberContainerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberContainerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(memberContainerTable);
        if (memberContainerTable.getColumnModel().getColumnCount() > 0) {
            memberContainerTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            memberContainerTable.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        menuFile.setText("Ficheiro");

        menuNew.setText("Novo");

        newMember.setText("Membro");
        newMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMemberActionPerformed(evt);
            }
        });
        menuNew.add(newMember);

        menuFile.add(menuNew);

        jMenuItem1.setText("Guardar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuFile.add(jMenuItem1);

        jMenuBar1.add(menuFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMemberActionPerformed
        
        // Abrir diálogo de inserção membrária
        InsertMemberUI insertDialog = new InsertMemberUI(Trabalho1UI.this, this.controller);
        
        insertDialog.setVisible(true);
    }//GEN-LAST:event_newMemberActionPerformed

    private void memberContainerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberContainerTableMouseClicked
        int index = memberContainerTable.getSelectedRow();
        int i = 0;
        SociUM SelectedSocium = new SociUM();
      
        for (Map.Entry<String, SociUM> entry : this.controller.getMembers().entrySet()) {
            if (i == index) {
                SelectedSocium = entry.getValue();
                break;
            }
            else {
                i++;
                SelectedSocium = null;
            }
        }
        
        ChangeMemberUI insertDialog = new ChangeMemberUI(Trabalho1UI.this, true, SelectedSocium, controller);
        
        insertDialog.setVisible(true);
        
    }//GEN-LAST:event_memberContainerTableMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        IO io = new IO();
        io.WriteHashMap(controller.getMembers());
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void show(HashMap<String, SociUM> members) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Trabalho1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trabalho1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trabalho1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trabalho1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        this.setVisible(true);
        
        this.internalUpdate(members);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        // Este update tem a ver com a interface observer, como recebe dois argumentos apenas serve
        // de ponte para o update interno, que é usado também em outros casos (inicialização, por exemplo)
        this.internalUpdate(arg);
    }
    
    public void internalUpdate(Object members) {
        
        // Atualizar a listagem de membros
        
        HashMap<String, SociUM> membersMap = (HashMap<String, SociUM>) members;
        
        DefaultTableModel tableModel = (DefaultTableModel) memberContainerTable.getModel();
        
        tableModel.setRowCount(0); // Remover todas as entradas da table
        
        Iterator it = membersMap.entrySet().iterator();
        
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            
            SociUM member = (SociUM) pair.getValue();
            
            String[] data = new String[2];
            
            data[0] = member.getNumber();
            data[1] = member.getName();
            
            tableModel.addRow(data);
        }
        
        tableModel.fireTableDataChanged();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable memberContainerTable;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuNew;
    private javax.swing.JMenuItem newMember;
    // End of variables declaration//GEN-END:variables
}
