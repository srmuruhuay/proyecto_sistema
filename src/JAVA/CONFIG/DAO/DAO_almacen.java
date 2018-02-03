package JAVA.CONFIG.DAO;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_almacen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_almacen {

    private Statement lq_stm = null;
    private ResultSet lq_rs = null;
    private String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_almacen";

    public ResultSet FNC_codigo_almacen() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_codigo_almacen() as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_codigo_almacen", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_almacen(String codigo_almacen) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_almacen('" + codigo_almacen + "') "
                    + "as (codigo_almacen character(4),fecha_registro timestamp with time zone,nombre_almacen character varying(100),direccion character varying(150),codigo_ubigeo character(6),descripcion character varying(100),nota character varying(250),status character(1),tipo_almacen character(1),codigo_sucursal character(4),estado text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_almacen", e.getMessage());
        }
        return null;
    }

    public boolean IST_almacen(BEAN_almacen OBJ_bal) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_almacen('" + OBJ_bal.getCodigo_almacen() + "','" + OBJ_bal.getNombre_almacen() + "','" + OBJ_bal.getDireccion() + "','" + OBJ_bal.getCodigo_ubigeo() + "','" + OBJ_bal.getDescripcion_ubigeo() + "','" + OBJ_bal.getNota() + "','" + OBJ_bal.getStatus() + "','" + OBJ_bal.getTipo_almacen() + "','" + OBJ_bal.getCodigo_sucursal() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_almacen", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_almacen", e.getMessage());
        }
        return resp;
    }

    public boolean DLT_almacen(String codigo_almacen) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_almacen('" + codigo_almacen + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_almacen", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_almacen", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_almacen(BEAN_almacen OBJ_bal) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_almacen('" + OBJ_bal.getCodigo_almacen() + "','" + OBJ_bal.getNombre_almacen() + "','" + OBJ_bal.getDireccion() + "','" + OBJ_bal.getCodigo_ubigeo() + "','" + OBJ_bal.getDescripcion_ubigeo() + "','" + OBJ_bal.getNota() + "','" + OBJ_bal.getStatus() + "','" + OBJ_bal.getTipo_almacen() + "','" + OBJ_bal.getCodigo_sucursal() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_almacen", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_almacen", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_cbx_almacen() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cbx_almacen() "
                    + "as (codigo_almacen character(4),nombre character varying(100))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cbx_almacen", e.getMessage());
        }
        return null;
    }

}
