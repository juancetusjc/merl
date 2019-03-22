#### Sistema de Predicción del clima MERL v1.0
Repositorio del código fuente:
https://github.com/juancetusjc/merl.git

* Ejecución en un Host público
   - Para realizar el cálculo del pronóstico del clima utilizar la siguiente dirección. :
     * https://vclima.herokuapp.com/vclima-1.0/webresources/prediction?year=10

   - Para consultar el pronóstico del clima:
     * https://vclima.herokuapp.com/vclima-1.0/webresources/clima?day=50

   - Para impiar el historial del calculo realizado:
     * https://vclima.herokuapp.com/vclima-1.0/webresources/clear


* Ejecución Local
   - Compilación de la aplicación 
     * mvn clean package -DskipeTests -P dist
   - Ejecución empotrada:
     * java -jar .\target\vclima-1.0.jar --port 8088
   
   - Para realizar el cálculo del pronóstico
     * https://localhost:8088/vclima-1.0/webresources/prediction?year=10
   
   - Para consultar el pronóstico del clima:
     * https://localhost:8088/vclima-1.0/webresources/clear
    
   - Para impiar el historial del calculo realizado:
     * https://localhost:8088/vclima-1.0/webresources/clima?day=50
     
* Requisitos:
   - Modificar la conexion de BDs en el archivo web.xml
     * Configuración para Postgresql   
      ** data-source
          - name:java:app/store 
          - class-name: org.postgresql.ds.PGPoolingDataSource
          - server-name:localhost
          - database-name:clima
          - user:user
          - password:xxxx
      
      
      * Configuración para MySql      
       ** data-source
          - name:java:app/store 
          - class-name: com.mysql.jdbc.jdbc2.optional.MysqlXADataSource
          - server-name:localhost
          - database-name:clima
          - user:user
          - password:xxxx
      
