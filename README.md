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

8. **Interfaz de Usuario con React y Tailwind CSS**: Creación de una interfaz sencilla para la gestión de productos utilizando React y Tailwind CSS, proporcionando una experiencia de usuario moderna y responsiva. [Curso de React](https://www.udemy.com/course/react-de-principiante-a-experto-creando-mas-de-10-aplicaciones)

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
    git clone https://github.com/JPabloAviOli/product-api.git
    ```

2. **Navegar al Directorio del Proyecto o abrir en el IDE de tu preferencia**

    ```bash
    cd product-api
    ```

3. **Configurar Variables de Entorno**

    Crea un archivo `.env` en la raíz del proyecto con las siguientes variables y utiliza como guia el archivo `.env.template`:

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

    Docker Compose descargará automáticamente las imágenes desde mi repositorio en [Docker Hub](https://hub.docker.com/repositories/jpabloavioli) y levantará los contenedores. Una vez que los contenedores estén en funcionamiento, 
    podrás acceder a la aplicación en tu navegador.

6. **Acceder a la Aplicación**

- La aplicación de la api estará disponible en [http://localhost:8090](http://localhost:8090).
- La base de datos MySQL estará disponible en el puerto 3307.
- La interfaz de usuario estará disponible en [http://localhost:5173](http://localhost:5173).

6. **Detener los Servicios**
   
    Para detener y eliminar todos los contenedores, redes y volúmenes definidos en el archivo `docker-compose.yml`, usa:
    
    ```bash
    docker compose down
    ```
### Vista previa de la interfaz de usuario
- **A continuación, se presentan algunas capturas de pantalla de la interfaz de usuario creada con React y Tailwind CSS**.

## Funcionalidades de la Interfaz de Usuario

![principal](https://github.com/user-attachments/assets/99c21b82-4cb9-4a00-a04c-ea483eafdf45)

### 1. Agregar un Producto
En la interfaz de usuario, puedes agregar un nuevo producto utilizando un formulario sencillo. Completa los campos necesarios y haz clic en **Agregar Producto** para enviarlo al backend.

![Agregar Producto](https://github.com/user-attachments/assets/0b280182-16c8-41a6-95a9-ebf7b5d693a2)

### 2. Editar un Producto
Al hacer clic en el botón **Editar** en la lista de productos, se abrirá un formulario con los datos del producto precargados. Esto te permite modificar la información existente de manera rápida y sencilla.

![Editar Producto](https://github.com/user-attachments/assets/77d4e6e5-3b51-4bd3-83ed-2ad31983780e)

### 3. Cambiar la Disponibilidad de un Producto
En la interfaz, también puedes cambiar el estado de disponibilidad de un producto utilizando un control booleano. Esta acción interactúa directamente con un endpoint en el backend para actualizar el estado en la base de datos.

![Cambiar Disponibilidad](https://github.com/user-attachments/assets/156eaf1f-f31f-4790-b67c-297705b79490)

## Desafíos y Aprendizaje

### Conexión de React con el Backend
Uno de los principales desafíos en este proyecto fue establecer una comunicación fluida entre la aplicación frontend desarrollada en React y el backend construido con Spring Boot. Asegurarse de que las llamadas a la API funcionaran correctamente, manejando CORS, autenticación y validación de datos, fue una parte crucial del proceso. Además, optimizar las solicitudes para que fueran eficientes y manejar errores de manera efectiva requirió un enfoque cuidadoso y pruebas exhaustivas.

**Aprendizaje clave**:
- Manejo de CORS y configuración de la seguridad en Spring Boot para permitir las solicitudes desde React.
- Implementación de validación en ambos lados (frontend y backend) para asegurar la integridad de los datos.
- Uso de herramientas como Axios en React para gestionar las peticiones HTTP de manera más sencilla y eficiente.

### Dockerización de la Aplicación React
Otro gran reto fue dockerizar la aplicación React. Esto implicó crear un archivo Dockerfile optimizado que pudiera compilar y servir la aplicación en un entorno de producción. También fue necesario configurar correctamente el `docker-compose.yml` para que React pudiera funcionar junto con la base de datos MySQL y el backend de Spring Boot, asegurando que todos los contenedores se comunicaran entre sí de manera efectiva.

**Aprendizaje clave**:
- Creación de un Dockerfile para una aplicación React, optimizando tanto el tamaño de la imagen como el tiempo de construcción.
- Configuración de variables de entorno para manejar diferentes configuraciones entre entornos de desarrollo y producción.
- Integración de la aplicación React en el ecosistema Docker junto con otros servicios (API y base de datos) usando Docker Compose.

Estos desafíos no solo fortalecieron mis habilidades en desarrollo full-stack, sino que también me proporcionaron una comprensión más profunda de cómo funcionan las aplicaciones web modernas en un entorno containerizado.

## Contribuciones

Si deseas contribuir al proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu feature o bug fix (`git checkout -b feature/mi-feature`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadida nueva feature'`).
4. Push a la rama (`git push origin feature/mi-feature`).
5. Abre un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para detalles.

## Autor

- **Jesús Pablo Avila Olivar** - Autor principal [LinkedIn](https://www.linkedin.com/in/pablo-avila-olivar/)

## Enlaces Útiles

- [Documentación de Spring Boot](https://spring.io/projects/spring-boot)
- [Documentación de Docker](https://docs.docker.com/)
- [Documentación de Docker Compose](https://docs.docker.com/compose/)
- [Documentación de SpringDoc](https://springdoc.org/#getting-started)
- [Lombok](https://projectlombok.org/) 
- [Documetación de React](https://react.dev/)
- [Axios](https://axios-http.com/docs/intro)

