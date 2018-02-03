package JAVA.CONFIG.DAO;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_general {

    Statement lq_stm = null;
    ResultSet lq_rs = null;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_general";

    public void SLT_datos() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_general() "
                    + "as (ruc character(11),fecha_registro timestamp with time zone,razon_social character varying(150),giro character varying(150),direccion character varying(150),codigo_ubigeo character(6) ,    descripcion_ubigeo character varying(100) ,    telefono character varying(20),fax character varying(20),e_mail character varying(60),website character varying(60),nombre_reporte character varying(60),fecha_actividad date,codigo_moneda character(3))";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                go_bean_general.setRuc(lq_rs.getString(1));
                go_bean_general.setFecha_registro(go_fnc_opera_campos.recupera_fecha_formato(lq_rs.getString(2).substring(0, 10)) + " " + lq_rs.getString(2).substring(11));
                go_bean_general.setRazon_social(lq_rs.getString(3));
                go_bean_general.setGiro(lq_rs.getString(4));
                go_bean_general.setDireccion(lq_rs.getString(5));
                go_bean_general.setCodigo_ubigeo(lq_rs.getString(6));
                go_bean_general.setDescripcion_ubigeo(lq_rs.getString(7));
                go_bean_general.setTelefono(lq_rs.getString(8));
                go_bean_general.setFax(lq_rs.getString(9));
                go_bean_general.setE_mail(lq_rs.getString(10));
                go_bean_general.setWebsite(lq_rs.getString(11));
                go_bean_general.setNombre_reporte(lq_rs.getString(12));
                go_bean_general.setFecha_actividad(go_fnc_opera_campos.recupera_fecha_formato((lq_rs.getString(13))));
                go_bean_general.setCodigo_moneda(lq_rs.getString(14));
            } else {
                go_fnc_mensaje.GET_mensaje(gi_id_rol, ls_modulo, ls_capa, ls_clase, "SLT_datos", "TABLA NO CONTIENE DATOS");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(gi_id_rol, ls_modulo, ls_capa, ls_clase, "SLT_datos", e.getMessage());
        }
    }
}
