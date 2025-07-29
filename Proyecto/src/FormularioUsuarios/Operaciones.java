/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FormularioUsuarios;

/**
 *
 * @author garci
 */



import conexionmysql.ConexionBD;
import java.awt.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;


public class Operaciones extends JFrame {

    private ConexionBD conexion;
    private String numeroTarjetaActual;
    private DefaultTableModel modeloTabla;

    private JPanel panelContenedor;
    private CardLayout cardLayout;

    private JPanel inicioPanel, retiroLoginPanel, retiroMontoPanel, depositoPanel, reportePanel;

    private JLabel lblSaldo;
    private JButton btnDeposito, btnRetiro, btnRegresarMenu;

    private JTextField txtTarjetaDeposito, txtMontoDeposito;
    private JButton btnDepositar, btnCancelarDeposito;

    private JTextField txtTarjetaRetiro, txtMontoRetiro;
    private JPasswordField txtNipRetiro;
    private JButton btnRetirar, btnCancelarRetiro;

    private JTable tblMovimientos;
    private JButton btnRegresarReporte;

    public Operaciones() {
        configurarVentana();
        inicializarComponentes();
        configurarEventos();
        conexion = new ConexionBD("localhost", "3306", "topicos", "root", "password");
    }

    private void configurarVentana() {
        setTitle("Cajero Automático");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicializarComponentes() {
        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);

        // Panel Inicio
        inicioPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        inicioPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblSaldo = new JLabel("Saldo: $0.00", SwingConstants.CENTER);
        lblSaldo.setFont(new java.awt.Font("Arial", Font.BOLD, 16));

        btnDeposito = new JButton("Depositar");
        btnRetiro = new JButton("Retirar");
        btnRegresarMenu = new JButton("Regresar");

        inicioPanel.add(lblSaldo);
        inicioPanel.add(btnDeposito);
        inicioPanel.add(btnRetiro);
        inicioPanel.add(btnRegresarMenu);

        // Panel Depósito
        depositoPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        depositoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        txtTarjetaDeposito = new JTextField();
        txtMontoDeposito = new JTextField();
        btnDepositar = new JButton("Confirmar");
        btnCancelarDeposito = new JButton("Cancelar");

        depositoPanel.add(new JLabel("Tarjeta Destino:"));
        depositoPanel.add(txtTarjetaDeposito);
        depositoPanel.add(new JLabel("Monto:"));
        depositoPanel.add(txtMontoDeposito);
        depositoPanel.add(new JLabel(""));
        depositoPanel.add(new JLabel(""));
        depositoPanel.add(btnDepositar);
        depositoPanel.add(btnCancelarDeposito);

        // Panel Retiro Login
        retiroLoginPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        retiroLoginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        txtTarjetaRetiro = new JTextField();
        txtNipRetiro = new JPasswordField();
        JButton btnValidarNip = new JButton("Continuar");

        retiroLoginPanel.add(new JLabel("Tarjeta:"));
        retiroLoginPanel.add(txtTarjetaRetiro);
        retiroLoginPanel.add(new JLabel("NIP:"));
        retiroLoginPanel.add(txtNipRetiro);
        retiroLoginPanel.add(new JLabel(""));
        retiroLoginPanel.add(btnValidarNip);

        // Panel Retiro Monto
        retiroMontoPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        retiroMontoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        txtMontoRetiro = new JTextField();
        btnRetirar = new JButton("Confirmar Retiro");
        btnCancelarRetiro = new JButton("Cancelar");

        retiroMontoPanel.add(new JLabel("Saldo actual:"));
        retiroMontoPanel.add(lblSaldo);
        retiroMontoPanel.add(new JLabel("Monto a retirar:"));
        retiroMontoPanel.add(txtMontoRetiro);
        retiroMontoPanel.add(btnRetirar);
        retiroMontoPanel.add(btnCancelarRetiro);

        // Panel Reporte
        reportePanel = new JPanel(new BorderLayout(10, 10));
        reportePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Monto");
        modeloTabla.addColumn("Tarjeta Relacionada");

        tblMovimientos = new JTable(modeloTabla);
        btnRegresarReporte = new JButton("Regresar al Inicio");

        reportePanel.add(new JScrollPane(tblMovimientos), BorderLayout.CENTER);
        reportePanel.add(btnRegresarReporte, BorderLayout.SOUTH);

        panelContenedor.add(inicioPanel, "inicio");
        panelContenedor.add(depositoPanel, "deposito");
        panelContenedor.add(retiroLoginPanel, "retiroLogin");
        panelContenedor.add(retiroMontoPanel, "retiroMonto");
        panelContenedor.add(reportePanel, "reporte");

        add(panelContenedor);
    }

