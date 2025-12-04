package es.cyberArena.arena;

import java.util.Random;
import es.cyberArena.Utils.Utils;

import es.cyberArena.Utils.TipoArma;


public class Robot {
	
	
	
	// Atributos
	private String nombreRobot;
	private int vidaRobot = 100;
	private Arma arma;

	// Constructores

	public Robot(String nombreRobot, Arma arma) {

		this.nombreRobot = nombreRobot;
		this.arma = arma;
	}

	public Robot(String nombreRobot) {

		this.nombreRobot = nombreRobot;
		this.arma = new Arma (TipoArma.POR_DEFECTO.getNombreArma(), TipoArma.POR_DEFECTO.getPotencia());
	}

	// Getters

	public String getNombreRobot() {
		return nombreRobot;
	}

	public int getVidaRobot() {
		return vidaRobot;
	}


// Métodos

	public void atacar(Robot robotEnemigo) {
		int dano = 0;
		dano = this.arma.getPotenciaArma() + Utils.numeroAleatorio(8);

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

		if (vidaRobot > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return this.getNombreRobot() + " ARMADO CON " + arma.getNombreArma();
	}
}
