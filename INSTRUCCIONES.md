# API RESTful de Reportes con Docker

Sistema completo para la gestión de **reportes**, ejecutado mediante contenedores Docker.

## 🛠️ Requisitos Previos

Antes de comenzar, asegúrese de tener instalado:

- **Docker** (20.10 o superior)
- **Cuenta en Docker Hub**
- **Postman** (para pruebas de la API)
- Archivo de pruebas: **`colina_report.postman_collection.json`**

## 🚀 Instrucciones de Ejecución

### 1️⃣ Crear la red de Docker

```bash
docker network create red-reports
```

### 2️⃣ Levantar el contenedor de MySQL

```bash
docker run -d `
  --name mysql-colina-report `
  --network red-reports `
  -e MYSQL_ROOT_PASSWORD=Espe2025. `
  -e MYSQL_DATABASE=sysdb2025 `
  -p 3307:3306 `
  mysql:8.0
```

### 3️⃣ Descargar y ejecutar la API de Reportes

```bash
docker pull mrcolina/colina_report

docker run -d `
  --name colina-report-api `
  --network red-reports `
  -p 8002:8002 `
  mrcolina/colina_report
```

### 4️⃣ Verificar que los contenedores están funcionando

```bash
docker ps
```

### 5️⃣ Probar la API

```bash
http://localhost:8002/api/reports
```

## 📡 Endpoints Disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET    | `/api/reports` | Listar todos los reportes |
| GET    | `/api/reports/{id}` | Obtener un reporte por ID |
| POST   | `/api/reports` | Crear un nuevo reporte |
| PUT    | `/api/reports/{id}` | Actualizar un reporte |
| DELETE | `/api/reports/{id}` | Eliminar un reporte |

## 🧪 Pruebas con Postman

1. Abra Postman
2. Clic en **Import**
3. Seleccione el archivo `colina_report.postman_collection.json`
4. La colección aparecerá lista para usar  
