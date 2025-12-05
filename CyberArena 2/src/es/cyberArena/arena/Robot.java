package es.cyberArena.arena;

import java.util.Random;import com.sun.source.doctree.EscapeTree;

import es.cyberArena.Utils.Utils;

import es.cyberArena.Utils.TipoArma;

/**
 * Clase Robot, representa un robot para la batalla de Robots que tiene un nombre, vida y un arma para luchar
 */

public class Robot {
	
	
	
	// Atributos
	/**
	 * {@link String} Nombre del Robot
	 */
	private String nombreRobot;
	/**
	 * Entero que representa la salud del Robot
	 */
	private int vidaRobot = 100;
	/**
	 * Arma asignada al robot para el combate
	 */
	private Arma arma;

	// Constructores

	/**
	 * Constructor de la clase Robot, con dos parametros 
	 * @param nombreRobot {@link java.lang.String} con el nombre del Robot
	 * @param arma atributo de tipo {@link es.cyberArena.arena.Arma} que se asignara al robot
	 * @author Gonzalo
	 */
	public Robot(String nombreRobot, Arma arma) {

		this.nombreRobot = nombreRobot;
		this.arma = arma;
	}
	
	/**
	 * Constructor con un parametro, Nombre de tipo {@link java.lang.String}, 
	 * se le asigna un arma por defecto "Puños de acero", con 10 de daño
	 * @param nombreRobot {@link java.lang.String} con el nombre del Robot
	 * @author Gonzalo
	 */

	public Robot(String nombreRobot) {

		this.nombreRobot = nombreRobot;
		this.arma = new Arma (TipoArma.POR_DEFECTO.getNombreArma(), TipoArma.POR_DEFECTO.getPotencia());
	}

	// Getters

	/**
	 * Getter del atributo Nombre de un robot
	 * @return devuelve el {@link java.lang.String} del nombre del Robot
	 * @author Gonzalo
	 */
	public String getNombreRobot() {
		return nombreRobot;
	}
	
	/**
	 * Getter del atributo vidaRobot que tiene la vida del robot expresada en {@link java.lang.Integer}
	 * @return un entero conla vida restante del robot
	 * @author Gonzalo
	 */

	public int getVidaRobot() {
		return vidaRobot;
	}


// Métodos
	
	/**
	 * Metodo que recibe un objeto de la clase Robot que sera el que recibe el daño del combate
	 * @param robotEnemigo objeto que recibira el daño de la batalla
	 * @author Gonzalo
	 */

	public void atacar(Robot robotEnemigo) {
		
		int dano = this.arma.getPotenciaArma() + Utils.numeroAleatorio(8);

		switch (Utils.numeroAleatorio(3)) {
		case 0, 1: {
			
			System.out.println(this.getNombreRobot() + " ataca ferozmente a " + robotEnemigo.getNombreRobot() + " con "
					+ arma.getNombreArma());
			robotEnemigo.recibirDano(dano);
			break;
		}

		case 2: {
            System.out.println(this.getNombreRobot() + " ataca ferozmente a " + robotEnemigo.getNombreRobot() + " con "
                    + arma.getNombreArma());
            System.out.println("Pero no acierta... " + this.getNombreRobot() +  " ha fallado.");
			break;
		}

		}

	}
	
	/**
	 * Metodo que calcula el daño recibido en batalla y modifica la vida del robot
	 * @param cantidadDano {@link java.lang.Integer} con el daño recibido del robot enemigo
	 * @author Gonzalo
	 */

	public void recibirDano(int cantidadDano) {
		vidaRobot -= cantidadDano;

		if (vidaRobot < 0) {
			vidaRobot = 0;
		}

		System.out.println(
				this.getNombreRobot() + " recibe " + cantidadDano + " puntos de daño. Vida restante: " + vidaRobot);
	}
	
	/**
	 * Metodo que verifica el estado del robot, si la vidaRobot es mayor que cero devuleve un true sino un false
	 * @return {@link java.lang.Boolean} compruba si es mayor que cero y devuelve true o false
	 * @author Cristian
	 */

	public boolean estaVivo() {

//		if (vidaRobot > 0) {
//			return true;
//		} else {
//			return false;
//		}
		
		return vidaRobot>0;

	}

	/**
	 * Devuelve una descripcion del objeto Robot
	 * @return Devuelve el nombre del Robot y el nombre del arma que posee
	 */
	@Override
	public String toString() {
		return this.getNombreRobot() + " ARMADO CON " + arma.getNombreArma();
	}
}
