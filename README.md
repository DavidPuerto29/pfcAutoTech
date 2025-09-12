# 🛠️ AutoTech – Gestión de Citas de Vehículos en Talleres

AutoTech es una aplicación diseñada para **usuarios propietarios de vehículos y administradores**.  
Permite a los clientes registrar, consultar y gestionar sus vehículos y citas, mientras que los administradores pueden controlar usuarios, talleres, empleados y citas de manera centralizada.

---

⚠️ **Nota sobre la interfaz:**  
La aplicación se desarrolló en **Java Swing** en NetBeans según los requisitos del proyecto. Aunque sencilla, permite acceder a todas las funcionalidades y refleja la correcta implementación de la arquitectura **MVC** y la lógica de negocio.

---

## ⚡ Demostración de la aplicación  

<div align="center">
  <img width="679" height="586" alt="01 Iniciar sesión clientes" src="https://github.com/user-attachments/assets/2b71dfc8-9367-494a-bebf-ce783e889108" />
</div>

Pantalla de inicio para clientes. Permite **iniciar sesión** con una cuenta existente o **registrarse** para crear una nueva.

<div align="center">
  <img width="1258" height="708" alt="02 Registro Clientes paso 1" src="https://github.com/user-attachments/assets/43a276ca-043e-4eeb-87e9-1645138372ee" />
</div>

Formulario de registro dividido en **dos pasos** para simplificar y agilizar el proceso.

<div align="center">
  <img width="1260" height="704" alt="03 Registro Clientes paso 2" src="https://github.com/user-attachments/assets/cec7dd28-b771-446e-8421-fe1fb93ab60b" />
</div>

Segundo paso del registro para activar la cuenta y permitir el acceso completo.

<div align="center">
  <img width="1260" height="706" alt="09 Vista principal vehiculos seleccionado" src="https://github.com/user-attachments/assets/9448fd5b-9059-4ab2-a949-93965347b08b" />
</div>

Gestión de **vehículos y citas**: añadir, modificar o eliminar.

<div align="center">
  <img width="1256" height="704" alt="04 Registro Vehiculos paso 1" src="https://github.com/user-attachments/assets/1cfaae98-7a24-471e-b821-73ade55f8f5c" />
</div>

Formulario de registro de vehículo, dividido en dos pasos para mejorar la experiencia.

<div align="center">
  <img width="1260" height="706" alt="05 Registro Vehiculos paso 2" src="https://github.com/user-attachments/assets/486a5fc7-ef81-4a05-8090-b22201cd197a" />
</div>

Segundo paso para completar el registro del vehículo.

<div align="center">
  <img width="1250" height="700" alt="06 Modificar Vehiculo" src="https://github.com/user-attachments/assets/05afd30a-baec-4885-8df9-576b5bd5e2be" />
</div>

Actualización de datos de vehículos de manera limitada.

<div align="center">
  <img width="1256" height="708" alt="10 Pedir cita" src="https://github.com/user-attachments/assets/07aa1677-4c63-46da-8533-517912f118a3" />
</div>

Formulario para solicitar cita, con validaciones para evitar duplicados.

---

## 🛡️ Administración  

Acceso al rol **administrador** (Ctrl + T en login de usuarios) para gestionar clientes, talleres, empleados y citas.

<div align="center">
  <img width="672" height="574" alt="05 Iniciar sesion administrador" src="https://github.com/user-attachments/assets/f29d249f-6900-43a7-bf18-b0d7a27b6c11" />
</div>

Pantalla de login de administradores.

<div align="center">
  <img width="1260" height="706" alt="01 Vista usuarios administrador" src="https://github.com/user-attachments/assets/cc66bbef-1c2e-4386-bf41-6ea6ecaac41c" />
</div>

Panel principal de administrador con gestión de usuarios, talleres, vehículos y citas.

<div align="center">
  <img width="1262" height="700" alt="02 Vista Mod Usuario" src="https://github.com/user-attachments/assets/0af35faf-8d88-45a1-8626-56f4027bb897" />
</div>

Formulario para modificar datos de usuarios.

<div align="center">
  <img width="1262" height="710" alt="03 Vista vehiculos administrador" src="https://github.com/user-attachments/assets/7d77bc65-84f2-410e-8543-75758a55f6d3" />
</div>

Gestión de vehículos: ver, añadir, modificar o eliminar.

<div align="center">
  <img width="1262" height="714" alt="04 Vista Modificar vehiculo administrador" src="https://github.com/user-attachments/assets/91f64de5-9f18-4306-aa95-d7910ea493d5" />
</div>

Modificar datos de vehículo y cliente asociado.

<div align="center">
  <img width="1260" height="706" alt="01 Vista Talleres" src="https://github.com/user-attachments/assets/249933f1-b138-4367-be0a-55aa86843c5d" />
</div>

Gestión de talleres: añadir, modificar, eliminar y asignar empleados.

<div align="center">
  <img width="1252" height="700" alt="04 Añadir taller" src="https://github.com/user-attachments/assets/d119fb78-b599-4b7a-8f01-a234f8a21d2b" />
</div>

Formulario para registrar un nuevo taller.

<div align="center">
  <img width="1256" height="702" alt="03 Vista asignar taller a empleados" src="https://github.com/user-attachments/assets/0e512b75-d30a-42be-8dab-ebb8ce3b806a" />
</div>

Asignación de taller a empleados para completar la activación de su cuenta.

---

## 🛠️ Datos técnicos  

La aplicación cifra las contraseñas combinándolas con un **valor aleatorio (salt)**, almacenando ambos en la base de datos para mayor seguridad.

<div align="center">
  <img width="1284" height="620" alt="01 Clase SHA 256" src="https://github.com/user-attachments/assets/04c46e73-6266-4556-a1ab-9be3a0b685ff" />
</div>

Clase con métodos de **SHA-256**, invocados desde los controladores para registro e inicio de sesión.

<div align="center">
  <img width="1852" height="636" alt="02 Llamada de cifrado en controlador" src="https://github.com/user-attachments/assets/1cb10beb-50d0-4447-bdf5-69b9a44f86af" />
</div>

El **controlador de inicio de sesión** gestiona la verificación y autenticación de credenciales usando la clase de cifrado.

---

## 🎧 Listeners y Controladores  

<div align="center">
  <img width="1352" height="578" alt="03 Fragmento listeners" src="https://github.com/user-attachments/assets/167e4a76-bbf0-4e4d-9ed9-ecf94e0c0d70" />
</div>

Se utilizan **listeners** en la vista para gestionar acciones de usuario, invocando los controladores correspondientes (inicio de sesión, registro, gestión de citas, etc.).

---

## 📂 Otras capas y utilidades

- **DAO (Data Access Objects):** Comunicación con base de datos mediante **Hibernate**.  
- **Controladores:** Orquestan la lógica entre vista y modelo siguiendo MVC.  
- **Utilidades:** Estilos personalizados para tablas y componentes gráficos.

---

## 🎯 Conclusión

El proyecto demuestra **buenas prácticas y estructura sólida**, aplicando MVC, persistencia con Hibernate y seguridad mediante cifrado de contraseñas.  
Aunque Swing no es el foco principal, el código enfatiza **organización, mantenibilidad** y posibilidad de evolucionar hacia **interfaces modernas o integración con APIs externas**.
