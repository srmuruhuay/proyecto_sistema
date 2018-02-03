package JAVA.CONFIG.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_tipo_documento;
import JAVA.CONFIG.GUI.pnl_datos_tipo_documento;
import java.awt.event.KeyListener;

public class evt_datos_tipo_documento {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_tipo_documento";

    public void activa_campos(int op, pnl_datos_tipo_documento OBJ_pnl, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pnl.TXT_codigo.setEnabled(valor);
                OBJ_pnl.TXT_nombre.setEnabled(valor);
                OBJ_pnl.CBX_tipo_movimiento.setEnabled(valor);
                OBJ_pnl.CBX_estado.setEnabled(valor);
                OBJ_pnl.CBX_codigo_sunat.setEnabled(valor);
                OBJ_pnl.TXT_codigo.requestFocus();
                break;
        }
    }

    public boolean valida_campos(pnl_datos_tipo_documento OBJ_pds) {
        boolean resp = false;
        if (go_fnc_opera_campos.campo_blanco(OBJ_pds.TXT_codigo) && go_fnc_opera_campos.cant_caracter(OBJ_pds.TXT_codigo.getText().trim(), 1, 2)) {
            if (go_fnc_opera_campos.campo_blanco(OBJ_pds.TXT_nombre) && go_fnc_opera_campos.cant_caracter(OBJ_pds.TXT_nombre.getText().trim(), 1, 4)) {
                resp = true;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DOCUMENTO");
                OBJ_pds.TXT_nombre.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO DE DOCUMENTO");
            OBJ_pds.TXT_codigo.requestFocus();
        }
        return resp;
    }

    public void setea_campos(BEAN_tipo_documento OBJ_bsu, pnl_datos_tipo_documento OBJ_pds, cbx_tabla_sunat cbx_tabla_sunat) {
        try {
            OBJ_bsu.setCodigo_documento(OBJ_pds.TXT_codigo.getText().trim());
            OBJ_bsu.setNombre_documento(OBJ_pds.TXT_nombre.getText().trim());
            OBJ_bsu.setCategoria("010");
            OBJ_bsu.setCodigo_sunat(cbx_tabla_sunat.getID());
            OBJ_bsu.setTipo_movimiento(OBJ_pds.CBX_tipo_movimiento.getSelectedIndex() + "");
            OBJ_bsu.setStatus(OBJ_pds.CBX_estado.getSelectedIndex() + "");
        } catch (Exception e) {
        }
    }

    public void limpia_datos(pnl_datos_tipo_documento OBJ_pnl) {
        OBJ_pnl.TXT_codigo.setText("");
        OBJ_pnl.TXT_nombre.setText("");
    }

    public KeyListener evento_press(pnl_datos_tipo_documento OBJ_pnl, KeyListener KeyEvnt) {
        OBJ_pnl.TXT_codigo.addKeyListener(KeyEvnt);
        OBJ_pnl.TXT_nombre.addKeyListener(KeyEvnt);
        OBJ_pnl.CBX_codigo_sunat.addKeyListener(KeyEvnt);
        OBJ_pnl.CBX_estado.addKeyListener(KeyEvnt);
        OBJ_pnl.CBX_tipo_movimiento.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

}
