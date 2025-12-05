package es.cyberArena.arena;

/**
 * Clase que representa un arma para la batalla de robots.
 */

public class Arma {
	
	//CONSTANTES
	/**
	 * Potencia maxima que puede tener un arma
	 */
	private static final int POTENCIA_MAXIMA = 19;
	/**
	 * Potencia minima que pude tener un arma
	 */
	private static final int POTENCIA_MINIMA = 10;
	
	// Atributos 
	
	/**
	 * {@link java.lang.String} que guarda el nombre del arma
	 */
	private String nombreArma;
	
	/**
	 * {@link java.lang.Integer} que guarda la potencia del arma 
	 */
	private int potenciaArma;
	
	/**
	 * Construnctor con ambos atributos del Arma
	 * 
	 * @param nombreArma atributo de tipo String que guarda el nombre del objeto Arma
	 * @param potenciaArma atributo de tipo entero que guarda el daño que inflinje el objeto Arma
	 * @author Cristian
	 */
	
	
	public Arma(String nombreArma, int potenciaArma) {
		
		this.nombreArma = nombreArma;
		if (potenciaArma>=POTENCIA_MINIMA && potenciaArma<=POTENCIA_MAXIMA)
			this.potenciaArma = potenciaArma;
		else 
			this.potenciaArma = POTENCIA_MINIMA;
	}

	/**
	 * Metodo que devuelve el nombre del Objeto
	 * @return devuelve un String con el nombre del arma
	 * @author Cristian
	 */
	public String getNombreArma() {
		return nombreArma;
	}
	
	/**
	 * Metodo que devuelve la potencia del arma
	 * @return devuelve un entero que representa la potencia del Arma
	 * @author Cristian
	 */

	public int getPotenciaArma() {
		return potenciaArma;
	}
	
	
	
	
	
	
	
}
