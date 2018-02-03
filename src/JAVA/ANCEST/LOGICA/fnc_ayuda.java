package JAVA.ANCEST.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class fnc_ayuda {

    ResultSet lq_rs;

    public void cbx_anio(JComboBox cbx_periodo) {
        try {
            lq_rs = go_dao_periodo.SLT_perido();
            if(lq_rs != null){
                do {                    
                    cbx_periodo.addItem(lq_rs.getString(1));
                } while (lq_rs.next());
            }
        } catch (Exception e) {
        }
    }

}
