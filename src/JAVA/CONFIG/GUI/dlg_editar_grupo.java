package JAVA.CONFIG.GUI;

import JAVA.ANCEST.IMAGES.IMAGES_ruta_ancestro;
import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_grupo;
import JAVA.CONFIG.LOGICA.evt_datos_grupo;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class dlg_editar_grupo extends javax.swing.JDialog {

    pnl_datos_grupo lo_pnl_datos_grupo = new pnl_datos_grupo();
    evt_datos_grupo lo_evt_datos_grupo = new evt_datos_grupo();
    BEAN_grupo lo_bean_producto_servicio = new BEAN_grupo();
    ResultSet lq_rs;
    String ls_codigo;

    public dlg_editar_grupo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_datos_grupo.setBounds(10, 10, 450, 350);
        this.add(lo_pnl_datos_grupo);

        ls_codigo = gs_parametros[0];
        lo_pnl_datos_grupo.TXT_codigo.setText(gs_parametros[0]);
        lo_pnl_datos_grupo.TXT_nombre.setText(gs_parametros[1]);

        gs_parametros[0] = "";
        gs_parametros[1] = "";

        lo_evt_datos_grupo.activa_campos(0, lo_pnl_datos_grupo, true);
        lo_evt_datos_grupo.evento_press(lo_pnl_datos_grupo, KeyEvnt);
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
                if (ke.getSource() == lo_pnl_datos_grupo.TXT_nombre && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_grupo.TXT_nombre.getText().trim(), 1, 4)) {
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
        if (lo_evt_datos_grupo.valida_campos(lo_pnl_datos_grupo)) {
            try {
                lo_evt_datos_grupo.setea_campos(lo_bean_producto_servicio, lo_pnl_datos_grupo);
                if (go_dao_grupo.UPD_grupo(lo_bean_producto_servicio)) {
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
            java.util.logging.Logger.getLogger(dlg_editar_grupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_grupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_grupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_grupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_editar_grupo dialog = new dlg_editar_grupo(new javax.swing.JFrame(), true);
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
