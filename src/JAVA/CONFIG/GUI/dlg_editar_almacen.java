package JAVA.CONFIG.GUI;

import JAVA.ANCEST.IMAGES.IMAGES_ruta_ancestro;
import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_almacen;
import JAVA.CONFIG.LOGICA.cbx_sucursal;
import JAVA.CONFIG.LOGICA.evt_datos_almacen;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class dlg_editar_almacen extends javax.swing.JDialog {

    pnl_datos_almacen lo_pnl_datos_almacen = new pnl_datos_almacen();
    evt_datos_almacen lo_evt_datos_almacen = new evt_datos_almacen();
    BEAN_almacen lo_bean_almacen = new BEAN_almacen();
    cbx_sucursal lo_cbx_sucursal;
    ResultSet lq_rs;
    String ls_codigo;

    public dlg_editar_almacen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        get_sucursal();
        formulario();
    }

    private void formulario() {
        lo_pnl_datos_almacen.setBounds(10, 10, 450, 350);
        this.add(lo_pnl_datos_almacen);

        ls_codigo = gs_parametros[0];
        lo_pnl_datos_almacen.TXT_codigo_almacen.setText(gs_parametros[0]);
        lo_pnl_datos_almacen.TXT_nombre_almacen.setText(gs_parametros[1]);
        lo_pnl_datos_almacen.TXT_direccion_almacen.setText(gs_parametros[2]);
        lo_pnl_datos_almacen.CBX_estado.setSelectedIndex(Integer.parseInt(gs_parametros[3]));
        lo_pnl_datos_almacen.CBX_tipo_almacen.setSelectedIndex(Integer.parseInt(gs_parametros[4]));
        go_cbx_trato_datos.selecciona_valor(1, gs_parametros[5], lo_pnl_datos_almacen.CBX_sucursal);
        lo_pnl_datos_almacen.TXT_ubigeo.setText(gs_parametros[6]);
        lo_pnl_datos_almacen.TXT_descripcion.setText(gs_parametros[7]);
        lo_pnl_datos_almacen.TXT_nota.setText(gs_parametros[8]);

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";
        gs_parametros[3] = "";
        gs_parametros[4] = "";
        gs_parametros[5] = "";
        gs_parametros[6] = "";
        gs_parametros[7] = "";
        gs_parametros[8] = "";

        lo_evt_datos_almacen.activa_campos(0, lo_pnl_datos_almacen, true);
        lo_evt_datos_almacen.evento_press(lo_pnl_datos_almacen, KeyEvnt);
    }

    private void get_sucursal() {
        lq_rs = go_dao_sucursal.SLT_cbx_sucursal();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(1, lq_rs, lo_pnl_datos_almacen.CBX_sucursal);
        }
    }

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_datos_almacen.TXT_ubigeo) {
                    go_activa_buscador.busq_ubigeo(lo_pnl_datos_almacen.TXT_ubigeo, lo_pnl_datos_almacen.TXT_descripcion);
                }
            }

            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }

            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {

                if (ke.getSource() == lo_pnl_datos_almacen.TXT_nombre_almacen && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_almacen.TXT_nombre_almacen.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_almacen.TXT_direccion_almacen && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_almacen.TXT_direccion_almacen.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_almacen.CBX_estado || ke.getSource() == lo_pnl_datos_almacen.CBX_tipo_almacen || ke.getSource() == lo_pnl_datos_almacen.CBX_sucursal) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_almacen.TXT_ubigeo && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_almacen.TXT_ubigeo.getText().trim(), 1, 6)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_almacen.TXT_nota) {
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
                .addContainerGap(236, Short.MAX_VALUE)
                .addComponent(BTN_guardar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_guardarActionPerformed
        if (lo_evt_datos_almacen.valida_campos(lo_pnl_datos_almacen)) {
            lo_cbx_sucursal = (cbx_sucursal) lo_pnl_datos_almacen.CBX_sucursal.getSelectedItem();
            try {
                lo_evt_datos_almacen.setea_campos(lo_bean_almacen, lo_pnl_datos_almacen, lo_cbx_sucursal);
                if (go_dao_almacen.UPD_almacen(lo_bean_almacen)) {
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
            java.util.logging.Logger.getLogger(dlg_editar_almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_editar_almacen dialog = new dlg_editar_almacen(new javax.swing.JFrame(), true);
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
