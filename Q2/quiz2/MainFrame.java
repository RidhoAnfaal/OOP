/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quiz2;

/**
 *
 * @author MSI
 */
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class MainFrame extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    Connection cn = koneksi.KoneksiDatabase.Bukakoneksi();
    private DefaultTableModel tableModel;
    private ArrayList<Object[]> transactionDetails = new ArrayList<>();
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        setTitle("Main Frame");
        initComponents();
        setupTable();
    }
    
    private void setupTable() {
        tableModel = new DefaultTableModel(new String[]{"NO", "Item ID", "Item", "Qty", "SubTotal"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(tableModel);
    }

    private void refreshTableNumbering() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.setValueAt(i + 1, i, 0);
        }
    }

    private void addItemToTable(String itemId, String itemName, int qty, float subtotal) {
        tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, itemId, itemName, qty, subtotal});
        transactionDetails.add(new Object[]{itemId, itemName, qty, subtotal});
        refreshTableNumbering();
    }

    private void updateTotal() {
        float total = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            total += Float.parseFloat(tableModel.getValueAt(i, 4).toString());
        }
        jTextAreaTotBelanja.setText(String.valueOf(total));
    }
        
    private void saveTransaction() {
        try {
            cn.setAutoCommit(false); // Start transaction
            String insertSaleQuery = "INSERT INTO penjualan (tanggal, totalrevenue) VALUES (NOW(), ?)";
            PreparedStatement pst = cn.prepareStatement(insertSaleQuery, Statement.RETURN_GENERATED_KEYS);
            pst.setFloat(1, Float.parseFloat(jTextAreaTotBelanja.getText()));
            pst.executeUpdate();
            
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                int saleId = rs.getInt(1);

                String insertDetailQuery = "INSERT INTO penjualan_detail (id_penjualan, id_barang, qty, subtotal) VALUES (?, ?, ?, ?)";
                PreparedStatement detailPst = cn.prepareStatement(insertDetailQuery);

                for (Object[] detail : transactionDetails) {
                    detailPst.setInt(1, saleId);
                    detailPst.setString(2, detail[0].toString());
                    detailPst.setInt(3, Integer.parseInt(detail[2].toString()));
                    detailPst.setFloat(4, Float.parseFloat(detail[3].toString()));
                    detailPst.addBatch();
                }

                detailPst.executeBatch();
            }
            cn.commit();
            JOptionPane.showMessageDialog(this, "Transaction saved!");
            clearTransaction();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Error saving transaction: " + e.getMessage());
        }
    }
    
    private void clearTransaction() {
        tableModel.setRowCount(0);
        transactionDetails.clear();
        
        jTextFieldItem.setText("");
        jTextFieldQty.setText("");
        
        jTextAreaTotBelanja.setText("");
        jTextArea1.setText("");
        jTextAreaTotal.setText("");
        
    }
        
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonItem = new javax.swing.JButton();
        jButtonKategori = new javax.swing.JButton();
        jButtonRevenue = new javax.swing.JButton();
        jLabelPenjualan = new javax.swing.JLabel();
        jLabelItem = new javax.swing.JLabel();
        jTextFieldItem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelQty = new javax.swing.JLabel();
        jTextFieldQty = new javax.swing.JTextField();
        jLabelTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaTotal = new javax.swing.JTextArea();
        jButtonTambahItem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelTotBelanja = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaTotBelanja = new javax.swing.JTextArea();
        jButtonBayar = new javax.swing.JButton();
        jButtonBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonItem.setText("Items");
        jButtonItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonItemActionPerformed(evt);
            }
        });

        jButtonKategori.setText("Categories");
        jButtonKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKategoriActionPerformed(evt);
            }
        });

        jButtonRevenue.setText("Revenue");
        jButtonRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRevenueActionPerformed(evt);
            }
        });

        jLabelPenjualan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPenjualan.setText("Sales");
        jLabelPenjualan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelPenjualan.setIconTextGap(77);
        jLabelPenjualan.setMaximumSize(new java.awt.Dimension(70, 16));
        jLabelPenjualan.setPreferredSize(new java.awt.Dimension(27, 16));

        jLabelItem.setText("Item :");

        jTextFieldItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldItemActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabelQty.setText("Qty :");

        jTextFieldQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtyActionPerformed(evt);
            }
        });

        jLabelTotal.setText("Total :");

        jTextAreaTotal.setColumns(20);
        jTextAreaTotal.setRows(5);
        jScrollPane2.setViewportView(jTextAreaTotal);

        jButtonTambahItem.setText("Add Items");
        jButtonTambahItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahItemActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NO", "Item ID", "Item", "Qty", "SubTotal"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(jTable1);

        jLabelTotBelanja.setText("Total Shopping :");

        jTextAreaTotBelanja.setColumns(20);
        jTextAreaTotBelanja.setRows(5);
        jScrollPane4.setViewportView(jTextAreaTotBelanja);

        jButtonBayar.setText("Pay");
        jButtonBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBayarActionPerformed(evt);
            }
        });

        jButtonBatal.setText("Cancel");
        jButtonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonKategori)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRevenue)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabelQty)
                                        .addGap(19, 19, 19)
                                        .addComponent(jTextFieldQty, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabelItem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldItem, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelTotal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                            .addComponent(jButtonTambahItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabelTotBelanja)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4))))
                            .addComponent(jLabelPenjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonItem)
                    .addComponent(jButtonKategori)
                    .addComponent(jButtonRevenue))
                .addGap(14, 14, 14)
                .addComponent(jLabelPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelItem))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldQty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelQty))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabelTotal)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonTambahItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelTotBelanja))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTambahItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahItemActionPerformed
        // TODO add your handling code here:
        try {
            String itemId = jTextFieldItem.getText();
            int qty = Integer.parseInt(jTextFieldQty.getText());

            // Fetch item details from the database
            String query = "SELECT nama_barang, harga_barang FROM stock WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, itemId);
            rs = pst.executeQuery();

            if (rs.next()) {
                String itemName = rs.getString("nama_barang");
                float price = rs.getFloat("harga_barang");
                float subtotal = qty * price;

                addItemToTable(itemId, itemName, qty, subtotal);
                updateTotal();
            } else {
                JOptionPane.showMessageDialog(this, "Item not found");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid quantity!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching item details: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonTambahItemActionPerformed

    private void jTextFieldItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldItemActionPerformed
        // TODO add your handling code here:
        String itemId = jTextFieldItem.getText();
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT nama_barang, ukuran, harga_barang FROM stock WHERE id = " + itemId);

            if (rs.next()) {
                String itemName = rs.getString("nama_barang");
                String itemSize = rs.getString("ukuran");
                double itemPrice = rs.getDouble("harga_barang");

                String itemDetails = "Item Name : " + itemName + "\n" + 
                                     "Size : " + itemSize + "\n" + 
                                     "Rp. " + itemPrice;
                jTextArea1.setText(itemDetails);
            } else {
                jTextArea1.setText("Item not found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching item details: " + e.getMessage());
        }
    }//GEN-LAST:event_jTextFieldItemActionPerformed

    private void jTextFieldQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtyActionPerformed
        // TODO add your handling code here:
        try {
            int quantity = Integer.parseInt(jTextFieldQty.getText());
            String itemId = jTextFieldItem.getText();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT harga_barang FROM stock WHERE id = " + itemId);
            if (rs.next()) {
                float price = rs.getFloat("harga_barang");
                jTextAreaTotal.setText(String.valueOf(quantity * price));
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error calculating total: " + e.getMessage());
        }
    }//GEN-LAST:event_jTextFieldQtyActionPerformed

    private void jButtonBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBayarActionPerformed
        // TODO add your handling code here:
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No items in the transaction.");
            return;
        }
        saveTransaction();
    }//GEN-LAST:event_jButtonBayarActionPerformed

    private void openItemFrame() {
        ItemFrame itemFrame = new ItemFrame();
        itemFrame.setVisible(true);
    }

    private void openKategoriFrame() {
        KategoriFrame categoryFrame = new KategoriFrame();
        categoryFrame.setVisible(true);
    }
    
    private void openRevenueFrame() {
        RevenueFrame revFrame = new RevenueFrame();
        revFrame.setVisible(true);
    }
    
    private void jButtonItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonItemActionPerformed
        // TODO add your handling code here:
        openItemFrame();
    }//GEN-LAST:event_jButtonItemActionPerformed

    private void jButtonKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKategoriActionPerformed
        // TODO add your handling code here:
        openKategoriFrame();
    }//GEN-LAST:event_jButtonKategoriActionPerformed

    private void jButtonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBatalActionPerformed
        // TODO add your handling code here:
        clearTransaction();

    }//GEN-LAST:event_jButtonBatalActionPerformed

    private void jButtonRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRevenueActionPerformed
        // TODO add your handling code here:
        openRevenueFrame();
    }//GEN-LAST:event_jButtonRevenueActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBatal;
    private javax.swing.JButton jButtonBayar;
    private javax.swing.JButton jButtonItem;
    private javax.swing.JButton jButtonKategori;
    private javax.swing.JButton jButtonRevenue;
    private javax.swing.JButton jButtonTambahItem;
    private javax.swing.JLabel jLabelItem;
    private javax.swing.JLabel jLabelPenjualan;
    private javax.swing.JLabel jLabelQty;
    private javax.swing.JLabel jLabelTotBelanja;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaTotBelanja;
    private javax.swing.JTextArea jTextAreaTotal;
    private javax.swing.JTextField jTextFieldItem;
    private javax.swing.JTextField jTextFieldQty;
    // End of variables declaration//GEN-END:variables
}