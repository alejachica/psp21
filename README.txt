Proyecto PSP2.1
Conceptos avanzados de Ingenieria de Software
Especializacion en construccion de Software
Universidad de los Andes

Instrucciones para obtener el repositorio desde github:
Hacer clone al proyecto con la siguiente URL:  https://github.com/alejachica/psp21.git
usuario: alejachica

Para ejecutar el programa localmente, ejecutar el siguiente comando:
mvn package
java -cp target/psp21-1.0-SNAPSHOT.jar edu.uniandes.ecos.psp21.vista.VistaConsola

Para ejecutar el progama desde Heroku, ingresar a la siguiente URL:
https://psp21-alejachica.herokuapp.com/

Estas son las cadenas para ejecutar los test.

Test 1

x = 1.0 
dof = 6 
NumSeg = 10 
Valor esperado integral = 0.20

Test 2

x = 1.0 
dof = 15 
NumSeg = 10 
Valor esperado integral = 0.45

Test 3

x = 1.0 
dof = 4 
NumSeg = 10 
Valor esperado integral = 0.495

Los formatos de psp2.1 y los archivos de test se encuentran en : psp21\src\site\resources
El javadoc se encuentra en: psp21\src\site\resources\javadoc