En esta carpeta llamada `entity` deben ir todas las clases que representan las entidades del sistema. Una entidad es una clase
que refleja una tabla en la base de datos y define la estructura de los datos que se van a almacenar. Por ejemplo, si tienes una
tabla de usuarios en la base de datos, aquí deberías tener una clase `Usuario.java` que contenga los atributos y métodos relacionados
con los usuarios.

Cada archivo dentro de esta carpeta representa una entidad diferente. Estas clases suelen estar anotadas con `@Entity` y contienen
atributos que corresponden a las columnas de la tabla en la base de datos, así como sus respectivos getters y setters.

Si en algún momento necesitas agregar una nueva tabla o tipo de dato a tu sistema, como por ejemplo una tabla de productos, debes
crear una nueva clase (por ejemplo, `Producto.java`) dentro de esta carpeta. Así, cada entidad del sistema está bien organizada y
separada, lo que facilita el mantenimiento y la comprensión del proyecto.

En resumen:
- Todas las entidades (clases que representan tablas de la base de datos) deben ir en esta carpeta.
- Cada entidad debe tener su propio archivo.
- Si agregas una nueva tabla o tipo de dato, crea una nueva clase para esa entidad aquí.