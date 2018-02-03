package JAVA.CONFIG.LOGICA;

public class cbx_sucursal {

    String ls_codigo, ls_nombre;

    public cbx_sucursal(String ls_codigo, String ls_nombre) {
        this.ls_codigo = ls_codigo;
        this.ls_nombre = ls_nombre;
    }

    public String getID() {
        return ls_codigo;
    }

    public String toString() {
        return ls_nombre;
    }
}
