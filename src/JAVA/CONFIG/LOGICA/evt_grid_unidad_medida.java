package JAVA.CONFIG.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.pnl_grid_unidad_medida;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class evt_grid_unidad_medida {

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
            lq_rs = go_dao_unidad_medida.SLT_datos_unidad_medida("%");
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
                    a++;
                } while (lq_rs.next());
            }
        } catch (Exception e) {
        }
    }
    public KeyListener evento_press(pnl_grid_unidad_medida OBJ_pnl, KeyListener KeyEvnt) {
        OBJ_pnl.TXT_dato.addKeyListener(KeyEvnt);     
        OBJ_pnl.TBL_unidad_medida.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
