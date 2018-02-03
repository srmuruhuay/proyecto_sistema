package JAVA.UTILITARIOS.CONEXION;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CONEXION_db {

    Connection lq_con = null;
    Statement lq_stm = null;
    String ls_server, ls_port, ls_nombre;
    String ls_path = new File("").getAbsolutePath();
    String ls_modulo = "UTILITARIOS", ls_capa = "CONEXION", ls_clase = "CONEXION_db";

    public Connection getConexion_db() {
        try {
            Properties lp_p = new Properties();
            lp_p.load(new FileInputStream(ls_path + "\\config.properties"));
            ls_server = lp_p.getProperty("Server_db");
            gs_db = lp_p.getProperty("Nombre_db");;
            ls_port = lp_p.getProperty("Port_db");

            Class.forName("org.postgresql.Driver");
            lq_con = DriverManager.getConnection("jdbc:postgresql://" + ls_server + ":" + ls_port + "/" + gs_db, "postgres", "CaDm1414");
            lq_con.setAutoCommit(false);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "getconexion_db", e.getMessage());
            go_fnc_cierra_sistema.cierra_sistema();
        }
        return lq_con;
    }

    public Statement crearStatement() {
        try {
            getConexion_db();
            lq_stm = lq_con.createStatement();
        } catch (SQLException e) {
        }
        return lq_stm;
    }
}
