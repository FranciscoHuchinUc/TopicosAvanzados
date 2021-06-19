# Diccionario Maya - Escritorio

Esta parte del proyecto es la encargada de agregar informacion 
a la base de datos, es decir la Palabra y Significado.
La conexion a la base de datos necesito de librerias externas, en este caso
fueran descargadas mediante las dependencia de Gradle

# Model
## Diccionario

Es el modelo que se encarga de administrar la estructura de la base de datos,
consta de dos variables Palabra, Significado con sus respetivos Getters and Setter.

## TextPlace

Es el modelo de la vista de un JTextField el cual hace el papel de poner un texto
estatido predefinido cuando el usuario no ah ingresado ningun dato.

# Service
## ApiService

Esta clase es la encargada de hacer la conexion a la base de datos, esa es la unica laborar
al igual que generar una ID aleatorio para los registros de la base de datos

# View
## RegistroDiccionario

Esta es la parte visual para el usuario, es una clase que estiendo de JFrame,
la cual consta internamente de mnetodos logicos para hacer las query en la base de datos,
tales como nuevoRegistroDb, que recibe como parametro la palabra y significado de tipo String
y otro metodo que limpia los JTextField despues de hacerce la query.