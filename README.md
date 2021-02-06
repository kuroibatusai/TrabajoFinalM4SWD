## Backend

### Requerimientos

**Estos deben estar instalados globalmente en la máquina del desarrollador**

- maven 3.6.3
- Java 11
- newman
- Selenium
- Jmeter

### Si haces un cambio y quieres ver que la API este todo ok

````
./mvnw compile
````

### Si deseas probar los test

````
./mvnw test
````

### Ejecutar API ( Nota : si la ejecutaste y haces cambio en dev, solo tira el comando compilar y la api se auto actualizará)
* Local:      ./mvnw spring-boot:run
* Background: nohup bash mvnw spring-boot:run &

### Probar Api Linux o Postman
* curl -X GET 'http://localhost:8082/rest/msdxc/dxc?sueldo=4900000&ahorro=45000000&fechaUf=06-02-2021'

### Probar API
* Abrir navegador: http://localhost:8082/rest/msdxc/dxc?sueldo=4900000&ahorro=45000000&fechaUf=06-02-2021

### Métodos API
###### Ruta Inicial : http://localhost:8082/rest/msdxc/

###### * 10% : 
> Ruta: /dxc 
Parametros : sueldo, ahorro, fechaUf

###### * obtenerUF :  
> Ruta /obtenerUF

###### * obtenerImpuesto : 
> Ruta: /obtenerImpuesto 
Parametros : sueldo, ahorro, fechaUf

###### * obtenerSaldo : 
> Ruta: /ObtenerSaldo 
Parametros : sueldo, ahorro, fechaUf

### Para poder leer el JSON de MiIndicador se cargo la dependencia de JSONPATH en POM.xml
    <dependency>
    	<groupId>com.jayway.jsonpath</groupId>
    	<artifactId>json-path</artifactId>
    	<version>2.2.0</version>
    </dependency>

### Ruta puerto API en /src/main/resources/application.properties
8082 , cambiar si afecta en algun puerto del cliente

## Frontend

### devops-calculadora-10-webapp

Aplicación web de la calculadora 10% realizada como trabajo entregable para el módulo 4 del Diplomados Devops USACH.

### Requerimientos

**Estos deben estar instalados globalmente en la máquina del desarrollador**

- Node 12.13.0 o superior
- NPM 6.14.8 o superior

### Instalación

- Posicionarse en la carpeta webapp/devops-calculadora-10-webapp

- Ejecutar comando en la carpeta contenedora del archivo package.json

````bash
npm install
````

### Ejecución ambiente local

Ejecutar comando en la carpeta contenedora del archivo package.json

````bash
npm start
````