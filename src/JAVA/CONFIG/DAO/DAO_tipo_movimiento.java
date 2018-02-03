package JAVA.CONFIG.DAO;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_tipo_movimiento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_tipo_movimiento {

    private Statement lq_stm = null;
    private ResultSet lq_rs = null;
    private String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_almacen";

    public ResultSet SLT_datos_tipo_movimiento(String codigo_movimiento) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_tipo_movimiento('" + codigo_movimiento + "') "
                    + "as (codigo_movimiento character(2),fecha_registro timestamp with time zone,descripcion character varying(100),categoria character(3),codigo_sunat character varying(20),tipo_movimiento character(1),es_transferencia character(1),codigo_almacen_ref character(4),tipo_almacen character(1),status character(1),tm text,estado text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_tipo_movimiento", e.getMessage());
        }
        return null;
    }

    public boolean IST_tipo_movimiento(BEAN_tipo_movimiento OBJ_btm) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_tipo_movimiento('" + OBJ_btm.getCodigo_movimiento() + "','" + OBJ_btm.getDescripcion() + "','" + OBJ_btm.getCategoria() + "','" + OBJ_btm.getCodigo_sunat() + "','" + OBJ_btm.getTipo_movimiento() + "','" + OBJ_btm.getEs_transferencia() + "','" + OBJ_btm.getCodigo_almacen_ref() + "','" + OBJ_btm.getTipo_almacen() + "','" + OBJ_btm.getStatus() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_tipo_movimiento", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_tipo_movimiento", e.getMessage());
        }
        return resp;
    }

    public boolean DLT_tipo_movimiento(String codigo) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_tipo_movimiento('" + codigo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_tipo_movimiento", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_tipo_movimiento", e.getMessage());
        }
        return resp;
    }
    
    public boolean UPD_tipo_movimiento(BEAN_tipo_movimiento OBJ_btm) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_tipo_movimiento('" + OBJ_btm.getCodigo_movimiento() + "','" + OBJ_btm.getDescripcion() + "','"+OBJ_btm.getCategoria()+"','" + OBJ_btm.getCodigo_sunat() + "','" + OBJ_btm.getTipo_movimiento() + "','" + OBJ_btm.getEs_transferencia() + "','" + OBJ_btm.getCodigo_almacen_ref() + "','" + OBJ_btm.getTipo_almacen() + "','" + OBJ_btm.getStatus() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_tipo_movimiento", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_tipo_movimiento", e.getMessage());
        }
        return resp;
    }
}
