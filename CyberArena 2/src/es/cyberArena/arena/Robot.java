package es.cyberArena.arena;

import java.util.Random;import com.sun.source.doctree.EscapeTree;

import es.cyberArena.Utils.Utils;

import es.cyberArena.Utils.TipoArma;


public class Robot {
	
	
	
	// Atributos
	private String nombreRobot;
	private int vidaRobot = 100;
	private Arma arma;

	// Constructores

	/**
	 * Constructor de la clase Robot, con dos parametros 
	 * @param nombreRobot {@link java.lang.String} con el nombre del Robot
	 * @param arma atributo de tipo {@link es.cyberArena.arena.Arma} que se asignara al robot
	 */
	public Robot(String nombreRobot, Arma arma) {

		this.nombreRobot = nombreRobot;
		this.arma = arma;
	}
	
	/**
	 * Constructor con un parametro, Nombre de tipo {@link java.lang.String}, 
	 * se le asigna un arma por defecto "Puños de acero", con 10 de daño
	 * @param nombreRobot {@link java.lang.String} con el nombre del Robot
	 */

	public Robot(String nombreRobot) {

		this.nombreRobot = nombreRobot;
		this.arma = new Arma (TipoArma.POR_DEFECTO.getNombreArma(), TipoArma.POR_DEFECTO.getPotencia());
	}

	// Getters

	/**
	 * Getter del atributo Nombre de un robot
	 * @return devuelve el {@link java.lang.String} del nombre del Robot
	 */
	public String getNombreRobot() {
		return nombreRobot;
	}
	
	/**
	 * Getter del atributo vidaRobot que tiene la vida del robot expresada en {@link java.lang.Integer}
	 * @return un entero conla vida restante del robot
	 */

	public int getVidaRobot() {
		return vidaRobot;
	}


// Métodos
	
	/**
	 * Metodo que recibe un objeto de la clase {@link } que sera el que recibe el daño del combate
	 * @param robotEnemigo objeto
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

	public void recibirDano(int cantidadDano) {
		vidaRobot = vidaRobot - cantidadDano;

		if (vidaRobot < 0) {
			vidaRobot = 0;
		}

		System.out.println(
				this.getNombreRobot() + " recibe " + cantidadDano + " puntos de daño. Vida restante: " + vidaRobot);
	}

	public boolean estaVivo() {

//		if (vidaRobot > 0) {
//			return true;
//		} else {
//			return false;
//		}
		
		return vidaRobot>0;

	}

	@Override
	public String toString() {
		return this.getNombreRobot() + " ARMADO CON " + arma.getNombreArma();
	}
}
