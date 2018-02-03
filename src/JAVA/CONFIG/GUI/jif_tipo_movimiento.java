package JAVA.CONFIG.GUI;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.ANCEST.GUI.pnl_opciones_1;
import JAVA.ANCEST.GUI.pnl_opciones_2;
import JAVA.ANCEST.LOGICA.evt_opciones_1;
import JAVA.ANCEST.LOGICA.evt_opciones_2;
import JAVA.CONFIG.BEAN.BEAN_tipo_movimiento;
import JAVA.CONFIG.LOGICA.cbx_almacen;
import JAVA.CONFIG.LOGICA.cbx_tabla_sunat;
import JAVA.CONFIG.LOGICA.evt_datos_tipo_movimiento;
import JAVA.CONFIG.LOGICA.evt_grid_tipo_movimiento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class jif_tipo_movimiento extends javax.swing.JInternalFrame {

    pnl_datos_tipo_movimiento lo_pnl_datos_tipo_movimiento = new pnl_datos_tipo_movimiento();
    evt_datos_tipo_movimiento lo_evt_datos_tipo_movimiento = new evt_datos_tipo_movimiento();
    pnl_grid_tipo_movimiento lo_pnl_grid_tipo_movimiento = new pnl_grid_tipo_movimiento();
    evt_grid_tipo_movimiento lo_evt_grid_tipo_movimiento = new evt_grid_tipo_movimiento();
    pnl_opciones_1 lo_pnl_opciones_1 = new pnl_opciones_1();
    evt_opciones_1 lo_evt_opciones_1 = new evt_opciones_1();
    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    BEAN_tipo_movimiento lo_bean_tipo_movimiento = new BEAN_tipo_movimiento();
    DefaultTableModel modelo;
    ResultSet lq_rs;
    cbx_almacen lo_cbx_almacen;
    cbx_tabla_sunat lo_cbx_tabla_sunat;
    int li_tipo_operacion;
    String ls_codigo;
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "jif_tipo_movimiento";

    public jif_tipo_movimiento() {
        initComponents();
        formulario();
        get_almacen();
        get_tabla_sunat();
    }

    private void formulario() {
        lo_pnl_datos_tipo_movimiento.setBounds(0, 0, 350, 350);
        lo_pnl_grid_tipo_movimiento.setBounds(0, 7, 500, 350);
        lo_pnl_opciones_1.setBounds(0, 0, 350, 100);
        lo_pnl_opciones_2.setBounds(0, 0, 450, 100);

        PNL_datos.add(lo_pnl_datos_tipo_movimiento);
        PNL_visor.add(lo_pnl_grid_tipo_movimiento);
        PNL_opcion_1.add(lo_pnl_opciones_1);
        PNL_opcion_2.add(lo_pnl_opciones_2);

        modelo = (DefaultTableModel) lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getModel();

        lo_evt_grid_tipo_movimiento.datos_tabla(modelo);

        lo_evt_opciones_1.evento_click(lo_pnl_opciones_1, Listener);
        lo_evt_opciones_1.evento_press(lo_pnl_opciones_1, KeyEvnt);
        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);
        lo_evt_datos_tipo_movimiento.evento_press(lo_pnl_datos_tipo_movimiento, KeyEvnt);
        lo_evt_grid_tipo_movimiento.evento_press(lo_pnl_grid_tipo_movimiento, KeyEvnt);

    }

    private void get_almacen() {
        lq_rs = go_dao_almacen.SLT_cbx_almacen();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(2, lq_rs, lo_pnl_datos_tipo_movimiento.CBX_almacen);
        }
    }

    private void get_tabla_sunat() {
        lq_rs = go_dao_tabla_sunat.SLT_cbx_tabla_sunat("012");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(3, lq_rs, lo_pnl_datos_tipo_movimiento.CBX_codigo_sunat);
        }
    }

    private void evt_nuevo() {
        li_tipo_operacion = 0;
        lo_evt_datos_tipo_movimiento.limpia_datos(lo_pnl_datos_tipo_movimiento);

        //lo_evt_opciones_1.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_tipo_movimiento.activa_campos(0, lo_pnl_datos_tipo_movimiento, true);
    }

    private void evt_guardar() {
        lo_cbx_almacen = (cbx_almacen) lo_pnl_datos_tipo_movimiento.CBX_almacen.getSelectedItem();
        lo_cbx_tabla_sunat = (cbx_tabla_sunat) lo_pnl_datos_tipo_movimiento.CBX_codigo_sunat.getSelectedItem();

        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_tipo_movimiento.valida_campos(lo_pnl_datos_tipo_movimiento)) {
                    try {
                        lo_evt_datos_tipo_movimiento.setea_campos(lo_bean_tipo_movimiento, lo_pnl_datos_tipo_movimiento, lo_cbx_almacen, lo_cbx_tabla_sunat);
                        if (go_dao_tipo_movimiento.IST_tipo_movimiento(lo_bean_tipo_movimiento)) {
                            lo_evt_datos_tipo_movimiento.limpia_datos(lo_pnl_datos_tipo_movimiento);
                            lo_evt_datos_tipo_movimiento.activa_campos(0, lo_pnl_datos_tipo_movimiento, false);
                            //lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                            lo_evt_grid_tipo_movimiento.datos_tabla(modelo);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
        }
    }

    private void evt_cancelar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA CANCELAR REGISTRO?") == 0) {
            lo_evt_datos_tipo_movimiento.limpia_datos(lo_pnl_datos_tipo_movimiento);
            lo_evt_datos_tipo_movimiento.activa_campos(0, lo_pnl_datos_tipo_movimiento, false);
        }
    }

    private void evt_eliminar() {
        try {
            if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR AL MOVIMIENTO " + lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getValueAt(lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getSelectedRow(), 1) + "?") == 0) {
                ls_codigo = lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getValueAt(lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getSelectedRow(), 0).toString();

                if (go_dao_tipo_movimiento.DLT_tipo_movimiento(ls_codigo)) {
                    //lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_tipo_movimiento.activa_campos(0, lo_pnl_datos_tipo_movimiento, false);
                    lo_evt_datos_tipo_movimiento.limpia_datos(lo_pnl_datos_tipo_movimiento);
                    lo_evt_grid_tipo_movimiento.datos_tabla(modelo);
                }

            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_eliminar", "SELECCIONE REGISTRO");
        }

    }

    private void evt_editar() {
        try {
            ls_codigo = lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getValueAt(lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getSelectedRow(), 0).toString();

            gs_parametros[0] = ls_codigo;
            gs_parametros[1] = lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getValueAt(lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getSelectedRow(), 1).toString();
            gs_parametros[2] = lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getValueAt(lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getSelectedRow(), 4).toString();
            gs_parametros[3] = lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getValueAt(lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getSelectedRow(), 5).toString();
            gs_parametros[4] = lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getValueAt(lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getSelectedRow(), 6).toString();
            gs_parametros[5] = lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getValueAt(lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getSelectedRow(), 7).toString();
            gs_parametros[6] = lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getValueAt(lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getSelectedRow(), 8).toString();
            gs_parametros[7] = lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getValueAt(lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getSelectedRow(), 3).toString();

            go_dlg_editar_tipo_movimiento = new dlg_editar_tipo_movimiento(null, true);
            go_dlg_editar_tipo_movimiento.setVisible(true);
            lo_evt_grid_tipo_movimiento.datos_tabla(modelo);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_editar", "SELECCIONE REGISTRO");
        }

    }

    private void evt_exportar() {
        go_evt_exportar.exportar(lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento);
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
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_opciones_1.BTN_guardar.isEnabled()) {
                evt_guardar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F2 && lo_pnl_opciones_2.BTN_editar.isEnabled()) {
                evt_editar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F3 && lo_pnl_opciones_2.BTN_eliminar.isEnabled()) {
                evt_eliminar();
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
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.TXT_codigo && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_tipo_movimiento.TXT_codigo.getText().trim(), 1, 2)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.TXT_nombre && go_fnc_opera_campos.cant_caracter(lo_pnl_datos_tipo_movimiento.TXT_nombre.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_estado || ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_tipo_almacen || ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_almacen || ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_tipo_movimiento || ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_es_transferencia) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_codigo_sunat) {
                    lo_pnl_opciones_1.BTN_guardar.requestFocus();
                }
                if (ke.getSource() == lo_pnl_grid_tipo_movimiento.TXT_dato) {
                    if (lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.getRowCount() != 0) {
                        lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.requestFocus();
                        lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento.changeSelection(0, 0, false, false);
                    } else {
                        lo_pnl_grid_tipo_movimiento.TXT_dato.requestFocus();
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_grid_tipo_movimiento.TXT_dato) {
                go_fnc_filtrar_tablas.filtro(modelo, lo_pnl_grid_tipo_movimiento.TBL_tipo_movimiento, lo_pnl_grid_tipo_movimiento.TXT_dato.getText(), 1);
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
        setTitle("TIPO MOVIMIENTO");
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
