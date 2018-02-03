package JAVA.CONFIG.GUI;

import JAVA.ANCEST.IMAGES.IMAGES_ruta_ancestro;
import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_usuario;
import JAVA.CONFIG.LOGICA.cbx_rol;
import JAVA.CONFIG.LOGICA.evt_datos_usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class dlg_editar_usuario extends javax.swing.JDialog {

    pnl_datos_usuario lo_pnl_datos_usuario = new pnl_datos_usuario();
    evt_datos_usuario lo_evt_datos_usuario = new evt_datos_usuario();
    BEAN_usuario lo_bean_usuario = new BEAN_usuario();
    cbx_rol lo_cbx_rol;
    ResultSet lq_rs;
    String ls_id;

    public dlg_editar_usuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
        get_rol();
    }

    private void formulario() {
        lo_pnl_datos_usuario.setBounds(10, 10, 350, 350);
        this.add(lo_pnl_datos_usuario);

        lo_cbx_rol = (cbx_rol) lo_pnl_datos_usuario.CBX_rol.getSelectedItem();
        ls_id = gs_parametros[0];
        lo_pnl_datos_usuario.TXT_datos.setText(gs_parametros[1]);
        lo_pnl_datos_usuario.TXT_usuario.setText(gs_parametros[2]);
        lo_pnl_datos_usuario.TXT_pass.setText(gs_parametros[3]);
        go_cbx_trato_datos.selecciona_valor(0, gs_parametros[4], lo_pnl_datos_usuario.CBX_rol);
        lo_pnl_datos_usuario.CBX_estado.setSelectedIndex(Integer.parseInt(gs_parametros[5]));

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";
        gs_parametros[3] = "";
        gs_parametros[4] = "";
        gs_parametros[5] = "";

        lo_evt_datos_usuario.activa_campos(0, lo_pnl_datos_usuario, true);
        lo_evt_datos_usuario.evento_press(lo_pnl_datos_usuario, KeyEvnt);
    }

    private void get_rol() {
        lq_rs = go_dao_rol.SLT_cbx_rol();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(0, lq_rs, lo_pnl_datos_usuario.CBX_rol);
        }
    }

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_datos_usuario.TXT_datos && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_usuario.TXT_datos.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_usuario.TXT_usuario && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_usuario.TXT_usuario.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_usuario.TXT_pass && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_usuario.TXT_pass.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_usuario.CBX_rol) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_usuario.CBX_estado) {
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
                .addContainerGap(211, Short.MAX_VALUE)
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
        lo_cbx_rol = (cbx_rol) lo_pnl_datos_usuario.CBX_rol.getSelectedItem();
        if (lo_evt_datos_usuario.valida_campos(lo_pnl_datos_usuario)) {
            try {
                lo_evt_datos_usuario.setea_campos(lo_bean_usuario, lo_pnl_datos_usuario, lo_cbx_rol);
                if (go_dao_usuario.UPD_usuario(lo_bean_usuario, Integer.parseInt(ls_id))) {
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
            java.util.logging.Logger.getLogger(dlg_editar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_editar_usuario dialog = new dlg_editar_usuario(new javax.swing.JFrame(), true);
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
