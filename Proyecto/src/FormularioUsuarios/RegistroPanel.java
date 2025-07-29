/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FormularioUsuarios;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import ProyectoTap.ValidadorTexto;
import conexionmysql.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JButton;

/**
 * Clase que representa una ventana de registro/inicio de sesión con interfaz gráfica personalizada.
 * Permite al usuario introducir su correo y contraseña, realizar validaciones y navegar hacia otras ventanas.
 * 
 * @author Yhudiel Mendoza
 * @version 1.0
 */
public class RegistroPanel extends javax.swing.JFrame {

private boolean captchaValidado = false;

    /**
     * 
     * Constructor de la clase RegistroPanel.
     * Configura componentes visuales, estilos, comportamiento de los campos y botones.
     */
    public RegistroPanel() {
        setUndecorated(true);
        setContentPane(new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondobanco.jpg"))));
        initComponents();
        setLocationRelativeTo(null);


       /* btnRegistro.setContentAreaFilled(false);     // Sin fondo
        btnRegistro.setBorderPainted(false);         // Sin borde
        btnRegistro.setForeground(new Color(0, 85, 74)); // Azul claro
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));*/
        btnCerrar.setContentAreaFilled(false);     // Sin fondo
        btnCerrar.setBorderPainted(false);         // Sin borde
        
        // Personalización visual del botón INGRESAR
btnIngresar.setBackground(new Color(0, 85, 74)); // Azul profesional
btnIngresar.setForeground(Color.WHITE);            // Texto blanco
btnIngresar.setFocusPainted(false);                // Sin borde de foco
btnIngresar.setBorderPainted(false);               // Sin borde exterior
btnIngresar.setContentAreaFilled(true);            // Relleno activado
btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//btnIngresar.setPreferredSize(new java.awt.Dimension(180, 45)); // Tamaño más grande


        

        
        // Se oculta borde completo y se dibuja solo línea inferior
        txtCorreo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        txtCorreo.setBackground(new Color(0,0,0,0)); // fondo transparente
        txtCorreo.setOpaque(false); // fondo del panel
        txtCorreo.setForeground(Color.GRAY);
        
        // Lógica para mostrar/ocultar texto en txtCorreo
        txtCorreo.setText("Introduce tu correo");
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (txtCorreo.getText().equals("Introduce tu correo")) {
                txtCorreo.setText("");
                txtCorreo.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (txtCorreo.getText().isEmpty()) {
                txtCorreo.setText("Introduce tu correo");
                txtCorreo.setForeground(Color.GRAY);
            }
        }
    });
        
        // ==== Personalización visual de txtContrasena ====
        txtContrasena.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        txtContrasena.setBackground(new Color(0,0,0,0));
        txtContrasena.setOpaque(false);
        txtContrasena.setForeground(Color.GRAY);
        txtContrasena.setText("Introduce tu contraseña");

