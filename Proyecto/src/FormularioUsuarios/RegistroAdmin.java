/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FormularioUsuarios;

import java.awt.Color;
import javax.swing.BorderFactory;
import ProyectoTap.ValidadorTexto;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import conexionmysql.ConexionBD;
import java.io.File;
import java.io.FileOutputStream;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import libreria.Libreria;
import java.util.*;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;

/**
 *
 * @author binis
 */
public class RegistroAdmin extends javax.swing.JFrame {

    ConexionBD bd = new ConexionBD("localhost", "3306", "topicos", "root", "password");
    String admin="Administrador";
    String cajero="Cajero";
    /**
     * Creates new form Usuarios
     */
    public RegistroAdmin() {
        initComponents();
    
btnRegistrar.setForeground(Color.WHITE);            // Texto blanco
btnRegistrar.setFocusPainted(false);                // Sin borde de foco
btnRegistrar.setBorderPainted(false);               // Sin borde exterior
btnRegistrar.setContentAreaFilled(true);            // Relleno activado
btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        // Se oculta borde completo y se dibuja solo línea inferior
        txtNombre.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        txtNombre.setBackground(new Color(0,0,0,0)); // fondo transparente
        txtNombre.setOpaque(false); // fondo del panel
        txtNombre.setForeground(Color.GRAY);
        
        // Lógica para mostrar/ocultar texto en txtCorreo
        txtNombre.setText("Introduce el nombre");
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (txtNombre.getText().equals("Introduce el nombre")) {
                txtNombre.setText("");
                txtNombre.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (txtNombre.getText().isEmpty()) {
                txtNombre.setText("Introduce el nombre");
                txtNombre.setForeground(Color.GRAY);
            }
        }
    });
        
        // Se oculta borde completo y se dibuja solo línea inferior
        txtUsuario.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        txtUsuario.setBackground(new Color(0,0,0,0)); // fondo transparente
        txtUsuario.setOpaque(false); // fondo del panel
        txtUsuario.setForeground(Color.GRAY);
        
        // Lógica para mostrar/ocultar texto en txtCorreo
        txtUsuario.setText("Introduce un usuario");
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (txtUsuario.getText().equals("Introduce un usuario")) {
                txtUsuario.setText("");
                txtUsuario.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (txtUsuario.getText().isEmpty()) {
                txtUsuario.setText("Introduce un usuario");
                txtUsuario.setForeground(Color.GRAY);
            }
        }
    });
        
        // Se oculta borde completo y se dibuja solo línea inferior
        txtContraseña.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        txtContraseña.setBackground(new Color(0,0,0,0)); // fondo transparente
        txtContraseña.setOpaque(false); // fondo del panel
        txtContraseña.setForeground(Color.GRAY);
        
        // Lógica para mostrar/ocultar texto en txtCorreo
        txtContraseña.setText("Ejemplo valido: Hola123!");
        txtContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (txtContraseña.getText().equals("Ejemplo valido: Hola123")) {
                txtContraseña.setText("");
                txtContraseña.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (txtContraseña.getText().isEmpty()) {
                txtContraseña.setText("Ejemplo valido: Hola123");
                txtContraseña.setForeground(Color.GRAY);
            }
        }
    });
        // Se oculta borde completo y se dibuja solo línea inferior
        txtCorreo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        txtCorreo.setBackground(new Color(0,0,0,0)); // fondo transparente
        txtCorreo.setOpaque(false); // fondo del panel
        txtCorreo.setForeground(Color.GRAY);
        
        // Lógica para mostrar/ocultar texto en txtCorreo
        txtCorreo.setText("Correo valido: usuario@gmail(hotmail).com");
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (txtCorreo.getText().equals("Correo valido: usuario@gmail(hotmail).com")) {
                txtCorreo.setText("");
                txtCorreo.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (txtCorreo.getText().isEmpty()) {
                txtCorreo.setText("Correo valido: usuario@gmail(hotmail).com");
                txtCorreo.setForeground(Color.GRAY);
            }
        }
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombre.setText("jTextField1");

        txtUsuario.setText("jTextField2");

        txtContraseña.setText("jTextField3");

        txtCorreo.setText("jTextField1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Cajero" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Contraseña");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Correo");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Rellene todos los campos.");

        btnRegistrar.setBackground(new java.awt.Color(51, 82, 47));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        jLabel6.setText("REGISTRO");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRegresar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                                        .addComponent(btnRegistrar)
                                        .addGap(148, 148, 148))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtContraseña, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(55, 55, 55)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnRegresar))
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }                                          

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Admin ad = new Admin();
    ad.setVisible(true);
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
String contra = txtContraseña.getText();
    String correo = txtCorreo.getText();

    if (Libreria.validarContra(contra, 8)) {
        if (ValidadorTexto.contieneMayuscula(contra)) {
            if (ValidadorTexto.contieneCaracter(contra)) {
                if (ValidadorTexto.tieneLongitudValida(contra)) {
                    if (ValidadorTexto.esCorreoValido(correo)) {

                        String seleccion = (String) jComboBox1.getSelectedItem();
                        if(seleccion.equals(admin)){
                        
                            if (bd.conectar()) {
                                List<String> cols = Arrays.asList("nombre_usuario", "usuario", "correo", "contraseña","id_rol");
                                List<Object> vals = Arrays.asList(txtNombre.getText(), txtUsuario.getText(), correo, contra,1);
                                bd.insertar("usuario", cols, vals);
                            }
                        }else if(seleccion.equals(cajero)){
                             if (bd.conectar()) {
                                List<String> cols = Arrays.asList("nombre_usuario", "usuario", "correo", "contraseña","id_rol");
                                List<Object> vals = Arrays.asList(txtNombre.getText(), txtUsuario.getText(), correo, contra,2);
                                bd.insertar("usuario", cols, vals);
                             }
                        }
                        

                        
                            String rutaPDF = generarPDF(txtNombre.getText(), txtUsuario.getText(), contra);
                            enviarCorreoConPDF(correo, rutaPDF);
                        

                    } else {
                        lblCorreo.setText("El correo no es válido");
                        lblCorreo.setForeground(Color.RED);
                    }
                } else {
                    lblContraseña.setText("Contraseña muy larga");
                    lblContraseña.setForeground(Color.RED);
                }
            } else {
                lblContraseña.setText("Faltan caracteres especiales");
                lblContraseña.setForeground(Color.RED);
            }
        } else {
            lblContraseña.setText("Debe tener Mayus y minus");
            lblContraseña.setForeground(Color.RED);
        }
    } else {
        lblContraseña.setText("Contraseña vacía o muy corta");
        lblContraseña.setForeground(Color.RED);
    }  
    this.dispose();
    // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        Admin a=new Admin();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
       
    
    
    private String generarPDF(String nombre, String usuario, String contra) {
    Document document = new Document();
    String rutaCompleta = "";

    try {
        String rutaUsuario = System.getProperty("user.home");
        String carpeta = rutaUsuario + File.separator + "Documents" + File.separator + "pdf de usuarios";

        File directorio = new File(carpeta);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        String nombreArchivo = "UsuarioContraseña_" + nombre + ".pdf";
        rutaCompleta = carpeta + File.separator + nombreArchivo;

        PdfWriter.getInstance(document, new FileOutputStream(rutaCompleta));
        document.open();

        // === RUTA DEL LOGO ===
        String rutaLogo = "C:\\Users\\garci\\Documents\\NetBeansProjects\\Implementacionbd\\src\\imagenes\\bancomex_png.png"; // Cambia esta ruta manualmente

        // Fuentes
        Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
        Font fontSub = new Font(Font.FontFamily.HELVETICA, 12, Font.ITALIC, BaseColor.RED);
        Font fontNormal = new Font(Font.FontFamily.HELVETICA, 12);
        Font fontNegrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Font fontPie = new Font(Font.FontFamily.HELVETICA, 9, Font.ITALIC, BaseColor.GRAY);

        // Logo alineado a la izquierda
        try {
            Image logo = Image.getInstance(rutaLogo);
            logo.scaleToFit(80, 80);
            logo.setAlignment(Image.ALIGN_LEFT);
            document.add(logo);
        } catch (Exception e) {
            System.out.println("No se pudo cargar el logo: " + e.getMessage());
        }

        // Título y subtítulo centrados
        Paragraph titulo = new Paragraph("BANCOMEX", fontTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);

        Paragraph subtitulo = new Paragraph("Confianza y seguridad.", fontSub);
        subtitulo.setAlignment(Element.ALIGN_CENTER);
        document.add(subtitulo);

        document.add(Chunk.NEWLINE);

        // Contenido principal
        Paragraph saludo = new Paragraph("Bienvenido(a)\n\n", fontNegrita);
        document.add(saludo);

        Paragraph texto = new Paragraph();
        texto.add(new Chunk("Estimado(a) " + nombre + ",\n", fontNegrita));
        texto.add(new Chunk("Nos complace darte la bienvenida y agradecerte por tu preferencia y confianza en nuestros servicios.\n\n", fontNormal));
        texto.add(new Chunk("A continuación, te compartimos tus credenciales de acceso, las cuales te permitirán ingresar a nuestra plataforma y comenzar a disfrutar de los beneficios que ofrecemos:\n\n", fontNormal));

        texto.add(new Chunk("•➤ Usuario: ", fontNegrita));
        texto.add(new Chunk(usuario + "\n", fontNormal));
        texto.add(new Chunk("•➤ Contraseña: ", fontNegrita));
        texto.add(new Chunk(contra + "\n\n", fontNormal));

        texto.add(new Chunk("Te recomendamos mantener esta información en un lugar seguro y no compartirla con terceros. Si tienes alguna duda o necesitas asistencia, no dudes en ponerte en contacto con nuestro equipo de soporte.\n\n", fontNormal));
        texto.add(new Chunk("Una vez más, ¡gracias por elegirnos!\n\n", fontNegrita));
        document.add(texto);

        // Texto final personalizado con BANCOMEX en negritas y mayúsculas
        Paragraph finalTexto = new Paragraph("Gracias por tu confianza. Seguimos trabajando para ti, ", fontNormal);
        finalTexto.add(new Chunk("BANCOMEX", fontNegrita));
        finalTexto.add(new Chunk(".", fontNormal));
        document.add(finalTexto);

        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);

        // Pie de página
        Paragraph pie = new Paragraph("Soporte: Bancomexavisos@gmail.com", fontPie);
        pie.setAlignment(Element.ALIGN_CENTER);
        document.add(pie);

        document.close();
        return rutaCompleta;

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al generar PDF:\n" + ex.getMessage());
        return "";
    }
}

    
    private void enviarCorreoConPDF(String correoDestino, String rutaPDF) {
    final String remitente = "garciaheber138@gmail.com"; // TU CORREO
    final String clave = "hhjy hacs pvtf pjin"; // Usa una contraseña de aplicación si es Gmail

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        @Override
        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
           return new javax.mail.PasswordAuthentication(remitente, clave); 
        }
    });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(remitente));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestino));
        message.setSubject("Credenciales de registro");

        BodyPart mensajeTexto = new MimeBodyPart();
        mensajeTexto.setText("Adjunto encontrarás tu usuario y contraseña en formato PDF.");

        MimeBodyPart adjunto = new MimeBodyPart();
        adjunto.attachFile(new File(rutaPDF));

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mensajeTexto);
        multipart.addBodyPart(adjunto);

        message.setContent(multipart);

        Transport.send(message);

        JOptionPane.showMessageDialog(this, "Correo enviado a: " + correoDestino);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al enviar correo:\n" + e.getMessage());
    }
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
            java.util.logging.Logger.getLogger(RegistroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
