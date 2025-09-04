# CAP - Centro de Atención Primaria

## Descripción del Proyecto

CAP es una aplicación médica desarrollada en Java con Spring Boot para la gestión de un Centro de Atención Primaria. Esta aplicación permite gestionar información de empleados y pacientes del centro médico.

### Características Principales

- **Gestión de Empleados**: Administración de información del personal médico y administrativo
- **Gestión de Pacientes**: Registro y seguimiento de pacientes del centro
- **API RESTful**: Interfaz de programación completa para operaciones CRUD
- **Base de Datos**: Integración con MySQL usando JPA/Hibernate
- **Arquitectura en Capas**: Separación clara entre controladores, servicios y repositorios

### Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Maven**

### Estructura del Proyecto

```
CAP/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/afminguela/CAP/
│   │           ├── controller/     # Controladores REST
│   │           ├── model/          # Entidades JPA
│   │           ├── service/        # Lógica de negocio
│   │           ├── Repository/     # Acceso a datos
│   │           ├── enums/          # Enumeraciones
│   │           └── CapApplication.java
│   └── test/                       # Tests unitarios
└── pom.xml                         # Configuración Maven
```

### Entidades Principales

#### Employee (Empleado)
- **ID**: Identificador único
- **Nombre**: Nombre del empleado
- **Departamento**: Departamento al que pertenece (enum)
- **Estado**: Estado del empleado (enum)

#### Patient (Paciente)
- **ID**: Identificador único
- **Nombre**: Nombre del paciente
- **Fecha de Nacimiento**: Fecha de nacimiento
- **Admitido por**: Relación con el empleado que lo admitió

### Ejercicios de Desarrollo

Este proyecto incluye varios ejercicios prácticos enfocados en:

#### 1. Testing con MockMVC
- **Objetivo**: Implementar tests de integración para todas las rutas disponibles
- **Herramientas**: Spring Boot Test, MockMVC, WebApplicationContext
- **Alcance**: 
  - Tests para operaciones GET, POST y PUT
  - Validación de códigos de respuesta HTTP
  - Verificación de contenido JSON
  - Manejo de casos positivos y negativos
  - Testing de parámetros de ruta y query parameters

#### 2. Manejo de Excepciones
- **Objetivo**: Crear excepciones personalizadas y manejarlas en los controladores
- **Implementación**: 
  - Excepciones customizadas para casos de negocio
  - Manejo global de excepciones en controladores
  - Respuestas HTTP apropiadas para diferentes tipos de errores

#### 3. Integración de Laboratorios
- **Combinación**: Integra conceptos de los laboratorios 4.02 (Intro to Spring Boot) y 4.04 (Add and Update)
- **Funcionalidades**: CRUD completo para empleados y pacientes

### Instrucciones de Laboratorio

Para instrucciones detalladas sobre la implementación de tests y ejercicios específicos, consulta el archivo [instrucciones.md](./instrucciones.md).

### Configuración y Ejecución

1. **Prerrequisitos**:
   - Java 17 o superior
   - Maven 3.6+
   - MySQL 8.0+

2. **Configuración de Base de Datos**:
   - Crear una base de datos MySQL
   - Configurar conexión en `application.properties`

3. **Compilación y Ejecución**:
   ```bash
   cd CAP
   mvn clean install
   mvn spring-boot:run
   ```

### API Endpoints

La aplicación expone endpoints REST para:
- Gestión de empleados (`/employees`)
- Gestión de pacientes (`/patients`)

Los endpoints específicos y su documentación detallada están disponibles una vez ejecutada la aplicación.

---

*Este proyecto es parte del curso Enterprise Java Development 4.02 y tiene fines educativos.*