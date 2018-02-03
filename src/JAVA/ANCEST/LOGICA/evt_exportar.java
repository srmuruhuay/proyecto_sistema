
package JAVA.ANCEST.LOGICA;

import static JAVA.ANCEST.LOGICA.variables_globales.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class evt_exportar {
    
    String ls_modulo = "ANCEST", ls_capa = "LOGICA", ls_clase = "evt_exportar";
    
    public void exportar(JTable table){
        if (table.getRowCount() > 0) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                List tb = new ArrayList();
                List nom = new ArrayList();
                tb.add(table);
                nom.add("REPORT");
                String file = chooser.getSelectedFile().toString().concat(".xls");
                try {
                    genera_excel e = new genera_excel(new File(file), tb, nom);
                    if (e.export()) {
                        go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "evt_exportar", "SE GENERO EXCEL");
                    }
                } catch (Exception e) {
                     go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_exportar", e.getMessage());
                }
            }
        }
    }
    
}
