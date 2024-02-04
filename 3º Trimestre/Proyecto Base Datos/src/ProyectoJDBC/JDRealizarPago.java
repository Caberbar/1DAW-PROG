/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ProyectoJDBC; //Tengo que sumar la cantidad gastos que ha hecho compararlo con el limite de la tarjeta para que no tenga saldo ilimitado

import ProyectoJDBC.Movimiento;
import ProyectoJDBC.TarjetaCredito;
import ProyectoJDBC.TarjetaCreditoDAO;
import ProyectoJDBC.Validar;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Bernal Barrionuevo
 */
public class JDRealizarPago extends javax.swing.JDialog {

    private TarjetaCredito tarjeta;
    private Movimiento movimiento;
    private double gastado;
    private boolean pagado = false;

    /**
     * Creates new form JDRealizarPago
     *
     * @param parent
     * @param modal
     * @param tarjetaCredito
     */
    public JDRealizarPago(Frame parent, boolean modal, TarjetaCredito tarjetaCredito) {
        super(parent, modal);
        tarjeta = tarjetaCredito;
        gastado = tarjeta.gastado();
        initComponents();
    }

    private JDRealizarPago(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public boolean isPagado() {
        return pagado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jlConcepto = new javax.swing.JLabel();
        jlCantidad = new javax.swing.JLabel();
        jtfConcepto = new javax.swing.JTextField();
        jbAceptar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jtfCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlTitulo.setText("REALIZAR PAGO");

        jlConcepto.setText("Concepto:");

        jlCantidad.setText("Cantidad:");

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jlTitulo)
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlConcepto)
                            .addComponent(jlCantidad))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfConcepto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlConcepto)
                    .addComponent(jtfConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCantidad)
                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAceptar)
                    .addComponent(jbCancelar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        int cantidad = -1;
        if (jtfCantidad.getText().isEmpty() || jtfConcepto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (Validar.validarCantidad(jtfCantidad.getText())) {
                cantidad = Integer.parseInt(jtfCantidad.getText());
                if (Validar.validarConcepto(jtfConcepto.getText(), 51)) {
                    JOptionPane.showMessageDialog(this, "Debes introducir un concepto valido (5-50 caracteres).", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (cantidad > tarjeta.getLimite() || gastado > tarjeta.getLimite() || cantidad < 1 || (gastado + cantidad) > tarjeta.getLimite()) {
                        JOptionPane.showMessageDialog(this, "No puedes superar el limite de la tarjeta.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        movimiento = new Movimiento(Integer.parseInt(jtfCantidad.getText()), jtfConcepto.getText());
                        TarjetaCreditoDAO.realizarPago(tarjeta, jtfConcepto.getText(), Integer.parseInt(jtfCantidad.getText()));
                        pagado = true;
                        dispose();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debes introducir un valor numérico en la cantidad.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDRealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDRealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDRealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDRealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDRealizarPago Frame;
                Frame = new JDRealizarPago(new javax.swing.JFrame(), true);
                Frame.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                Frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlCantidad;
    private javax.swing.JLabel jlConcepto;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfConcepto;
    // End of variables declaration//GEN-END:variables
}
