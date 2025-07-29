# 🏦 Sistema de Gestión Bancaria - <BANCOMEX>

### 🧾 Número de equipo: <Equipo 6>

### 👥 Integrantes:
- <Yhudiel Mendoza Sánchez> – Desarrollador y diseñador
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

  Aqui se muestra la implementación del Captcha en el login, que se usa cuando el usuario entre o inicie en el sistema, usando el componente del equipo 6 .


### 👤 CRUD de Usuarios
- Se activa cuando el usuario ingresa como gerente y entre en la opción **"Gestion de personal"**.
- Gerentes pueden registrar, modificar o eliminar usuarios, ya sean cajeros o clientes en el sistema.

  <img width="873" height="673" alt="image" src="https://github.com/user-attachments/assets/ee7175bf-c4d4-4d17-a16d-aef7d3a1f3ea" />

  En esta imagen se puede observan que se pueden leer los datos de la tabla la cual tenemos almacenado en la base de datos.

  <img width="712" height="640" alt="image" src="https://github.com/user-attachments/assets/39c23c24-ad47-40c2-b792-7da02a90e886" />

  En esta otra imagen podemos observar el formulario para registrar a un usuario, en el combobox podemos seleccionar el tipo de usuario que vamos a registrar, ya sea gerentes o cajeros.

  <img width="881" height="666" alt="image" src="https://github.com/user-attachments/assets/4b9561b7-e17f-4b3e-b74d-1b79fe7a6c31" />

  En esta otra imagen podemos ver que al darle doble clic a un campo este lo podemos modificar y con darle clic al boton modificar este se modofica con los cambios que le hemos hecho a la información de la tabla.



### 💳 CRUD de Cuentas Bancarias
- Se activa cuando el usuario ingresa como cajero y entra a la opcion **"pertura de cuentas bancarias"**.
- Registro de cuentas al cliente y su asignacion de numero de tarjeta y saldo inicial.

  <img width="761" height="740" alt="image" src="https://github.com/user-attachments/assets/17436a60-30cf-4c37-a7ab-6320403f0c74" />

  En esta imagen se puede observar que se pueden leer los datos de la tabla la cual tenemos almacenado en la base de datos de los clientes.

  <img width="651" height="576" alt="image" src="https://github.com/user-attachments/assets/66ddc54f-dd9f-4cb2-8bd0-ad462e12e9fd" />

  En esta otra imagen se puede mostrar el formulario para registrar a un nuevo cliente, y un boton para generar su numero de tarjeta automaticamente, cabe señalar que este numero de tarjeta en UNICO y no se
  llega a repetir.
  


### 💰 Operaciones bancarias
- **Depósitos**: Aumentan el saldo de la cuenta selecionada ya sea desde la practicaja o desde ventanilla (en este caso lo hace el cajero), en este apartado solo pide el numero de tarjeta y el monto a depósitar.
- **Retiros**: Disminuyen el saldo, con verificación de fondos e igaulmente se puede hacer desde la practicaja o desde  ventanilla (en este caso lo hace el cajero) y aqui pide el numero de tarjeta y el NIP del cliente y posteriormente el monto a retirar.

<img width="723" height="344" alt="image" src="https://github.com/user-attachments/assets/5901bed4-60de-4eb4-94ff-975967f59a83" />

En el menú de las operaciones tenemos las opciones de Depositar y Retirar.

<img width="727" height="482" alt="image" src="https://github.com/user-attachments/assets/d7c75d72-48e7-4902-83dc-1fdb77cbe704" />

En este apartado pide al cliente la tarjeta a la cual le vamos a depositar y el monto a depositar.

<img width="720" height="476" alt="image" src="https://github.com/user-attachments/assets/686fb9a7-e1ac-464b-8d0b-0c68129b9689" />

Al momento de realizar el depósito y darle clic a "Confirmar" este mostrara un panel de que el depósito se realizó correctamente en caso de que lo haya sido, así mismo manda un ticket al correo del cliente de que realizo dicho movimiento.

<img width="729" height="482" alt="image" src="https://github.com/user-attachments/assets/e016e697-ca17-4bc0-a585-114ca13a2abb" />

En el apartdo de retiro nos pedira el numero de tarjeta y el NIP del cliente tal y como se muestra en la imagen.

<img width="718" height="488" alt="image" src="https://github.com/user-attachments/assets/bfed5e99-4469-4120-b7a7-5f81fc1b9286" />

Una vez que hemos ingresado nos mostrara otro panel donde nos dira cuanto tenemos disponible en la tarjeta asi como tambien nos pedira el monto a retirar.

<img width="727" height="478" alt="image" src="https://github.com/user-attachments/assets/6ed2f80c-dac9-406b-b1d3-a651b522800e" />

En esta iamgen se muestra que cuando le damos clic al boton "Confirmar" este realiza el retiro mostrando un mensaje en pantalla de que el retiro fue exitoso en caso de serlo, tambien se manda un correo al cliente de que se realizó el movimiento en su cuenta.


### 🧾 Generación y envío de comprobante en PDF

- Envío automático de tickets de operación bancaria a clientes vía email asi como tambien a usuario al momento de registrarse.
- Clase usada: `PruebaCorreo.java` y `PruebaCorreoVisual.java` las cuales nos ayudaron a mandar correos con pdf´s adjuntos.
- Las clases usadas son de la libreria "CorreoElectronico" del equipo 2, (<https://github.com/olmomomo/Libreria_correoElectronico>).
- Los tickets PDF se generan con un diseño personalizado (archivos `.pdf` encontrados en el proyecto).



### ✨ Otras funcionalidades:
- Búsqueda de cuentas y clientes por nombre o número.
- Seguridad basada en roles (cajero vs gerente).
- Panel de control con saldos totales.

---

## ⚙️ Dependencias y Configuración

### 📦 Librerías externas utilizadas

| Librería                   | Descripción breve                                                               |
|----------------------------|----------------------------------------------------------------------------------|
| `JavaMail`                 | Envío de correos con comprobantes                                               |
| `itextpdf`                 | Generación de documentos PDF                                                    |
| `mysql-connector-java.jar`| Conexión a base de datos MySQL                                                  |
| `activation.jar`           | Soporte para tipos de contenido en mensajes MIME                                |
| `jakarta.mail.jar`         | Versión moderna de JavaMail con espacio de nombres Jakarta                      |
| `javax.mail-api.jar`       | API estándar para funcionalidades de correo electrónico                         |


---

### 🛠️ Pasos para instalar y ejecutar

1. Clonar o descargar este repositorio.
2. Abrirlo en NetBeans (o tu IDE de preferencia).
3. Asegúrate de que los `.jar` estén añadidos al proyecto.
4. Configura los datos de conexión en `ConexionBD.java` (host, usuario, contraseña).
5. Ejecuta `RegistroPanel.java` como clase principal.
6. Tener tu base de datos en MySQL creada con las tablas necesarias (usuarios, cuentas, movimientos y roles).
   git clone <URL_DEL_REPOSITORIO>


## 💻 Requisitos Mínimos del Sistema

| Requisito              | Versión/Recomendación                   |
|------------------------|-----------------------------------------|
| **Sistema Operativo**  | Windows 10 o superior                   |
| **Java JDK**           | Java SE 11 o superior                   |
| **IDE de desarrollo**  | NetBeans 12+ o cualquier compatible con Swing |
| **Base de datos**      | MySQL 8.0 o superior                    |
| **RAM mínima**         | 4 GB                                    |
| **Espacio en disco**   | 200 MB libres para código y PDFs        |
| **Conexión a Internet**| Solo necesaria para envío de correos (JavaMail) |



