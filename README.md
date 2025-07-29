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

Se utilizó la librería **`Librería `** del **Equipo 7** para validar las contraseñas con sus debidos formatos.  
🔗 [Repositorio de Librería del Equipo 7](<https://github.com/Marco1120/Creacion-Libreria>).

Se utilizó la librería **`Librería para enviar correo electronicos con PDF´s `** del **Equipo 2** para poder enviar correos con los pdf´s generados al momento de registrarse y hacer una operación.  
🔗 [Repositorio de la librería para enviar correos con pdf del Equipo 2](<https://github.com/olmomomo/Libreria_correoElectronico>).

También utilizamos las librerías hecha por el equipo la cual es **`Libreria de validacion de correos y contraseñas `** del equipo **Equipo 6** para validar los correos y contraseñas.
🔗 [Repositorio de la librería para validar correos y contraseñas del Equipo 6](<https://github.com/YHUDIEL/Login-con-validaciones>).

---

### 🗓️ Componente visual integrado

Incluimos el componente **`CaptchaPanel`** del **Equipo 6** para usarlo en el login para validar que el usuario no es un bot, para ello usamos el componente del Captcha.  
🔗 [Repositorio de la librería para validar correos y contraseñas del Equipo 11](<https://github.com/YHUDIEL/Login-con-validaciones>).

Incluimos tambien el componente del cuadro de texto del **Equipo 7** para ingresar la contraseña y con ello validar las contraseñas ingresadas.
🔗 [Repositorio de Librería del Equipo 7](<https://github.com/Marco1120/Creacion-Libreria>).

---

## ✨ Funcionalidades Clave

### 🔒 Validación CAPTCHA
- Se activa al iniciar sesión para evitar accesos no autorizados de usuarios bot.
- Utiliza el CAPTCHA del **Equipo 6** (Propio).

  <img width="987" height="664" alt="image" src="https://github.com/user-attachments/assets/e4351a58-2ffc-4e81-8915-e2143468c84e" />

  Aqui se muestra la implementación del Captcha en el login, cuando el usuario entre al sistema.



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
