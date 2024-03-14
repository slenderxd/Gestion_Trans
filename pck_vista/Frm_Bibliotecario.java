/*Integrantes Equipo 1:
- Ordaz Rangel David
- Hernández Carlos Mayte Eridani
- Torres Pérez Ashley
Semestre: 3     Grupo: 3 
 */
package pck_vista;

import pck_modelo.Bibliotecario_BD;
import java.sql.Time;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Frm_Bibliotecario extends javax.swing.JFrame {

    private final Bibliotecario_BD BBD;

    public Frm_Bibliotecario() {
        initComponents();
        this.setLocationRelativeTo(null);
        BBD = new Bibliotecario_BD();
        this.listarBiblio();
    }

    public void listarBiblio() {
        DTM_Biblio.setModel(BBD.getDatosBibliotecarios());
    }

    public void limpiar() {
        biblioNombre.setText("");
        biblioApellidoP.setText("");
        biblioApellidoM.setText("");
        biblioID.setEnabled(true);
        biblioID.setText("");
        biblioEntrada.setSelectedIndex(-1);
        biblioSalida.setSelectedIndex(-1);
        biblioNombre.requestFocus();
    }

    public void agregarActualizarBiblio(boolean agregar) {
        String nombre = null, apellidoP = null, apellidoM = null, id = null, hEntrada = null, hSalida = null;
        Time salida = null, entrada = null;
        Date fecha;
        SimpleDateFormat sdf;
        boolean valido = true;
        int res = 0;

        nombre = biblioNombre.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del bibliotecario es un dato requerido.",
                    "CAMPO VACIO!", 2);
            valido = false;
            biblioNombre.grabFocus();
        }
        apellidoP = biblioApellidoP.getText();
        if (apellidoP.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El apellido paterno del bibliotecario es un dato requerido.",
                    "CAMPO VACIO!", 2);
            valido = false;
            biblioApellidoP.grabFocus();
        }
        apellidoM = biblioApellidoM.getText();
        if (apellidoM.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El apellido materno del bibliotecario es un dato requerido.",
                    "CAMPO VACIO!", 2);
            valido = false;
            biblioApellidoM.grabFocus();
        }
        id = biblioID.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El ID del bibliotecario es un dato requerido.",
                    "CAMPO VACIO!", 2);
            valido = false;
            biblioID.grabFocus();
        }
        if (biblioEntrada.getSelectedIndex() != -1) {
            hEntrada = biblioEntrada.getSelectedItem().toString();
            try {
                sdf = new SimpleDateFormat("HH:mm:ss");
                fecha = sdf.parse(hEntrada);
                entrada = new Time(fecha.getTime());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Error al convertir la hora! " + e.getMessage(),
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            valido = false;
            JOptionPane.showMessageDialog(null, "La hora de entrada del bibliotecario es un dato requerido.",
                    "CAMPO VACIO!", 2);
        }
        if (biblioSalida.getSelectedIndex() != -1) {
            hSalida = biblioSalida.getSelectedItem().toString();
            try {
                sdf = new SimpleDateFormat("HH:mm:ss");
                fecha = sdf.parse(hSalida);
                salida = new Time(fecha.getTime());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Error al convertir la hora! " + e.getMessage(),
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            valido = false;
            JOptionPane.showMessageDialog(null, "La hora de salida del bibliotecario es un dato requerido.",
                    "CAMPO VACIO!", 2);
        }
        if (agregar && valido) {
            res = BBD.agregarRegistroBibliotecarios(id, nombre, apellidoP, apellidoM, entrada, salida);
            this.listarBiblio();
            this.limpiar();
        } else if (!agregar && valido) {
            res = BBD.actualizarRegistroBibliotecarios(id, nombre, apellidoP, apellidoM, entrada, salida);
            this.listarBiblio();
            this.limpiar();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        biblioNombre = new javax.swing.JTextField();
        biblioApellidoP = new javax.swing.JTextField();
        biblioApellidoM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        biblioID = new javax.swing.JTextField();
        biblioSalida = new javax.swing.JComboBox<>();
        biblioEntrada = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        biblioCriterio = new javax.swing.JComboBox<>();
        biblioParametro = new javax.swing.JTextField();
        biblioBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DTM_Biblio = new javax.swing.JTable();
        biblioActualizar = new javax.swing.JButton();
        biblioGuadar = new javax.swing.JButton();
        biblioListar = new javax.swing.JButton();
        biblioEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro - Bibliotecario");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Catálogo Bibliotecarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(153, 0, 0))); // NOI18N

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido Paterno:");

        jLabel3.setText("Apellido Materno:");

        jLabel4.setText("ID Bibliotecario:");

        jLabel5.setText("Hora de Entrada:");

        jLabel6.setText("Hora de Salida:");

        biblioSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16:00:00", "16:15:00", "16:30:00", "17:00:00", "17:15:00", "17:30:00", "18:00:00", "18:15:00", "18:30:00" }));
        biblioSalida.setSelectedIndex(-1);

        biblioEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00:00", "08:15:00", "08:30:00", "09:00:00", "09:15:00", "09:30:00", "10:00:00", "10:15:00", "10:30:00" }));
        biblioEntrada.setSelectedIndex(-1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clean.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(biblioID))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(biblioNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(biblioApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(biblioApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(biblioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(biblioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(biblioNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(biblioApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(biblioApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(biblioID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(biblioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(biblioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda de Bibliotecarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(153, 0, 0))); // NOI18N

        biblioCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Bibliotecario", "Nombre Completo" }));

        biblioBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar1.JPG"))); // NOI18N
        biblioBuscar.setText("BUSCAR");
        biblioBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biblioBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(biblioCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(biblioParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(biblioBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(biblioCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(biblioParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(biblioBuscar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Bibliotecarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(153, 0, 0))); // NOI18N

        DTM_Biblio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        DTM_Biblio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DTM_BiblioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DTM_Biblio);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        biblioActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar1.JPG"))); // NOI18N
        biblioActualizar.setText("ACTUALIZAR");
        biblioActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biblioActualizarActionPerformed(evt);
            }
        });

        biblioGuadar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.JPG"))); // NOI18N
        biblioGuadar.setText("GUARDAR");
        biblioGuadar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biblioGuadarActionPerformed(evt);
            }
        });

        biblioListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.JPG"))); // NOI18N
        biblioListar.setText("LISTAR");
        biblioListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biblioListarActionPerformed(evt);
            }
        });

        biblioEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar1.JPG"))); // NOI18N
        biblioEliminar.setText("ELIMINAR");
        biblioEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biblioEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(biblioGuadar)
                        .addGap(18, 18, 18)
                        .addComponent(biblioActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(biblioListar)
                        .addGap(18, 18, 18)
                        .addComponent(biblioEliminar)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(biblioActualizar)
                    .addComponent(biblioGuadar)
                    .addComponent(biblioListar)
                    .addComponent(biblioEliminar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DTM_BiblioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DTM_BiblioMouseClicked
        // TODO add your handling code here:
        this.limpiar();
        int fila = DTM_Biblio.getSelectedRow();

        biblioID.setText(DTM_Biblio.getValueAt(fila, 0).toString());
        biblioID.setEnabled(false);
        biblioNombre.setText(DTM_Biblio.getValueAt(fila, 1).toString());
        biblioApellidoP.setText(DTM_Biblio.getValueAt(fila, 2).toString());
        biblioApellidoM.setText(DTM_Biblio.getValueAt(fila, 3).toString());
        biblioEntrada.setSelectedItem(DTM_Biblio.getValueAt(fila, 4).toString());
        biblioSalida.setSelectedItem(DTM_Biblio.getValueAt(fila, 5).toString());

    }//GEN-LAST:event_DTM_BiblioMouseClicked

    private void biblioGuadarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biblioGuadarActionPerformed
        // TODO add your handling code here:
        this.agregarActualizarBiblio(true);
    }//GEN-LAST:event_biblioGuadarActionPerformed

    private void biblioActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biblioActualizarActionPerformed
        // TODO add your handling code here:
        this.agregarActualizarBiblio(false);
    }//GEN-LAST:event_biblioActualizarActionPerformed

    private void biblioListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biblioListarActionPerformed
        // TODO add your handling code here:
        this.listarBiblio();
    }//GEN-LAST:event_biblioListarActionPerformed

    private void biblioBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biblioBuscarActionPerformed
        // TODO add your handling code here:
        DTM_Biblio.setModel(BBD.buscarRegistroBibliotecarios(biblioCriterio.getSelectedIndex(), biblioParametro.getText()));
    }//GEN-LAST:event_biblioBuscarActionPerformed

    private void biblioEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biblioEliminarActionPerformed
        // TODO add your handling code here:
        int res = 0;
        int fila = DTM_Biblio.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla.", "Eliminar un registro.", 2);
        } else {
            res = BBD.eliminarRegistroBibliotecarios(DTM_Biblio.getValueAt(fila, 0).toString());
            if (res > 0) {
                this.listarBiblio();
                this.limpiar();
            }
        }
    }//GEN-LAST:event_biblioEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Bibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Bibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Bibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Bibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Bibliotecario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DTM_Biblio;
    private javax.swing.JButton biblioActualizar;
    private javax.swing.JTextField biblioApellidoM;
    private javax.swing.JTextField biblioApellidoP;
    private javax.swing.JButton biblioBuscar;
    private javax.swing.JComboBox<String> biblioCriterio;
    private javax.swing.JButton biblioEliminar;
    private javax.swing.JComboBox<String> biblioEntrada;
    private javax.swing.JButton biblioGuadar;
    private javax.swing.JTextField biblioID;
    private javax.swing.JButton biblioListar;
    private javax.swing.JTextField biblioNombre;
    private javax.swing.JTextField biblioParametro;
    private javax.swing.JComboBox<String> biblioSalida;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
