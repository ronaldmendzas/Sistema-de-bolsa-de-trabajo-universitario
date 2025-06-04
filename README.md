# 🎓 Sistema de Bolsa de Trabajo Universitaria

Este proyecto tiene como objetivo conectar a universitarios y docentes con oportunidades laborales dentro y fuera del ámbito académico, ayudando a combatir el desempleo juvenil en Bolivia.

## 📌 Descripción General

El **Sistema de Bolsa de Trabajo Universitaria** permite a estudiantes, egresados y docentes buscar ofertas de empleo de manera centralizada y organizada. También permite a las instituciones o empresas publicar vacantes disponibles. Este sistema busca aliviar la problemática del desempleo profesional, facilitando la vinculación entre el talento universitario y el mercado laboral.

## 🚀 Tecnologías Utilizadas

### 🔧 Backend

- **Lenguaje:** Java
- **Frameworks:** Spring Boot
- **Base de datos:** PostgreSQL

### 🛠️ Dependencias principales:

- `spring-boot-starter-data-jpa`
- `spring-boot-starter-jdbc`
- `hibernate-validator` (v8.0.1.Final)
- `springdoc-openapi-starter-webmvc-ui` (v2.5.0)
- `spring-boot-starter-security`
- `spring-session-core`, `spring-session-jdbc`
- `jjwt-api`, `jjwt-impl`, `jjwt-jackson` (v0.11.5)
- `javax.servlet-api` (v4.0.1)
- `jakarta.validation-api` (v3.0.2)
- `postgresql` (driver)
- `spring-boot-starter-thymeleaf`
- `spring-boot-starter-web`
- `spring-cloud-starter`
- `spring-boot-devtools`
- `lombok` (opcional)
- `spring-boot-starter-test`

### 🔌 Plugins:

- `maven-compiler-plugin` (con soporte para Lombok)
- `spring-boot-maven-plugin` (excluye Lombok del empaquetado)

## 🖥️ Instalación y Ejecución Local

### 1. Clonar el repositorio o descargar el código

```bash
git clone https://github.com/usuario/proyecto.git
````

O descargar el archivo `.zip` desde GitHub y extraerlo.

### 2. Abrir el proyecto

Abrir el proyecto en **IntelliJ IDEA** (recomendado) o **Visual Studio Code**. Asegúrate de tener instalada una versión de **JDK 21 o superior**.

### 3. Configurar la base de datos

Edita el archivo `application.properties` para configurar tu conexión a PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_basedatos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 4. Ejecutar la aplicación

Haz clic en el botón **"Run"** o ejecuta:

```bash
./mvnw spring-boot:run
```

El sistema iniciará en `http://localhost:8080` por defecto.

## 👥 Equipo de Desarrollo

* **Quinteros Mollinedo Jose Julian** – Líder del proyecto / Backend
* **Amezaga Garrido Brandon Jhosef** – Frontend
* **Perez Murillo Joel Alejandro**
* **Cuevas Alconini Cael Mathew**
* **Mendoza Caspa Ronald**
* **Quiroz Coila Ariadne Checcid** – Documentación
* **Choque Choque Jose Alfredo** – QA / Soporte Técnico

## 📄 Estado del proyecto

🔧 Primera versión funcional en desarrollo.
📦 En etapa de pruebas e integración.

## 📚 Licencia

Este proyecto es de uso académico y no cuenta con una licencia abierta aún. Uso restringido para fines educativos.

