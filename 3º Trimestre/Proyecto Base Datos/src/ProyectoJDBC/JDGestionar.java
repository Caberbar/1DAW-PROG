/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ProyectoJDBC;

import ProyectoJDBC.TarjetaCredito;
import ProyectoJDBC.TarjetaCreditoDAO;
import static ProyectoJDBC.Validar.*;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Bernal Barrionuevo
 */
public class JDGestionar extends javax.swing.JDialog {

    private TarjetaCredito tarjeta;
    private String pin;

    /**
     * Creates new form JDGestionar
     */
    public JDGestionar(Frame parent, boolean modal, TarjetaCredito tarjetacredito) {
        super(parent, modal);
        tarjeta = tarjetacredito;
        initComponents();
    }

    private JDGestionar(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getPin() {
        return pin;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jpfDNI = new javax.swing.JPasswordField();
        jbdni = new javax.swing.JButton();
        jbMostrarNomrbe = new javax.swing.JButton();
        jpfNombreTitular = new javax.swing.JPasswordField();
        jbMostrarFecha = new javax.swing.JButton();
        jpfFecha = new javax.swing.JPasswordField();
        jtfPin = new javax.swing.JTextField();
        jbConsultarGasto = new javax.swing.JButton();
        jlGastos = new javax.swing.JLabel();
        jbModificarPIN = new javax.swing.JButton();
        jbCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("GESTIÓN TARJETA CRÉDITO");

        jpfDNI.setText("jPasswordField1");

        jbdni.setText("Mostrar DNI/NIF/CIF");
        jbdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbdniActionPerformed(evt);
            }
        });

        jbMostrarNomrbe.setText("Mostrar nombre titular");
        jbMostrarNomrbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarNomrbeActionPerformed(evt);
            }
        });

        jpfNombreTitular.setText("jPasswordField2");

        jbMostrarFecha.setText("Mostrar fecha caducidad");
        jbMostrarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarFechaActionPerformed(evt);
            }
        });

        jpfFecha.setText("jPasswordField3");

        jbConsultarGasto.setText("Consultar gasto total");
        jbConsultarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarGastoActionPerformed(evt);
            }
        });

        jbModificarPIN.setText("Modificar PIN");
        jbModificarPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarPINActionPerformed(evt);
            }
        });

        jbCerrar.setText("Cerrar");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbMostrarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbConsultarGasto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbModificarPIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbMostrarNomrbe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbdni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfPin)
                                .addComponent(jpfFecha)
                                .addComponent(jlGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jpfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpfNombreTitular))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbdni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMostrarNomrbe)
                    .addComponent(jpfNombreTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMostrarFecha)
                    .addComponent(jpfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificarPIN))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConsultarGasto)
                    .addComponent(jlGastos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCerrar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMostrarNomrbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarNomrbeActionPerformed
        jpfNombreTitular.setText(tarjeta.getNombre());
        jpfNombreTitular.setEchoChar((char) 0);
    }//GEN-LAST:event_jbMostrarNomrbeActionPerformed

    private void jbdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbdniActionPerformed
        jpfDNI.setText(tarjeta.getNif());
        jpfDNI.setEchoChar((char) 0);
    }//GEN-LAST:event_jbdniActionPerformed

    private void jbMostrarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarFechaActionPerformed
        jpfFecha.setText(String.valueOf(tarjeta.getMes() + " - " + tarjeta.getAnno()));
        jpfFecha.setEchoChar((char) 0);
    }//GEN-LAST:event_jbMostrarFechaActionPerformed

    private void jbConsultarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarGastoActionPerformed
        jlGastos.setText(String.valueOf(tarjeta.gastado()));
    }//GEN-LAST:event_jbConsultarGastoActionPerformed

    private void jbModificarPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarPINActionPerformed
        if (jtfPin.getText().isBlank() || jtfPin.getText().isEmpty() || !validarPin(jtfPin.getText())) {
            JOptionPane.showMessageDialog(this, "Introduce un PIN valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            tarjeta.setPin(jtfPin.getText());
            TarjetaCreditoDAO.cambiarPin(jtfPin.getText(), tarjeta.getNumero());
            JOptionPane.showMessageDialog(this, "El PIN se cambió correctamente.", "CREADO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jbModificarPINActionPerformed

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(JDGestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDGestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDGestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDGestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDGestionar dialog = new JDGestionar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbConsultarGasto;
    private javax.swing.JButton jbModificarPIN;
    private javax.swing.JButton jbMostrarFecha;
    private javax.swing.JButton jbMostrarNomrbe;
    private javax.swing.JButton jbdni;
    private javax.swing.JLabel jlGastos;
    private javax.swing.JPasswordField jpfDNI;
    private javax.swing.JPasswordField jpfFecha;
    private javax.swing.JPasswordField jpfNombreTitular;
    private javax.swing.JTextField jtfPin;
    // End of variables declaration//GEN-END:variables
}
