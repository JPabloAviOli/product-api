### Product API

![principal](https://github.com/user-attachments/assets/99c21b82-4cb9-4a00-a04c-ea483eafdf45)

## Descripción
Product-api es una API REST desarrollada para la gestión de productos. Implementa un CRUD (Create, Read, Update, Delete) básico, permitiendo a los usuarios realizar operaciones sobre los productos, como crear nuevos productos, obtener la lista de productos disponibles, actualizar la información de un producto existente y eliminar productos. Esta API está diseñada para ser fácil de usar e integrar con otras aplicaciones, proporcionando endpoints claros y consistentes para la administración eficiente de inventarios o catálogos de productos.


## Características Principales

1. **CRUD de Productos**: Implementación de un CRUD completo para la gestión de productos, permitiendo crear, leer, actualizar y eliminar productos a través de endpoints REST.

2. **Persistencia con JPA y MySQL**: Uso de Spring Data JPA para interactuar con la base de datos MySQL, facilitando la manipulación de datos mediante un ORM (Object-Relational Mapping) eficiente.

3. **Validación de Datos**: Integración de Spring Boot Validation para asegurar que los datos de entrada sean validados antes de ser procesados, mejorando la robustez de la API.

4. **Documentación de la API con OpenAPI**: Generación automática de documentación interactiva de la API utilizando Springdoc OpenAPI, lo que facilita la exploración y prueba de los endpoints a través de Swagger UI.

5. **Manejo de Dependencias con Maven**: Uso de Maven para la gestión de dependencias y la automatización del ciclo de vida de construcción del proyecto.

6. **Compatibilidad con Java 17**: Proyecto configurado para utilizar Java 17, aprovechando las últimas características del lenguaje.

7. **Simplificación del código con Lombok** (opcional): Uso de Lombok para reducir la cantidad de código repetitivo, como getters, setters y constructores, haciendo el código más limpio y legible.

8. **Interfaz de Usuario con React y Tailwind CSS**: Creación de una interfaz sencilla para la gestión de productos utilizando React y Tailwind CSS, proporcionando una experiencia de usuario moderna y responsiva.

## Instalación y Configuración

### Configuración del Entorno

- **Docker Daemon**: Asegúrate de que Docker Daemon (dockerd) esté instalado y en funcionamiento en tu máquina. Este componente es esencial para la ejecución de contenedores Docker y se encarga de las operaciones relacionadas con los contenedores.

- **Docker Desktop (para Windows y macOS)**: Si estás utilizando Windows o macOS, Docker Desktop es necesario para proporcionar una interfaz gráfica y facilitar la gestión de Docker. Docker Desktop incluye Docker Daemon y otros componentes necesarios para el funcionamiento de Docker en estos sistemas operativos.

[Docker Desktop - Página Principal](https://www.docker.com/products/docker-desktop)

## Ejecutar la Aplicación

### Clonar el Repositorio y Usar Docker Compose

Clona el repositorio y usa Docker Compose para construir y gestionar los servicios, sigue estos pasos:

1. **Clonar el Repositorio**

    ```bash
    git clone https://github.com/JPabloAviOli/Spring-Security-Login.git
    ```

2. **Navegar al Directorio del Proyecto o abrir en el IDE de tu preferencia**

    ```bash
    cd api-product
    ```

3. **Configurar Variables de Entorno**

    Crea un archivo `.env` en la raíz del proyecto con las siguientes variables y utiliza como guia el archivo `.env-template`:

    ```env
    MYSQL_ROOT_PASSWORD=your_root_password
    MYSQL_DATABASE=your_database_name
    MYSQL_USER=your_username
    MYSQL_PASSWORD=your_password
    ```

4. **Construir y Levantar los Servicios**

    Usa Docker Compose para construir la imagen de la aplicación y levantar todos los servicios definidos en el archivo `docker-compose.yml`:

    ```bash
    docker compose up -d
    ```

    Esto iniciará todos los servicios necesarios para tu aplicación en modo "detach" (en segundo plano).

5. **Acceder a la Aplicación**

- La aplicación estará disponible en [http://localhost:8080](http://localhost:8090).
- La base de datos MySQL estará disponible en el puerto 3307.
- La interfaz de usuario estará disponible en [http://localhost:5173](http://localhost:5173)

6. **Detener los Servicios**
   
    Para detener y eliminar todos los contenedores, redes y volúmenes definidos en el archivo `docker-compose.yml`, usa:
    
    ```bash
    docker compose down
    ```

