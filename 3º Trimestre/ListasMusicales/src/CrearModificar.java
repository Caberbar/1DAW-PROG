import Modelo.Cancion;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Este JDialog crea y/o modifica un objeto Canción. Es una versión inicial que
 * he creado sobre el trabajo de Listas Musicales.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class CrearModificar extends javax.swing.JDialog {

    private Cancion nuevaCancion;
    private boolean modifico = false;
    private File directorio;

    /**
     * Creación nuevo formulario JDcrearTarjeta
     *
     * @param parent Marco principal
     * @param modal Indica si el Jdialog es modal
     */
    public CrearModificar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jbModificar.setVisible(false);

    }

    /**
     * Creación nuevo formulario JDcrearTarjeta
     *
     * @param parent Marco principal
     * @param modal Indica si el Jdialog es modal
     * @param nuevaCancion El objeto canción que se usara para modificar
     */
    public CrearModificar(java.awt.Frame parent, boolean modal, Cancion nuevaCancion) {
        super(parent, modal);
        initComponents();
        this.nuevaCancion = nuevaCancion;

        jbCrear.setVisible(false);
        jlTitulo.setText("MODIFICACIÓN CANCIÓN");

    }

    /**
     * Extrae la cancion.
     *
     * @return Devuelve la cancion creada/modificada.
     */
    public Cancion getNuevaCancion() {
        return nuevaCancion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jbCrear = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jtfNombre = new javax.swing.JTextField();
        jlNombre = new javax.swing.JLabel();
        jlRuta = new javax.swing.JLabel();
        jtfRuta = new javax.swing.JTextField();
        jlLimite = new javax.swing.JLabel();
        jtfLimite = new javax.swing.JTextField();
        jbModificar = new javax.swing.JButton();
        jbElegirRuta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlTitulo.setText("CREACIÓN CANCIÓN");

        jbCrear.setText("Crear");
        jbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jlNombre.setText("Introduzca el titulo:");

        jlRuta.setText("Introduzca la ruta:");

        jlLimite.setText("Introduce la duración:");

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbElegirRuta.setText("Elegir ruta");
        jbElegirRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbElegirRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jlTitulo)
                .addContainerGap(249, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlRuta)
                            .addComponent(jlLimite)
                            .addComponent(jlNombre))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfNombre)
                                .addGap(101, 101, 101))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfLimite)
                                    .addComponent(jtfRuta))
                                .addGap(18, 18, 18)
                                .addComponent(jbElegirRuta))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jbCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                        .addComponent(jbCancelar)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlRuta)
                    .addComponent(jtfRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbElegirRuta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLimite)
                    .addComponent(jtfLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrear)
                    .addComponent(jbCancelar)
                    .addComponent(jbModificar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método invocado al hacer clic en el botón "Crear".
     * Realiza la validación de los campos de entrada y crea una nueva canción
     * si todos los valores son válidos.
     * En caso de encontrar errores, muestra un mensaje de error.
     * Hasta que los datos no esten validados correctamente no creará la canción.
     * @param evt el evento de acción generado
     */
    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed
        int limite = -1;
        directorio = new File(jtfRuta.getText());
        StringBuilder errores = new StringBuilder();
        boolean correcto = false;
        if (jtfNombre.getText().isBlank() || jtfNombre.getText().isEmpty()) {
            errores.append("\nDebes introducir un titulo válido");
            correcto = true;
        }
        if (jtfRuta.getText().isBlank() || jtfRuta.getText().isEmpty() || !directorio.isDirectory()) {
            errores.append("\nDebes introducir una ruta válida");
            correcto = true;
        }
        if (jtfLimite.getText().isBlank() || jtfLimite.getText().isEmpty()) {
            errores.append("\nDebes introducir una duración");
            correcto = true;
        } else {
            try {
                limite = Integer.parseInt(jtfLimite.getText());
                if (limite < 1) {
                    errores.append("\nDebes introducir una duración");
                    correcto = true;
                }
            } catch (Exception e) {
                errores.append("\nDebes introducir una duración valida");
                correcto = true;
            }
        }
        if (correcto) {
            JOptionPane.showMessageDialog(rootPane, errores, "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            this.nuevaCancion = new Cancion(jtfNombre.getText(), jtfRuta.getText(), limite);
            dispose();
        }
    }//GEN-LAST:event_jbCrearActionPerformed

    /**
     * Método invocado al hacer clic en el botón "Cancelar". Cerrará el
     * JDialog.
     *
     * @param evt el evento de acción generado
     */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * Método invocado al hacer clic en el botón "Modificar". Realiza la
     * validación de los campos de entrada y modifica los valores de la canción
     * actual si son válidos. No sera necesario rellenar todos los campos, en
     * caso de no rellenarlos, se dara una advertencia que tomara los datos que
     * tenia anteriormente
     *
     * En caso de encontrar errores, muestra un mensaje de error.
     *
     * @param evt el evento de acción generado
     */
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        StringBuilder errores = new StringBuilder();
        directorio = new File(jtfRuta.getText());
        boolean correcto = false;
        if (jtfNombre.getText().isBlank() || jtfNombre.getText().isEmpty()) {
            errores.append("el nombre");
            correcto = true;
        } else {
            this.nuevaCancion.setTitulo(jtfNombre.getText());
        }
        if (jtfRuta.getText().isBlank() || jtfRuta.getText().isEmpty() || !directorio.isDirectory()) {
            errores.append(" - la ruta");
            correcto = true;
        } else {
            this.nuevaCancion.setRuta(jtfRuta.getText());
        }
        if (!jtfLimite.getText().isBlank() || !jtfLimite.getText().isEmpty()) {
            int limite = -1;
            try {
                limite = Integer.parseInt(jtfLimite.getText());
                if (limite < 1) {
                    errores.append(" - el limite");
                    correcto = true;
                } else {
                    this.nuevaCancion.setDuracion(limite);
                }
            } catch (Exception e) {
                errores.append("\nDebes introducir una duración valida");
                correcto = true;
            }
        } else {
            errores.append(" - el limite");
        }
        if (correcto) {
            JOptionPane.showMessageDialog(rootPane, "No has cambiado " + errores + " se tomarán los valores anteriores.", "AVISO", JOptionPane.WARNING_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Método invocado al hacer clic en el botón "Elegir ruta". Abre un cuadro
     * de diálogo de selección de directorio. Permite al usuario elegir un 
     * directorio y establece la ruta seleccionada en el campo correspondiente.
     *
     * @param evt el evento de acción generado
     */
    private void jbElegirRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbElegirRutaActionPerformed
        File directorioEscogido = null;
        JFileChooser guardar = new JFileChooser();
        guardar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int seleccion = guardar.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            directorioEscogido = guardar.getSelectedFile();
            if (!directorioEscogido.isDirectory()) {
                JOptionPane.showMessageDialog(rootPane, "El archivo seleccionado no es un directorio.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                jtfRuta.setText(directorioEscogido.getAbsolutePath());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se seleccionó ningún directorio.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        directorio = directorioEscogido;
    }//GEN-LAST:event_jbElegirRutaActionPerformed


    /**
     * Main del programa.
     * @param args argumentos de la linea de comandos
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
            java.util.logging.Logger.getLogger(CrearModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Crear y muestra el Jdialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearModificar dialog = new CrearModificar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbCrear;
    private javax.swing.JButton jbElegirRuta;
    private javax.swing.JButton jbModificar;
    private javax.swing.JLabel jlLimite;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlRuta;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtfLimite;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfRuta;
    // End of variables declaration//GEN-END:variables
}
