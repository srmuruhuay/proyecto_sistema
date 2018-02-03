package JAVA.ANCEST.LOGICA;

import JAVA.ANCEST.GUI.pnl_opciones_1;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class evt_opciones_1 {

    public ActionListener evento_click(pnl_opciones_1 OBJ_pnl, ActionListener Listener) {
        OBJ_pnl.BTN_cancelar.addActionListener(Listener);
        OBJ_pnl.BTN_guardar.addActionListener(Listener);
        OBJ_pnl.BTN_nuevo.addActionListener(Listener);
        return Listener;
    }

    public KeyListener evento_press(pnl_opciones_1 OBJ_pnl, KeyListener KeyEvnt) {
        OBJ_pnl.BTN_cancelar.addKeyListener(KeyEvnt);
        OBJ_pnl.BTN_guardar.addKeyListener(KeyEvnt);
        OBJ_pnl.BTN_nuevo.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
