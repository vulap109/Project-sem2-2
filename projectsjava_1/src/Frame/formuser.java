/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Util.ketnoi;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class formuser extends javax.swing.JDialog {

    /**
     * Creates new form formuser
     */
    public formuser() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public formuser(JFrame master) {
        super(master);
        initComponents();
        setModalityType(ModalityType.APPLICATION_MODAL);
        this.setLocationRelativeTo(master);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);        
        revalidate();
    }

    public void getdata(String sql) {
        try {
            Vector data = null;
            //tblmodel.setRowCount(0);
            ketnoi kn = new ketnoi();
            ResultSet rs = kn.TruyVan(sql);
            while (rs.next()) {
                data = new Vector();
                String ten = rs.getString("taikhoan");
                String gt = rs.getString("gioitinh");
                Double sdt = rs.getDouble("sdt");

                txtareu.setText("\t\t" + ten);
                txtareu.append("\n\nGiới Tính: \t" + gt);
                txtareu.append("\n\nSDT:\t " + sdt);
                txtareu.append("\n\n==============================================\n");

            }
            //tblsp.setModel(tblmodel);
        } catch (Exception e) {
            System.out.println("loi lay du lieu;" + e);
        }
    }

    //        =========================================================================================
//        TextArea.setText(TextArea.getText() + "Cafe Management System");
//        TextArea.setText(TextArea.getText() + "\nMã hóa đơn: " + ref);
//        TextArea.setText(TextArea.getText() + "\n==============================================\t\t");
//        TextArea.append("\nLatte:\t\t\t" + drink[0]);
//        TextArea.append("\nIced Latte:\t\t\t" + drink[1]);
//        TextArea.append("\nEspresso:\t\t\t" + drink[2]);
//        TextArea.append("\nCappucchino:\t\t\t" + drink[3]);
//        TextArea.append("\nIced Cappucchino:\t\t" + drink[4]);
//        TextArea.setText(TextArea.getText() + "\n==============================================\t\t");
//        TextArea.append("\nCoffee Cake:\t\t\t" + cake[0]);
//        TextArea.append("\nMatcha Cake:\t\t\t" + cake[1]);
//        TextArea.append("\nBlack Forest Cake:\t\t" + cake[2]);
//        TextArea.append("\nXiaoZhan Chocolate Cake:\t\t" + cake[3]);
//        TextArea.append("\nSuper Nha Trang Cake:\t\t" + cake[4]);
//        TextArea.setText(TextArea.getText() + "\n==============================================\t\t");
//        TextArea.setText(TextArea.getText() + "\n Thuế:\t\t\t" + jlblTax.getText());
//        TextArea.setText(TextArea.getText() + "\n Thành tiền:\t\t\t" + jlblTotal.getText());
//        TextArea.setText(TextArea.getText() + "\n==============================================\t\t");
//        TextArea.setText(TextArea.getText() + "\n Ngày giao dịch:\t\t\t" + Tdate.format(timer.getTime()));
//        TextArea.setText(TextArea.getText() + "\n Giờ giao dịch:\t\t\t" + tTime.format(timer.getTime()));
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareu = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Thông tin người dùng");

        txtareu.setColumns(20);
        txtareu.setRows(5);
        jScrollPane1.setViewportView(txtareu);

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(jButton1))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        String sql = "select * from username where taikhoan = '" + loginForm.txtuser.getText() + "'";
        getdata(sql);


    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(formuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formuser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtareu;
    // End of variables declaration//GEN-END:variables
}