package JAVA.ANCEST.GUI;

import JAVA.ANCEST.LOGICA.evt_login;
import static JAVA.ANCEST.LOGICA.variables_globales.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class frm_login extends javax.swing.JFrame {

    pnl_login lo_pnl_login = new pnl_login();
    evt_login lo_evt_login = new evt_login();
    ResultSet lq_rs;
    String ls_modulo = "ANCEST", ls_capa = "GUI", ls_clase = "frm_login";

    public frm_login() {
        initComponents();
        formulario();
        get_anio();
        //get_codigo();
    }

    private void get_codigo() {
        System.out.println(go_fnc_opera_campos.desencriptar("TLFeqKfjHPOeDEaEtbxI+Q=="));
    }

    private void formulario() {
        lo_pnl_login.setBounds(10, 10, 600, 600);
        PNL_datos.add(lo_pnl_login);

        lo_evt_login.evento_click(lo_pnl_login, listener);
        lo_evt_login.evento_press(lo_pnl_login, KeyEvnt);

        lo_pnl_login.TXT_usuario.requestFocus();
    }

    private void get_anio() {
        lo_pnl_login.CBX_periodo.removeAllItems();
        go_fnc_ayuda.cbx_anio(lo_pnl_login.CBX_periodo);
    }

    private void limpia_campos() {
        lo_pnl_login.TXT_usuario.setText("");
        lo_pnl_login.TXT_contrasenia.setText("");
        lo_pnl_login.TXT_usuario.requestFocus();
    }

    private void evt_aceptar() {
        if (go_fnc_opera_campos.campo_blanco(lo_pnl_login.TXT_usuario)) {
            if (go_fnc_opera_campos.campo_blanco(lo_pnl_login.TXT_contrasenia)) {
                lq_rs = go_dao_usuario.SLT_usuario_sesion(lo_pnl_login.TXT_usuario.getText().trim(), go_fnc_opera_campos.encriptar(lo_pnl_login.TXT_contrasenia.getText().trim()));
                try {
                    switch (lq_rs.getInt(1)) {
                        /*  NO EXISTE USUARIO = 0
                            EXISTE USUARIO = 1
                            EXISTE PERO NO ESTA ACTIVO = 2*/
                        case 0:
                            limpia_campos();
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "USUARIO y/o CONTRASEÑA INCORRECTOS");
                            break;
                        case 1:
                            this.dispose();

                            gs_periodo = lo_pnl_login.CBX_periodo.getSelectedItem().toString().trim();
                            gi_id_usuario = lq_rs.getInt(2);
                            gs_nombre_usuario = lq_rs.getString(3);
                            gs_datos_usuario = lq_rs.getString(4);
                            gi_id_rol = lq_rs.getInt(5);
                            gs_nombre_rol = lq_rs.getString(7);
                            gs_entidad_usuario = lq_rs.getString(8).trim();
                            gs_vendedor_usuario = lq_rs.getString(9).trim();

                            go_frm_principal = new frm_principal();
                            go_frm_principal.setVisible(true);
                            break;
                        case 2:
                            limpia_campos();
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "USUARIO BLOQUEADO");
                            break;
                    }
                } catch (Exception e) {
                }

            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "INGRESE CONTRASEÑA");
                lo_pnl_login.TXT_contrasenia.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "INGRESE USUARIO");
            lo_pnl_login.TXT_usuario.requestFocus();
        }
    }

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_login.BTN_login) {
                evt_aceptar();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_login.CBX_periodo) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_login.TXT_usuario && go_fnc_opera_campos.cant_caracter(lo_pnl_login.TXT_usuario.getText().trim(), 1, 3)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_login.TXT_contrasenia && go_fnc_opera_campos.cant_caracter(lo_pnl_login.TXT_contrasenia.getText().trim(), 1, 3)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_login.BTN_login) {
                    evt_aceptar();
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

        PNL_general = new javax.swing.JPanel();
        PNL_datos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SEÑOR DE MURUHUAY");

        PNL_general.setBackground(new java.awt.Color(237, 243, 245));

        PNL_datos.setBackground(new java.awt.Color(237, 243, 245));

        javax.swing.GroupLayout PNL_datosLayout = new javax.swing.GroupLayout(PNL_datos);
        PNL_datos.setLayout(PNL_datosLayout);
        PNL_datosLayout.setHorizontalGroup(
            PNL_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        PNL_datosLayout.setVerticalGroup(
            PNL_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PNL_generalLayout = new javax.swing.GroupLayout(PNL_general);
        PNL_general.setLayout(PNL_generalLayout);
        PNL_generalLayout.setHorizontalGroup(
            PNL_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PNL_generalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PNL_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PNL_generalLayout.setVerticalGroup(
            PNL_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PNL_generalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PNL_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PNL_general, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PNL_general, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        new frm_login().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNL_datos;
    private javax.swing.JPanel PNL_general;
    // End of variables declaration//GEN-END:variables
}