    private void configurarEventos() {
        btnDeposito.addActionListener(e -> mostrarPanel("deposito"));
        btnRetiro.addActionListener(e -> mostrarPanel("retiroLogin"));

        btnDepositar.addActionListener(e -> realizarDeposito());
        btnCancelarDeposito.addActionListener(e -> mostrarPanel("inicio"));

        btnRetirar.addActionListener(e -> realizarRetiro());
        btnCancelarRetiro.addActionListener(e -> mostrarPanel("inicio"));

        btnRegresarReporte.addActionListener(e -> mostrarPanel("inicio"));
        
        
        btnRegresarMenu.addActionListener(e -> {
    this.dispose(); // Cierra esta ventana

    // Abre el panel de menú principal
    MenuCajero menu = new MenuCajero();
    menu.setVisible(true);
});


        JButton btnValidarNip = (JButton) retiroLoginPanel.getComponent(5);
        btnValidarNip.addActionListener(e -> {
            String tarjeta = txtTarjetaRetiro.getText().trim();
            String nip = new String(txtNipRetiro.getPassword());

            if (tarjeta.isEmpty() || nip.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese tarjeta y NIP");
                return;
            }

            if (!verificarTarjetaYNip(tarjeta, nip)) {
                JOptionPane.showMessageDialog(this, "NIP incorrecto");
                return;
            }

            numeroTarjetaActual = tarjeta;
            lblSaldo.setText(String.format("$%.2f", obtenerSaldo(tarjeta)));
            mostrarPanel("retiroMonto");
        });
    }

    private void mostrarPanel(String nombrePanel) {
        cardLayout.show(panelContenedor, nombrePanel);
    }

