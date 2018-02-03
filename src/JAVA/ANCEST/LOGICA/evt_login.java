package JAVA.ANCEST.LOGICA;

import JAVA.ANCEST.GUI.pnl_login;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class evt_login {

    public ActionListener evento_click(pnl_login OBJ_pnl, ActionListener Listener) {
        OBJ_pnl.BTN_login.addActionListener(Listener);
        return Listener;
    }

    public KeyListener evento_press(pnl_login OBJ_pnl, KeyListener KeyEvnt) {
        OBJ_pnl.CBX_periodo.addKeyListener(KeyEvnt);
        OBJ_pnl.TXT_usuario.addKeyListener(KeyEvnt);
        OBJ_pnl.TXT_contrasenia.addKeyListener(KeyEvnt);
        OBJ_pnl.BTN_login.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

}
