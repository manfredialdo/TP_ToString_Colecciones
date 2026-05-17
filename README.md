# trabajo practico 5 progrAmaacion 3
## tostring, equals, hashcode 

    
    TP_ToString_Colecciones/
    ├── src/
    │   └── main/
    │       ├── java/
    │       │   └── com.tup.programacion3/
    │       │       ├── entities/
    │       │       │   ├── Categoria.java
    │       │       │   ├── DetallePedido.java
    │       │       │   ├── Pedido.java
    │       │       │   ├── Producto.java
    │       │       │   └── Usuario.java
    │       │       ├── enums/
    │       │       │   ├── Estado.java
    │       │       │   ├── FormaPago.java
    │       │       │   └── Rol.java
    │       │       └── Main.java
    │       └── resources/
    ├── build.gradle
    └── settings.gradle




### 1. Limpiar y Compilar el Proyecto
Asegurate de generar los archivos `.class` actualizados ejecutando Maven:
```bash
source "/usr/local/sdkman/bin/sdkman-init.sh"

sdk install maven

mvn clean compile exec:java -Dexec.mainClass="com.tup.programacion3.Main"

```
### 2. y luego
```bash
java -cp target/classes com.tup.programacion3.Main

``` 


## Guía de Configuración y Ejecución en GitHub Codespaces

Si al intentar ejecutar el proyecto en Codespaces obtienes un error de versión de Java (ej. *release version 19/21 not supported*), sigue estos 3 pasos para configurar el entorno correctamente.

### Paso 1: Configurar Java 21
Abre el archivo `.devcontainer/devcontainer.json` en la raíz de tu proyecto, borra su contenido actual y reemplázalo por el siguiente código:

```json
{
  "name": "Java 21",
  "image": "mcr.microsoft.com/devcontainers/java:1-21-bullseye"
}


### Paso 2: Guardar y Reconstruir el Contenedor

Guarda los cambios en el archivo presionando Ctrl + S (Cmd + S en Mac).

Abre la paleta de comandos con Ctrl + Shift + P (Cmd + Shift + P en Mac).

Escribe Dev Containers: Rebuild Container elegir full y presiona Enter (o haz clic en el botón azul Rebuild que aparece abajo a la derecha).

Nota: El entorno se reiniciará automáticamente en un minuto con Java 21 activo.

probar con java --version desde terminal

### paso 3


```bash
sudo apt-get update && sudo apt-get install -y maven

mvn compile exec:java -Dexec.mainClass="com.tup.programacion3.Main"

``` 










Opción 1: Ejecución en Entorno Local (Tu PC)
Asegúrate de tener instalado Java 21 configurado en las variables de entorno del sistema (JAVA_HOME).

Si utilizas Gradle (Recomendado por estructura)
Ejecuta los siguientes comandos en la raíz del proyecto usando la terminal:

Bash
# Limpiar y compilar el proyecto

```bash
sudo apt-get update && sudo apt-get install -y maven

mvn compile exec:java -Dexec.mainClass="com.tup.programacion3.Main"

``` 

./gradlew clean compileJava

# Ejecutar la clase Main
./gradlew run
Si utilizas Maven (Alternativa)
Si estás usando un entorno configurado con pom.xml:

# Compilar y ejecutar en un solo paso
mvn clean compile exec:java -Dexec.mainClass="com.tup.programacion3.Main"
☁️ Opción 2: Ejecución en la Nube (GitHub Codespaces / Project IDX)
Para evitar lidiar con la instalación manual de Java y comandos rotos de Linux en contenedores virtuales, se incluye la preconfiguración automática para entornos remotos.

## Paso 1: Fijar la configuración del contenedor
Asegúrate de que en la raíz de tu proyecto exista la carpeta .devcontainer con el archivo devcontainer.json configurado de la siguiente manera:

JSON
{
  "name": "Java 21 con SDKMAN",
  "image": "[mcr.microsoft.com/devcontainers/java:21-bullseye](https://mcr.microsoft.com/devcontainers/java:21-bullseye)"
}


## Paso 2: Aplicar los cambios (Rebuild)


Selecciona Full Rebuild y espera a que el entorno se reinicie por completo.

## Paso 3: Activar herramientas y Ejecutar
Una vez que el entorno cargue de nuevo, abre una terminal limpia (Terminal -> New Terminal) y ejecuta estos comandos secuenciales para activar SDKMAN, instalar Maven de forma segura y arrancar el programa:

Bash
# 1. Cargar el gestor SDKMAN preinstalado
source "/usr/local/sdkman/bin/sdkman-init.sh"

# 2. Instalar Maven de forma nativa en la máquina virtual
sdk install maven

# 3. Compilar y arrancar la aplicación gastronómica
mvn clean compile exec:java -Dexec.mainClass="com.tup.programacion3.Main"