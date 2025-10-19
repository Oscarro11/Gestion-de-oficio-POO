# App Organízate
Aplicación para ayudar a padres de familia a organizar el oficio de su hogar con sus hijos. Ayuda a planificar tareas para el día, con recompensas para motivar a niños y adultos a realizar el oficio del hogar.

![alt text](FrontEnd/assets/images/README-screenshot.png)      

![alt text](FrontEnd/assets/images/README-screenshot2.png)

## Autores
- Andres Pineda Schwarz                 pin25212@uvg.edu.gt
- Daniel Alejandro Hernández Silvestre  her25054@uvg.edu.gt
- José Alejandro Sagastume Valley       sag25257@uvg.edu.gt
- Lester Rodrigo Alvarez Cifuentes      alv25196@uvg.edu.gt 
- María Jimena Vásquez Meléndez         vas25092@uvg.edu.gt  
- Miguel Angel Sajquín González         saj252149@uvg.edu.gt 
- Oscar Rodrigo Melchor Estrada         mel25216@uvg.edu.gt


## Proceso de desarrollo
**Tecnología usada**: HTML, CSS, JavaScript, Java, Springboot framework for java (usando Gradle)

Para crear este programa, se pensó en un diseño de aplicación sencillo y fácil de entender. Adicionalmente, el diseño debia ser capaz de poder usarse en dispositivos moviles, ya que se tiene como objetivo que la aplicacion se use en intervalos cortos de tiempo en teléfonos. En cuestion de funcionalidad, la aplicación debe funcionar con internet, para poder sincronizar cambios entre los miembros de una familia. Esto se realiza por medio de APIs locales, usando el framework de Springboot para guardar los datos requeridos.

## Requerimientos

Para poder usar este proyecto, es necesario tener lo siguiente:
- Java v21
- Acceso a buscador de internet (preferiblemente Google Chrome)

## Cómo crear build
Antes de poder usar la aplicación, es necesario realizar lo siguiente:
1. Configurar servidor local para usar la dirección: "localhost".
2. Bloquear la sincronización de OneDrive en el equipo, en caso de que se use.
3. Borrar el folder de "backEnd/build/" y "backend/.gradle/", en caso de que se encuentren presentes

## Cómo usar la aplicación
Para poder usar la aplicación, se deben seguir los siguientes pasos:

#### Para sistema Linux:
1. Posicionarse en la carpeta de "backend" del proyecto
2. Usar el siguiente comando en la terminal: ./gradlew bootRun --no-daemon
3. Abrir la página de "frontEnd/index.html" con el servidor local 

#### Para sistema Windows:
1. Posicionarse en la carpeta de "backend" del proyecto
2. Usar el siguiente comando en la terminal: ./gradlew.bat bootRun --no-daemon
3. Abrir la página de "frontEnd/index.html" con el servidor local 

## Funcionalidades pendientes

Este programa aun no puede manejar la asignacion de tareas a otros miembros de familia. Adicionalmente, tampoco puede introducir recompensas que otros miembros puedan reclamar, negando el incentivo que tienen para ayudar con el oficio del hogar. Por ultimo, el programa unicamente funciona de manera local, por lo que los datos de un usuario no pueden ser accedidos por otros usuarios.
