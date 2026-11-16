package juegito;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SavePoint {

    int casa;
    int poblacion;
    int madera;
    int carbon;
    int hierro;
    int aserradero;
    int mina;
    int fundicion;
    int descontento;
    int dia;

    int nivelTemperatura;
    int contadorTemperatura;
    int limiteTemp;
    int diaCambio;

    public static void guardar(
            int casa,
            int poblacion,
            int madera,
            int carbon,
            int hierro,
            int aserradero,
            int mina,
            int fundicion,
            int descontento,
            int dia,
            int nivelTemperatura,
            int contadorTemperatura,
            int limiteTemp,
            int diaCambio) {

        try {

            PrintWriter pw = new PrintWriter(new FileWriter("save.txt"));

            pw.println(casa);
            pw.println(poblacion);
            pw.println(madera);
            pw.println(carbon);
            pw.println(hierro);
            pw.println(aserradero);
            pw.println(mina);
            pw.println(fundicion);
            pw.println(descontento);
            pw.println(dia);

            pw.println(nivelTemperatura);
            pw.println(contadorTemperatura);
            pw.println(limiteTemp);
            pw.println(diaCambio);

            pw.close();

            System.out.println("Partida guardada");

        } catch (Exception e) {

            System.out.println("Error al guardar");
        }
    }

    public static SavePoint cargar() {

        SavePoint save = new SavePoint();

        try {

            Scanner sc = new Scanner(new File("save.txt"));

            save.casa = Integer.parseInt(sc.nextLine());
            save.poblacion = Integer.parseInt(sc.nextLine());
            save.madera = Integer.parseInt(sc.nextLine());
            save.carbon = Integer.parseInt(sc.nextLine());
            save.hierro = Integer.parseInt(sc.nextLine());
            save.aserradero = Integer.parseInt(sc.nextLine());
            save.mina = Integer.parseInt(sc.nextLine());
            save.fundicion = Integer.parseInt(sc.nextLine());
            save.descontento = Integer.parseInt(sc.nextLine());
            save.dia = Integer.parseInt(sc.nextLine());

            save.nivelTemperatura = Integer.parseInt(sc.nextLine());
            save.contadorTemperatura = Integer.parseInt(sc.nextLine());
            save.limiteTemp = Integer.parseInt(sc.nextLine());
            save.diaCambio = Integer.parseInt(sc.nextLine());

            sc.close();

            System.out.println("Partida cargada");

        } catch (Exception e) {

            System.out.println("No se encontró ninguna partida guardada");
        }

        return save;
    }
}