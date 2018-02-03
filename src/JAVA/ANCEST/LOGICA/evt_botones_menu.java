package JAVA.ANCEST.LOGICA;

import JAVA.ANCEST.GUI.frm_principal;
import java.awt.event.ActionListener;

public class evt_botones_menu {

    public ActionListener evento_click(frm_principal OBJ_frm, ActionListener Listener) {
        OBJ_frm.BTN_config.addActionListener(Listener);
        OBJ_frm.BTN_config_ico.addActionListener(Listener);
        OBJ_frm.BTN_producto.addActionListener(Listener);
        OBJ_frm.BTN_producto_ico.addActionListener(Listener);
        return Listener;
    }

}
