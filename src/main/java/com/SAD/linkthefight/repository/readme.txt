En esta carpeta llamada `repositories` deben ir todas las interfaces que funcionan como repositorios JPA
(también conocidos como DAO, Data Access Object). Los repositorios son responsables de interactuar con la base de datos,
permitiendo realizar operaciones como guardar, buscar, actualizar o eliminar entidades.

Cada archivo dentro de esta carpeta suele ser una interfaz que extiende de `JpaRepository` u otra interfaz de Spring Data JPA,
y está asociada a una entidad específica. Por ejemplo, si tienes una entidad `Usuario`, aquí deberías tener una interfaz
`UsuarioRepository.java` que permita acceder y manipular los datos de los usuarios en la base de datos.

Si en algún momento necesitas manejar una nueva entidad o tabla, como por ejemplo productos, debes crear una nueva interfaz de
repositorio (por ejemplo, `ProductoRepository.java`) dentro de esta carpeta. Así, cada repositorio está bien organizado y separado
según la entidad que maneja, facilitando el mantenimiento y la comprensión del proyecto.

En resumen:
- Todos los repositorios JPA (DAO) deben ir en esta carpeta.
- Cada entidad debe tener su propio repositorio.
- Si agregas una nueva entidad, crea una nueva interfaz de repositorio aquí.