package JAVA.CONFIG.LOGICA;

public class cbx_familia {

    String ls_nombre,ls_codigo;

    public cbx_familia(String ls_codigo, String ls_nombre) {
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
