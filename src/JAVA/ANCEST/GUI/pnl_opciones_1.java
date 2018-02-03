
package JAVA.ANCEST.GUI;

public class pnl_opciones_1 extends javax.swing.JPanel {

    public pnl_opciones_1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTN_nuevo = new javax.swing.JButton();
        BTN_guardar = new javax.swing.JButton();
        BTN_cancelar = new javax.swing.JButton();

        BTN_nuevo.setFont(new java.awt.Font("Arial", 0, 9)); // NOI18N
        BTN_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/nuevo.png"))); // NOI18N
        BTN_nuevo.setText("Nuevo (F1)");
        BTN_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BTN_guardar.setFont(new java.awt.Font("Arial", 0, 9)); // NOI18N
        BTN_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/guardar.png"))); // NOI18N
        BTN_guardar.setText("Guardar (F6)");
        BTN_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BTN_cancelar.setFont(new java.awt.Font("Arial", 0, 9)); // NOI18N
        BTN_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/cancelar.png"))); // NOI18N
        BTN_cancelar.setText("Cancelar (ESC)");
        BTN_cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_nuevo)
                    .addComponent(BTN_cancelar)
                    .addComponent(BTN_guardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_cancelar;
    public javax.swing.JButton BTN_guardar;
    public javax.swing.JButton BTN_nuevo;
    // End of variables declaration//GEN-END:variables
}
