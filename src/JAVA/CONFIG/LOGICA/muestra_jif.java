package JAVA.CONFIG.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.jif_modulo_config;
import java.beans.PropertyVetoException;

public class muestra_jif {

        public void muestra_jif_modulo_config() throws PropertyVetoException {
        if (go_jif_modulo_config != null) {
            if (go_jif_modulo_config.isClosed()) {
                go_jif_modulo_config = new jif_modulo_config();
                go_frm_principal.JDP_principal.add(go_jif_modulo_config);
                go_jif_modulo_config.show();

            } else if (go_jif_modulo_config.isIcon()) {
                go_jif_modulo_config.setIcon(false);
            } else if (!go_jif_modulo_config.isShowing()) {
                go_jif_modulo_config = new jif_modulo_config();
                go_frm_principal.JDP_principal.add(go_jif_modulo_config);
                go_jif_modulo_config.show();
            }
        } else {
            go_jif_modulo_config = new jif_modulo_config();
            go_frm_principal.JDP_principal.add(go_jif_modulo_config);
            go_jif_modulo_config.show();
        }
    }

}
