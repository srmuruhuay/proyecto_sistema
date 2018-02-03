package JAVA.CONFIG.DAO;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_ubigeo {

    Statement lq_stm = null;
    ResultSet lq_rs = null;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_ubigeo";

    public ResultSet SLT_datos_ubigeo() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_ubigeo() "
                    + "as (codigo_ubigeo character(6),distrito character varying(60),provincia character varying(60),departamente character varying(60),descripcion character varying(100))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_ubigeo", "NO EXISTEN DATOS DE UBIGEO");
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_ubigeo", e.getMessage());
        }
        return null;
    }
}
