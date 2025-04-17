En esta carpeta llamada `controller` deben ir todos los endpoints del backend del proyecto.
Los endpoints son los puntos de entrada de la API, es decir, las rutas a las que pueden acceder los clientes (como el frontend o aplicaciones externas)
para interactuar con el sistema.

Cada archivo dentro de esta carpeta representa un "controlador", que se encarga de manejar una sección específica de la API.
Por ejemplo, si tienes una sección relacionada con usuarios, puedes tener un archivo llamado `UsuarioController.java` que contenga todos los
endpoints relacionados con usuarios.

Si en algún momento necesitas agregar una nueva sección a la API, como por ejemplo `/api/ejemplo`, lo recomendable es crear un nuevo archivo
controlador (por ejemplo, `EjemploController.java`) dentro de esta misma carpeta.
De esta manera, el código se mantiene organizado y cada sección de la API está separada en su propio archivo, facilitando el mantenimiento
y la comprensión del proyecto.

En resumen:
- Todos los controladores (endpoints) deben ir en esta carpeta.
- Cada sección de la API debe tener su propio archivo controlador.
- Si agregas una nueva ruta principal, crea un nuevo archivo para esa sección.