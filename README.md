# Monster Shop – Backend

Este proyecto corresponde al backend de **Monster Shop**, un e-commerce donde los usuarios pueden explorar productos, dejar reseñas y calificar artículos. El objetivo fue desarrollar una API REST utilizando Java 21 y Spring Boot, que funcione de forma integrada con un frontend ya desarrollado en React.

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Maven
- MySQL
- JPA (Jakarta Persistence)
- Hibernate Validator para validaciones
- Arquitectura por capas (Controller, Service, Repository, Model, DTO)

## Funcionalidades principales

### Gestión de productos

- Obtener todos los productos
- Obtener los detalles de un producto específico
- Crear un nuevo producto
- Actualizar un producto existente
- Eliminar un producto

### Gestión de reseñas

- Obtener todas las reseñas asociadas a un producto
- Crear una nueva reseña vinculada a un producto

### Relación entre entidades

Se establece una relación bidireccional entre `Product` y `Review`:
- Un `Product` puede tener múltiples `Review` (`@OneToMany`)
- Cada `Review` está asociado a un solo `Product` (`@ManyToOne`)

Esto permite acceder fácilmente tanto a las reseñas de un producto como al producto desde una reseña.

## Diseño del proyecto

El código está organizado en capas, separando controladores, servicios, repositorios, modelos y DTOs.  
Se utilizan mapeadores personalizados para convertir entre entidades y DTOs, y se aplican validaciones en los requests para garantizar la integridad de los datos entrantes.

## Instrucciones para correr el proyecto localmente

1. **Clonar el repositorio**

```bash
git clone https://github.com/usuario/monster-shop-backend.git
cd monster-shop-backend
```
2. **Configurar la base de datos MySQL**

Crea una base de datos local llamada `monster_shop` y actualiza las credenciales en el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/monster_shop
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Correr el proyecto**

Puedes ejecutar la aplicación desde tu IDE (como IntelliJ o VS Code) o desde la terminal usando:

```bash
./mvnw spring-boot:run
```

4. **Probar con Postman**

Una vez que el servidor está corriendo en `http://localhost:8080`, puedes utilizar Postman para verificar que los endpoints funcionen correctamente.

### Ejemplos de endpoints:

- Obtener todos los productos:
```bash
GET http://localhost:8080/api/products
```
- Obtener detalles de un producto:
```bash
GET http://localhost:8080/api/reviews/{productId}
```
- Crear un nuevo producto:
```bash
POST http://localhost:8080/api/products
```
```json
{
  "name": "Producto Ejemplo",
  "price": 19.99,
  "imageUrl": "https://example.com/imagen.jpg",
  "rating": 4.5,
  "reviewCount": 10,
  "featured": true
}
```