    public void realizarDeposito() {
        String tarjeta = txtTarjetaDeposito.getText().trim();
        String montoStr = txtMontoDeposito.getText().trim();

        if (tarjeta.isEmpty() || montoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
            return;
        }

        double monto;
        try {
            monto = Double.parseDouble(montoStr);
            if (monto <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Monto no válido");
            return;
        }

        if (!verificarTarjeta(tarjeta)) {
            JOptionPane.showMessageDialog(this, "Tarjeta no encontrada");
            return;
        }

        if (conexion.conectar()) {
            Connection conn = conexion.getConexion();
            try {
                conn.setAutoCommit(false);
                double saldoActual = obtenerSaldo(tarjeta);
                if (!actualizarSaldo(conn, tarjeta, saldoActual + monto)) {
                    conn.rollback();
                    JOptionPane.showMessageDialog(this, "Error al actualizar saldo");
                    return;
                }

                int idCliente = obtenerIdCliente(tarjeta);
                if (!registrarMovimiento(conn, idCliente, "Depósito", monto, tarjeta)) {
                    conn.rollback();
                    JOptionPane.showMessageDialog(this, "Error al registrar movimiento");
                    return;
                }

                conn.commit();
                
                String correo = obtenerCorreoCliente(tarjeta);
                if (correo != null) {
                    enviarTicketPorCorreo(correo, "Depósito", monto, tarjeta);
                }

                JOptionPane.showMessageDialog(this, "Depósito realizado correctamente");
                actualizarDatosCliente(tarjeta);
            } catch (SQLException e) {
                try { conn.rollback(); } catch (SQLException ex) {}
                JOptionPane.showMessageDialog(this, "Error en el depósito: " + e.getMessage());
            } finally {
                try { conn.setAutoCommit(true); } catch (SQLException e) {}
            }
        }
    }

    public void realizarRetiro() {
        String tarjeta = numeroTarjetaActual;
        String montoStr = txtMontoRetiro.getText().trim();

        if (tarjeta == null || montoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Datos incompletos");
            return;
        }

        double monto;
        try {
            monto = Double.parseDouble(montoStr);
            if (monto <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Monto no válido");
            return;
        }

        if (conexion.conectar()) {
            Connection conn = conexion.getConexion();
            try {
                conn.setAutoCommit(false);
                double saldoActual = obtenerSaldo(tarjeta);
                if (saldoActual < monto) {
                    JOptionPane.showMessageDialog(this, "Saldo insuficiente");
                    conn.rollback();
                    return;
                }

                if (!actualizarSaldo(conn, tarjeta, saldoActual - monto)) {
                    conn.rollback();
                    JOptionPane.showMessageDialog(this, "Error al actualizar saldo");
                    return;
                }

                int idCliente = obtenerIdCliente(tarjeta);
                if (!registrarMovimiento(conn, idCliente, "Retiro", -monto, tarjeta)) {
                    conn.rollback();
                    JOptionPane.showMessageDialog(this, "Error al registrar movimiento");
                    return;
                }

                conn.commit();
                String correo = obtenerCorreoCliente(tarjeta);
                if (correo != null) {
                    enviarTicketPorCorreo(correo, "Retiro", monto, tarjeta);
                }

                JOptionPane.showMessageDialog(this, "Retiro exitoso\nMonto retirado: $" + monto);
                actualizarDatosCliente(tarjeta);
            } catch (SQLException ex) {
                try { conn.rollback(); } catch (SQLException e) {}
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            } finally {
                try { conn.setAutoCommit(true); } catch (SQLException e) {}
            }
        }
    }

    private void actualizarDatosCliente(String numeroTarjeta) {
        int idCliente = obtenerIdCliente(numeroTarjeta);
        if (idCliente != -1) {
            lblSaldo.setText("Saldo: $" + String.format("%.2f", obtenerSaldo(numeroTarjeta)));
            cargarMovimientos(idCliente);
            mostrarPanel("inicio");
        }
    }

    private boolean verificarTarjeta(String numeroTarjeta) {
        String limpio = numeroTarjeta.replaceAll("[^0-9]", "");
        if (conexion.conectar()) {
            try {
                PreparedStatement stmt = conexion.getConexion().prepareStatement(
                        "SELECT COUNT(*) FROM cliente WHERE numero_tarjeta = ?");
                stmt.setString(1, limpio);
                ResultSet rs = stmt.executeQuery();
                return rs.next() && rs.getInt(1) > 0;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    private boolean verificarTarjetaYNip(String numeroTarjeta, String nip) {
        String limpio = numeroTarjeta.replaceAll("[^0-9]", "");
        if (conexion.conectar()) {
            try {
                PreparedStatement stmt = conexion.getConexion().prepareStatement(
                        "SELECT nip_cliente FROM cliente WHERE numero_tarjeta = ?");
                stmt.setString(1, limpio);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    byte[] nipBD = rs.getBytes("nip_cliente");
                    return MessageDigest.isEqual(nipBD, hashNip(nip));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    private byte[] hashNip(String nip) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(nip.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            return new byte[0];
        }
    }

    private int obtenerIdCliente(String numeroTarjeta) {
        String limpio = numeroTarjeta.replaceAll("[^0-9]", "");
        if (conexion.conectar()) {
            try {
                PreparedStatement stmt = conexion.getConexion().prepareStatement(
                        "SELECT id_cliente FROM cliente WHERE numero_tarjeta = ?");
                stmt.setString(1, limpio);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) return rs.getInt("id_cliente");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    private double obtenerSaldo(String numeroTarjeta) {
        String limpio = numeroTarjeta.replaceAll("[^0-9]", "");
        if (conexion.conectar()) {
            try {
                PreparedStatement stmt = conexion.getConexion().prepareStatement(
                        "SELECT saldo FROM cliente WHERE numero_tarjeta = ?");
                stmt.setString(1, limpio);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) return rs.getDouble("saldo");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    private boolean actualizarSaldo(Connection conn, String numeroTarjeta, double nuevoSaldo) throws SQLException {
        String limpio = numeroTarjeta.replaceAll("[^0-9]", "");
        PreparedStatement stmt = conn.prepareStatement("UPDATE cliente SET saldo = ? WHERE numero_tarjeta = ?");
        stmt.setDouble(1, nuevoSaldo);
        stmt.setString(2, limpio);
        return stmt.executeUpdate() > 0;
    }

    private boolean registrarMovimiento(Connection conn, int idCliente, String tipo, double monto, String relacionada) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO movimientos (id_cliente, tipo, monto, tarjeta_relacionada) VALUES (?, ?, ?, ?)");
        stmt.setInt(1, idCliente);
        stmt.setString(2, tipo);
        stmt.setDouble(3, monto);
        stmt.setString(4, relacionada);
        return stmt.executeUpdate() > 0;
    }

    private void cargarMovimientos(int idCliente) {
        modeloTabla.setRowCount(0);
        if (conexion.conectar()) {
            try {
                String sql = "SELECT tipo, monto, fecha, tarjeta_relacionada FROM movimientos WHERE id_cliente = ? ORDER BY fecha DESC";
                PreparedStatement stmt = conexion.getConexion().prepareStatement(sql);
                stmt.setInt(1, idCliente);
                ResultSet rs = stmt.executeQuery();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                while (rs.next()) {
                    modeloTabla.addRow(new Object[]{
                        sdf.format(rs.getTimestamp("fecha")),
                        rs.getString("tipo"),
                        String.format("$%.2f", rs.getDouble("monto")),
                        rs.getString("tarjeta_relacionada") != null ? rs.getString("tarjeta_relacionada") : "N/A"
                    });
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private String obtenerNombreCliente(String numeroTarjeta) {
    if (conexion.conectar()) {
        try {
            PreparedStatement stmt = conexion.getConexion().prepareStatement(
                "SELECT nombre_cliente FROM cliente WHERE numero_tarjeta = ?");
            stmt.setString(1, numeroTarjeta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("nombre_cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return "Cliente";
}

    
    
    private void enviarTicketPorCorreo(String correo, String tipoMovimiento, double monto, String tarjeta) {
    String remitente = "garciaheber138@gmail.com"; // Cambia por tu correo
    String clave = "hhjy hacs pvtf pjin"; // Usa contraseña de app (si es Gmail)

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(remitente, clave);
        }
    });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(remitente));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
        message.setSubject("Ticket de " + tipoMovimiento);

        // Parte del mensaje
        MimeBodyPart textoParte = new MimeBodyPart();
        textoParte.setText("Hola,\n\nSe ha realizado un " + tipoMovimiento.toLowerCase() +
            " exitoso. Adjuntamos el ticket en PDF.\n\nGracias por usar nuestro cajero.");

        // Parte del archivo adjunto
        String nombreCliente = obtenerNombreCliente(tarjeta);
        File archivoPDF = generarTicketPDF(tipoMovimiento, monto, tarjeta, nombreCliente);
        MimeBodyPart adjuntoParte = new MimeBodyPart();
        adjuntoParte.attachFile(archivoPDF);

        // Juntar ambas partes
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(textoParte);
        multipart.addBodyPart(adjuntoParte);

        message.setContent(multipart);
        Transport.send(message);

        System.out.println("Correo enviado con ticket adjunto a " + correo);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al enviar ticket por correo: " + e.getMessage());
    }
}

    
    private String obtenerCorreoCliente(String numeroTarjeta) {
    if (conexion.conectar()) {
        try {
            PreparedStatement stmt = conexion.getConexion().prepareStatement(
                "SELECT correo_cliente FROM cliente WHERE numero_tarjeta = ?");
            stmt.setString(1, numeroTarjeta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("correo_cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
}
    
    
    
     private File generarTicketPDF(String tipo, double monto, String tarjeta, String nombreCliente) {
    Document documento = new Document();
    File archivo = new File("ticket_" + System.currentTimeMillis() + ".pdf");

    try {
        PdfWriter.getInstance(documento, new FileOutputStream(archivo));
        documento.open();

       com.itextpdf.text.Font titulo = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 18, com.itextpdf.text.Font.BOLD);
com.itextpdf.text.Font normal = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12);


        documento.add(new Paragraph("TICKET DE " + tipo.toUpperCase(), titulo));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("Cliente: " + nombreCliente, normal));
        documento.add(new Paragraph("Número de tarjeta: " + tarjeta, normal));
        documento.add(new Paragraph("Monto: $" + String.format("%.2f", monto), normal));
        documento.add(new Paragraph("Fecha: " + new java.util.Date(), normal));
        documento.add(new Paragraph("\nGracias por usar nuestro cajero.", normal));

        documento.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al generar el PDF");
    }

    return archivo;
}



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Operaciones().setVisible(true));
    }
}


