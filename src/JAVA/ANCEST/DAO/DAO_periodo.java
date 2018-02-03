package JAVA.ANCEST.DAO;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_periodo {

    private Statement lq_stm = null;
    private ResultSet lq_rs = null;
    private String ls_modulo = "ANCEST", ls_capa = "DAO", ls_clase = "DAO_periodo";
    
    public ResultSet SLT_perido() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            lq_rs = lq_stm.executeQuery("select * from slt_periodo() as (periodo character(4))");
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "SLT_datos_x_empresa", "TABLA NO CONTIENE DATOS");
            }
        } catch (SQLException e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "SLT_perido", e.getMessage());
        }
        return null;
    }
}
