package JAVA.CONFIG.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.jif_almacen;
import JAVA.CONFIG.GUI.jif_familia;
import JAVA.CONFIG.GUI.jif_grupo;
import JAVA.CONFIG.GUI.jif_marca;
import JAVA.CONFIG.GUI.jif_producto;
import JAVA.CONFIG.GUI.jif_subfamilia;
import JAVA.CONFIG.GUI.jif_sucursal;
import JAVA.CONFIG.GUI.jif_tipo_documento;
import JAVA.CONFIG.GUI.jif_tipo_movimiento;
import JAVA.CONFIG.GUI.jif_unidad_medida;
import JAVA.CONFIG.GUI.jif_usuario;
import java.beans.PropertyVetoException;

public class muestra_jif_config {

    public void muestra_jif_usuario() throws PropertyVetoException {
        if (go_jif_usuario != null) {
            if (go_jif_usuario.isClosed()) {
                go_jif_usuario = new jif_usuario();
                go_jif_modulo_config.JDP_config.add(go_jif_usuario);
                go_jif_usuario.show();

            } else if (go_jif_usuario.isIcon()) {
                go_jif_usuario.setIcon(false);
            } else if (!go_jif_usuario.isShowing()) {
                go_jif_usuario = new jif_usuario();
                go_jif_modulo_config.JDP_config.add(go_jif_usuario);
                go_jif_usuario.show();
            }
        } else {
            go_jif_usuario = new jif_usuario();
            go_jif_modulo_config.JDP_config.add(go_jif_usuario);
            go_jif_usuario.show();
        }
    }

    public void muestra_jif_sucursal() throws PropertyVetoException {
        if (go_jif_sucursal != null) {
            if (go_jif_sucursal.isClosed()) {
                go_jif_sucursal = new jif_sucursal();
                go_jif_modulo_config.JDP_config.add(go_jif_sucursal);
                go_jif_sucursal.show();

            } else if (go_jif_sucursal.isIcon()) {
                go_jif_sucursal.setIcon(false);
            } else if (!go_jif_sucursal.isShowing()) {
                go_jif_sucursal = new jif_sucursal();
                go_jif_modulo_config.JDP_config.add(go_jif_sucursal);
                go_jif_sucursal.show();
            }
        } else {
            go_jif_sucursal = new jif_sucursal();
            go_jif_modulo_config.JDP_config.add(go_jif_sucursal);
            go_jif_sucursal.show();
        }
    }

    public void muestra_jif_almacen() throws PropertyVetoException {
        if (go_jif_almacen != null) {
            if (go_jif_almacen.isClosed()) {
                go_jif_almacen = new jif_almacen();
                go_jif_modulo_config.JDP_config.add(go_jif_almacen);
                go_jif_almacen.show();

            } else if (go_jif_almacen.isIcon()) {
                go_jif_almacen.setIcon(false);
            } else if (!go_jif_almacen.isShowing()) {
                go_jif_almacen = new jif_almacen();
                go_jif_modulo_config.JDP_config.add(go_jif_almacen);
                go_jif_almacen.show();
            }
        } else {
            go_jif_almacen = new jif_almacen();
            go_jif_modulo_config.JDP_config.add(go_jif_almacen);
            go_jif_almacen.show();
        }
    }

    public void muestra_jif_tipo_movimiento() throws PropertyVetoException {
        if (go_jif_tipo_movimiento != null) {
            if (go_jif_tipo_movimiento.isClosed()) {
                go_jif_tipo_movimiento = new jif_tipo_movimiento();
                go_jif_modulo_config.JDP_config.add(go_jif_tipo_movimiento);
                go_jif_tipo_movimiento.show();

            } else if (go_jif_tipo_movimiento.isIcon()) {
                go_jif_tipo_movimiento.setIcon(false);
            } else if (!go_jif_tipo_movimiento.isShowing()) {
                go_jif_tipo_movimiento = new jif_tipo_movimiento();
                go_jif_modulo_config.JDP_config.add(go_jif_tipo_movimiento);
                go_jif_tipo_movimiento.show();
            }
        } else {
            go_jif_tipo_movimiento = new jif_tipo_movimiento();
            go_jif_modulo_config.JDP_config.add(go_jif_tipo_movimiento);
            go_jif_tipo_movimiento.show();
        }
    }

    public void muestra_jif_tipo_documento() throws PropertyVetoException {
        if (go_jif_tipo_documento != null) {
            if (go_jif_tipo_documento.isClosed()) {
                go_jif_tipo_documento = new jif_tipo_documento();
                go_jif_modulo_config.JDP_config.add(go_jif_tipo_documento);
                go_jif_tipo_documento.show();

            } else if (go_jif_tipo_documento.isIcon()) {
                go_jif_tipo_documento.setIcon(false);
            } else if (!go_jif_tipo_documento.isShowing()) {
                go_jif_tipo_documento = new jif_tipo_documento();
                go_jif_modulo_config.JDP_config.add(go_jif_tipo_documento);
                go_jif_tipo_documento.show();
            }
        } else {
            go_jif_tipo_documento = new jif_tipo_documento();
            go_jif_modulo_config.JDP_config.add(go_jif_tipo_documento);
            go_jif_tipo_documento.show();
        }
    }

