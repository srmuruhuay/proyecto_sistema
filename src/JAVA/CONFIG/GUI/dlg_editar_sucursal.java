package JAVA.CONFIG.GUI;

import JAVA.ANCEST.IMAGES.IMAGES_ruta_ancestro;
import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_sucursal;
import JAVA.CONFIG.LOGICA.evt_datos_sucursal;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class dlg_editar_sucursal extends javax.swing.JDialog {

    pnl_datos_sucursal lo_pnl_datos_sucursal = new pnl_datos_sucursal();
    evt_datos_sucursal lo_evt_datos_sucursal = new evt_datos_sucursal();
    BEAN_sucursal lo_bean_sucursal = new BEAN_sucursal();
    ResultSet lq_rs;
    String ls_codigo;

    public dlg_editar_sucursal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_datos_sucursal.setBounds(10, 10, 450, 350);
        this.add(lo_pnl_datos_sucursal);

        ls_codigo = gs_parametros[0];
        lo_pnl_datos_sucursal.TXT_codigo.setText(gs_parametros[0]);
        lo_pnl_datos_sucursal.TXT_nombre.setText(gs_parametros[1]);
        lo_pnl_datos_sucursal.TXT_direccion.setText(gs_parametros[2]);
        lo_pnl_datos_sucursal.CBX_estado.setSelectedIndex(Integer.parseInt(gs_parametros[3]));
        lo_pnl_datos_sucursal.TXT_ubigeo.setText(gs_parametros[4]);
        lo_pnl_datos_sucursal.TXT_descripcion.setText(gs_parametros[5]);
        lo_pnl_datos_sucursal.TXT_nota.setText(gs_parametros[6]);

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";
        gs_parametros[3] = "";
        gs_parametros[4] = "";
        gs_parametros[5] = "";
        gs_parametros[6] = "";

        lo_evt_datos_sucursal.activa_campos(0, lo_pnl_datos_sucursal, true);
        lo_evt_datos_sucursal.evento_press(lo_pnl_datos_sucursal, KeyEvnt);
    }

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_datos_sucursal.TXT_ubigeo) {
                    go_activa_buscador.busq_ubigeo(lo_pnl_datos_sucursal.TXT_ubigeo, lo_pnl_datos_sucursal.TXT_descripcion);
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_datos_sucursal.TXT_nombre && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_sucursal.TXT_nombre.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_sucursal.TXT_direccion && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_sucursal.TXT_direccion.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_sucursal.CBX_estado) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_sucursal.TXT_ubigeo && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_sucursal.TXT_ubigeo.getText().trim(), 1, 6)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_sucursal.TXT_nota) {
                    BTN_guardar.requestFocus();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTN_guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDITAR");
        setIconImage(getIconImage());
        setResizable(false);

        BTN_guardar.setText("Guardar Cambios");
        BTN_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addComponent(BTN_guardar)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addComponent(BTN_guardar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_guardarActionPerformed
        if (lo_evt_datos_sucursal.valida_campos(lo_pnl_datos_sucursal)) {
            try {
                lo_evt_datos_sucursal.setea_campos(lo_bean_sucursal, lo_pnl_datos_sucursal);
                if (go_dao_sucursal.UPD_sucursal(lo_bean_sucursal)) {
                    this.dispose();
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_BTN_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(dlg_editar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_editar_sucursal dialog = new dlg_editar_sucursal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_ancestro.class.getResource("editar_d.png"));
        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_guardar;
    // End of variables declaration//GEN-END:variables
}
