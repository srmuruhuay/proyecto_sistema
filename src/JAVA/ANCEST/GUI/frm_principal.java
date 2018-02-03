package JAVA.ANCEST.GUI;

import JAVA.ANCEST.LOGICA.evt_botones_menu;
import JAVA.ANCEST.LOGICA.reloj;
import static JAVA.ANCEST.LOGICA.variables_globales.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Calendar;

public class frm_principal extends javax.swing.JFrame {

    evt_botones_menu lo_evt_botones_menu = new evt_botones_menu();
    Calendar fecha = Calendar.getInstance();
    reloj lo_reloj;

    public frm_principal() throws UnknownHostException, SocketException {
        initComponents();
        datos_pantalla();
        datos_pc();
        formulario();
        BTN_config.requestFocus();
        this.setExtendedState(this.MAXIMIZED_BOTH);

        try {
            lo_reloj = new reloj();
            lo_reloj.start();
        } catch (Exception e) {
        }
    }

    private void formulario() {
        lo_evt_botones_menu.evento_click(this, Listener);
    }

    private void datos_pantalla() {
        LBL_periodo.setText(gs_periodo);
        LBL_periodo.setToolTipText(gs_periodo);
        LBL_rol.setText(gs_nombre_rol);
        LBL_rol.setToolTipText(gs_nombre_rol);
        LBL_user.setText(gs_nombre_usuario);
        LBL_user.setToolTipText(gs_nombre_usuario);

        go_dao_general.SLT_datos();
        this.setTitle(go_bean_general.getNombre_reporte() + " // DB_" + gs_db);

        gs_mes = go_fnc_opera_campos.completa_digitos((fecha.get(Calendar.MONTH) + 1) + "", "0", 2);
        gs_dia = go_fnc_opera_campos.completa_digitos((fecha.get(Calendar.DAY_OF_MONTH)) + "", "0", 2);
    }

    private void datos_pc() throws UnknownHostException, SocketException {
        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(address.getLocalHost());
            byte[] mac = network.getHardwareAddress();
            gs_direccion_ip = address.getHostAddress();
            gs_nombre_pc = address.getHostName();
            gs_direccion_mac = go_fnc_opera_campos.get_mac(mac);
        } catch (Exception e) {
            gs_direccion_mac = "00-00-00-00-00-00";
            gs_nombre_pc = "SIN CONECCION";
            gs_direccion_ip = "255.255.255.255";
        }

    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == BTN_config || ae.getSource() == BTN_config_ico) {
                try {
                    go_muestra_jif_principal.muestra_jif_modulo_config();
                } catch (Exception e) {
                }
            }
            if (ae.getSource() == BTN_producto || ae.getSource() == BTN_producto_ico) {
                try {
                    go_muestra_jif_config.muestra_jif_producto();
                } catch (Exception e) {
                }
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BTN_producto_ico = new javax.swing.JButton();
        BTN_config_ico = new javax.swing.JButton();
        JDP_principal = new javax.swing.JDesktopPane();
        BTN_config = new javax.swing.JButton();
        BTN_producto = new javax.swing.JButton();
        BTN_calculadora = new javax.swing.JButton();
        LBL_hora = new javax.swing.JLabel();
        LBL_rol = new javax.swing.JLabel();
        LBL_user = new javax.swing.JLabel();
        LBL_periodo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(66, 66, 132));

        BTN_producto_ico.setBackground(new java.awt.Color(153, 153, 0));
        BTN_producto_ico.setForeground(new java.awt.Color(255, 255, 255));
        BTN_producto_ico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/producto_2.png"))); // NOI18N
        BTN_producto_ico.setBorder(null);
        BTN_producto_ico.setFocusPainted(false);

        BTN_config_ico.setBackground(new java.awt.Color(0, 102, 153));
        BTN_config_ico.setForeground(new java.awt.Color(255, 255, 255));
        BTN_config_ico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/config_2.png"))); // NOI18N
        BTN_config_ico.setBorder(null);
        BTN_config_ico.setFocusPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BTN_producto_ico, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(BTN_config_ico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_config_ico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BTN_producto_ico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );

        JDP_principal.setBackground(new java.awt.Color(240, 240, 240));

        BTN_config.setBackground(new java.awt.Color(0, 102, 153));
        BTN_config.setForeground(new java.awt.Color(255, 255, 255));
        BTN_config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/config.png"))); // NOI18N
        BTN_config.setText("CONFIGURACION");
        BTN_config.setFocusPainted(false);
        BTN_config.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        BTN_producto.setBackground(new java.awt.Color(153, 153, 0));
        BTN_producto.setForeground(new java.awt.Color(255, 255, 255));
        BTN_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/producto.png"))); // NOI18N
        BTN_producto.setText("PRODUCTOS");
        BTN_producto.setFocusPainted(false);
        BTN_producto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        BTN_calculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/calculadora.png"))); // NOI18N
        BTN_calculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_calculadoraActionPerformed(evt);
            }
        });

        LBL_hora.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        LBL_hora.setText("jLabel1");

        LBL_rol.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_rol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/rol.png"))); // NOI18N

        LBL_user.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/sesion.png"))); // NOI18N

        LBL_periodo.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_periodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCEST/IMAGES/calendario.png"))); // NOI18N

        JDP_principal.setLayer(BTN_config, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDP_principal.setLayer(BTN_producto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDP_principal.setLayer(BTN_calculadora, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDP_principal.setLayer(LBL_hora, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDP_principal.setLayer(LBL_rol, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDP_principal.setLayer(LBL_user, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDP_principal.setLayer(LBL_periodo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDP_principalLayout = new javax.swing.GroupLayout(JDP_principal);
        JDP_principal.setLayout(JDP_principalLayout);
        JDP_principalLayout.setHorizontalGroup(
            JDP_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDP_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JDP_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JDP_principalLayout.createSequentialGroup()
                        .addComponent(BTN_config, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BTN_calculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 508, Short.MAX_VALUE)
                .addComponent(LBL_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDP_principalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(JDP_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LBL_periodo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LBL_user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LBL_rol, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        JDP_principalLayout.setVerticalGroup(
            JDP_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDP_principalLayout.createSequentialGroup()
                .addComponent(LBL_rol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_periodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                .addGroup(JDP_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_config, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128)
                .addGroup(JDP_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTN_calculadora)
                    .addGroup(JDP_principalLayout.createSequentialGroup()
                        .addComponent(LBL_hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(JDP_principal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JDP_principal)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_calculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_calculadoraActionPerformed
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("calc");
            p.waitFor();
        } catch (IOException | InterruptedException ex) {
        }
    }//GEN-LAST:event_BTN_calculadoraActionPerformed
    public static void main(String args[]) throws UnknownHostException, SocketException {
        new frm_principal().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_calculadora;
    public javax.swing.JButton BTN_config;
    public javax.swing.JButton BTN_config_ico;
    public javax.swing.JButton BTN_producto;
    public javax.swing.JButton BTN_producto_ico;
    public javax.swing.JDesktopPane JDP_principal;
    public javax.swing.JLabel LBL_hora;
    private javax.swing.JLabel LBL_periodo;
    private javax.swing.JLabel LBL_rol;
    private javax.swing.JLabel LBL_user;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
