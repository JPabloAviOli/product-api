### PRODUCT API

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

