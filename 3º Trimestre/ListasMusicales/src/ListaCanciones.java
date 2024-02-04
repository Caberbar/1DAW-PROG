
import Modelo.Cancion;
import Modelo.ModeloListaCanciones;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.w3c.dom.Document;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * Este JFrame administra una lista musical. Es una versión inicial que he
 * creado sobre el trabajo de Listas Musicales.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class ListaCanciones extends javax.swing.JFrame {

    private ModeloListaCanciones modelo;
    private File fichero;
    private ArrayList<Cancion> listaCanciones;

    private int contadorVersiones = 1;
    private boolean editado = false;

    /**
     * Iniciación JFrame. En este método, iniciaremos los componentes y
     * ocultaremos algunos botones hasta que no se cree o se cargue una lista.
     * Ademas creamos un modelo.
     *
     */
    public ListaCanciones() {
        initComponents();
        jmExportar.setVisible(false);
        jmHerramientas.setVisible(false);
        jbGuardar.setVisible(false);

        modelo = new ModeloListaCanciones();
        jTable1.setModel(modelo);
        modelo.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jlTitulo = new javax.swing.JLabel();
        jbCerrar = new javax.swing.JButton();
        jbCrearLista = new javax.swing.JButton();
        jbCargarLista = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jmbMenu = new javax.swing.JMenuBar();
        jmHerramientas = new javax.swing.JMenu();
        jmiCrearCancion = new javax.swing.JMenuItem();
        jmiModificarCancion = new javax.swing.JMenuItem();
        jmiEliminarCancion = new javax.swing.JMenuItem();
        jmiVaciarLista = new javax.swing.JMenuItem();
        jmExportar = new javax.swing.JMenu();
        jmiM3U = new javax.swing.JMenuItem();
        jmiPLS = new javax.swing.JMenuItem();
        jmiXSPF = new javax.swing.JMenuItem();
        jmInfo = new javax.swing.JMenu();
        jmiAcerda = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Título", "Ruta", "Duración"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jlTitulo.setText("LISTA DE CANCIONES");

        jbCerrar.setText("Cerrar");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        jbCrearLista.setText("Crear lista");
        jbCrearLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearListaActionPerformed(evt);
            }
        });

        jbCargarLista.setText("Cargar lista");
        jbCargarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarListaActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jmHerramientas.setText("Herramientas");

        jmiCrearCancion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiCrearCancion.setIcon(new javax.swing.ImageIcon("G:\\Mi unidad\\Programación\\ListasMusicales\\Imagenes\\Awicons-Vista-Artistic-Add.16.png")); // NOI18N
        jmiCrearCancion.setText("Crear canción");
        jmiCrearCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCrearCancionActionPerformed(evt);
            }
        });
        jmHerramientas.add(jmiCrearCancion);

        jmiModificarCancion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiModificarCancion.setIcon(new javax.swing.ImageIcon("G:\\Mi unidad\\Programación\\ListasMusicales\\Imagenes\\Custom-Icon-Design-Pretty-Office-10-Pencil.16.png")); // NOI18N
        jmiModificarCancion.setText("Modificar canción");
        jmiModificarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiModificarCancionActionPerformed(evt);
            }
        });
        jmHerramientas.add(jmiModificarCancion);

        jmiEliminarCancion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiEliminarCancion.setIcon(new javax.swing.ImageIcon("G:\\Mi unidad\\Programación\\ListasMusicales\\Imagenes\\Designcontest-Ecommerce-Business-Trash.16.png")); // NOI18N
        jmiEliminarCancion.setText("Eliminar canción");
        jmiEliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEliminarCancionActionPerformed(evt);
            }
        });
        jmHerramientas.add(jmiEliminarCancion);

        jmiVaciarLista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiVaciarLista.setIcon(new javax.swing.ImageIcon("G:\\Mi unidad\\Programación\\ListasMusicales\\Imagenes\\Roundicons-100-Free-Solid-Vacuum-cleaner.16.png")); // NOI18N
        jmiVaciarLista.setText("Vaciar lista");
        jmiVaciarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVaciarListaActionPerformed(evt);
            }
        });
        jmHerramientas.add(jmiVaciarLista);

        jmbMenu.add(jmHerramientas);

        jmExportar.setText("Exportar");

        jmiM3U.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiM3U.setText("M3U");
        jmiM3U.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiM3UActionPerformed(evt);
            }
        });
        jmExportar.add(jmiM3U);

        jmiPLS.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiPLS.setText("PLS");
        jmiPLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPLSActionPerformed(evt);
            }
        });
        jmExportar.add(jmiPLS);

        jmiXSPF.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiXSPF.setText("XSPF");
        jmiXSPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiXSPFActionPerformed(evt);
            }
        });
        jmExportar.add(jmiXSPF);

        jmbMenu.add(jmExportar);

        jmInfo.setText("Ayuda");

        jmiAcerda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiAcerda.setIcon(new javax.swing.ImageIcon("G:\\Mi unidad\\Programación\\ListasMusicales\\Imagenes\\Graphicloads-100-Flat-2-Information.16.png")); // NOI18N
        jmiAcerda.setText("Acerca de");
        jmiAcerda.setToolTipText("");
        jmiAcerda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAcerdaActionPerformed(evt);
            }
        });
        jmInfo.add(jmiAcerda);

        jmbMenu.add(jmInfo);

        setJMenuBar(jmbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 350, Short.MAX_VALUE)
                        .addComponent(jlTitulo)
                        .addGap(350, 350, 350))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbCrearLista)
                        .addGap(18, 18, 18)
                        .addComponent(jbCargarLista)
                        .addGap(18, 18, 18)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCerrar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCerrar)
                    .addComponent(jbCrearLista)
                    .addComponent(jbCargarLista)
                    .addComponent(jbGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método invocado al hacer clic en el botón "Cancelar". Cerrará el
     * programa.
     *
     * @param evt el evento de acción generado
     */
    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        if (editado == true) {
            int opcion = JOptionPane.showConfirmDialog(null, "Hay archivos sin guardar.\nSi no guardas, los cambios\nse perderan.\n¿Desea salir?", "AVISO", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcion == 0) {
                dispose();
            }
        } else {
            dispose();
        }
    }//GEN-LAST:event_jbCerrarActionPerformed

    /**
     * Método invocado al hacer clic en el menu "Exportar/M3U". Llamara una
     * función que abrira un JFileChooser(guardarComo), para sobreescribir o
     * crear un nuevo archivo y cuya extensión sera .m3u. Una vez seleccionado
     * el archivo llamara a otra función(ExportarM3U)que se encargara escribir y
     * dar formato dentro del fichero a la lista para despues poder leerlo.
     *
     * @param evt el evento de acción generado
     */
    private void jmiM3UActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiM3UActionPerformed
        fichero = guardarComo("Solo se permiten archivos .m3u", "m3u");
        if (extension(fichero).equals("m3u")) {
            ExportarM3U(fichero, false);
        }

    }//GEN-LAST:event_jmiM3UActionPerformed
    /**
     * Método invocado al hacer clic en el menu "Exportar/PLS". Llamara una
     * función que abrira un JFileChooser(guardarComo), para sobreescribir o
     * crear un nuevo archivo y cuya extensión sera .pls. Una vez seleccionado
     * el archivo llamara a otra función(ExportarPLS)que se encargara escribir y
     * dar formato dentro del fichero a la lista para despues poder leerlo.
     *
     * @param evt el evento de acción generado
     */
    private void jmiPLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPLSActionPerformed
        fichero = guardarComo("Solo se permiten archivos .pls", "pls");
        if (extension(fichero).equals("pls")) {
            ExportarPLS(fichero, false);
        }
    }//GEN-LAST:event_jmiPLSActionPerformed
    /**
     * Método invocado al hacer clic en el menu "Exportar/XSPF". Llamara una
     * función que abrira un JFileChooser(guardarComo), para sobreescribir o
     * crear un nuevo archivo y cuya extensión sera .xspf. Una vez seleccionado
     * el archivo llamara a otra función(ExportarXSPF)que se encargara escribir
     * y dar formato dentro del fichero a la lista para despues poder leerlo.
     *
     * @param evt el evento de acción generado
     */
    private void jmiXSPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiXSPFActionPerformed
        fichero = guardarComo("Solo se permiten archivos .xspf", "xspf");
        if (extension(fichero).equals("xspf")) {
            ExportarXSPF(fichero, false);
        }
    }//GEN-LAST:event_jmiXSPFActionPerformed
    /**
     * Método invocado al hacer clic en el menu "Herramientas/Crear canción".
     * Crearemos un objeto CrearModificar(crear) y haremos visible el JDialog
     * que se encargara de mostrar los distintos campos a rellenas para poder
     * crear una cación. Una vez creada la canción cogeremos la canción con un
     * metodo get, y con nu metodo del modelo(añadirCancionModelo) lo añadiremos
     * a el. Finalmente recargaremos el modelo.
     *
     * @param evt el evento de acción generado
     */
    private void jmiCrearCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCrearCancionActionPerformed
        CrearModificar crear = new CrearModificar(this, true);
        crear.setVisible(true);

        if (crear.getNuevaCancion() != null) {
            modelo.añadirCancionModelo(crear.getNuevaCancion());
            editado = true;
        }
        modelo.fireTableDataChanged();
    }//GEN-LAST:event_jmiCrearCancionActionPerformed
    /**
     * Método invocado al hacer clic en el menu "Herramientas/Modificar
     * canción". Le pediremos al ususario que seleccione con el raton una
     * canción de la lista, validaremos la posición y si en valida y pulsamos en
     * JMenuItemModificar, crearemos un objeto CrearModificar(modificar) y
     * haremos visible el JDialog que se encargara de mostrar los distintos
     * campos a rellenas para poder modificar una cación. Validamos todos los
     * datos y no sera necesario rellenar todos los campos, una vez modificada,
     * llamaremos a una funcion del modelo(actualizarCancionModelo) que se
     * encargara de insertar la cancion en la posicion pasada por parametro. Por
     * último actulizaremos el modelo.
     *
     * @param evt el evento de acción generado
     */
    private void jmiModificarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiModificarCancionActionPerformed
        int pos = 0;
        if (jTable1.getSelectedRow() >= -1 && jTable1.getSelectedColumn() >= -1) {
            pos = jTable1.getSelectedRow();
        }
        if (pos < 0) {
            JOptionPane.showMessageDialog(rootPane, "Marque una cancion de la lista.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            Cancion cancion = modelo.getCancion(pos);
            CrearModificar modificar = new CrearModificar(this, true, cancion);
            modificar.setVisible(true);
            if (modificar.getNuevaCancion() != null) {
                modelo.actualizarCancionModelo(pos, modificar.getNuevaCancion());
                editado = true;
            }
            modelo.fireTableDataChanged();
        }
    }//GEN-LAST:event_jmiModificarCancionActionPerformed
    /**
     * Método invocado al hacer clic en el menu "Herramientas/Eliminar canción".
     * Le pediremos al ususario que seleccione con el raton una canción de la
     * lista, validaremos la posición y si en valida y pulsamos en
     * JMenuItemModificar,llamaremos a un función(eliminarCancionModelo) del
     * modelo que se encargará de eliminar la cancion del ArrayList en la
     * posición pasada por parametro. Por último actulizaremos el modelo.
     *
     * @param evt el evento de acción generado
     */
    private void jmiEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEliminarCancionActionPerformed
        if (jTable1.getSelectedRow() >= -1 && jTable1.getSelectedColumn() >= -1) {
            int pos = jTable1.getSelectedRow();
            if (pos < 0) {
                JOptionPane.showMessageDialog(rootPane, "Marque una cancion de la lista.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                modelo.eliminarCancionModelo(pos);
                editado = true;
            }
            modelo.fireTableDataChanged();
        }
    }//GEN-LAST:event_jmiEliminarCancionActionPerformed
    /**
     * Método invocado al hacer clic en el menu "Herramientas/Vaciar lista".
     * Limpiaremos el ArrayList de modelo. Por último actulizaremos el modelo.
     *
     * @param evt el evento de acción generado
     */
    private void jmiVaciarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVaciarListaActionPerformed
        if (!modelo.getListatarjetas().isEmpty()) {
            modelo.getListatarjetas().clear();
            modelo.fireTableDataChanged();
            editado = true;
        } else {
            JOptionPane.showMessageDialog(rootPane, "La lista esta vacía.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmiVaciarListaActionPerformed

    /**
     * Método invocado al hacer clic en el botón "Guardar". Le preguntara al
     * usuario si quiere sobreescribir o no el archivo, en caso de que diga que
     * si, extraera la extensión del archivo donde estan guardadas para poder
     * reutilizar las funciones de exportar y activaremos la opción de
     * sobreescribir que nuestra intención en el archivo.
     *
     * @param evt el evento de acción generado
     */
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        if (modelo.getListatarjetas().size() == 0) {
            JOptionPane.showMessageDialog(rootPane, "La lista esta vacía.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea sobreescribir el archivo?", "AVISO", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcion == 0) {
                if (fichero.exists()) {
                    String extension = extension(fichero);

                    if (extension.equals("m3u")) {
                        ExportarM3U(fichero, true);
                    } else if (extension.equals("pls")) {
                        ExportarPLS(fichero, true);
                    } else if (extension.equals("xspf")) {
                        ExportarXSPF(fichero, true);
                    }
                    editado = false;
                } else {
                    System.out.println("No existe"); //hay que coger el archivo en las exportaciones
                }
            }
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    /**
     * Método invocado al hacer clic en el botón "Crear Lista". Creará una lista
     * nueva vacia, en caso de que ya exista una, si el ususario desea crear
     * otra, avisara al ususario de que se perdera la otra. En caso de crearse
     * correctamente avisara al ussuario de su correcta creación, en el caso
     * contrario dara un mensaje de error.
     *
     * @param evt el evento de acción generado
     */
    private void jbCrearListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearListaActionPerformed
        if (listaCanciones != null) {
            int opcion = JOptionPane.showConfirmDialog(null, "Ya existe una lista.\n¿Desea eliminarla y crear una nueva?", "AVISO", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcion == 0) {
                listaCanciones.clear();
                modelo.getListatarjetas().clear();
                modelo.fireTableDataChanged();
                jbGuardar.setVisible(false);
                visibleHerramientas();
            }
        } else {
            listaCanciones = new ArrayList<>();
            if (listaCanciones != null) {
                JOptionPane.showMessageDialog(rootPane, "La lista se creo correctamente", "CREADO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se ha podido crear la lista", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            modelo.añadirCanciones(listaCanciones);
            modelo.fireTableDataChanged();
            visibleHerramientas();
        }
    }//GEN-LAST:event_jbCrearListaActionPerformed

    /**
     * Método invocado al hacer clic en el botón "Cargar Lista". En caso de que
     * haya una lista cargada avisara al usuario si desea cerrarla, en caso de
     * que diga que si llamará a una función(Cargar) que cargara una lista de
     * canciones. En caso de que no haya ninguna cargada se creara una lista
     * nueva y cargara una lista con una función(Cargar).
     *
     * @param evt el evento de acción generado
     */
    private void jbCargarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarListaActionPerformed
        if (listaCanciones != null) {
            int options = JOptionPane.showConfirmDialog(null, "Ya existe una lista.\n¿Desea quitarla?", "AVISO", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (options == 0) {
                listaCanciones.clear();
                modelo.getListatarjetas().clear();
                fichero = Cargar(listaCanciones);
            }
        } else {
            listaCanciones = new ArrayList<>();
            fichero = Cargar(listaCanciones);
        }
    }//GEN-LAST:event_jbCargarListaActionPerformed

    /**
     * Método invocado al hacer clic en el menu "Ayuda/Acerca de". Mostrará un
     * mensaje por pantalla con información básica del proyecto.
     *
     * @param evt el evento de acción generado
     */
    private void jmiAcerdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAcerdaActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Trabajo - Listas Musicales\nRealizado por Carlos Bernal\nMarzo 2023\nVersion: 1", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jmiAcerdaActionPerformed

    /**
     * Función de exportar en formato M3U. Recibira un fichero por parametro y
     * leera la lista de canciones y las irá insertando en el fichero con un
     * formato en excepcífico, en este caso(M3U) una vez hemos escrito el
     * fichero lo cerramos.
     *
     * @param fichero fichero que sera donde se escribirá la lista.
     * @param sobreescribir Opción de sobreescribir el archivo o no.
     */
    public void ExportarM3U(File fichero, boolean sobreescribir) {
        try {
            BufferedWriter bf;
            if (sobreescribir != true) {
                bf = new BufferedWriter(new FileWriter(fichero));
            } else {
                bf = new BufferedWriter(new FileWriter(fichero, false));
            }
            bf.write("#EXTM3U\n");
            for (int i = 0; i < modelo.getListatarjetas().size(); i++) {
                bf.write("#EXTINF:" + modelo.getListatarjetas().get(i).getDuracion() + "," + modelo.getListatarjetas().get(i).getTitulo());
                bf.write("\n" + modelo.getListatarjetas().get(i).getRuta() + "\n");
            }
            bf.flush();
            bf.close();
        } catch (IOException ex) {
            Logger.getLogger(ListaCanciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        jbGuardar.setVisible(true);
    }

    /**
     * Función de exportar en formato PLS. Recibira un fichero por parametro y
     * leera la lista de canciones y las irá insertando en el fichero con un
     * formato en excepcífico, en este caso(PLS) una vez hemos escrito el
     * fichero lo cerramos.
     *
     * @param fichero fichero que sera donde se escribirá la lista.
     * @param sobreescribir Opción de sobreescribir el archivo o no.
     */
    public void ExportarPLS(File fichero, boolean sobreescribir) {
        try {
            BufferedWriter bf;
            if (sobreescribir != true) {
                bf = new BufferedWriter(new FileWriter(fichero));
            } else {
                bf = new BufferedWriter(new FileWriter(fichero, false));
            }
            bf.write("[playlist]\n");
            for (int i = 0, contador = 1; i < modelo.getListatarjetas().size(); i++, contador++) {
                bf.write("File" + contador + "=" + modelo.getListatarjetas().get(i).getRuta() + "\n");
                bf.write("Title" + contador + "=" + modelo.getListatarjetas().get(i).getTitulo() + "\n");
                bf.write("Length" + contador + "=" + modelo.getListatarjetas().get(i).getDuracion() + "\n");
            }
            bf.write("NumberOfEntries=" + modelo.getListatarjetas().size() + "\n");
            bf.write("Version=" + contadorVersiones);
            bf.flush();
            bf.close();
            contadorVersiones++;
        } catch (IOException ex) {
            Logger.getLogger(ListaCanciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        jbGuardar.setVisible(true);
    }

    /**
     * Función de exportar en formato XSPF. Recibira un fichero por parametro y
     * leera la lista de canciones y las irá insertando en el fichero con un
     * formato en excepcífico, en este caso(XSPF) una vez hemos escrito el
     * fichero lo cerramos.
     *
     * @param fichero fichero que sera donde se escribirá la lista.
     * @param sobreescribir Opción de sobreescribir el archivo o no.
     */
    public void ExportarXSPF(File fichero, boolean sobreescribir) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element raiz = doc.createElement("playlist");
            raiz.setAttribute("version", "1");
            raiz.setAttribute("xmlns", "http://xspf.org/ns/0/");
            doc.appendChild(raiz);

            Element listaCanciones = doc.createElement("trackList");
            raiz.appendChild(listaCanciones);

            Element pista, ruta, duracion, nombre;

            for (Cancion cancion : modelo.getListatarjetas()) {
                pista = doc.createElement("track");

                ruta = doc.createElement("location");
                ruta.setTextContent(cancion.getRuta());

                duracion = doc.createElement("duration");
                duracion.setTextContent(Integer.toString(cancion.getDuracion() * 1000));

                nombre = doc.createElement("title");
                nombre.setTextContent(cancion.getTitulo());

                pista.appendChild(nombre);
                pista.appendChild(duracion);
                pista.appendChild(ruta);

                listaCanciones.appendChild(pista);
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer prueba = null;

            try {
                prueba = tf.newTransformer();
                prueba.setOutputProperty(OutputKeys.INDENT, "yes");
                prueba.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                if (sobreescribir) {
                    prueba.setOutputProperty(OutputKeys.METHOD, "xml");
                    prueba.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                }

                StreamResult result = new StreamResult(fichero);
                DOMSource source = new DOMSource(doc);
                prueba.transform(source, result);

            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(ListaCanciones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(ListaCanciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ListaCanciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        jbGuardar.setVisible(true);
    }

    /**
     *
     * Método de activación de guardar como una lista. Con esta función
     * abriremos un JFileChooser que permitira guardar una lista solo con la
     * extensión pasada por parametro, una vez realizada la acción devolvera un
     * archivo que se usara posteriormente en otras funciones.
     *
     *
     * @param mensaje Mensaje que vera el usuario al abrirse el JFileChooser
     * @param extension Extensión permitida para guardar el archivo
     * @return Devuelve el fichero donde s
     */
    public File guardarComo(String mensaje, String extension) {
        File ficheroSeleccionado;

        JFileChooser guardar = new JFileChooser();
        guardar.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter(mensaje, extension);
        guardar.addChoosableFileFilter(filtroExtension);
        guardar.showSaveDialog(null);
        guardar.setFileSelectionMode(JFileChooser.SAVE_DIALOG);

        ficheroSeleccionado = guardar.getSelectedFile();

        if (ficheroSeleccionado != null) {
            if (ficheroSeleccionado.isFile()) {
                if (ficheroSeleccionado.exists()) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Desea sobreescribir el archivo?", "AVISO", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (opcion == 0) {
                        fichero = guardar.getSelectedFile();
                    }
                }
            } else {
                if (!extension(guardar.getSelectedFile()).equals(extension)) {
                    JOptionPane.showMessageDialog(rootPane, "La extension no es valida, pruebe de nuevo.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    fichero = guardar.getSelectedFile();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No seleccionó/creó ningún archivo.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return fichero;
    }

    /**
     * Método de activación de opciones. Con este metodo sabre que extensión
     * tiene un archivo para poder filtrar a la hora de guardar como y guardar
     * las listas musicales.
     *
     * @param archivo Archivo para extrear extensión
     * @return Devuelve la extensión del fichero pasado por parametro.
     */
    public String extension(File archivo) {
        String ruta = archivo.getAbsolutePath();
        String extensiones = ruta.substring(ruta.lastIndexOf(".") + 1);
        return extensiones;
    }

    /**
     * Función para cargar un lista musical. Esta función recibira por parametro
     * una lista musical que sera llenada por las canciones que haya en el
     * archivo cargado, la función llamara a un JFileChooser para que el usuario
     * excoja un fichero para leer, previamente habremos filtrado por las
     * extensiones pedidas en el proyecto, cuando el usuario escoja un fichero
     * se extraera u¡la extensión del fichero y a partir de ahi leeremos el
     * fichero dependiendo de la extensión y el formato que tenga. Una vez
     * cargada se actualizara el metodo cuando las canciones ya se hallan
     * añadido al ArrayList de canciones
     *
     * @throws En caso de no poder leerse correctamente los fichero se lanzarán
     * excepción.
     * @param listaCanciones Lista de canciones vacia para ser llenada
     * @return Devuelve el fichero seleccionado
     */
    public File Cargar(ArrayList<Cancion> listaCanciones) {
        String titulos = null, rutas = null;
        int duracion = 0;

        JFileChooser jfc = new JFileChooser();
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter("Solo archivos m3u,pls,xspf", "m3u", "pls", "xspf");
        jfc.addChoosableFileFilter(filtroExtension);

        int opcion = jfc.showOpenDialog(this);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            fichero = jfc.getSelectedFile();
            if (fichero.isFile()) {
                String ficheroEscogido = jfc.getSelectedFile().getAbsolutePath();
                if (extension(jfc.getSelectedFile()).equals("m3u")) {
                    try (BufferedReader br = new BufferedReader(new FileReader(ficheroEscogido))) {
                        String line = br.readLine();
                        while ((line = br.readLine()) != null) {
                            if (line.startsWith("#EXTINF")) {
                                String[] partes = line.split(",");
                                if (partes[0].substring(8).equals("")) {
                                    duracion = -1;
                                } else {
                                    duracion = Integer.parseInt(partes[0].substring(8));
                                }
                                titulos = partes[1].substring(0);
                            } else if (!line.startsWith("#") && titulos != null) {
                                String ruta = line;
                                listaCanciones.add(new Cancion(titulos, ruta, duracion));
                                duracion = -1;
                                titulos = null;
                            }
                        }
                        modelo.añadirCanciones(listaCanciones);
                        modelo.fireTableDataChanged();
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Error al leer el archivo: " + e.getMessage());
                    }

                } else if (extension(jfc.getSelectedFile()).equals("pls")) {
                    try (BufferedReader br = new BufferedReader(new FileReader(ficheroEscogido))) {
                        String line = br.readLine();
                        while ((line = br.readLine()) != null) {
                            if (line.startsWith("File")) {
                                rutas = line.split("=")[1];
                            } else if (line.startsWith("Title")) {
                                titulos = line.split("=")[1];
                            } else if (line.startsWith("Length")) {
                                try {
                                    duracion = Integer.parseInt(line.split("=")[1]);
                                } catch (Exception e) {
                                    duracion = -1;
                                }
                                listaCanciones.add(new Cancion(titulos, rutas, duracion));
                            }
                        }
                        modelo.añadirCanciones(listaCanciones);
                        modelo.fireTableDataChanged();
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Error al leer el archivo: " + e.getMessage());
                    }
                } else if (extension(jfc.getSelectedFile()).equals("xspf")) {

                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = null;
                    try {
                        dBuilder = dbFactory.newDocumentBuilder();
                        try {
                            Document document = dBuilder.parse(ficheroEscogido);

                            Element raiz = document.getDocumentElement();

                            NodeList listacanciones = raiz.getElementsByTagName("trackList");
                            NodeList pista = ((Element) listacanciones.item(0)).getElementsByTagName("track");
                            for (int i = 0; i < pista.getLength(); i++) {
                                Element track = (Element) pista.item(i);
                                titulos = track.getElementsByTagName("title").item(0).getTextContent();
                                rutas = track.getElementsByTagName("location").item(0).getTextContent();
                                if (track.getElementsByTagName("duration").item(0).getTextContent().equals("")) {
                                    duracion = -1;
                                } else {
                                    duracion = Integer.parseInt(track.getElementsByTagName("duration").item(0).getTextContent()) / 1000;
                                }
                                listaCanciones.add(new Cancion(titulos, rutas, duracion));
                            }
                            modelo.añadirCanciones(listaCanciones);
                            modelo.fireTableDataChanged();
                        } catch (SAXException ex) {
                            throw new IllegalArgumentException("Error al leer el archivo: " + ex.getMessage());
                        } catch (IOException ex) {
                            throw new IllegalArgumentException("Error al leer el archivo: " + ex.getMessage());
                        }
                    } catch (ParserConfigurationException ex) {
                        throw new IllegalArgumentException("Error al leer el archivo: " + ex.getMessage());
                    }
                }
                jbGuardar.setVisible(true);
                visibleHerramientas();
            } else {
                JOptionPane.showMessageDialog(rootPane, "No seleccionó ningún archivo.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return fichero;
    }

    /**
     * Método de activación de opciones. En caso de haberse cargado o creado
     * correctamente una lista musical las opción de edición y exportación se
     * haran visibles al ususario.
     */
    public void visibleHerramientas() {
        jmExportar.setVisible(true);
        jmHerramientas.setVisible(true);
    }

    /**
     * Main del programa.
     *
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
            java.util.logging.Logger.getLogger(ListaCanciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaCanciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaCanciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaCanciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListaCanciones().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbCargarLista;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbCrearLista;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JMenu jmExportar;
    private javax.swing.JMenu jmHerramientas;
    private javax.swing.JMenu jmInfo;
    private javax.swing.JMenuBar jmbMenu;
    private javax.swing.JMenuItem jmiAcerda;
    private javax.swing.JMenuItem jmiCrearCancion;
    private javax.swing.JMenuItem jmiEliminarCancion;
    private javax.swing.JMenuItem jmiM3U;
    private javax.swing.JMenuItem jmiModificarCancion;
    private javax.swing.JMenuItem jmiPLS;
    private javax.swing.JMenuItem jmiVaciarLista;
    private javax.swing.JMenuItem jmiXSPF;
    // End of variables declaration//GEN-END:variables
}
