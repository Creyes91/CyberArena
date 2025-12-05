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
		int indice = Utils.numeroAleatorio(catalogoArmas.length);
		TipoArma armaAleatoria = catalogoArmas[indice];
		catalogoArmas[indice]=null;
		
		// 
		return armaAleatoria;
	}

	// Método para crear los robots

	private static Robot configuracionRobots(String mensaje, Scanner sc) {

		String nombreRobot1 = Utils.leerCadena(mensaje, 0, 10, sc);

		
		Arma arma = new Arma(armaAleatoria().getNombreArma(), armaAleatoria().getPotencia());
		Robot robot = new Robot(nombreRobot1, arma);
		return robot;
	}

	private static boolean ataqueRobot1(Robot robot1, Robot robot2) {

		if ((Utils.numeroAleatorio(1) == 1)) {
            System.out.println(robot1.getNombreRobot() + " inicia el combate!");
            robot1.atacar(robot2);
            Utils.pulsaContinuar();
            return true;
        } else {
            System.out.println(robot2.getNombreRobot() + " inicia el combate!");
            robot2.atacar(robot1);
            Utils.pulsaContinuar();
            return false;
        }
        }

    // Método para el resto de turnos

    private static void combate(Robot robot1, Robot robot2) {

        boolean ataqueRobot1 = ataqueRobot1(robot1, robot2);

        while (robot1.estaVivo() && robot2.estaVivo()) {

            if (ataqueRobot1) {
                robot2.atacar(robot1);
                ataqueRobot1 = false;
                Utils.pulsaContinuar();

            } else {
                robot1.atacar(robot2);
                ataqueRobot1 = true;
                Utils.pulsaContinuar();
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

        combate(robot1, robot2);

	}

	public static void main(String[] args) {

		// VARIABLES Y SCANNER

		Scanner sc = new Scanner(System.in);

		// BIENVENIDA, CREACIÓN ROBOTS y CELEBRACION DE COMBATE

		celebrarCombate(robot1, robot2, sc);

	}
}
