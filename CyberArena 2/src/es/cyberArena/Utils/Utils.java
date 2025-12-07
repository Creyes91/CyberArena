package es.cyberArena.Utils;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase Utils con metodos staticos que usamos en nuestro programa 
 */

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
	 * 
	 */

	public static String leerCadena(String mensaje, int min, int max, Scanner sc) {

		String cadenaString;

		do {
			System.out.println(mensaje);
			cadenaString = sc.nextLine();

		} while (!(cadenaString.length() >= min && (max == 0 || cadenaString.length() <= max)));

		return cadenaString;
	}

	
	
	/**
	 * Metodo para continuar al plsar enter,el combate se interrumpe esperando a interactuar con un Enter, 
	 * si pulsas algo mas devuelve un mensaje que solo es necesario ENTER
	 * 
	 */

	public static void pulsaContinuar(Scanner sc) {
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
