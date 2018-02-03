package JAVA.CONFIG.GUI;

import static JAVA.ANCEST.LOGICA.variables_globales.*;

public class jif_modulo_config extends javax.swing.JInternalFrame {

    public jif_modulo_config() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDP_config = new javax.swing.JDesktopPane();
        MNB_config = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        M_A_A = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        M_B_A = new javax.swing.JMenuItem();
        M_B_B = new javax.swing.JMenuItem();
        M_B_C = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        M_C_B = new javax.swing.JMenuItem();
        M_C_C = new javax.swing.JMenuItem();
        M_C_D = new javax.swing.JMenuItem();
        M_C_E = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setTitle("CONFIGURACION");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/form.png"))); // NOI18N

        JDP_config.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout JDP_configLayout = new javax.swing.GroupLayout(JDP_config);
        JDP_config.setLayout(JDP_configLayout);
        JDP_configLayout.setHorizontalGroup(
            JDP_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 967, Short.MAX_VALUE)
        );
        JDP_configLayout.setVerticalGroup(
            JDP_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        jMenu1.setText("Datos");

        M_A_A.setText("Empresa");
        jMenu1.add(M_A_A);

        MNB_config.add(jMenu1);

        jMenu3.setText("Acceso");

        M_B_A.setText("Rol");
        jMenu3.add(M_B_A);

        M_B_B.setText("Usuario");
        M_B_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_B_BActionPerformed(evt);
            }
        });
        jMenu3.add(M_B_B);

        M_B_C.setText("Permisos");
        jMenu3.add(M_B_C);

        MNB_config.add(jMenu3);

        jMenu2.setText("General");

        M_C_B.setText("Sucursal");
        M_C_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_C_BActionPerformed(evt);
            }
        });
        jMenu2.add(M_C_B);

        M_C_C.setText("Almacen");
        M_C_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_C_CActionPerformed(evt);
            }
        });
        jMenu2.add(M_C_C);

        M_C_D.setText("Tipo Movimiento");
        M_C_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_C_DActionPerformed(evt);
            }
        });
        jMenu2.add(M_C_D);

        M_C_E.setText("Tipo Documento");
        M_C_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_C_EActionPerformed(evt);
            }
        });
        jMenu2.add(M_C_E);

        MNB_config.add(jMenu2);

        setJMenuBar(MNB_config);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDP_config)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDP_config)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void M_B_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_B_BActionPerformed
        try {
            go_muestra_jif_config.muestra_jif_usuario();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_M_B_BActionPerformed

    private void M_C_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_C_BActionPerformed
        try {
            go_muestra_jif_config.muestra_jif_sucursal();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_M_C_BActionPerformed

    private void M_C_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_C_CActionPerformed
        try {
            go_muestra_jif_config.muestra_jif_almacen();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_M_C_CActionPerformed

    private void M_C_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_C_DActionPerformed
        try {
            go_muestra_jif_config.muestra_jif_tipo_movimiento();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_M_C_DActionPerformed

    private void M_C_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_C_EActionPerformed
        try {
            go_muestra_jif_config.muestra_jif_tipo_documento();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_M_C_EActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane JDP_config;
    private javax.swing.JMenuBar MNB_config;
    private javax.swing.JMenuItem M_A_A;
    private javax.swing.JMenuItem M_B_A;
    private javax.swing.JMenuItem M_B_B;
    private javax.swing.JMenuItem M_B_C;
    private javax.swing.JMenuItem M_C_B;
    private javax.swing.JMenuItem M_C_C;
    private javax.swing.JMenuItem M_C_D;
    private javax.swing.JMenuItem M_C_E;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    // End of variables declaration//GEN-END:variables
}
