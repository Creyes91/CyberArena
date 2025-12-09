package es.cyberArena.arena;

import es.cyberArena.Utils.TipoArma;
import es.cyberArena.Utils.Utils;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase Arena que representa la creación de dos robots y la bienvenida y
 * transcurso de un combate por turnos entre ambos
 */

public class Arena {

	private static final int LONG_MINIMA = 0;
	private static final int LONG_MAXIMA = 10;

	private static TipoArma[] catalogoArmas;

	private static Random rnd = new Random();

	// Métodos

	/**
	 * Crea un array de tipo {@link es.cyberArena.Utils.TipoArma } y saca un objeto
	 * del array
	 * 
	 * @return devuelve un entero aleatorio para sacar un objeto TipoArma
	 * @author Cristian y Gonzalo
	 */
	private static TipoArma armaAleatoria() {

		TipoArma arma;
		int indice;
		do {
			indice = rnd.nextInt(catalogoArmas.length - 1);
			arma = catalogoArmas[indice];
		} while (arma == null);
		catalogoArmas[indice] = null;

		return arma;
	}

	/**
	 * Configura y crea los robots llamando a los constructores de la clase arma y
	 * robot
	 * 
	 * @param mensaje recibe el nombre del Robot con {@link java.lang.String}
	 * @param sc      objeto de la clase {@link java.util.Scanner}
	 * @return devuelve un objeto de la clase Robot
	 *         {@link es.cyberArena.arena.Robot}
	 * @author Gonzalo
	 */
	private static Robot configuracionRobots(String mensaje, Scanner sc) {

		String nombreRobot1 = Utils.leerCadena(mensaje, LONG_MINIMA, LONG_MAXIMA, sc);

		Arma arma = new Arma(armaAleatoria().getNombreArma(), armaAleatoria().getPotencia());
		Robot robot = new Robot(nombreRobot1, arma);
		return robot;
	}

	/**
	 * Método que decide quien atacará primero de forma aleatoria
	 * 
	 * @param robot1 objeto de la clase Robot {@link es.cyberArena.arena.Robot} que
	 *               hará de protagonista
	 * @param robot2 objeto de la clase Robot {@link es.cyberArena.arena.Robot} que
	 *               hará de enemigo
	 * @param sc     objeto de la clase {@link java.util.Scanner}
	 * @return Devuelve un {@link java.lang.Boolean} que representa quien atacó
	 *         primero
	 * @author Gonzalo
	 */
	private static boolean ataqueRobot1(Robot robot1, Robot robot2, Scanner sc, int primero) {

		if ((primero == 1)) {
			System.out.println(robot1.getNombreRobot() + " inicia el combate!");
			robot1.atacar(robot2);
			Utils.pulsaContinuar(sc);
			return true;
		} else {
			System.out.println(robot2.getNombreRobot() + " inicia el combate!");
			robot2.atacar(robot1);
			Utils.pulsaContinuar(sc);
			return false;
		}
	}

	/**
	 * Método que comprueba quien atacó primero y ejecuta el resto del combate
	 * asegurándose que los robots ataquen sucesivamente por turnos
	 * 
	 * @param robot1 objeto de la clase Robot {@link es.cyberArena.arena.Robot} que
	 *               hará de protagonista
	 * @param robot2 objeto de la clase Robot {@link es.cyberArena.arena.Robot} que
	 *               hará de enemigo
	 * @param sc     objeto de la clase {@link java.util.Scanner}
	 * @author Gonzalo
	 */

	private static void celebraCombate(Robot robot1, Robot robot2, Scanner sc) {

		boolean ataqueRobot1 = ataqueRobot1(robot1, robot2, sc, rnd.nextInt(2));

		while (robot1.estaVivo() && robot2.estaVivo()) {

			if (ataqueRobot1) {
				robot2.atacar(robot1);
				ataqueRobot1 = false;
				Utils.pulsaContinuar(sc);

			} else {
				robot1.atacar(robot2);
				ataqueRobot1 = true;
				Utils.pulsaContinuar(sc);
			}

		}

		if (robot1.estaVivo()) {
			System.out.println("¡¡¡EL GANADOR ES: " + robot1.getNombreRobot() + " !!");
		} else if (robot2.estaVivo()) {
			System.out.println("¡¡¡EL GANADOR ES: " + robot2.getNombreRobot() + " !!");
		}

	}

	/**
	 * Método main que ejecuta el código
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// VARIABLES Y SCANNER

		Scanner sc = new Scanner(System.in);

		catalogoArmas = TipoArma.values();

		// BIENVENIDA, CREACIÓN ROBOTS y CELEBRACION DE COMBATE
		System.out.println("¡¡¡Bienvenidos a ... ROBOOOOT WARS!!!");

		Robot robot1 = configuracionRobots("Introduce el nombre de tu robot: ", sc);

		Robot robot2 = configuracionRobots("Introduce el nombre del robot enemigo: ", sc);
		System.out.println("EN LA ESQUINA AZUL, EL ACTUAL CAMPEON, RECIEN ENGRASADO Y PULIDO... " + robot1);

		System.out.println("------");
		System.out.println("Y EN LA ESQUINA ROJA, EL ASPIRANTE A CHATARRERO... " + robot2);
		System.out.println("------");
		System.out.println("COMIENZA EL COMBATE");

		System.out.println(robot1.getNombreRobot() + " VS " + robot2.getNombreRobot());

		System.out.println("------");

		celebraCombate(robot1, robot2, sc);

	}
}
