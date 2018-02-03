package JAVA.CONFIG.GUI;

import static JAVA.ANCEST.LOGICA.variables_globales.*;

public class pnl_grid_busq_ubigeo extends javax.swing.JPanel {

    public pnl_grid_busq_ubigeo() {
        initComponents();
        go_fnc_opera_campos.ancho_columna(TBL_ubigeo, 4, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_ubigeo = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int colum){
                return false;
            }
        };

        TBL_ubigeo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_ubigeo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Distrito", "Provincia", "Departamento", "descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_ubigeo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_ubigeo);
        if (TBL_ubigeo.getColumnModel().getColumnCount() > 0) {
            TBL_ubigeo.getColumnModel().getColumn(0).setResizable(false);
            TBL_ubigeo.getColumnModel().getColumn(0).setPreferredWidth(30);
            TBL_ubigeo.getColumnModel().getColumn(1).setResizable(false);
            TBL_ubigeo.getColumnModel().getColumn(1).setPreferredWidth(150);
            TBL_ubigeo.getColumnModel().getColumn(2).setResizable(false);
            TBL_ubigeo.getColumnModel().getColumn(2).setPreferredWidth(120);
            TBL_ubigeo.getColumnModel().getColumn(3).setResizable(false);
            TBL_ubigeo.getColumnModel().getColumn(3).setPreferredWidth(80);
            TBL_ubigeo.getColumnModel().getColumn(4).setResizable(false);
            TBL_ubigeo.getColumnModel().getColumn(4).setPreferredWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_ubigeo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
