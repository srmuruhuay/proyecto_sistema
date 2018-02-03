package JAVA.ANCEST.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.dlg_busq_ubigeo;
import java.sql.ResultSet;
import javax.swing.JTextField;

public class activa_buscador {

    ResultSet lq_rs;
    String ls_modulo = "ANCESTRO", ls_capa = "LOGICA", ls_clase = "activa_buscador";

    public void busq_ubigeo(JTextField codigo, JTextField descripcion) {
        go_dlg_busq_ubigeo = new dlg_busq_ubigeo(null, true);
        go_dlg_busq_ubigeo.setVisible(true);
        String ls_codigo_ubigeo = go_dlg_busq_ubigeo.ls_codigo_ubigeo;
        String ls_descripcion = go_dlg_busq_ubigeo.ls_descripcion;

        if (ls_codigo_ubigeo != null) {
            codigo.setText(ls_codigo_ubigeo);
            descripcion.setText(ls_descripcion);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "busq_ubigeo", "SELECCIONE UBIGEO");
            codigo.setText("");
            descripcion.setText("");
        }
    }
}