        // Lógica para texto en txtContrasena
        txtContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (String.valueOf(txtContrasena.getPassword()).equals("Introduce tu contraseña")) {
                txtContrasena.setText("");
                txtContrasena.setEchoChar('•'); // o '*'
                txtContrasena.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (String.valueOf(txtContrasena.getPassword()).isEmpty()) {
                txtContrasena.setEchoChar((char)0);
                txtContrasena.setText("Introduce tu contraseña");
                txtContrasena.setForeground(Color.GRAY);
            }
        }
        });
        
        // Se oculta borde completo y se dibuja solo línea inferior
        txtCaptcha.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        txtCaptcha.setBackground(new Color(0,0,0,0)); // fondo transparente
        txtCaptcha.setOpaque(false); // fondo del panel
        txtCaptcha.setForeground(Color.GRAY);
        
        // Lógica para mostrar/ocultar texto en txtCorreo
        txtCaptcha.setText("Introduce el texto");
        txtCaptcha.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (txtCaptcha.getText().equals("Introduce el texto")) {
                txtCaptcha.setText("");
                txtCaptcha.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (txtCaptcha.getText().isEmpty()) {
                txtCaptcha.setText("Introduce el texto");
                txtCaptcha.setForeground(Color.GRAY);
            }
        }
    });
    }    

    /**
     * Cambia el color de fondo del panel derecho.
     * @param color Color deseado
     */
    public void setColorFondoPanel2(Color color) {
        jPanel3.setBackground(color);
    }

    /**
     * Obtiene el color de fondo del panel derecho.
     * @return Color actual
     */
    public Color getColorFondoPanel2() {
        return jPanel3.getBackground();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        lblErrorContrasena = new javax.swing.JLabel();
        lblErrorCorreo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlReCaptcha = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        captchaPanel1 = new FormularioUsuarios.CaptchaPanel();
        txtCaptcha = new javax.swing.JTextField();
        lblErrorCaptcha = new javax.swing.JLabel();
        lblErrorcaptcha = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnPracticaja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 650));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe Print", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Somos tu mejor aliado..!");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        lblMensaje.setBackground(new java.awt.Color(0, 0, 0));
        lblMensaje.setFont(new java.awt.Font("Segoe UI Semibold", 2, 36)); // NOI18N
        lblMensaje.setText("Iniciar Sesión");

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
        });
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        btnIngresar.setBackground(new java.awt.Color(0, 85, 74));
        btnIngresar.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        btnIngresar.setText("Entrar");
        btnIngresar.setBorder(null);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        lblErrorContrasena.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorCorreo.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel1.setText("Correo:");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel2.setText("Contraseña:");

        pnlReCaptcha.setBackground(new java.awt.Color(255, 255, 255));
        pnlReCaptcha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlReCaptchaMouseClicked(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoframe/refresh.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout captchaPanel1Layout = new javax.swing.GroupLayout(captchaPanel1);
        captchaPanel1.setLayout(captchaPanel1Layout);
        captchaPanel1Layout.setHorizontalGroup(
            captchaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        captchaPanel1Layout.setVerticalGroup(
            captchaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlReCaptchaLayout = new javax.swing.GroupLayout(pnlReCaptcha);
        pnlReCaptcha.setLayout(pnlReCaptchaLayout);
        pnlReCaptchaLayout.setHorizontalGroup(
            pnlReCaptchaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReCaptchaLayout.createSequentialGroup()
                .addComponent(captchaPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlReCaptchaLayout.setVerticalGroup(
            pnlReCaptchaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlReCaptchaLayout.createSequentialGroup()
                .addComponent(captchaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtCaptcha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaptchaActionPerformed(evt);
            }
        });

        lblErrorcaptcha.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(lblMensaje)
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(lblErrorCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lblErrorContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblErrorCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlReCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(lblErrorcaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlReCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblErrorcaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorCaptcha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCaptcha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(204, 0, 0));
        btnCerrar.setText("X");
        btnCerrar.setBorder(null);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnPracticaja.setText("PractiCaja");
        btnPracticaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPracticajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnPracticaja)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(297, 297, 297))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 454, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPracticaja)
                        .addGap(132, 132, 132)))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción del botón de cerrar ventana.
     * Cierra completamente la aplicación.
     * @param evt Evento del botón
     */
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed
    
    private void btnPracticaCajeroActionPerformed(java.awt.event.ActionEvent evt) {                                              
    PracticaCajero practica = new PracticaCajero();
    practica.setVisible(true);
}  

    /**
     * Acción del botón "Entrar".
     * Valida los campos y abre la ventana principal si las credenciales son válidas.
     * @param evt Evento del botón
     */
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String correoIngresado = txtCorreo.getText();
    String contrasenaIngresada = new String(txtContrasena.getPassword());
    String captchaIngresado = txtCaptcha.getText().trim();

    // Validar CAPTCHA vacío
    if (captchaIngresado.isEmpty() || captchaIngresado.equals("Introduce el texto")) {
        lblErrorcaptcha.setText("Por favor ingrese el captcha");
        lblErrorcaptcha.setForeground(Color.RED);
        return;
    }

    // CAPTCHA válido
    lblErrorcaptcha.setText(""); // Limpia errores anteriores

    ConexionBD conexion = new ConexionBD("localhost", "3306", "topicos", "root", "password");

    if (conexion.conectar()) {
        String consulta = "SELECT id_rol FROM usuario WHERE correo = ? AND contraseña = ?";
        
        try {
            PreparedStatement stmt = conexion.getConexion().prepareStatement(consulta);
            stmt.setString(1, correoIngresado);
            stmt.setString(2, contrasenaIngresada);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int rol = rs.getInt("id_rol");

                // Abrir ventana según el rol
                if (rol == 1) {
                    MenuAdmin admin = new MenuAdmin();
                    admin.setVisible(true);
                } else if (rol == 2) {
                    MenuCajero cajero = new MenuCajero();
                    cajero.setVisible(true);
                }

                this.dispose(); // Cierra el login
            } else {
                lblErrorContrasena.setText("Contraseña incorrecta");
                lblErrorCorreo.setText("Correo Incorrecto");
            }

            rs.close();
            stmt.close();
            conexion.cerrar();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al consultar en la base de datos.");
        }

    } else {
        JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
    }

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoFocusGained

    private void btnPracticajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPracticajaActionPerformed
        // TODO add your handling code here:
        PracticaCajero p= new PracticaCajero();
        p.setVisible(true);
    }//GEN-LAST:event_btnPracticajaActionPerformed

    private void pnlReCaptchaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlReCaptchaMouseClicked

    }//GEN-LAST:event_pnlReCaptchaMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        captchaPanel1.refrescarCaptcha();   // TODO add your handling code here:
        //captcha.refrescarCaptcha();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txtCaptchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaptchaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaptchaActionPerformed

    /**
     * Método principal. Lanza la ventana RegistroPanel.
     * @param args Argumentos de línea de comandos
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
            java.util.logging.Logger.getLogger(RegistroPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnIngresar;
    public javax.swing.JButton btnPracticaja;
    public FormularioUsuarios.CaptchaPanel captchaPanel1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblErrorCaptcha;
    public javax.swing.JLabel lblErrorContrasena;
    public javax.swing.JLabel lblErrorCorreo;
    public javax.swing.JLabel lblErrorcaptcha;
    public javax.swing.JLabel lblMensaje;
    public javax.swing.JPanel pnlReCaptcha;
    public javax.swing.JTextField txtCaptcha;
    public javax.swing.JPasswordField txtContrasena;
    public javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
