# 🏦 Sistema de Gestión Bancaria - <BANCOMEX>

### 🧾 Número de equipo: <Equipo 6>

### 👥 Integrantes:
- <Nombre completo 1> – Desarrollador y diseñador
- <Heber de Jesús García Bautista> – Base de datos y lógica.

---

### 📌 ¿Qué hace el sistema?

Sistema de gestion bancaria que permite la gestión de cuentas bancarias, usuarios (como gerentes, cajeros y clientes), asi como tambien depósitos y retiros entre cuentas. Incluye validación con CAPTCHA y envío de pdf´s con registro de usuarios y ticktes por correo electrónico.

---

### 🖥️ Tipo de sistema

**Aplicación de escritorio en Java**, desarrollada con **Swing**, conexión a **MySQL** y generación de PDF con librerías externas.

---

### 📚 Librería externa implementada

Se utilizó la librería **`Validator`** del **Equipo 2** para validar formularios de ingreso, transferencia y creación de cuentas.  
🔗 [Repositorio de Validator del Equipo 2](<URL_DEL_REPOSITORIO>)

---

### 🗓️ Componente visual integrado

Incluimos el componente **`CalendarPicker`** del **Equipo 11** para seleccionar fechas en los reportes bancarios.  
🔗 [Repositorio de CalendarPicker del Equipo 11](<URL_DEL_REPOSITORIO>)

---

## ✨ Funcionalidades Clave

### 🔒 Validación CAPTCHA
- Se activa al iniciar sesión para evitar accesos no autorizados.
- Utiliza el CAPTCHA del **Equipo 2**.

### 👤 CRUD de Usuarios
- Administradores pueden registrar, modificar o eliminar clientes.

### 💳 CRUD de Cuentas Bancarias
- Registro de cuentas por cliente.
- Asignación de tipo de cuenta y saldo inicial.

### 💰 Operaciones bancarias
- **Depósitos**: Aumentan el saldo de la cuenta.
- **Retiros**: Disminuyen el saldo, con verificación de fondos.
- **Transferencias**: De una cuenta a otra, con comprobante de movimiento.

### 🧾 Generación y envío de comprobante en PDF
- Cada operación genera un PDF con los datos clave de la transacción.
- El comprobante se envía al correo del cliente usando **JavaMail API**.

> 📄 PDF generado con la librería **PDFBox** (adaptada para agregar logo del banco y detalles de la transacción).  
🔗 [Repositorio PDFBox](https://github.com/apache/pdfbox)

### 📈 Reporte de movimientos
- Consultar movimientos por fecha o por tipo (depósitos, retiros, etc.).

### ✨ Otras funcionalidades:
- Búsqueda de cuentas y clientes por nombre o número.
- Seguridad basada en roles (cliente vs administrador).
- Panel de control con saldos totales.

---

## ⚙️ Dependencias y Configuración

### 📦 Librerías externas utilizadas

- `JavaMail` – Envío de correos con comprobantes
- `PDFBox` – Generación de documentos PDF
- `Validator` – Validación de campos (Equipo 2)
- `CalendarPicker` – Selector de fechas (Equipo 11)

---

### 🛠️ Pasos para instalar y ejecutar

1. Clonar el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
