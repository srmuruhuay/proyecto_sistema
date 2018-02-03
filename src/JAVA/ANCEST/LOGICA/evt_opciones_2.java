package JAVA.ANCEST.LOGICA;

import JAVA.ANCEST.GUI.pnl_opciones_2;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class evt_opciones_2 {

    public ActionListener evento_click(pnl_opciones_2 OBJ_pnl, ActionListener Listener) {
        OBJ_pnl.BTN_editar.addActionListener(Listener);
        OBJ_pnl.BTN_eliminar.addActionListener(Listener);
        OBJ_pnl.BTN_imprimir.addActionListener(Listener);
        OBJ_pnl.BTN_exportar.addActionListener(Listener);
        return Listener;
    }

    public KeyListener evento_press(pnl_opciones_2 OBJ_pnl, KeyListener KeyEvnt) {
        OBJ_pnl.BTN_editar.addKeyListener(KeyEvnt);
        OBJ_pnl.BTN_eliminar.addKeyListener(KeyEvnt);
        OBJ_pnl.BTN_imprimir.addKeyListener(KeyEvnt);
        OBJ_pnl.BTN_exportar.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
