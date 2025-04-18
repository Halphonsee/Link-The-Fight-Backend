En esta carpeta llamada `service` deben ir todas las clases que contienen la lógica de negocio del sistema. Los servicios se encargan de
procesar la información, aplicar reglas de negocio y coordinar la interacción entre los controladores (endpoints) y los repositorios
(acceso a la base de datos).

Cada archivo dentro de esta carpeta suele ser una clase que representa un servicio para una entidad o funcionalidad específica.
Por ejemplo, si tienes una entidad `Usuario`, aquí deberías tener una clase `UsuarioService.java` que contenga los métodos necesarios
para gestionar usuarios, como crear, actualizar, eliminar o buscar usuarios.

Si en algún momento necesitas agregar una nueva funcionalidad o lógica relacionada con otra entidad, como productos, debes crear una
nueva clase de servicio (por ejemplo, `ProductoService.java`) dentro de esta carpeta. Así, cada servicio está bien organizado y separado
según la funcionalidad que maneja, facilitando el mantenimiento y la comprensión del proyecto.

En resumen:
- Todas las clases de servicio (lógica de negocio) deben ir en esta carpeta.
- Cada entidad o funcionalidad debe tener su propio servicio.
- Si agregas una nueva entidad o funcionalidad, crea una nueva clase de servicio aquí.