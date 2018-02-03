package JAVA.CONFIG.GUI;

import JAVA.ANCEST.LOGICA.evt_focus_general;
import static JAVA.ANCEST.LOGICA.variables_globales.*;
import JAVA.UTILITARIOS.FUNCION.fnc_txt_mayuscula;

public class pnl_grid_usuario extends javax.swing.JPanel {

    public pnl_grid_usuario() {
        initComponents();
        TXT_dato.addFocusListener(new evt_focus_general());
        TXT_dato.setDocument(new fnc_txt_mayuscula());

        go_fnc_opera_campos.ancho_columna(TBL_usuario, 0, 20);
        go_fnc_opera_campos.ancho_columna(TBL_usuario, 1, 80);
        go_fnc_opera_campos.ancho_columna(TBL_usuario, 2, 0);
        go_fnc_opera_campos.ancho_columna(TBL_usuario, 3, 140);
        go_fnc_opera_campos.ancho_columna(TBL_usuario, 4, 0);
        go_fnc_opera_campos.ancho_columna(TBL_usuario, 5, 0);
        go_fnc_opera_campos.ancho_columna(TBL_usuario, 6, 0);
        go_fnc_opera_campos.ancho_columna(TBL_usuario, 7, 0);
        go_fnc_opera_campos.ancho_columna(TBL_usuario, 8, 120);
        go_fnc_opera_campos.ancho_columna(TBL_usuario, 9, 80);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_usuario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        TXT_dato = new javax.swing.JTextField();

        TBL_usuario.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "clave_usuario", "Nombre", "id_rol", "status", "codigo_entidad", "codigo_vendedor", "Rol", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TBL_usuario);
        if (TBL_usuario.getColumnModel().getColumnCount() > 0) {
            TBL_usuario.getColumnModel().getColumn(0).setResizable(false);
            TBL_usuario.getColumnModel().getColumn(1).setResizable(false);
            TBL_usuario.getColumnModel().getColumn(2).setResizable(false);
            TBL_usuario.getColumnModel().getColumn(3).setResizable(false);
            TBL_usuario.getColumnModel().getColumn(4).setResizable(false);
            TBL_usuario.getColumnModel().getColumn(5).setResizable(false);
            TBL_usuario.getColumnModel().getColumn(6).setResizable(false);
            TBL_usuario.getColumnModel().getColumn(7).setResizable(false);
            TBL_usuario.getColumnModel().getColumn(8).setResizable(false);
            TBL_usuario.getColumnModel().getColumn(9).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setText("Buscar :");

        TXT_dato.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TXT_dato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_dato, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXT_dato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 135, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_usuario;
    public javax.swing.JTextField TXT_dato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
