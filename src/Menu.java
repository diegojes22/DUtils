// Librerias
import java.util.Scanner;

/**
 * @autor Diego Jesus Munoz Andrade
 * @version 0.0.1
 * @date 13 de Abril del 2024
 * @file Utils.java
 *
 * @brief Contiene funciones de utilidad para mejorar la estetica
 * de los programas en consola. Mas informacion en la documentacion.
 */

// package DUtils.Source; // Cambiar por el nombre de tu paquete o modificar

// El objetivo de esta libreria es reducir codigo en los programas
// que requieran de un menu de opciones en consola dejados en mi
// universidad.
public class Menu {
    // Attributes
    private String menuName;
    private String[] options;
    private int selectedOption = 0;

    // Methods
    /**
     * Constructor
     *
     * @param menuName Nombre del menu
     * @param options  Opciones del menu
     */
    public Menu(String menuName, String[] options) {
        this.menuName = menuName;
        this.options = options;
        this.selectedOption = 0;
    }

    /**
     * Constructor por defecto
     * @implNote <p>Recomiendo mas hinstaciar la clase completa
     * o usar el metodo estatico</p>
     */
    public Menu() {}

    // Setters
    public void setMenuName(String menuName) { this.menuName = menuName; }
    public void setOptions(String[] options) { this.options = options; }

    // Getters
    public String getMenuName() { return menuName; }
    public String[] getOptions() { return options; }


    /**
     * Solo imprime las opciones del menu en consola
     * @implNote <p>Recomendable usar el metodo <b>run</b>, ya que
     * este lee los datos del teclado ademas de mostrar las opciones
     * del menu.</p>
     */
    public void printMenu() {
        int index = 0;

        Utils.lines();
        System.out.println("\t"+menuName);

        for(String option : options) {
            System.out.println("["+index+"] "+option);
            index++;
        }
    }

    /**
     * Muestra las opciones del menu y lee la opcion seleccionada
     * por el usuario
     *
     * @param input Scanner para leer la opcion seleccionada
     * @return Opcion seleccionada por el usuario
     *
     * @implNote <p>Recomendable analizar el dato leido en un switch
     * para poder realizar la accion determinada por el usuario.</p>
     */
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

    /**
     * Metodo estatico para poder ejecutar un menu sin la necesidad
     * de instanciar la clase. Esto puede ayudar a reducir codigo.
     *
     * @param input    Scanner para leer la opcion seleccionada, dicho Scanner debe ser declarado en el programa principal
     * @param menuName Nombre del menu
     * @param options  Lista de opciones del menu
     * @return         Devolvemos el valor seleccionado por el usuario
     */
    public static int run(Scanner input, String menuName, String[] options) {
        Menu menu = new Menu(menuName, options);
        int opc = menu.run(input);

        menu = null;  // Por si acaso
        return opc;
    }
}