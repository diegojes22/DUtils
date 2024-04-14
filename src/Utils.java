/**
 * @autor Diego Jesus Munoz Andrade
 * @version 0.0.1
 * @date 13 de Abril del 2024
 * @file Utils.java
 *
 * @brief Contiene funciones de utilidad para mejorar la estetica
 * de los programas en consola. Mas informacion en la documentacion.
 */

// La finalidad de esta libreria es tener algunas utilidades
// basicas para simplificar y mejorar algunos de los programas
// echos en mi universidad.

// package DUtils.Source; // Cambiar por el nombre de tu paquete o modificar

public class Utils {
    /**
     * Imprime una linea de n caracteres '-' para separar secciones
     * en la consola y mejorar la estetica en programas simples
     *
     * @param n Cantidad de caracteres a imprimir
     */
    public static void lines(int n) {
        for(int i = 0; i < n; i++)
            System.out.print("-");

        System.out.println();
    }

    /**
     * Imprime una linea de 50 caracteres '-' para separar secciones
     * en la consola y mejorar la estetica en programas simples
     */
    public static void lines() {
        lines(50);
    }

    /**
     * Limpia la consola
     *
     * @see <p>Esta funcion solo se ejecuta correctamente en la terminal de MacOS
     * o linux, no se ejecuta correctamente en la terminal de windows o de un IDE
     * como IntelliJ IDEA o APACHE NetBeans</p>
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Dirige el cursor a una cordenada en la consola
     *
     * @implNote  <p>Esta funcion todavia esta en fase de pruevas.
     * No la uses, ya que te puedes encontrar con resultados
     * inesperados.</p>
     */
    public static void gotoXY(int x, int y) {
        System.out.print("\033[" + y + ";" + x + "H");
    }

    /**
     * Dirige el cursor a una cordenada en la consola para imprimir
     * un texto a partir de esa cordenada.
     *
     * @implNote  <p>Esta funcion todavia esta en fase de pruevas.
     * No la uses, ya que te puedes encontrar con resultados
     * inesperados.</p>
     */
    public static void gotoXY(int x, int y, String text) {
        gotoXY(x, y);
        System.out.print(text);
    }
}
