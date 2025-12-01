# API RESTful de Libros con Docker

Sistema completo de gestión de reportes.

## Requisitos Previos

Antes de comenzar, asegúrese de tener instalado:

- **Docker** (versión 20.10 o superior)
- **Docker Hub Account** (para descargar la imagen)
- **Postman** (para pruebas de la API)


## Instrucciones de Ejecución

### Paso 1: Crear la Red de Docker

Primero, cree una red personalizada para permitir la comunicación entre contenedores:

```bash
docker network create red-libros
```

### Paso 2: Levantar el Contenedor de MySQL

Ejecute el siguiente comando para iniciar MySQL en Docker:

```bash
docker run -d `
  --name mysql2 `
  --network red-libros `
  -e MYSQL_ROOT_PASSWORD=Espe2025. `
  -e MYSQL_DATABASE=sysdb2025 `
  -p 3307:3306 `
  mysql:8.0
```

### Paso 3: Descargar y Ejecutar la API de Libros


```bash
docker pull mrcolina/api-restful-libros:1.0

docker run -d `
  --name api-restful-libros-container `
  --network red-libros `
  -p 8001:8001 `
  mrcolina/api-restful-libros:1.0

```

### Paso 4: Verificar que la API está funcionando


# Verificar que ambos contenedores están corriendo
```
docker ps
```

Debería ver ambos contenedores (mysql2 y api-restful-libros-container) en estado "Up".

### Paso 6: Probar la API

Abra su navegador para verificar:

```bash
http://localhost:8001/api/libros
```

La API está lista cuando recibe una respuesta (puede ser un array vacío `[]` al inicio).

## Endpoints Disponibles

La API expone los siguientes endpoints REST:

| GET | `/api/libros` | Listar todos los libros |

| GET | `/api/libros/{id}` | Obtener un libro por ID |

| POST | `/api/libros` | Crear un nuevo libro |

| PUT | `/api/libros/{id}` | Actualizar un libro existente |

| DELETE | `/api/libros/{id}` | Eliminar un libro |

## Pruebas con Postman

### Importar la Colección

1. Abra Postman
2. Click en "Import"
3. Seleccione el archivo `coleccion-api-restful-libros.postman_collection.json`
4. La colección aparecerá en su sidebar
