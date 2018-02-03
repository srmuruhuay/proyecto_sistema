package JAVA.ANCEST.LOGICA;

import JAVA.ANCEST.DAO.*;
import JAVA.ANCEST.GUI.frm_principal;
import JAVA.CONFIG.BEAN.BEAN_general;
import JAVA.CONFIG.DAO.*;
import JAVA.CONFIG.GUI.dlg_busq_ubigeo;
import JAVA.CONFIG.GUI.dlg_editar_almacen;
import JAVA.CONFIG.GUI.dlg_editar_familia;
import JAVA.CONFIG.GUI.dlg_editar_grupo;
import JAVA.CONFIG.GUI.dlg_editar_marca;
import JAVA.CONFIG.GUI.dlg_editar_subfamilia;
import JAVA.CONFIG.GUI.dlg_editar_sucursal;
import JAVA.CONFIG.GUI.dlg_editar_tipo_documento;
import JAVA.CONFIG.GUI.dlg_editar_tipo_movimiento;
import JAVA.CONFIG.GUI.dlg_editar_unidad_medida;
import JAVA.CONFIG.GUI.dlg_editar_usuario;
import JAVA.CONFIG.GUI.jif_almacen;
import JAVA.CONFIG.GUI.jif_familia;
import JAVA.CONFIG.GUI.jif_grupo;
import JAVA.CONFIG.GUI.jif_marca;
import JAVA.CONFIG.GUI.jif_modulo_config;
import JAVA.CONFIG.GUI.jif_producto;
import JAVA.CONFIG.GUI.jif_subfamilia;
import JAVA.CONFIG.GUI.jif_sucursal;
import JAVA.CONFIG.GUI.jif_tipo_documento;
import JAVA.CONFIG.GUI.jif_tipo_movimiento;
import JAVA.CONFIG.GUI.jif_unidad_medida;
import JAVA.CONFIG.GUI.jif_usuario;
import JAVA.CONFIG.LOGICA.muestra_jif_config;
import JAVA.CONFIG.LOGICA.muestra_jif_principal;
import JAVA.UTILITARIOS.CONEXION.CONEXION_db;
import JAVA.UTILITARIOS.FUNCION.*;

public class variables_globales {

    //CONEXION    
    public static CONEXION_db go_conexion_db = new CONEXION_db();

    //BEAN
    public static BEAN_general go_bean_general = new BEAN_general();

    //VARIABLES
    public static String gs_periodo,
            gs_nombre_usuario,
            gs_datos_usuario,
            gs_nombre_rol,
            gs_entidad_usuario,
            gs_vendedor_usuario,
            gs_direccion_ip,
            gs_nombre_pc,
            gs_direccion_mac,
            gs_mes,
            gs_dia,
            gs_db;
    public static int gi_id_usuario,
            gi_id_rol;
    public static String[] gs_parametros = new String[99999];

    //GUI
    public static frm_principal go_frm_principal;

    //FUNCIONES
    public static fnc_opera_campos go_fnc_opera_campos = new fnc_opera_campos();
    public static fnc_mensaje go_fnc_mensaje = new fnc_mensaje();
    public static fnc_cierra_sistema go_fnc_cierra_sistema = new fnc_cierra_sistema();
    public static fnc_finaliza_conexion go_fnc_finaliza_conexion = new fnc_finaliza_conexion();
    public static fnc_ayuda go_fnc_ayuda = new fnc_ayuda();
    public static fnc_filtrar_tablas go_fnc_filtrar_tablas = new fnc_filtrar_tablas();

    //CLASES
    public static muestra_jif_principal go_muestra_jif_principal = new muestra_jif_principal();
    public static muestra_jif_config go_muestra_jif_config = new muestra_jif_config();
    public static cbx_trato_datos go_cbx_trato_datos = new cbx_trato_datos();
    public static evt_exportar go_evt_exportar = new evt_exportar();
    public static activa_buscador go_activa_buscador = new activa_buscador();

    //DAO
    public static DAO_periodo go_dao_periodo = new DAO_periodo();
    public static DAO_usuario go_dao_usuario = new DAO_usuario();
    public static DAO_general go_dao_general = new DAO_general();
    public static DAO_rol go_dao_rol = new DAO_rol();
    public static DAO_sucursal go_dao_sucursal = new DAO_sucursal();
    public static DAO_ubigeo go_dao_ubigeo = new DAO_ubigeo();
    public static DAO_almacen go_dao_almacen = new DAO_almacen();
    public static DAO_tabla_sunat go_dao_tabla_sunat = new DAO_tabla_sunat();
    public static DAO_tipo_movimiento go_dao_tipo_movimiento = new DAO_tipo_movimiento();
    public static DAO_tipo_documento go_dao_tipo_documento = new DAO_tipo_documento();
    public static DAO_unidad_medida go_dao_unidad_medida = new DAO_unidad_medida();
    public static DAO_grupo go_dao_grupo = new DAO_grupo();
    public static DAO_marca go_dao_marca = new DAO_marca();
    public static DAO_familia go_dao_familia = new DAO_familia();
    public static DAO_subfamilia go_dao_subfamilia = new DAO_subfamilia();

    //JIF
    public static jif_modulo_config go_jif_modulo_config;
    public static jif_usuario go_jif_usuario;
    public static jif_sucursal go_jif_sucursal;
    public static jif_almacen go_jif_almacen;
    public static jif_tipo_movimiento go_jif_tipo_movimiento;
    public static jif_tipo_documento go_jif_tipo_documento;
    public static jif_producto go_jif_producto;
    public static jif_unidad_medida go_jif_unidad_medida;
    public static jif_grupo go_jif_grupo;
    public static jif_marca go_jif_marca;
    public static jif_familia go_jif_familia;
    public static jif_subfamilia go_jif_subfamilia;

    //DLG
    public static dlg_editar_usuario go_dlg_editar_usuario;
    public static dlg_busq_ubigeo go_dlg_busq_ubigeo;
    public static dlg_editar_sucursal go_dlg_editar_sucursal;
    public static dlg_editar_almacen go_dlg_editar_almacen;
    public static dlg_editar_tipo_movimiento go_dlg_editar_tipo_movimiento;
    public static dlg_editar_tipo_documento go_dlg_editar_tipo_documento;
    public static dlg_editar_unidad_medida go_dlg_editar_unidad_medida;
    public static dlg_editar_grupo go_dlg_editar_grupo;
    public static dlg_editar_marca go_dlg_editar_marca;
    public static dlg_editar_familia go_dlg_editar_familia;
    public static dlg_editar_subfamilia go_dlg_editar_subfamilia;
}
