package es.cyberArena.arena;

import es.cyberArena.Utils.TipoArma;
import es.cyberArena.Utils.Utils;

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

	private static boolean atacaPrimerRobot(Robot robot1, Robot robot2) {

		if ((Utils.numeroAleatorio(1) == 1)) {
            robot1.atacar(robot2);
            return true;
        } else {
            robot2.atacar(robot1);
            return false;
        }
        }

    // Método para el resto de turnos

    private static void continuarCombate(Robot robot1, Robot robot2) {

        boolean atacaRobot1 = atacaPrimerRobot(robot1, robot2);

        while (robot2.estaVivo() && robot1.estaVivo()) {

            if (atacaRobot1) {
                robot2.atacar(robot1);
                atacaRobot1 = false;

            } else {
                robot2.atacar(robot1);

                atacaRobot1 = true;
            }
        }

        if (robot1.estaVivo()) {
            System.out.println("¡¡¡El combate terminó: " + robot1.getNombreRobot() + " ganó!!!");
        } else if (robot2.estaVivo()) {
            System.out.println("¡¡¡El combate terminó: " + robot2.getNombreRobot() + " ganó!!!");
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

        atacaPrimerRobot(robot1, robot2);
        continuarCombate(robot1, robot2);



	}

	public static void main(String[] args) {

		// VARIABLES Y SCANNER

		Scanner sc = new Scanner(System.in);

		// BIENVENIDA Y CREACIÓN ROBOTS

		celebrarCombate(robot1, robot2, sc);


		// COMBATE

	}
}
