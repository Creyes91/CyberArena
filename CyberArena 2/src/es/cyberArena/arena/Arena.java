package es.cyberArena.arena;

import es.cyberArena.Utils.TipoArma;
import es.cyberArena.Utils.Utils;

import java.util.Random;
import java.util.Scanner;

public class Arena {

	private static Robot robot1;
	private static Robot robot2;

	// Método para generar un arma aleatoria del arsenal

	private static TipoArma armaAleatoria() {
		TipoArma[] catalogoArmas = TipoArma.values();
		TipoArma armaAleatoria = catalogoArmas[Utils.numeroAleatorio(catalogoArmas.length)];
		return armaAleatoria;
	}

	// Método para crear los robots

	private static Robot configuracionRobots(String mensaje, Scanner sc) {

		String nombreRobot1 = Utils.leerCadena(mensaje, 0, 10, sc);

		Arma arma = new Arma(armaAleatoria().getNombreArma(), armaAleatoria().getPotencia());
		Robot robot = new Robot(nombreRobot1, arma);
		return robot;
	}

	private static void primerTurno(Robot robot1, Robot robot2) {

		switch (Utils.numeroAleatorio(1)) {
		case 0: {

			robot1.atacar(robot2);
			break;

		}
		case 1: {

			robot2.atacar(robot1);
			break;
		}

		}

	}

	// Método para celebrar el combate

	private static void celebrarCombate(Robot robot1, Robot robot2, Scanner sc) {
		System.out.println("¡¡¡Bienvenidos a ... ROBOOOOT WARS!!!");

		robot1 = configuracionRobots("Introduce el nombre de tu robot: ", sc);

		robot2 = configuracionRobots("Introduce el nombre del robot enemigo: ", sc);
		System.out.println("EN LA ESQUINA AZUL, EL ACTUAL CAMPEON, RECIEN ENGRASADO Y PULIDO... " + robot1);

		System.out.println("------");
		System.out.println("Y EN LA ESQUINA ROJA, EL ASPIRANTE A CHATARRERO... " + robot2);
		System.out.println("------");
		System.out.println("COMIENZA EL COMBATE");

		System.out.println(robot1.getNombreRobot() + " VS " + robot2.getNombreRobot());

		System.out.println("------");

		primerTurno(robot1, robot2);

	}

	public static void main(String[] args) {

		// VARIABLES Y SCANNER

		Scanner sc = new Scanner(System.in);

		// BIENVENIDA Y CREACIÓN ROBOTS

		celebrarCombate(robot1, robot2, sc);

		// COMBATE

	}
}
