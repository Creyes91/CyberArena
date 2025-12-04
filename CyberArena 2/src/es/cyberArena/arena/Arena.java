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
    
	// Método para celebrar el combate
	
	private static void celebrarCombate(Robot robot1, Robot robot2, Scanner sc) {
		System.out.println("¡¡¡Bienvenidos a ... ROBOOOOT WARS!!!");

		Robot robotAliado = configuracionRobots("Introduce el nombre de tu robot: ", sc);
		Robot robotEnemigo = configuracionRobots("Introduce el nombre del robot enemigo: ", sc);
		System.out.println("EN LA ESQUINA AZUL, EL ACTUAL CAMPEON, RECIEN ENGRASADO Y PULIDO... " + robotAliado);

		System.out.println("------");
		System.out.println("Y EN LA ESQUINA ROJA, EL ASPIRANTE A CHATARRERO... " + robotEnemigo);
		System.out.println("------");
		System.out.println("COMIENZA EL COMBATE");

		System.out.println(robotAliado.getNombreRobot() + " VS " + robotEnemigo.getNombreRobot());

		System.out.println("------");
		
		
		
		switch (Utils.numeroAleatorio(1)) {
		case 0: {
			
		robotAliado.atacar(robotEnemigo);
		
		} case 1: {
			// pega el robot2
		}

	
		}
	}

	public static void main(String[] args) {

		// VARIABLES Y SCANNER

		Scanner sc = new Scanner(System.in);

		// BIENVENIDA Y CREACIÓN ROBOTS

		celebrarCombate(robot1, robot2, sc);

		// COMBATE

	}
}
