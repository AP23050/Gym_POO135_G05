# 🏋️‍♂️ Sistema de Gestión de Gimnasio (API REST)

Este proyecto es una API REST desarrollada con **Spring Boot** para la administración integral de un gimnasio. El sistema permite gestionar el registro de usuarios, la administración de instructores y el control de membresías, utilizando una arquitectura en capas y buenas prácticas de desarrollo.

---

## 👥 Integrantes del Equipo (Grupo 05)

* **Rodrigo Antonio Alvarado Perez** - [@AP23050](https://github.com/AP23050)
* **Cesar Castro** - [@CesarCA07001](https://github.com/CesarCA07001)
* **Josue Hernandez** - [@MH24055-JosueHernandez](https://github.com/MH24055)
* **Lidia Cruz** - [@CH20039](https://github.com/CH20039)
* **Esmeralda Muñoz** - [@MF23004](https://github.com/MF23004)

---

## 🚀 Tecnologías Utilizadas

* **Java 17** (Lenguaje principal)
* **Spring Boot 3** (Framework para desarrollo web)
* **Spring Data JPA** (Persistencia de datos)
* **PostgreSQL** (Motor de Base de Datos)
* **Lombok** (Para reducción de código repetitivo)
* **Maven** (Gestión de dependencias)
* **JUnit 5 & Mockito** (Pruebas Unitarias)

---

## ⚙️ Instrucciones de Ejecución

Para ejecutar este proyecto en tu máquina local, sigue estos pasos:

### 1. Prerrequisitos
* Tener instalado Java 17.
* Tener instalado PostgreSQL y pgAdmin.
* Tener un cliente API como Postman.

### 2. Configuración de la Base de Datos
1. Abrir pgAdmin.
2. Crear una nueva base de datos llamada: **`gimnasio`**.
3. En el proyecto, abrir el archivo `src/main/resources/application.properties`.
4. Verificar que el puerto (`2603` o `5432`) y la contraseña coincidan con tu instalación local de PostgreSQL.

### 3. Ejecutar la Aplicación
* Desde la terminal:
  ```bash
  ./mvnw spring-boot:run