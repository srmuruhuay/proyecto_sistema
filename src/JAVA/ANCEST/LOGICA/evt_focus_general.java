package JAVA.ANCEST.LOGICA;

import javax.swing.JComponent;

public class evt_focus_general extends java.awt.event.FocusAdapter {

    public evt_focus_general() {
    }

    @Override
    public void focusLost(java.awt.event.FocusEvent evt) {
        ((JComponent) evt.getComponent()).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }

    @Override
    public void focusGained(java.awt.event.FocusEvent evt) {
        Object o = evt.getSource();
        ((JComponent) evt.getComponent()).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        if (o instanceof javax.swing.JTextField) {
            javax.swing.JTextField txt = (javax.swing.JTextField) o;
            txt.setSelectionStart(0);
            txt.setSelectionEnd(txt.getText().length());
        }
    }
}