    public void muestra_jif_producto() throws PropertyVetoException {
        if (go_jif_producto != null) {
            if (go_jif_producto.isClosed()) {
                go_jif_producto = new jif_producto();
                go_frm_principal.JDP_principal.add(go_jif_producto);
                go_jif_producto.show();

            } else if (go_jif_producto.isIcon()) {
                go_jif_producto.setIcon(false);
            } else if (!go_jif_producto.isShowing()) {
                go_jif_producto = new jif_producto();
                go_frm_principal.JDP_principal.add(go_jif_producto);
                go_jif_producto.show();
            }
        } else {
            go_jif_producto = new jif_producto();
            go_frm_principal.JDP_principal.add(go_jif_producto);
            go_jif_producto.show();
        }
    }

    public void muestra_jif_unidad_medida() throws PropertyVetoException {
        if (go_jif_unidad_medida != null) {
            if (go_jif_unidad_medida.isClosed()) {
                go_jif_unidad_medida = new jif_unidad_medida();
                go_jif_producto.JDP_config.add(go_jif_unidad_medida);
                go_jif_unidad_medida.show();

            } else if (go_jif_unidad_medida.isIcon()) {
                go_jif_unidad_medida.setIcon(false);
            } else if (!go_jif_unidad_medida.isShowing()) {
                go_jif_unidad_medida = new jif_unidad_medida();
                go_jif_producto.JDP_config.add(go_jif_unidad_medida);
                go_jif_unidad_medida.show();
            }
        } else {
            go_jif_unidad_medida = new jif_unidad_medida();
            go_jif_producto.JDP_config.add(go_jif_unidad_medida);
            go_jif_unidad_medida.show();
        }
    }

    public void muestra_jif_grupo() throws PropertyVetoException {
        if (go_jif_grupo != null) {
            if (go_jif_grupo.isClosed()) {
                go_jif_grupo = new jif_grupo();
                go_jif_producto.JDP_config.add(go_jif_grupo);
                go_jif_grupo.show();

            } else if (go_jif_grupo.isIcon()) {
                go_jif_grupo.setIcon(false);
            } else if (!go_jif_grupo.isShowing()) {
                go_jif_grupo = new jif_grupo();
                go_jif_producto.JDP_config.add(go_jif_grupo);
                go_jif_grupo.show();
            }
        } else {
            go_jif_grupo = new jif_grupo();
            go_jif_producto.JDP_config.add(go_jif_grupo);
            go_jif_grupo.show();
        }
    }

    public void muestra_jif_marca() throws PropertyVetoException {
        if (go_jif_marca != null) {
            if (go_jif_marca.isClosed()) {
                go_jif_marca = new jif_marca();
                go_jif_producto.JDP_config.add(go_jif_marca);
                go_jif_marca.show();

            } else if (go_jif_marca.isIcon()) {
                go_jif_marca.setIcon(false);
            } else if (!go_jif_marca.isShowing()) {
                go_jif_marca = new jif_marca();
                go_jif_producto.JDP_config.add(go_jif_marca);
                go_jif_marca.show();
            }
        } else {
            go_jif_marca = new jif_marca();
            go_jif_producto.JDP_config.add(go_jif_marca);
            go_jif_marca.show();
        }
    }

    public void muestra_jif_familia() throws PropertyVetoException {
        if (go_jif_familia != null) {
            if (go_jif_familia.isClosed()) {
                go_jif_familia = new jif_familia();
                go_jif_producto.JDP_config.add(go_jif_familia);
                go_jif_familia.show();

            } else if (go_jif_familia.isIcon()) {
                go_jif_familia.setIcon(false);
            } else if (!go_jif_familia.isShowing()) {
                go_jif_familia = new jif_familia();
                go_jif_producto.JDP_config.add(go_jif_familia);
                go_jif_familia.show();
            }
        } else {
            go_jif_familia = new jif_familia();
            go_jif_producto.JDP_config.add(go_jif_familia);
            go_jif_familia.show();
        }
    }
    
    public void muestra_jif_subfamilia() throws PropertyVetoException {
        if (go_jif_subfamilia != null) {
            if (go_jif_subfamilia.isClosed()) {
                go_jif_subfamilia = new jif_subfamilia();
                go_jif_producto.JDP_config.add(go_jif_subfamilia);
                go_jif_subfamilia.show();

            } else if (go_jif_subfamilia.isIcon()) {
                go_jif_subfamilia.setIcon(false);
            } else if (!go_jif_subfamilia.isShowing()) {
                go_jif_subfamilia = new jif_subfamilia();
                go_jif_producto.JDP_config.add(go_jif_subfamilia);
                go_jif_subfamilia.show();
            }
        } else {
            go_jif_subfamilia = new jif_subfamilia();
            go_jif_producto.JDP_config.add(go_jif_subfamilia);
            go_jif_subfamilia.show();
        }
    }
    
}
