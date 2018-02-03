package JAVA.CONFIG.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_usuario;
import JAVA.CONFIG.GUI.pnl_datos_usuario;
import java.awt.event.KeyListener;

public class evt_datos_usuario {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_usuario";

    public void activa_campos(int op, pnl_datos_usuario OBJ_pnl, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pnl.TXT_datos.setEnabled(valor);
                OBJ_pnl.TXT_usuario.setEnabled(valor);
                OBJ_pnl.TXT_pass.setEnabled(valor);
                OBJ_pnl.CBX_rol.setEnabled(valor);
                OBJ_pnl.CBX_estado.setEnabled(valor);
                OBJ_pnl.TXT_datos.requestFocus();
                break;
        }
    }

    public boolean valida_campos(pnl_datos_usuario OBJ_usu) {
        boolean resp = false;
        if (go_fnc_opera_campos.campo_blanco(OBJ_usu.TXT_datos) && go_fnc_opera_campos.cant_caracter(OBJ_usu.TXT_datos.getText().trim(), 1, 4)) {
            if (go_fnc_opera_campos.campo_blanco(OBJ_usu.TXT_usuario) && go_fnc_opera_campos.cant_caracter(OBJ_usu.TXT_usuario.getText().trim(), 1, 4)) {
                if (go_fnc_opera_campos.campo_blanco(OBJ_usu.TXT_pass) && go_fnc_opera_campos.cant_caracter(OBJ_usu.TXT_pass.getText().trim(), 1, 4)) {
                    resp = true;
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CONTRASEÑA");
                    OBJ_usu.TXT_pass.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE USUARIO");
                OBJ_usu.TXT_usuario.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE DATOS DEL USUARIO");
            OBJ_usu.TXT_datos.requestFocus();
        }
        return resp;
    }

    public void setea_campos(BEAN_usuario OBJ_bean, pnl_datos_usuario OBJ_pnl, cbx_rol cbx_rol) {
        try {
            OBJ_bean.setDatos_usuario(OBJ_pnl.TXT_datos.getText().trim());
            OBJ_bean.setNombre_usuario(OBJ_pnl.TXT_usuario.getText().trim());
            OBJ_bean.setClave_usuario(go_fnc_opera_campos.encriptar(OBJ_pnl.TXT_pass.getText().trim()));
            OBJ_bean.setStatus(OBJ_pnl.CBX_estado.getSelectedIndex() + "");
            OBJ_bean.setId_rol(cbx_rol.getID());
            OBJ_bean.setCodigo_entidad("%");
            OBJ_bean.setCodigo_vendedor("%");
        } catch (Exception e) {
        }
    }

    public void limpia_datos(pnl_datos_usuario OBJ_pnl) {
        OBJ_pnl.TXT_datos.setText("");
        OBJ_pnl.TXT_usuario.setText("");
        OBJ_pnl.TXT_pass.setText("");
    }

    public KeyListener evento_press(pnl_datos_usuario OBJ_pnl, KeyListener KeyEvnt) {
        OBJ_pnl.TXT_datos.addKeyListener(KeyEvnt);
        OBJ_pnl.TXT_pass.addKeyListener(KeyEvnt);
        OBJ_pnl.TXT_usuario.addKeyListener(KeyEvnt);
        OBJ_pnl.CBX_rol.addKeyListener(KeyEvnt);
        OBJ_pnl.CBX_estado.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

}
