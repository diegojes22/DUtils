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

    /**
     * Evalua una expresion aritmetica simple
     * en formato String y devolver el resultado
     * como un double.
     * 
     * @implNote <p>Esta funcion es experimental</p>
     * 
     * @param exp
     * @return
     */
    public static double eval(String exp) {
        exp = exp.replaceAll(" ", "");  // Eliminar los espacios

        // Variables
        int num1 = 0;
        int num2 = 0;
        char op = ' ';

        // Encontrar el operador y los valores numericos
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*' || exp.charAt(i) == '/') {
                op = exp.charAt(i);

                num1 = Integer.parseInt(exp.substring(0, i));
                num2 = Integer.parseInt(exp.substring(i + 1));
                break;
            }
        }

        // operaciones aritmeticas simples
        if(op == '+') {
            // Suma
            return num1 + num2;
        }
        else if(op == '-') {
            // Resta
            return num1 - num2;
        }
        else if(op == '*') {
            // Multiplicacion
            return num1 * num2;
        }
        else if(op == '/') {
            // Division
            try {
                return num1 / num2;
            } catch (Exception e) {
                System.err.println(e.getClass() + " : " + e.getMessage());
            }
            
        }
        else if(op == '%') {
            // Modulo o resiuo
            try {
                return num1 % num2;
            } catch (Exception e) {
                System.err.println(e.getClass() + " : " + e.getMessage());
            }
        }
        else {
            // caso invalido
            System.out.println("Operador no válido");
            return 0.0;
        }

        return 0.0;
    }
}
