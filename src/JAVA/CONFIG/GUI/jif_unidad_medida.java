package JAVA.CONFIG.GUI;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.ANCEST.GUI.pnl_opciones_1;
import JAVA.ANCEST.GUI.pnl_opciones_2;
import JAVA.ANCEST.LOGICA.evt_opciones_1;
import JAVA.ANCEST.LOGICA.evt_opciones_2;
import JAVA.CONFIG.BEAN.BEAN_unidad_medida;
import JAVA.CONFIG.LOGICA.cbx_tabla_sunat;
import JAVA.CONFIG.LOGICA.evt_datos_unidad_medida;
import JAVA.CONFIG.LOGICA.evt_grid_unidad_medida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class jif_unidad_medida extends javax.swing.JInternalFrame {

    pnl_datos_unidad_medida lo_pnl_datos_unidad_medida = new pnl_datos_unidad_medida();
    evt_datos_unidad_medida lo_evt_datos_unidad_medida = new evt_datos_unidad_medida();
    pnl_grid_unidad_medida lo_pnl_grid_unidad_medida = new pnl_grid_unidad_medida();
    evt_grid_unidad_medida lo_evt_grid_unidad_medida = new evt_grid_unidad_medida();
    pnl_opciones_1 lo_pnl_opciones_1 = new pnl_opciones_1();
    evt_opciones_1 lo_evt_opciones_1 = new evt_opciones_1();
    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    BEAN_unidad_medida lo_bean_unidad_medida = new BEAN_unidad_medida();
    DefaultTableModel modelo;
    ResultSet lq_rs;
    cbx_tabla_sunat lo_cbx_tabla_sunat;
    int li_tipo_operacion;
    String ls_codigo;
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "jif_tipo_unidad_medida";

    public jif_unidad_medida() {
        initComponents();
        formulario();
        get_tabla_sunat();
    }

    private void formulario() {
        lo_pnl_datos_unidad_medida.setBounds(0, 0, 350, 350);
        lo_pnl_grid_unidad_medida.setBounds(0, 7, 500, 350);
        lo_pnl_opciones_1.setBounds(0, 0, 350, 100);
        lo_pnl_opciones_2.setBounds(0, 0, 450, 100);

        PNL_datos.add(lo_pnl_datos_unidad_medida);
        PNL_visor.add(lo_pnl_grid_unidad_medida);
        PNL_opcion_1.add(lo_pnl_opciones_1);
        PNL_opcion_2.add(lo_pnl_opciones_2);

        modelo = (DefaultTableModel) lo_pnl_grid_unidad_medida.TBL_unidad_medida.getModel();

        lo_evt_grid_unidad_medida.datos_tabla(modelo);

        lo_evt_opciones_1.evento_click(lo_pnl_opciones_1, Listener);
        lo_evt_opciones_1.evento_press(lo_pnl_opciones_1, KeyEvnt);
        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);
        lo_evt_datos_unidad_medida.evento_press(lo_pnl_datos_unidad_medida, KeyEvnt);
        lo_evt_grid_unidad_medida.evento_press(lo_pnl_grid_unidad_medida, KeyEvnt);

    }

    private void get_tabla_sunat() {
        lq_rs = go_dao_tabla_sunat.SLT_cbx_tabla_sunat("006");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(3, lq_rs, lo_pnl_datos_unidad_medida.CBX_codigo_sunat);
        }
    }

    private void evt_nuevo() {
        li_tipo_operacion = 0;
        lo_evt_datos_unidad_medida.limpia_datos(lo_pnl_datos_unidad_medida);

        try {
            lq_rs = go_dao_unidad_medida.FNC_codigo_unidad();
            if (lq_rs.next()) {
                lo_pnl_datos_unidad_medida.TXT_codigo.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }

        //lo_evt_opciones_1.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_unidad_medida.activa_campos(0, lo_pnl_datos_unidad_medida, true);
    }

    private void evt_guardar() {
        lo_cbx_tabla_sunat = (cbx_tabla_sunat) lo_pnl_datos_unidad_medida.CBX_codigo_sunat.getSelectedItem();

        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_unidad_medida.valida_campos(lo_pnl_datos_unidad_medida)) {
                    try {
                        lo_evt_datos_unidad_medida.setea_campos(lo_bean_unidad_medida, lo_pnl_datos_unidad_medida, lo_cbx_tabla_sunat);
                        if (go_dao_unidad_medida.IST_unidad_medida(lo_bean_unidad_medida)) {
                            lo_evt_datos_unidad_medida.limpia_datos(lo_pnl_datos_unidad_medida);
                            lo_evt_datos_unidad_medida.activa_campos(0, lo_pnl_datos_unidad_medida, false);
                            //lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                            lo_evt_grid_unidad_medida.datos_tabla(modelo);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
        }
    }

    private void evt_cancelar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA CANCELAR REGISTRO?") == 0) {
            lo_evt_datos_unidad_medida.limpia_datos(lo_pnl_datos_unidad_medida);
            lo_evt_datos_unidad_medida.activa_campos(0, lo_pnl_datos_unidad_medida, false);
        }
    }

    private void evt_eliminar() {
        try {
            if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR LA UNIDAD DE MEDIDA " + lo_pnl_grid_unidad_medida.TBL_unidad_medida.getValueAt(lo_pnl_grid_unidad_medida.TBL_unidad_medida.getSelectedRow(), 1) + "?") == 0) {
                ls_codigo = lo_pnl_grid_unidad_medida.TBL_unidad_medida.getValueAt(lo_pnl_grid_unidad_medida.TBL_unidad_medida.getSelectedRow(), 0).toString();

                if (go_dao_unidad_medida.DLT_unidad_medida(ls_codigo)) {
                    //lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_unidad_medida.activa_campos(0, lo_pnl_datos_unidad_medida, false);
                    lo_evt_datos_unidad_medida.limpia_datos(lo_pnl_datos_unidad_medida);
                    lo_evt_grid_unidad_medida.datos_tabla(modelo);
                }

            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_eliminar", "SELECCIONE REGISTRO");
        }

    }

    private void evt_editar() {
        try {
            ls_codigo = lo_pnl_grid_unidad_medida.TBL_unidad_medida.getValueAt(lo_pnl_grid_unidad_medida.TBL_unidad_medida.getSelectedRow(), 0).toString();

            gs_parametros[0] = ls_codigo;
            gs_parametros[1] = lo_pnl_grid_unidad_medida.TBL_unidad_medida.getValueAt(lo_pnl_grid_unidad_medida.TBL_unidad_medida.getSelectedRow(), 1).toString();
            gs_parametros[2] = lo_pnl_grid_unidad_medida.TBL_unidad_medida.getValueAt(lo_pnl_grid_unidad_medida.TBL_unidad_medida.getSelectedRow(), 2).toString();
            gs_parametros[3] = lo_pnl_grid_unidad_medida.TBL_unidad_medida.getValueAt(lo_pnl_grid_unidad_medida.TBL_unidad_medida.getSelectedRow(), 3).toString();
            gs_parametros[4] = lo_pnl_grid_unidad_medida.TBL_unidad_medida.getValueAt(lo_pnl_grid_unidad_medida.TBL_unidad_medida.getSelectedRow(), 5).toString();

            go_dlg_editar_unidad_medida = new dlg_editar_unidad_medida(null, true);
            go_dlg_editar_unidad_medida.setVisible(true);
            lo_evt_grid_unidad_medida.datos_tabla(modelo);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_editar", "SELECCIONE REGISTRO");
        }
    }

    private void evt_exportar() {
        go_evt_exportar.exportar(lo_pnl_grid_unidad_medida.TBL_unidad_medida);
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_opciones_1.BTN_nuevo) {
                evt_nuevo();
            }
            if (ae.getSource() == lo_pnl_opciones_1.BTN_guardar) {
                evt_guardar();
            }
            if (ae.getSource() == lo_pnl_opciones_1.BTN_cancelar) {
                evt_cancelar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_eliminar) {
                evt_eliminar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_editar) {
                evt_editar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_exportar) {
                evt_exportar();
            }
        }

    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F1 && lo_pnl_opciones_1.BTN_nuevo.isEnabled()) {
                evt_nuevo();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F2 && lo_pnl_opciones_2.BTN_editar.isEnabled()) {
                evt_editar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F3 && lo_pnl_opciones_2.BTN_eliminar.isEnabled()) {
                evt_eliminar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_opciones_1.BTN_guardar.isEnabled()) {
                evt_guardar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE && lo_pnl_opciones_1.BTN_cancelar.isEnabled()) {
                evt_cancelar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_opciones_1.BTN_nuevo) {
                    evt_nuevo();
                }
                if (ke.getSource() == lo_pnl_opciones_1.BTN_guardar) {
                    evt_guardar();
                }
                if (ke.getSource() == lo_pnl_opciones_1.BTN_cancelar) {
                    evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_eliminar) {
                    evt_eliminar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_editar) {
                    evt_editar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_exportar) {
                    evt_exportar();
                }
                if (ke.getSource() == lo_pnl_datos_unidad_medida.TXT_nombre && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_unidad_medida.TXT_nombre.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_unidad_medida.TXT_simbolo && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_unidad_medida.TXT_simbolo.getText().trim(), 1, 3)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_unidad_medida.CBX_estado) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_unidad_medida.CBX_codigo_sunat) {
                    lo_pnl_opciones_1.BTN_guardar.requestFocus();
                }
                if (ke.getSource() == lo_pnl_grid_unidad_medida.TXT_dato) {
                    if (lo_pnl_grid_unidad_medida.TBL_unidad_medida.getRowCount() != 0) {
                        lo_pnl_grid_unidad_medida.TBL_unidad_medida.requestFocus();
                        lo_pnl_grid_unidad_medida.TBL_unidad_medida.changeSelection(0, 0, false, false);
                    } else {
                        lo_pnl_grid_unidad_medida.TXT_dato.requestFocus();
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_grid_unidad_medida.TXT_dato) {
                go_fnc_filtrar_tablas.filtro(modelo, lo_pnl_grid_unidad_medida.TBL_unidad_medida, lo_pnl_grid_unidad_medida.TXT_dato.getText(), 1);
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PNL_datos = new javax.swing.JPanel();
        PNL_visor = new javax.swing.JPanel();
        PNL_opcion_1 = new javax.swing.JPanel();
        PNL_opcion_2 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("UNIDAD DE MEDIDA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout PNL_datosLayout = new javax.swing.GroupLayout(PNL_datos);
        PNL_datos.setLayout(PNL_datosLayout);
        PNL_datosLayout.setHorizontalGroup(
            PNL_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        PNL_datosLayout.setVerticalGroup(
            PNL_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PNL_visorLayout = new javax.swing.GroupLayout(PNL_visor);
        PNL_visor.setLayout(PNL_visorLayout);
        PNL_visorLayout.setHorizontalGroup(
            PNL_visorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        PNL_visorLayout.setVerticalGroup(
            PNL_visorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PNL_opcion_1Layout = new javax.swing.GroupLayout(PNL_opcion_1);
        PNL_opcion_1.setLayout(PNL_opcion_1Layout);
        PNL_opcion_1Layout.setHorizontalGroup(
            PNL_opcion_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PNL_opcion_1Layout.setVerticalGroup(
            PNL_opcion_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PNL_opcion_2Layout = new javax.swing.GroupLayout(PNL_opcion_2);
        PNL_opcion_2.setLayout(PNL_opcion_2Layout);
        PNL_opcion_2Layout.setHorizontalGroup(
            PNL_opcion_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PNL_opcion_2Layout.setVerticalGroup(
            PNL_opcion_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PNL_opcion_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PNL_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PNL_visor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PNL_opcion_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PNL_opcion_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PNL_opcion_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PNL_visor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PNL_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNL_datos;
    private javax.swing.JPanel PNL_opcion_1;
    private javax.swing.JPanel PNL_opcion_2;
    private javax.swing.JPanel PNL_visor;
    // End of variables declaration//GEN-END:variables
}
