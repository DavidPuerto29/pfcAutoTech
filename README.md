Aplicación destinada para la gestión de citas de vehiculos en talleres, esta aplicación esta destinada para el uso de los usuarios propietarios de vehiculos.

⚠️Nota sobre la interfaz: La aplicación se desarrolló en Java Swing en NetBeans según los requisitos del proyecto. Aunque sencilla, permite acceder a todas las funcionalidades y refleja la correcta implementación de la arquitectura MVC y la lógica de negocio.

⚡Demostración de la aplicación

<div align="center">
  <img width="686" height="594" alt="-01 Iniciar sesion" src="https://github.com/user-attachments/assets/99b1912d-0574-454c-9800-8b424785308d" />
</div>
Pantalla de inicio de la aplicación para empleados de taller. Permite iniciar sesión con una cuenta existente o registrarse para crear una nueva

<div align="center">
   <img width="1256" height="702" alt="-02 Registro Paso 1" src="https://github.com/user-attachments/assets/cc504b1d-d559-4972-aa05-0a09d7c34a7c" />
</div>
Si un empleado se registra por primera vez, será redirigido a un formulario de registro dividido en dos pasos, diseñado para simplificar y agilizar el proceso.

<div align="center">
   <img width="1258" height="706" alt="-03 Registro Paso 2" src="https://github.com/user-attachments/assets/f0375424-04be-4e4b-bdd5-696000acea2c" />
</div>
En el segundo paso, el registro se completa con la información adicional necesaria para activar la cuenta y permitir el acceso completo a la aplicación.

<div align="center">
   <img width="1262" height="738" alt="-04 Vista modificar r cita" src="https://github.com/user-attachments/assets/a33532f5-2bc2-40f5-939f-1468dc21bc9c" />
</div>
Una vez que el empleado inicie sesión, podrá acceder a las citas asignadas al taller y actualizar su estado, como “En proceso”, “Finalizado” o “Cancelado”.

🛠️Datos técnicos🛠️

La aplicación utiliza un sistema de hash con un valor aleatorio (*randomizador*), almacenando en la base de datos la contraseña cifrada junto con dicho valor para mayor seguridad.

<div align="center">
   <img width="1284" height="620" alt="-01 Clase SHA 256" src="https://github.com/user-attachments/assets/04c46e73-6266-4556-a1ab-9be3a0b685ff" />
</div>
En una clase, siguiendo el patrón MVC, se implementan los métodos de cifrado con SHA-256, que posteriormente son invocados desde las clases controladoras para el registro e inicio de sesión.

<div align="center">
  <img width="1852" height="636" alt="-02 Llamada de cifrado en controlador" src="https://github.com/user-attachments/assets/1cb10beb-50d0-4447-bdf5-69b9a44f86af" />
</div>
En el controlador de inicio de sesión se invocan los métodos de la clase de cifrado, encargándose de la verificación y autenticación de credenciales al iniciar sesión.

🎧Listeners y Controladores🎧

<div align="center">
   <img width="1352" height="578" alt="-03 Fragmento listeners" src="https://github.com/user-attachments/assets/167e4a76-bbf0-4e4d-9ed9-ecf94e0c0d70" />
</div>
La aplicación utiliza listeners en la capa de vista para gestionar las acciones del usuario.  
Por ejemplo, al pulsar un botón, el listener asociado invoca el controlador correspondiente, encargándose de procesar la lógica de la operación (inicio de sesión, registro, gestión de citas, etc.).

📂 Otras capas y utilidades

- **DAO (Data Access Objects):** Gestionan la comunicación con la base de datos mediante Hibernate.  
- **Controladores:** Orquestan la lógica entre la vista y el modelo siguiendo el patrón MVC.  
- **Utilidades:** Incluyen estilos personalizados para tablas y componentes gráficos.

🎯Conclusión🎯

En conjunto, la aplicación demuestra la aplicación práctica del patrón MVC, integrando persistencia con Hibernate, seguridad mediante cifrado de contraseñas y una interfaz gráfica desarrollada en Swing. Aunque la interfaz no es el foco principal, el proyecto pone énfasis en la estructura, la organización del código y la implementación de buenas prácticas orientadas a la seguridad y la mantenibilidad.
