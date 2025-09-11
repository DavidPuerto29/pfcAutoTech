🛠️ AutoTech – Gestión de Citas de Vehículos en Talleres 🛠️

AutoTech es una aplicación diseñada para usuarios propietarios de vehículos y administradores.
Permite a los clientes registrar, consultar y gestionar sus vehículos y citas, mientras que los administradores pueden controlar usuarios, talleres, empleados y citas de manera centralizada.

---

⚠️ **Nota sobre la interfaz:**  
La aplicación se desarrolló en **Java Swing** en NetBeans según los requisitos del proyecto. Aunque sencilla, permite acceder a todas las funcionalidades y refleja la correcta implementación de la arquitectura **MVC** y la lógica de negocio.

---

## ⚡ Demostración de la aplicación -

---

<div align="center">
   <img width="679" height="586" alt="-01 Iniciar sesión clientes" src="https://github.com/user-attachments/assets/2b71dfc8-9367-494a-bebf-ce783e889108" />
</div>
Pantalla de inicio de la aplicación para clientes. Permite iniciar sesión con una cuenta existente o registrarse para crear una nueva.

<div align="center">
   <img width="1258" height="708" alt="-02 Registro Clientes paso 1" src="https://github.com/user-attachments/assets/43a276ca-043e-4eeb-87e9-1645138372ee" />
</div>
Si un cliente se registra por primera vez, será redirigido a un formulario de registro dividido en dos pasos, diseñado para simplificar y agilizar el proceso.

<div align="center">
   <img width="1260" height="704" alt="-03 Registro Clientes paso 2" src="https://github.com/user-attachments/assets/cec7dd28-b771-446e-8421-fe1fb93ab60b" />
</div>
En el segundo paso, se completa el registro para activar la cuenta y permitir el acceso completo.

<div align="center">
  <img width="1260" height="706" alt="-09 Vista principal vehiculos seleccionado" src="https://github.com/user-attachments/assets/9448fd5b-9059-4ab2-a949-93965347b08b" />
</div>
Tras iniciar sesión, el cliente puede ver y gestionar sus vehículos y las citas asociadas (añadir, modificar o eliminar).

<div align="center">
   <img width="1256" height="704" alt="-04 Registro Vehiculos paso 1" src="https://github.com/user-attachments/assets/1cfaae98-7a24-471e-b821-73ade55f8f5c" />
</div>
Al registrar un vehículo, el usuario es dirigido a un formulario dividido en dos pasos, diseñado para simplificar el proceso y mejorar la experiencia de uso.

<div align="center">
   <img width="1260" height="706" alt="-05 Registro Vehiculos paso 2" src="https://github.com/user-attachments/assets/486a5fc7-ef81-4a05-8090-b22201cd197a" />
</div>
En el segundo paso, se completa el registro del vehículo, confirmando todos los datos necesarios para que quede correctamente asociado al usuario.

<div align="center">
   <img width="1250" height="700" alt="-06 Modificar Vehiculo" src="https://github.com/user-attachments/assets/05afd30a-baec-4885-8df9-576b5bd5e2be" />
</div>
Si el usuario decide modificar un vehículo, será dirigido a un formulario donde podrá actualizar ciertos datos del vehículo de manera limitada.

<div align="center">
  <img width="1256" height="708" alt="-10 Pedir cita" src="https://github.com/user-attachments/assets/07aa1677-4c63-46da-8533-517912f118a3" />
</div>
Al solicitar una cita, el usuario accede a un formulario para seleccionar los datos necesarios y la fecha. Se realizan comprobaciones para asegurar que la cita sea válida y evitar duplicados.

---

## 🛡️ Administración 🛡️

---

Aquí se muestran las funcionalidades disponibles para el rol de administrador, incluyendo la gestión de clientes, talleres, empleados y citas. Cabe recalcar que para acceder al login de administrador se debe pulsar Ctrl + T en la pantalla de login de usuarios.

<div align="center">
   <img width="672" height="574" alt="-05 Iniciar sesion administrador" src="https://github.com/user-attachments/assets/f29d249f-6900-43a7-bf18-b0d7a27b6c11" />
</div>
Pantalla de inicio de sesión para administradores, donde los usuarios con este rol pueden autenticarse y acceder al panel de administración.

<div align="center">
  <img width="1260" height="706" alt="-01 Vista usuarios administrador" src="https://github.com/user-attachments/assets/cc66bbef-1c2e-4386-bf41-6ea6ecaac41c" />
</div>
Pantalla principal del administrador, donde se muestra una tabla con los usuarios registrados y se accede a las distintas gestiones. Además, permite navegar por los submenús para administrar talleres, vehículos y citas.

