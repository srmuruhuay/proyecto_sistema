package JAVA.CONFIG.DAO;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_grupo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_grupo {

    private Statement lq_stm = null;
    private ResultSet lq_rs = null;
    private String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_grupo";

    public ResultSet FNC_codigo_grupo() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_codigo_grupo() as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_codigo_grupo", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_grupo(String codigo_grupo) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_grupo('" + codigo_grupo + "') "
                    + "as (codigo_producto character(4),fecha_registro timestamp with time zone,nombre_grupo character varying(60))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_producto_grupo", e.getMessage());
        }
        return null;
    }

    public boolean IST_grupo(BEAN_grupo OBJ_bal) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_grupo('" + OBJ_bal.getCodigo_producto() + "',$$" + OBJ_bal.getNombre_producto() + "$$)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_producto", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_grupo", e.getMessage());
        }
        return resp;
    }

    public boolean DLT_grupo(String codigo_producto) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_grupo('" + codigo_producto + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_grupo", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_grupo", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_grupo(BEAN_grupo OBJ_bal) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_grupo('" + OBJ_bal.getCodigo_producto() + "',$$" + OBJ_bal.getNombre_producto() + "$$)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_grupo", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_grupo", e.getMessage());
        }
        return resp;
    }
}
