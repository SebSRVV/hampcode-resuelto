## 🚀 1. Requisitos previos
Antes de ejecutar el proyecto, asegúrate de tener instalado:
* ☕ **Java 21+**
* 🧰 **Maven 3.8+**
* 🐘 **PostgreSQL +14+**
* 💻 **pgAdmin**

---
## 🧱 2. Crear una DB y la tabla `memberships`

Ejecuta el siguiente script SQL dentro de la db:

```sql
CREATE TABLE memberships (
    id BIGSERIAL PRIMARY KEY,
    member_name VARCHAR(100) NOT NULL,
    membership_type VARCHAR(20) NOT NULL,
    months_subscribed INTEGER NOT NULL,
    months_remaining INTEGER NOT NULL,
    membership_price NUMERIC(10, 2) NOT NULL,
    monthly_visits INTEGER NOT NULL DEFAULT 0,
    description VARCHAR(255) NOT NULL
);
```

---

## 🔌 3. Configurar la conexión a PostgreSQL

Abre tu archivo `src/main/resources/application.properties` o `application.yml`
y añade la configuración correspondiente:

### **application.properties**

```properties

spring.datasource.url=jdbc:postgresql://localhost:5432/name_db
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña_aquí
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

server.port=8080
```

## ▶️ 4. Ejecutar la aplicación

Ejecuta en IntelliJ o desde la terminal:

```bash
mvn spring-boot:run
```

* Ejecuta la clase principal:

  ```
  com.sebrvv.name.NameApplication
  ```

---

## 🌐 5. Endpoints disponibles

Base URL: `http://localhost:8080/api/v1`

| Método     | Endpoint                             | Descripción                                             |
| ---------- | ------------------------------------ | ------------------------------------------------------- |
| **POST**   | `/memberships`                       | Registrar una nueva membresía                           |
| **PUT**    | `/memberships/{membershipId}/visit`  | Registrar visita de un miembro                          |
| **GET**    | `/memberships?membershipType={type}` | Listar membresías por tipo (`BASICA`, `PREMIUM`, `VIP`) |
| **GET**    | `/memberships/statistics`            | Generar reporte de estadísticas                         |
| **DELETE** | `/memberships/{membershipId}`        | Eliminar una membresía                                  |

---

## 🧪 6. Probar la API

Puedes probar los endpoints con **Postman**, **Insomnia**, o **cURL**.

### Ejemplo — Crear una membresía

```bash
POST http://localhost:8080/api/v1/memberships
Content-Type: application/json

{
  "memberName": "Juan Pérez",
  "membershipType": "BASICA",
  "monthsSubscribed": 6,
  "membershipPrice": 120.00,
  "description": "Plan básico de 6 meses"
}
```

### Ejemplo — Registrar visita

```bash
PUT http://localhost:8080/api/v1/memberships/1/visit
```

---

## 🧰 7. Dependencias principales

En tu `pom.xml`, asegúrate de incluir:

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- PostgreSQL Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>

    <!-- ModelMapper -->
    <dependency>
        <groupId>org.modelmapper</groupId>
        <artifactId>modelmapper</artifactId>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Spring Boot Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## 🧾 8. Resultado esperado

Cuando inicies la aplicación, deberías ver algo como esto en la consola:

```