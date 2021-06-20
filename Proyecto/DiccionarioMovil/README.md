# Diccionario Maya - Movil

Esta parte del proyecto es la encargada de agregar informacion 
a la base de datos, es decir la Palabra y Significado.
La conexion a la base de datos necesito de librerias externas, en este caso
fueran descargadas mediante las dependencia de Gradle

# Model
## Diccionario

Es el modelo que se encarga de administrar la estructura de la base de datos,
consta de dos variables Palabra, Significado con sus respetivos Getters and Setter.

# Services
## ApiServices

Esta clase es la encargada de hacer la conexion a la base de datos, al igual que hacer las query necesarias para la recuperacion de datos de la misma

# Fonts

Esta es la carpeta encargada de adminitrar las fuentes utilizadas en la parte visual de la aplicacion

# App.xaml

Esta agregado los recursos tipo Binding para este caso el uso de la fuentes personalizadas

# MainPage

En la parte visual simlemente usarmos una StackLayout junto a un Listview para mostar en una lista diccionario los datos de la base de datos

En la parte logica usamos metodos para realizar el llamado de la clase ApiService y hacer las coneccion y el respectivo Query, asi mismo se encarga de llenar el ListView