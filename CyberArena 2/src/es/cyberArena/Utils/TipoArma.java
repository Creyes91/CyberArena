package es.cyberArena.Utils;

public enum TipoArma {

	MOTOSIERRA_DE_PLASMA("Motosierra de Plasma", 15), CANYON_DE_PULSOS("Cañon de Pulsos", 18),
	ESPADA_INFINITA("Espada Infinita", 10), MARTILLO_NEUMATICO("Martillo Neumatico", 12),
    GARRAS_DE_TITANIO("Garras de Titanio", 10), LATIGO_ELECTRICO("Látigo Eléctrico", 11),
	PISTOLA_NUCLEAR("Pistola Nuclear", 12), LANZA_DE_DIAMANTE("Lanza de Diamante", 11),
	ESCOPETA_SONICA("Escopeta Sonica", 14), LANZALLAMAS_FUNDENTE("Lanzallamas fundente", 15),
	POR_DEFECTO("Puños de Acero", 10);

	// Atributos
	private final int potencia;
	private final String nombreArma;

	/**
	 * Constructor privado con dos paramtros, construye un enum que repredenta el
	 * tipo de arma que hay y guarda su nombre y su potencia
	 * 
	 * @param nombreArma parametro de tipo String que guarda el nombbre del arma
	 * @param potencia   parametro de tipo entero que representa la potencia de un
	 *                   arma
	 */
	private TipoArma(String nombreArma, int potencia) {
		this.nombreArma = nombreArma;
		this.potencia = potencia;
	}

	/**
	 * metodo getter de potencia
	 * 
	 * @return devuelve un entero con la informacion de la potencia de un arma
	 */

	public int getPotencia() {
		return potencia;
	}

	/**
	 *metodo getter de NombreArma 
	 * @return devuelve un String con el nombre del arma
	 */
	public String getNombreArma() {
		return nombreArma;
	}

}
