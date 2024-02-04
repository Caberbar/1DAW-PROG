/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ProyectoJPA;

import ProyectoJPA.TarjetaCredito;
import static ProyectoJPA.TarjetaCredito.comprobarNumeroTarjeta;
import static ProyectoJPA.TarjetaCreditoJPAController.obtenerTarjeta;
import ProyectoJPA.Validar;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class JDCrear extends javax.swing.JDialog {

    private TarjetaCredito nuevaTarjeta;
    private boolean valido = false;

    /**
     * Creates new form JDCrear
     *
     * @param parent
     * @param modal
     */
    public JDCrear(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jlNombre = new javax.swing.JLabel();
        jlDNI = new javax.swing.JLabel();
        jlPin = new javax.swing.JLabel();
        jlLimite = new javax.swing.JLabel();
        jlNúmero = new javax.swing.JLabel();
        jsLimite = new javax.swing.JSpinner();
        jtfNombre = new javax.swing.JTextField();
        jtfDNI = new javax.swing.JTextField();
        jtfPin = new javax.swing.JTextField();
        jtfNúmero = new javax.swing.JTextField();
        jbCrear = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CREACIÓN TARJETA CREDITO");

        jlNombre.setText("Nombre - titular:");

        jlDNI.setText("DNI/NIF/CIF: ");

        jlPin.setText("PIN:");

        jlLimite.setText("Limite gasto:");

        jlNúmero.setText("Número tajeta:");

        jsLimite.setModel(new javax.swing.SpinnerNumberModel(500, 500, 5000, 5));

        jbCrear.setText("Crear");
        jbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlLimite)
                            .addComponent(jlNombre)
                            .addComponent(jlDNI)
                            .addComponent(jlPin)
                            .addComponent(jlNúmero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNúmero)
                            .addComponent(jtfPin)
                            .addComponent(jtfDNI)
                            .addComponent(jtfNombre)
                            .addComponent(jsLimite))))
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jbCrear)
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDNI)
                    .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlPin)
                    .addComponent(jtfPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLimite)
                    .addComponent(jsLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNúmero)
                    .addComponent(jtfNúmero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrear)
                    .addComponent(jbSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed
        String nombre = jtfNombre.getText();
        String nif = jtfDNI.getText();
        String pin = jtfPin.getText();
        String numero = jtfNúmero.getText();
        StringBuilder errores = new StringBuilder();
        boolean correcto = false;

        int limite = (int) jsLimite.getValue();

        if (nombre.isEmpty() || nif.isEmpty() || jtfPin.getText().isEmpty() || numero.isEmpty()) {
            errores.append("Rellene todos los campos.");
            correcto = true;
        } else {
            if (!Validar.validarNombre(nombre)) {
                errores.append("Debes introducir un nombre válido");
                correcto = true;
            }
            if (!Validar.validarNIE(nif)) {
                errores.append("\nDebes introducir un NIF/NIE/CIF valido");
                correcto = true;
            }
            if (!Validar.validarPin(pin)) {
                errores.append("\nDebes introducir un PIN v�lido de 4 cirfras");
                correcto = true;
            }
            if (Validar.validarLimite(limite)) {
                errores.append("\nDebes introducir un limite entre 500 y 5000");
                correcto = true;
            }
            if (!comprobarNumeroTarjeta(numero)) {
                errores.append("\nDebes introducir una tarjeta valida");
                correcto = true;
            }
            if (obtenerTarjeta(numero) != null) {
                errores.append("\nYa existe una tarjeta con el número " + numero + ".");
                correcto = true;
            }
        }
        if (correcto) {
            JOptionPane.showMessageDialog(this, errores, "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            nuevaTarjeta = new TarjetaCredito(nombre, nif, pin, limite, numero);
            valido = true;
            this.setVisible(false);
        }

    }//GEN-LAST:event_jbCrearActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    public boolean valido() {
        return valido;
    }

    public TarjetaCredito getTarjetaCredito() {
        return nuevaTarjeta;
    }

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
            java.util.logging.Logger.getLogger(JDCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDCrear dialog = new JDCrear(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbCrear;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlDNI;
    private javax.swing.JLabel jlLimite;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlNúmero;
    private javax.swing.JLabel jlPin;
    private javax.swing.JSpinner jsLimite;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNúmero;
    private javax.swing.JTextField jtfPin;
    // End of variables declaration//GEN-END:variables
}
