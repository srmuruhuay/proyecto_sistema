package JAVA.CONFIG.DAO;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_tipo_documento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_tipo_documento {

    private Statement lq_stm = null;
    private ResultSet lq_rs = null;
    private String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_tipo_documento";

    public ResultSet SLT_datos_tipo_documento(String codigo_documento) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_tipo_documento('" + codigo_documento + "') "
                    + "as (codigo_documento character(2),fecha_registro timestamp with time zone,descripcion character varying(60),tipo_movimiento character(1),status character(1),categoria character(3),codigo_sunat character varying(20),tm text,estado text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_tipo_documento", e.getMessage());
        }
        return null;
    }

    public boolean IST_tipo_documento(BEAN_tipo_documento OBJ_btm) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_tipo_documento('" + OBJ_btm.getCodigo_documento() + "','" + OBJ_btm.getNombre_documento() + "','" + OBJ_btm.getTipo_movimiento() + "','" + OBJ_btm.getStatus() + "','" + OBJ_btm.getCategoria() + "','" + OBJ_btm.getCodigo_sunat() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_tipo_documento", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_tipo_documento", e.getMessage());
        }
        return resp;
    }

    public boolean DLT_tipo_documento(String codigo) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_tipo_documento('" + codigo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_tipo_documento", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_tipo_documento", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_tipo_documento(BEAN_tipo_documento OBJ_btm) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_tipo_documento('" + OBJ_btm.getCodigo_documento() + "','" + OBJ_btm.getNombre_documento() + "','" + OBJ_btm.getTipo_movimiento() + "','" + OBJ_btm.getStatus() + "','" + OBJ_btm.getCategoria() + "','" + OBJ_btm.getCodigo_sunat() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_tipo_documento", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_tipo_documento", e.getMessage());
        }
        return resp;
    }
}
