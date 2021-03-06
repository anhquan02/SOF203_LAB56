/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.LuggerDAOImpl;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import entity.Lugger;
import dao.IDAO;

/**
 *
 * @author Mypc
 */
public class LuggerFrame extends javax.swing.JInternalFrame {

    private JDesktopPane desktopPane;
    private IDAO<Lugger> dao;
    private DefaultTableModel model;
    private int index;

    public IDAO<Lugger> getDao() {
        return dao;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public int getIndex() {
        return index;
    }

    /**
     * Creates new form LuggerFrame
     */
    public LuggerFrame(JDesktopPane desktopPane) {
        initComponents();
        model = (DefaultTableModel) tblLugger.getModel();
        this.desktopPane = desktopPane;
        dao = new LuggerDAOImpl();
        fillToTable();
        
    }
    // đổ dữ liệu lên table
    private void fillToTable() {
        model.setRowCount(0);
        for (Lugger lugger : dao.getList()) {
            model.addRow(new Object[]{lugger.getMaHL(), lugger.getTen(), 
                lugger.getTrongLuong(), lugger.getSoLuong(), 
                lugger.getGiaHienTai(), lugger.getColor()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLugger = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.blue);
        jLabel1.setText("Hành lý");

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblLugger.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HL", "Tên", "Trọng lượng", "Số lượng", "Giá hiện tại", "Màu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLugger.setRowHeight(25);
        tblLugger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLuggerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLugger);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(263, 263, 263)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnNew, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDelete, btnNew, btnUpdate});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        try {
            AddFrame frame = new AddFrame(this);
            desktopPane.add(frame);
            frame.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nút New");
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            int[] rows = tblLugger.getSelectedRows();
            if (rows.length == 0) {
                JOptionPane.showMessageDialog(this, "Chọn dòng");
                return;
            }
            index = rows[0];
            UpdateFrame frame = new UpdateFrame(this);
            desktopPane.add(frame);
            frame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nút Update");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
int[] rows;
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
             rows = tblLugger.getSelectedRows();
            if (rows.length == 0) {
                JOptionPane.showMessageDialog(this, "Chọn dòng");
                return;
            }
            int chon = JOptionPane.showConfirmDialog(this, "Delete", "Delete", 
                    JOptionPane.YES_NO_OPTION);
            if (chon == JOptionPane.YES_OPTION) {              
                for(int i = rows.length-1 ; i>=0 ;i--){
                    model.removeRow(rows[i]);
                    dao.delete(dao.getItem(rows[i]));                    
                }
            }
            JOptionPane.showMessageDialog(this, "Xoá thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nút Delete");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblLuggerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLuggerMouseClicked
        // TODO add your handling code here:
        try {
//            index = tblLugger.getSelectedRow();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi click table");
        }
    }//GEN-LAST:event_tblLuggerMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLugger;
    // End of variables declaration//GEN-END:variables
}
