/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Cliente;
import models.Offer;
import models.Product;
import servicios.OfertaServices;
import servicios.ProductServices;

/**
 *
 * @author juanc
 */
public class FormOfrecerOferta extends javax.swing.JFrame  implements Runnable{

    
    private Cliente client;
    private ProductServices objProductServices;
    private OfertaServices objOfertaServices;
    Thread hilo;
    
    
    /**
     * Creates new form FormRegistrarProducto
     */
    public FormOfrecerOferta(Cliente cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.objProductServices=new ProductServices();
        this.objOfertaServices=new OfertaServices();
        this.client=cliente;
        consultarSubastaActual();
        iniciarHilo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        JbtnOferta = new javax.swing.JButton();
        JlblOferta = new javax.swing.JLabel();
        JtxtOferta = new javax.swing.JTextField();
        JlblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblProducto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblListaDeOfertas = new javax.swing.JTable();
        JlblOfertasRealizadas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JbtnOferta.setBackground(new java.awt.Color(200, 200, 200));
        JbtnOferta.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        JbtnOferta.setText("Ofertar");
        JbtnOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnOfertaActionPerformed(evt);
            }
        });

        JlblOferta.setText("Suministre su oferta :");

        JlblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JlblTitulo.setText("Oferta");

        jTblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Estado", "Valor Inicial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTblProducto);

        jTblListaDeOfertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Cliente", "Oferta"
            }
        ));
        jScrollPane2.setViewportView(jTblListaDeOfertas);

        JlblOfertasRealizadas.setText("Ofertas Realizadas :");

        jLabel1.setText("Producto Actual En Subasta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JlblOfertasRealizadas)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(JlblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JlblOferta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtxtOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbtnOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(JlblTitulo)
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlblOferta)
                    .addComponent(JtxtOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(JlblOfertasRealizadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbtnOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnOfertaActionPerformed
        realizarOferta();
    }//GEN-LAST:event_JbtnOfertaActionPerformed
    private void consultarSubastaActual(){
        try{
            Product objProduct = this.objProductServices.consultarProductSubasta();
            Object matriz [][] = new Object [1][4];
            this.jTblProducto.setModel(new DefaultTableModel(
            matriz,
            new String[]{"Codigo", "Nombre", "Estado", "Valor"}
            ));

            this.jTblProducto.setValueAt(objProduct.getCode(), 0, 0);
            this.jTblProducto.setValueAt(objProduct.getName(), 0, 1);
            this.jTblProducto.setValueAt(objProduct.getState(), 0, 2);
            this.jTblProducto.setValueAt(objProduct.getInitValue(), 0, 3);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "No hay productos en la subasta.");
        }
        
        
    }
    private void realizarOferta(){
        try{
            Product subasta = this.objProductServices.consultarProductSubasta();
            List<Offer> lstOfertas = this.objOfertaServices.listarOfertas();
            System.out.println("porque: "+client.getUsername());
            long oferta = Long.parseLong(this.JtxtOferta.getText());
            long precioproducto = subasta.getInitValue();
            
            for (int i = 0; i < lstOfertas.size(); i++) {
                if(precioproducto<lstOfertas.get(i).getValue()){
                    System.out.println("precio adentro:"+lstOfertas.get(i).getValue());    
               precioproducto  = lstOfertas.get(i).getValue();
                }
            }
            
            if(oferta > precioproducto){
            Offer offer = new Offer(client,subasta,Long.parseLong(this.JtxtOferta.getText()));
            this.objOfertaServices.registrarOferta(offer);
            }else{
                JOptionPane.showMessageDialog(this, "La oferta debe ser mayor al precio original o anterior.");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "No hay productos en subasta.");
        }
         
    }
    
     public void iniciarHilo(){
        hilo=new Thread(this);
        hilo.start();
    }
     @Override
    public void run() {
        while (true) {
            List<Offer> lstOfertas = this.objOfertaServices.listarOfertas();
            Object matriz[][] = new Object[lstOfertas.size()][4];
            int j = 0;
            for (int i = 0; i < lstOfertas.size(); i++) {

                matriz[j][0] = lstOfertas.get(i).getProduct().getCode();
                matriz[j][1] = lstOfertas.get(i).getProduct().getName();
                matriz[j][2] = lstOfertas.get(i).getClient().getUsername();
                matriz[j][3] = lstOfertas.get(i).getValue();
                j++;
            }
            this.jTblListaDeOfertas.setModel(new DefaultTableModel(
                    matriz,
                new String [] {"Codigo","Nombre","Cliente","Oferta"}
            ));
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
            java.util.logging.Logger.getLogger(FormOfrecerOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormOfrecerOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormOfrecerOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormOfrecerOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormOfrecerOferta(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtnOferta;
    private javax.swing.JLabel JlblOferta;
    private javax.swing.JLabel JlblOfertasRealizadas;
    private javax.swing.JLabel JlblTitulo;
    private javax.swing.JTextField JtxtOferta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblListaDeOfertas;
    private javax.swing.JTable jTblProducto;
    // End of variables declaration//GEN-END:variables

    
}
