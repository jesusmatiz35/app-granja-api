# Mi Granja App

## Descripción
Mi Granja App es una aplicación desarrollada en Java que permite gestionar una granja. Utiliza Maven para la gestión de dependencias y SQL para la base de datos.

## Características
- Gestión de gallinas ponedoras
- Registro de actividades diarias
- Generación de reportes

## Requisitos
- Java 11 o superior
- Maven 3.6.3 o superior
- Base de datos SQL (MySQL, PostgreSQL, etc.)

## Instalación
1. Clonar el repositorio:
   ```sh
   git clone https://github.com/jesusmatiz35/mi-granja-app.git
   ```
2. Navegar al directorio del proyecto:
   ```sh
   cd mi-granja-app
   ```
3. Compilar el proyecto con Maven:
   ```sh
   mvn clean install
   ```

## Configuración
1. Configurar la base de datos en el archivo `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3806/granjadb
   spring.datasource.password=contraseña
   ```

## Ejecución
Para ejecutar la aplicación, usar el siguiente comando:


## Uso
Una vez iniciada la aplicación, se puede acceder a la interfaz web en `http://localhost:8080`.

## Contribuir
1. Hacer un fork del repositorio.
2. Crear una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realizar los cambios y hacer commit (`git commit -am 'Añadir nueva funcionalidad'`).
4. Hacer push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Crear un Pull Request.

## Licencia
Este proyecto está licenciado bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.
