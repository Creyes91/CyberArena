package es.cyberArena.arena;


import es.cyberArena.Utils.TipoArma;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

public class Arena {
    public static void main(String[] args) {

        // VARIABLES Y SCANNER

        Scanner sc = new Scanner(System.in);

        TipoArma[] catalogoArmas = TipoArma.values();
        Random random = new Random();
        int indiceArmaAleatoria = random.nextInt(catalogoArmas.length);
        TipoArma armaAleatoria = catalogoArmas[indiceArmaAleatoria];

        //BIENVENIDA

        System.out.println("¡¡¡Bienvenidos a ... ROBOOOOT WARS!!!");

        // CREACIÓN ROBOT1
        System.out.println("Introduce el nombre de tu robot: ");

        Arma arma1 = new Arma(armaAleatoria.getNombreArma(),armaAleatoria.getPotencia());
        Robot robot1 = new Robot(sc.nextLine(),arma1);


        // FALTA SACAR EL ARMA DE LA LISTA PARA QUE NO SE REPITAN

        // CREACION ROBOT2

        System.out.println("Introduce el nombre del robot enemigo: ");
        indiceArmaAleatoria = random.nextInt(catalogoArmas.length);
        armaAleatoria = catalogoArmas[indiceArmaAleatoria];

        Arma arma2 = new Arma(armaAleatoria.getNombreArma(),armaAleatoria.getPotencia());

        Robot robot2 = new Robot(sc.nextLine(),arma2);

        // PRESENTACIÓN ROBOTS

        System.out.println("EN LA ESQUINA AZUL, EL ACTUAL CAMPEON, RECIEN ENGRASADO Y PULIDO... " + robot1);

        System.out.println("------");
        System.out.println("Y EN LA ESQUINA ROJA, EL ASPIRANTE A CHATARRERO... " + robot2);
        System.out.println("------");
        System.out.println("COMIENZA EL COMBATE");

        System.out.println(robot1.getNombreRobot() + " VS " + robot2.getNombreRobot());

        System.out.println("------");

        // COMBATE





    }
}