<div align="center">
 <img width="1262" height="700" alt="-02 Vista Mod Usuario" src="https://github.com/user-attachments/assets/0af35faf-8d88-45a1-8626-56f4027bb897" />
</div>
Si el administrador decide modificar un usuario, será dirigido a un formulario donde podrá actualizar los datos necesarios.

<div align="center">
   <img width="1262" height="710" alt="-03 Vista vehiculos administrador" src="https://github.com/user-attachments/assets/7d77bc65-84f2-410e-8543-75758a55f6d3" />
</div>
En el apartado de vehículos, el administrador puede ver todos los vehículos registrados en una tabla y gestionar cada uno de ellos, incluyendo la posibilidad de añadir, modificar o eliminar registros.

<div align="center">
  <img width="1262" height="714" alt="-04 Vista Modificar vehiculo administrador" src="https://github.com/user-attachments/assets/91f64de5-9f18-4306-aa95-d7910ea493d5" />
</div>
Si el administrador decide modificar un vehículo, será dirigido a un formulario donde podrá actualizar los datos del vehículo y el cliente al que está asociado.

<div align="center">
   <img width="1260" height="706" alt="-01 Vista Talleres" src="https://github.com/user-attachments/assets/249933f1-b138-4367-be0a-55aa86843c5d" />
</div>
En el apartado de talleres, el administrador puede ver todos los talleres registrados en una tabla y gestionar cada uno, incluyendo añadir, modificar o eliminar registros, así como acceder al apartado de empleados de cada taller.

<div align="center">
  <img width="1252" height="700" alt="-04 Añadir taller" src="https://github.com/user-attachments/assets/d119fb78-b599-4b7a-8f01-a234f8a21d2b" />
</div>
Si el administrador decide añadir un taller, será dirigido a un formulario donde podrá completar los datos necesarios para registrar el taller.

<div align="center">
 <img width="1256" height="702" alt="-03 Vista asignar taller a empleados" src="https://github.com/user-attachments/assets/0e512b75-d30a-42be-8dab-ebb8ce3b806a" />
</div>
En el apartado de empleados, el administrador puede ver la lista de empleados registrados y asignar un taller a cada uno para completar la activación de su cuenta.

---

## 🛠️ Datos técnicos 🛠

---

La aplicación cifra las contraseñas combinándolas con un valor aleatorio (randomizador), almacenando ambos en la base de datos para mayor seguridad.

<div align="center">
   <img width="1284" height="620" alt="-01 Clase SHA 256" src="https://github.com/user-attachments/assets/04c46e73-6266-4556-a1ab-9be3a0b685ff" />
</div>
En una clase, siguiendo el patrón MVC, se implementan los métodos de cifrado con SHA-256, que posteriormente son invocados desde las clases controladoras para el registro e inicio de sesión.

<div align="center">
  <img width="1852" height="636" alt="-02 Llamada de cifrado en controlador" src="https://github.com/user-attachments/assets/1cb10beb-50d0-4447-bdf5-69b9a44f86af" />
</div>
En el controlador de inicio de sesión se invocan los métodos de la clase de cifrado, encargándose de la verificación y autenticación de credenciales al iniciar sesión.

---

## 🎧 Listeners y Controladores 

---

<div align="center">
   <img width="1352" height="578" alt="-03 Fragmento listeners" src="https://github.com/user-attachments/assets/167e4a76-bbf0-4e4d-9ed9-ecf94e0c0d70" />
</div>
La aplicación utiliza listeners en la capa de vista para gestionar las acciones del usuario.  
Por ejemplo, al pulsar un botón, el listener asociado invoca el controlador correspondiente, encargándose de procesar la lógica de la operación (inicio de sesión, registro, gestión de citas, etc.).

---

## 📂 Otras capas y utilidades

---

Además, el proyecto incluye otras capas y utilidades que soportan la funcionalidad principal:

- **DAO (Data Access Objects):** Gestionan la comunicación con la base de datos mediante Hibernate.  
- **Controladores:** Orquestan la lógica entre la vista y el modelo siguiendo el patrón MVC.  
- **Utilidades:** Incluyen estilos personalizados para tablas y componentes gráficos.

🎯Conclusión

En conjunto, el proyecto demuestra buenas prácticas y una estructura sólida, aplicando el patrón MVC, persistencia con Hibernate y seguridad mediante cifrado de contraseñas. Aunque la interfaz en Swing no es el foco principal, la aplicación pone énfasis en la organización del código, la mantenibilidad y la posibilidad de evolucionar hacia interfaces más modernas o integración con APIs externas.
