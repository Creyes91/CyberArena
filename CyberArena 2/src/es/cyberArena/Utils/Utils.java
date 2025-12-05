package es.cyberArena.Utils;

import java.util.Random;
import java.util.Scanner;

public class Utils {

	/**
	 * 
	 * metodo estatico para leer cadenas de texto despues de mostrar un mensaje por
	 * consola
	 * 
	 * @param mensaje: mensaje que se muestra por consola que se pasa como atributo
	 * @param min      parametro que indica el tamaño minimo de la cadena de
	 *                 caracteres que se leera por teclado
	 * @param max      parametro que indica el tamaño maximo de la cadena leida por
	 *                 teclado, si vale 0 no tiene maximo
	 * @param sc       objeto de la clase {@link java.util.Scanner}
	 * @return devuelve la cadena leida por teclado, siempre y cuando este entre min
	 *         y max
	 */

	public static String leerCadena(String mensaje, int min, int max, Scanner sc) {

		String cadenaString;

		do {
			System.out.println(mensaje);
			cadenaString = sc.nextLine();

		} while (!(cadenaString.length() >= min && (max == 0 || cadenaString.length() <= max)));

		return cadenaString;
	}

	public static int numeroAleatorio(int cantidad) {

		Random rd = new Random();

		int numeroAleatorio = rd.nextInt(cantidad);

		return numeroAleatorio;

	}

public static void pulsaContinuar() {
    Scanner sc = new Scanner(System.in);
    String entrada;

    do {
        System.out.println("Pulsa ENTER para continuar...");
        entrada = sc.nextLine();

        if (!entrada.isEmpty()) {
            System.out.println("Por favor, pulsa solo ENTER (no escribas nada).");
        }

    } while (!entrada.isEmpty());
}
}
