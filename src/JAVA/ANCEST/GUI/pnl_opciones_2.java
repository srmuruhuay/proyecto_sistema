package JAVA.ANCEST.GUI;

public class pnl_opciones_2 extends javax.swing.JPanel {

    public pnl_opciones_2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTN_editar = new javax.swing.JButton();
        BTN_eliminar = new javax.swing.JButton();
        BTN_exportar = new javax.swing.JButton();
        BTN_imprimir = new javax.swing.JButton();
        BTN_exportar1 = new javax.swing.JButton();

        BTN_editar.setFont(new java.awt.Font("Arial", 0, 9)); // NOI18N
        BTN_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/editar.png"))); // NOI18N
        BTN_editar.setText("Editar (F2)");
        BTN_editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BTN_eliminar.setFont(new java.awt.Font("Arial", 0, 9)); // NOI18N
        BTN_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/delete.png"))); // NOI18N
        BTN_eliminar.setText("Eliminar (F3)");
        BTN_eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BTN_exportar.setFont(new java.awt.Font("Arial", 0, 9)); // NOI18N
        BTN_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/excel.png"))); // NOI18N
        BTN_exportar.setText("Exportar");
        BTN_exportar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_exportar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BTN_imprimir.setFont(new java.awt.Font("Arial", 0, 9)); // NOI18N
        BTN_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/imprimir.png"))); // NOI18N
        BTN_imprimir.setText("Imprimir");
        BTN_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BTN_exportar1.setFont(new java.awt.Font("Arial", 0, 9)); // NOI18N
        BTN_exportar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/copy.png"))); // NOI18N
        BTN_exportar1.setText("Copiar");
        BTN_exportar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_exportar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_imprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_exportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_exportar1)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_exportar1)
                    .addComponent(BTN_imprimir)
                    .addComponent(BTN_exportar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BTN_editar)
                        .addComponent(BTN_eliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_editar;
    public javax.swing.JButton BTN_eliminar;
    public javax.swing.JButton BTN_exportar;
    public javax.swing.JButton BTN_exportar1;
    public javax.swing.JButton BTN_imprimir;
    // End of variables declaration//GEN-END:variables
}
