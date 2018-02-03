package JAVA.CONFIG.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_unidad_medida;
import JAVA.CONFIG.GUI.pnl_datos_unidad_medida;
import java.awt.event.KeyListener;

public class evt_datos_unidad_medida {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_unidad_medida";

    public void activa_campos(int op, pnl_datos_unidad_medida OBJ_pnl, boolean valor) {
        switch (op) {
            case 0:                
                OBJ_pnl.TXT_nombre.setEnabled(valor);
                OBJ_pnl.TXT_simbolo.setEnabled(valor);
                OBJ_pnl.CBX_estado.setEnabled(valor);
                OBJ_pnl.CBX_codigo_sunat.setEnabled(valor);
                OBJ_pnl.TXT_nombre.requestFocus();
                break;
        }
    }

    public boolean valida_campos(pnl_datos_unidad_medida OBJ_pds) {
        boolean resp = false;
        if (go_fnc_opera_campos.campo_blanco(OBJ_pds.TXT_codigo) && go_fnc_opera_campos.cant_caracter(OBJ_pds.TXT_codigo.getText().trim(), 1, 2)) {
            if (go_fnc_opera_campos.campo_blanco(OBJ_pds.TXT_nombre) && go_fnc_opera_campos.cant_caracter(OBJ_pds.TXT_nombre.getText().trim(), 1, 4)) {
                if (go_fnc_opera_campos.campo_blanco(OBJ_pds.TXT_simbolo) && go_fnc_opera_campos.cant_caracter(OBJ_pds.TXT_simbolo.getText().trim(), 1, 3)) {
                    resp = true;
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE SIMBOLO UNIDAD");
                    OBJ_pds.TXT_nombre.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE UNIDAD");
                OBJ_pds.TXT_nombre.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO DE UNIDAD");
            OBJ_pds.TXT_codigo.requestFocus();
        }
        return resp;
    }

    public void setea_campos(BEAN_unidad_medida OBJ_bsu, pnl_datos_unidad_medida OBJ_pds, cbx_tabla_sunat cbx_tabla_sunat) {
        try {
            OBJ_bsu.setCodigo_unidad(OBJ_pds.TXT_codigo.getText().trim());
            OBJ_bsu.setNombre_unidad(OBJ_pds.TXT_nombre.getText().trim());
            OBJ_bsu.setCategoria("006");
            OBJ_bsu.setCodigo_sunat(cbx_tabla_sunat.getID());
            OBJ_bsu.setSimbolo_unidad(OBJ_pds.TXT_simbolo.getText().trim());
            OBJ_bsu.setStatus(OBJ_pds.CBX_estado.getSelectedIndex() + "");
        } catch (Exception e) {
        }
    }

    public void limpia_datos(pnl_datos_unidad_medida OBJ_pnl) {
        OBJ_pnl.TXT_codigo.setText("");
        OBJ_pnl.TXT_nombre.setText("");
        OBJ_pnl.TXT_simbolo.setText("");
    }

    public KeyListener evento_press(pnl_datos_unidad_medida OBJ_pnl, KeyListener KeyEvnt) {
        OBJ_pnl.TXT_codigo.addKeyListener(KeyEvnt);
        OBJ_pnl.TXT_nombre.addKeyListener(KeyEvnt);
        OBJ_pnl.CBX_codigo_sunat.addKeyListener(KeyEvnt);
        OBJ_pnl.CBX_estado.addKeyListener(KeyEvnt);
        OBJ_pnl.TXT_simbolo.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

}
