# DUtils
> ## Instituto Tecnológico de La Piedad
> ### Programación de orientada a objetos
> 
> ------------------------------------------------------------
> 
> **Desarrollador: Diego Jesus Munoz Andrade**
> 
> **Departamento de Sistemas y Computacion**
> 
> **2-C**
> 
> **Contacto: l23640125@piedad.tecnm.mx**

>Esta es una librería de utilidades para el desarrollo de mis aplicaciones en mi universidad.
>Cualquier otro puede usarla, modificarlas, etc...
>
> ##### Esta libreria se actualizara con el tiempo, por lo que es recomendable revisarla de vez en cuando.

## Agregar a un proyecto
Selecciona los tres archivos y cópialos a tu proyecto. Es todo 😀

---------------------------------------------------------------------
## Documentación
La librería se compone solo de tres archivos:
- Utils.java
- Menu.java
- Example.java

---------------------------------------------------------------------
## Utils.java
Es una clase que contiene métodos estáticos que ayudan un poco a la decoración de la 
consola. Esta clase está todavía en desarrollo por lo que algunas funciones todavía 
están en revisión o están incompletas. 

```Una vez aclarado veamos cuales son los métodos que contiene:```

### Lines
El método imprime una línea en la consola, y como este método esta
sobrecargado, puedes imprimir *n* líneas en la consola o utilizar 
su version que ya tiene un valor por defecto.

```java
// En este elegimos la cantidad de lineas que queremos imprimir
public static void lines(int n) {
    for(int i = 0; i < n; i++)
        System.out.print("-");

    System.out.println();
}

// En este solo imprimimos una linea
public static void lines() {
    lines(50);
}
```

### Clear
Solo limpia la consola y no tiene parámetros. No hay mucho que decir de este metodo.
>Nota: Este método solo funciona en sistemas operativos basados en Unix.
>     En Windows no funciona aun.

```java
public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
}
```

### gotoXY
La idea de este método es mover el cursor a una posición específica en la consola, 
pero aún está en fase de desarrollo y no funciona correctamente.

>Nota: No es recomendable usar el método a pesar de que pueda funcionar en algunos 
>      casos ya que puede arrojar resultados inesperados.

```java
// solo pongo el codigo para que el documento se vea mejor.
public static void gotoXY(int x, int y) {
    System.out.print("\033[" + x + ";" + y + "H");
}
```

---------------------------------------------------------------------
## Menu.java
Esta clase es una clase que contiene métodos para la creación de menús en la consola 
e intentar reducir la cantidad de código que se necesita para crear un menú en el 
main o donde sea que se necesite.

### Atributos
La clase tiene tres atributos que son:
- ```private String menuName;```  Es el nombre del menú.
- ```private String[] options;``` Es un arreglo de opciones que tendrá el menú.
- ```private int selectedOption = 0;``` Es la opción que el usuario deberá elegir, 
                                        más adelante se profundizará en su uso.

### Constructor
El constructor de la clase recibe dos parámetros, el nombre del menú y un arreglo de
opciones. 

```java
public Menu(String menuName, String[] options) {
    this.menuName = menuName;
    this.options = options;
    this.selectedOption = 0;
}
```

Tambien hay un constructor vacio que no recibe parametros, no es recomendable usarlo.
```java
public Menu() {
   
}
```

### Getters y Setters
Como en cualquier otra clase, hay métodos para obtener y establecer los valores de 
los atributos. No es necesario explicarlos más ni mirar el código.

### printMenu
Este es el método que imprime el menú en la consola, aquí es donde se ahorra la mayor 
parte del código.

Este método muestra las opciones que están en el arreglo de opciones, cuyo número de 
acceso es su posición en el arreglo que empieza en 0.


>Nota: En vez de usar este método, es mejor utilizar ```run``` que imprime el menú 
>      y además permite al usuario elegir una opción.

```java
int index = 0;

Utils.lines();
    System.out.println("\t"+menuName);

    for(String option : options) {
        System.out.println("["+index+"] "+option);
        index++;
    }
}
```

### run
Este método imprime el menú y permite al usuario elegir una opción. 

> ### Codigo de error de retorno
> Si ocurre una excepción con ```Scanner``` el método regresara el valor 255.
> El numero 255 es un código de error que nos indica que se ingresó un parámetro 
> invalido, un número no entero o un carácter. Este código de error puede ser 
> utilizado en el switch o puede ser cambiado, ignorado, etc...

```java
public int run(Scanner input) {
    printMenu(); // Mostrar opciones

    System.out.print("\nSeleccione una opción: ");
    try {
        // si se utilizar directamente el metodo nextInt el programa
        // se salta la lectura y va directamente a la excepcion, o en
        // otros casos se queda en un loop.

        String selectedOptionStr = input.next();
        selectedOption = Integer.parseInt(selectedOptionStr);
    }
    catch (Exception e) {
        // El codigo de error 255 es para indicar que se ingreso un
        // valor invalido. Este puede ser utilizado en el switch
        // o tambien puede ser cambiado, ignorado, etc...
        System.err.println("Error: Se ingreso un valor invalido");
        System.err.println("Por favor, ingrese un numero entero");
        selectedOption = 255;
    }

    Utils.lines();
    return selectedOption;
}
```

El método run también esta sobrecargado, en este caso es de tipo estático por lo 
que no necesita un objeto de la clase para ser llamado. Además, este recibe 
como parámetros el nombre del menú y un arreglo de opciones.

```java
public static int run(Scanner input, String menuName, String[] options) {
    Menu menu = new Menu(menuName, options);
    int opc = menu.run(input);

    menu = null;  // Por si acaso
    return opc;
}
```

---------------------------------------------------------------------
## Example.java
Esta clase es un ejemplo de cómo se puede utilizar la clase ```Menu``` y ```Utils```.
La clase puede ser utilizada como una plantilla muy simple para crear tu programa.

---------------------------------------------------------------------
## Codigos de error
- 255: Se ingreso un valor invalido en algun ```Scanner```.

> De momento solo hay un código de error implementado, con forme el proyecto 
> crezca y aparezcan más excepciones se agregarán más.