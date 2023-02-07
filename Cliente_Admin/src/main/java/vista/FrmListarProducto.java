/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Product;
import models.State;
import servicios.ProductServices;

/**
 *
 * @author Personal
 */
public class FrmListarProducto extends javax.swing.JFrame {
    
    private ProductServices objProductService = new ProductServices();
    /**
     * Creates new form FrmListarProducto
     */
    public FrmListarProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarTablaProductosPendientes();
    }
    
 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonProductoEnSubasta = new javax.swing.JButton();
        jButtonProductosPendientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Valor Inicial", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTableProducts);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Listado De Productos");

        jButtonProductoEnSubasta.setText("Producto En Subasta");
        jButtonProductoEnSubasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductoEnSubastaActionPerformed(evt);
            }
        });

        jButtonProductosPendientes.setText("Productos Pendientes");
        jButtonProductosPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductosPendientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButtonProductoEnSubasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonProductosPendientes)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonProductosPendientes)
                    .addComponent(jButtonProductoEnSubasta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProductoEnSubastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductoEnSubastaActionPerformed
        /*
        for (int i = 0; i < this.jTableProducts.getRowCount(); i++) {
             this.jTableProducts.remove(i);
            i-=1;
        }
        */
        llenarTablaProductoEnSubasta();
    }//GEN-LAST:event_jButtonProductoEnSubastaActionPerformed

    private void jButtonProductosPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductosPendientesActionPerformed
        /*
        for (int i = 0; i < this.jTableProducts.getRowCount(); i++) {
             this.jTableProducts.remove(i);
            i-=1;
        }
        */
        llenarTablaProductosPendientes();
    }//GEN-LAST:event_jButtonProductosPendientesActionPerformed
    
    private void llenarTablaProductosPendientes(){
        List<Product> lstProducts = objProductService.listarProducts();
        Object matriz [][] = new Object [lstProducts.size()][5];
        int j=0;
	for(int i=0;i<lstProducts.size();i++) {
            if(lstProducts.get(i).getState().toString().equals("Pendiente")){
		matriz [j][0] =  lstProducts.get(i).getCode();
		matriz [j][1] = lstProducts.get(i).getName();
		matriz [j][2] = lstProducts.get(i).getState();
		matriz [j][3] = lstProducts.get(i).getinitValue();
                j++;
            }
        }
        this.jTableProducts.setModel(new DefaultTableModel(
				matriz,
            new String [] {"Codigo","Nombre","Estado","Valor"}
	));
        
                /*
        List<Product> lstProducts = objProductService.listarProducts();
        
        for (int i = 0; i < lstProducts.size(); i++) {
            if(lstProducts.get(i).getState().equals(State.En_Subasta)){
                lstProducts.remove(i);
            }
        }
        
        for (int i = 0; i < lstProducts.size(); i++) {
            this.jTableProducts.setValueAt(lstProducts.get(i).getCode(), i,0);
            this.jTableProducts.setValueAt(lstProducts.get(i).getName(), i,1);
            this.jTableProducts.setValueAt(lstProducts.get(i).getinitValue(), i,2);
            this.jTableProducts.setValueAt(lstProducts.get(i).getState(), i,3);
        }
        */
    }
    
    private void llenarTablaProductoEnSubasta(){
        List<Product> lstProducts = objProductService.listarProducts();
        Object matriz [][] = new Object [lstProducts.size()][5];
        int j=0;
	for(int i=0;i<lstProducts.size();i++) {
            if(lstProducts.get(i).getState().toString().equals("En_Subasta")){		
                matriz [j][0] =  lstProducts.get(i).getCode();
		matriz [j][1] = lstProducts.get(i).getName();
		matriz [j][2] = lstProducts.get(i).getState();
		matriz [j][3] = lstProducts.get(i).getinitValue();
                j++;
            }
        }
        this.jTableProducts.setModel(new DefaultTableModel(
				matriz,
            new String [] {"Codigo","Nombre","Estado","Valor"}
	));
        /*
        List<Product> lstProducts = objProductService.listarProducts();
        Product objProductEnSubasta = new Product();
        for (int i = 0; i < lstProducts.size(); i++) {
            if(lstProducts.get(i).getState().equals(State.En_Subasta)){
                objProductEnSubasta=lstProducts.get(i);
                this.jTableProducts.setValueAt(objProductEnSubasta.getCode(), i,0);
                this.jTableProducts.setValueAt(objProductEnSubasta.getName(), i,1);
                this.jTableProducts.setValueAt(objProductEnSubasta.getinitValue(), i,2);
                this.jTableProducts.setValueAt(objProductEnSubasta.getState(), i,3);
            }
        }
        */
    }
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
            java.util.logging.Logger.getLogger(FrmListarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonProductoEnSubasta;
    private javax.swing.JButton jButtonProductosPendientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    // End of variables declaration//GEN-END:variables
}
