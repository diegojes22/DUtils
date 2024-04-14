import java.util.Scanner;

/**
 * @autor Diego Jesus Munoz Andrade
 * @version 0.0.1
 * @date 13 de Abril del 2024
 *
 * @brief <p>Ejemplo de como implementar un menu de opciones en
 * consola con la ayuda de las librerias Utils y Menu.</p>
 *
 * Puedes utilizar este mismo codigo en tus programas para crear
 * tu proyecto.
 */

// package DUtils.Source; // Cambiar por el nombre de tu paquete o modificar

public class Example {
    // Main
    public static void main(String[] args) {
        // Variables
        int opc = 0;
        Scanner input = new Scanner(System.in);

        // Mainloop
        do {
            // Creamos el menu principal
            opc = Menu.run(input, "Inicio", new String[]{"Salir", "Opcion 1", "Opcion 2"});

            // Dependiendo de la opcion seleccionada
            // se ejecutara un bloque de codigo u otro.
            //
            // Tambien es importante mencionar que el numero
            // de opcion va de acuerdo a como este esta
            // ordenado en el arreglo de opciones.
            //
            // Todo esto se aclara en la documentacion.

            switch (opc) {
                // Opcion 0 es la salida
                case 0:
                    System.out.println("Saliendo...");
                    break;

                // Mas opciones
                case 1:
                    System.out.println("Opcion 1");
                    System.out.println("Hola Mundo");
                    break;
                case 2:
                    System.out.println("Opcion 2");
                    break;

                // Opcion invalida
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while(opc != 0);

        input.close();
    }
}
