package JAVA.CONFIG.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.pnl_grid_almacen;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class evt_grid_almacen {

    ResultSet lq_rs;

    public void limpia_tabla(DefaultTableModel modelo) {
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void datos_tabla(DefaultTableModel modelo) {
        limpia_tabla(modelo);
        int a = 0;
        try {
            lq_rs = go_dao_almacen.SLT_datos_almacen("%");
            if (lq_rs != null) {
                do {
                    modelo.addRow(new Object[]{""});
                    modelo.setValueAt(lq_rs.getString(1), a, 0);
                    modelo.setValueAt(lq_rs.getString(3), a, 1);
                    modelo.setValueAt(lq_rs.getString(4), a, 2);
                    modelo.setValueAt(lq_rs.getString(5), a, 3);
                    modelo.setValueAt(lq_rs.getString(6), a, 4);
                    modelo.setValueAt(lq_rs.getString(7), a, 5);
                    modelo.setValueAt(lq_rs.getString(8), a, 6);
                    modelo.setValueAt(lq_rs.getString(9), a, 7);
                    modelo.setValueAt(lq_rs.getString(10), a, 8);
                    modelo.setValueAt(lq_rs.getString(11), a, 9);
                    a++;
                } while (lq_rs.next());
            }
        } catch (Exception e) {
        }
    }
    public KeyListener evento_press(pnl_grid_almacen OBJ_pnl, KeyListener KeyEvnt) {
        OBJ_pnl.TXT_dato.addKeyListener(KeyEvnt);     
        OBJ_pnl.TBL_almacen.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
