package JAVA.CONFIG.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_sucursal;
import JAVA.CONFIG.GUI.pnl_datos_sucursal;
import java.awt.event.KeyListener;

public class evt_datos_sucursal {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_sucursal";

    public void activa_campos(int op, pnl_datos_sucursal OBJ_pnl, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pnl.TXT_nombre.setEnabled(valor);
                OBJ_pnl.TXT_ubigeo.setEnabled(valor);
                OBJ_pnl.TXT_direccion.setEnabled(valor);
                OBJ_pnl.CBX_estado.setEnabled(valor);
                OBJ_pnl.TXT_nota.setEnabled(valor);
                OBJ_pnl.TXT_nombre.requestFocus();
                break;
        }
    }

    public boolean valida_campos(pnl_datos_sucursal OBJ_pds) {
        boolean resp = false;
        if (go_fnc_opera_campos.campo_blanco(OBJ_pds.TXT_nombre) && go_fnc_opera_campos.cant_caracter(OBJ_pds.TXT_nombre.getText().trim(), 1, 4)) {
            if (go_fnc_opera_campos.campo_blanco(OBJ_pds.TXT_direccion) && go_fnc_opera_campos.cant_caracter(OBJ_pds.TXT_direccion.getText().trim(), 1, 4)) {
                if (go_fnc_opera_campos.campo_blanco(OBJ_pds.TXT_ubigeo) || go_fnc_opera_campos.campo_blanco(OBJ_pds.TXT_descripcion)) {
                    resp = true;
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE UBIGEO");
                    OBJ_pds.TXT_ubigeo.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE DIRECCION");
                OBJ_pds.TXT_direccion.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE SUCURSAL");
            OBJ_pds.TXT_nombre.requestFocus();
        }
        return resp;
    }
    
    public void setea_campos(BEAN_sucursal OBJ_bsu, pnl_datos_sucursal OBJ_pds) {
        try {
            OBJ_bsu.setCodigo_sucursal(OBJ_pds.TXT_codigo.getText().trim());
            OBJ_bsu.setNombre_sucursal(OBJ_pds.TXT_nombre.getText().trim());
            OBJ_bsu.setDireccion(OBJ_pds.TXT_direccion.getText().trim());
            OBJ_bsu.setNota(OBJ_pds.TXT_nota.getText().trim());
            OBJ_bsu.setStatus(OBJ_pds.CBX_estado.getSelectedIndex() + "");
            OBJ_bsu.setCodigo_ubigeo(OBJ_pds.TXT_ubigeo.getText().trim());
            OBJ_bsu.setDescripcion_ubigeo(OBJ_pds.TXT_descripcion.getText().trim());
        } catch (Exception e) {
        }
    }

    public void limpia_datos(pnl_datos_sucursal OBJ_pnl) {
        OBJ_pnl.TXT_nombre.setText("");
        OBJ_pnl.TXT_ubigeo.setText("");
        OBJ_pnl.TXT_direccion.setText("");
        OBJ_pnl.TXT_nota.setText("");
        OBJ_pnl.TXT_codigo.setText("");
        OBJ_pnl.TXT_descripcion.setText("");
        OBJ_pnl.CBX_estado.setSelectedIndex(1);
    }

    public KeyListener evento_press(pnl_datos_sucursal OBJ_pnl, KeyListener KeyEvnt) {
        OBJ_pnl.TXT_nombre.addKeyListener(KeyEvnt);
        OBJ_pnl.TXT_ubigeo.addKeyListener(KeyEvnt);
        OBJ_pnl.TXT_direccion.addKeyListener(KeyEvnt);
        OBJ_pnl.TXT_nota.addKeyListener(KeyEvnt);
        OBJ_pnl.CBX_estado.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

}
