## Automatización de Pruebas – SauceDemo

Este proyecto contiene pruebas automatizadas para la aplicación SauceDemo utilizando Serenity BDD con Cucumber y el patrón Screenplay, y una simulación de carga con Gatling.

---

### Prerrequisitos

- Java 17  
- Maven 3.6+  
- Google Chrome  
- Git  

---

### Configuración del Proyecto

1. Clonar repositorio y entrar al directorio:

   ```bash
   git clone https://github.com/Cristian-Infante/Makers-TT-QA
   cd "Makers-TT-QA"
   ```

2. Descargar dependencias:

   ```bash
   mvn clean compile
   ```

---

### Ejecución de pruebas UI

1. Configurar credenciales en variables de entorno:

   ```powershell
   $Env:SAUCE_USERNAME = "standard_user"
   $Env:SAUCE_PASSWORD = "secret_sauce"
   ```

2. Ejecutar:

   * **Todas las pruebas de regresión**:

     ```bash
     mvn -Dtest=RegressionTest verify
     ```

   * **Pruebas individuales**:

     ```bash
     mvn -Dtest=LoginTest verify
     mvn -Dtest=PurchaseTest verify
     ```

3. Reporte HTML en `target/site/serenity/index.html`

---

#### Ejecutar simulación

```bash
mvn gatling:test
```

#### Resultados

Informe en: `target/gatling/PostsSimulation-<timestamp>/index.html`

### Resumen de hallazgos

> [!NOTE]
> Los reportes de las pruebas y simulaciones realizadas se encuentran en la carpeta `reports`.

* **¿El endpoint soportó la carga?**

    Sí. Se enviaron 100 solicitudes concurrentes en $1s$ y todas cumplieron los umbrales definidos(tiempo medio de respuesta < $800 ms$, tiempo máximo < $1200 ms$).

* **¿Hubo errores?**
  
    No. El porcentaje de fallos fue $0\%$ durante toda la simulación.

* **¿Qué mejoras recomendarías?**

    * Implementar cacheo de respuestas frecuentes para reducir la carga del backend.
    * Monitorizar en tiempo real el uso de CPU/memoria y configurar autoescalado horizontal si fuese necesario.
    * Revisar y optimizar consultas o lógica de negocio que pueda disparar picos de latencia bajo mayor concurrencia.
