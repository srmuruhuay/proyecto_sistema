package JAVA.CONFIG.GUI;

import JAVA.ANCEST.GUI.pnl_opciones_1;
import JAVA.ANCEST.GUI.pnl_opciones_2;
import static JAVA.ANCEST.LOGICA.variables_globales.*;

public class jif_producto extends javax.swing.JInternalFrame {

    pnl_datos_articulo lo_pnl_datos_articulo = new pnl_datos_articulo();
    pnl_grid_articulo lo_pnl_grid_articulo = new pnl_grid_articulo();
    pnl_opciones_1 lo_pnl_opciones_1 = new pnl_opciones_1();
    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();

    public jif_producto() {
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_datos_articulo.setBounds(10, 0, 500, 507);
        lo_pnl_opciones_1.setBounds(212, 497, 300, 100);
        lo_pnl_grid_articulo.setBounds(515, 6, 600, 500);
        lo_pnl_opciones_2.setBounds(570, 497, 600, 200);

        PNL_datos.add(lo_pnl_datos_articulo);
        PNL_datos.add(lo_pnl_opciones_1);
        PNL_datos.add(lo_pnl_grid_articulo);
        PNL_datos.add(lo_pnl_opciones_2);

        lo_pnl_grid_articulo.TXT_dato.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDP_config = new javax.swing.JDesktopPane();
        PNL_datos = new javax.swing.JPanel();
        MNB_config = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        M_D_A = new javax.swing.JMenuItem();
        M_D_B = new javax.swing.JMenuItem();
        M_D_C = new javax.swing.JMenuItem();
        M_D_D = new javax.swing.JMenuItem();
        M_D_E = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setTitle("PRODUCTO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/form.png"))); // NOI18N

        JDP_config.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout PNL_datosLayout = new javax.swing.GroupLayout(PNL_datos);
        PNL_datos.setLayout(PNL_datosLayout);
        PNL_datosLayout.setHorizontalGroup(
            PNL_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 976, Short.MAX_VALUE)
        );
        PNL_datosLayout.setVerticalGroup(
            PNL_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );

        JDP_config.setLayer(PNL_datos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDP_configLayout = new javax.swing.GroupLayout(JDP_config);
        JDP_config.setLayout(JDP_configLayout);
        JDP_configLayout.setHorizontalGroup(
            JDP_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDP_configLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(PNL_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        JDP_configLayout.setVerticalGroup(
            JDP_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDP_configLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(PNL_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jMenu3.setText("Caracteristicas");

        M_D_A.setText("Unidad Medida");
        M_D_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_D_AActionPerformed(evt);
            }
        });
        jMenu3.add(M_D_A);

        M_D_B.setText("Grupo");
        M_D_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_D_BActionPerformed(evt);
            }
        });
        jMenu3.add(M_D_B);

        M_D_C.setText("Marca");
        M_D_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_D_CActionPerformed(evt);
            }
        });
        jMenu3.add(M_D_C);

        M_D_D.setText("Familia");
        M_D_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_D_DActionPerformed(evt);
            }
        });
        jMenu3.add(M_D_D);

        M_D_E.setText("Sub Familia");
        M_D_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_D_EActionPerformed(evt);
            }
        });
        jMenu3.add(M_D_E);

        MNB_config.add(jMenu3);

        setJMenuBar(MNB_config);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDP_config)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JDP_config, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void M_D_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_D_BActionPerformed
        try {
            go_muestra_jif_config.muestra_jif_grupo();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_M_D_BActionPerformed

    private void M_D_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_D_CActionPerformed
        try {
            go_muestra_jif_config.muestra_jif_marca();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_M_D_CActionPerformed

    private void M_D_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_D_AActionPerformed
        try {
            go_muestra_jif_config.muestra_jif_unidad_medida();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_M_D_AActionPerformed

    private void M_D_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_D_DActionPerformed
        try {
            go_muestra_jif_config.muestra_jif_familia();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_M_D_DActionPerformed

    private void M_D_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_D_EActionPerformed
        try {
            go_muestra_jif_config.muestra_jif_subfamilia();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_M_D_EActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane JDP_config;
    private javax.swing.JMenuBar MNB_config;
    private javax.swing.JMenuItem M_D_A;
    private javax.swing.JMenuItem M_D_B;
    private javax.swing.JMenuItem M_D_C;
    private javax.swing.JMenuItem M_D_D;
    private javax.swing.JMenuItem M_D_E;
    private javax.swing.JPanel PNL_datos;
    private javax.swing.JMenu jMenu3;
    // End of variables declaration//GEN-END:variables
}
