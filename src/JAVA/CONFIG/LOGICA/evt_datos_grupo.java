package JAVA.CONFIG.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_grupo;
import JAVA.CONFIG.GUI.pnl_datos_grupo;
import java.awt.event.KeyListener;

public class evt_datos_grupo {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_grupo";

    public void activa_campos(int op, pnl_datos_grupo OBJ_pnl, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pnl.TXT_nombre.setEnabled(valor);
                OBJ_pnl.TXT_nombre.requestFocus();
                break;
        }
    }

    public boolean valida_campos(pnl_datos_grupo OBJ_pds) {
        boolean resp = false;
        if (go_fnc_opera_campos.campo_blanco(OBJ_pds.TXT_nombre) && go_fnc_opera_campos.cant_caracter(OBJ_pds.TXT_nombre.getText().trim(), 1, 4)) {
            resp = true;
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE GRUPO");
            OBJ_pds.TXT_nombre.requestFocus();
        }
        return resp;
    }

    public void setea_campos(BEAN_grupo OBJ_bsu, pnl_datos_grupo OBJ_pds) {
        try {
            OBJ_bsu.setCodigo_producto(OBJ_pds.TXT_codigo.getText().trim());
            OBJ_bsu.setNombre_producto(OBJ_pds.TXT_nombre.getText().trim());
        } catch (Exception e) {
        }
    }

    public void limpia_datos(pnl_datos_grupo OBJ_pnl) {
        OBJ_pnl.TXT_nombre.setText("");
        OBJ_pnl.TXT_codigo.setText("");
    }

    public KeyListener evento_press(pnl_datos_grupo OBJ_pnl, KeyListener KeyEvnt) {
        OBJ_pnl.TXT_nombre.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

}
