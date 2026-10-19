/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegito;

import java.util.Scanner;

/**
 *
 * @author Lenovo i7
 */
public class Juegito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int resp;
        //stats
        int casa = 3;
        int poblacion = 50;

        //recursos
        int madera = 0, carbon = 0, hierro = 0;
        int aserradero = 0, mina = 0, fundicion = 0;
        

        //medidores 
        int descontento = 0;
        int dia = 1;

        //menu dificultad
        System.out.println(" dificultad");
        System.out.println("1.facil 2.normal 3.dificil");
        resp = sc.nextInt();
        switch (resp) {
            case 1:
                madera = 75;
                carbon = 100;
                hierro = 70;
                descontento = 25;
                break;
            case 2:
                madera = 50;
                carbon = 100;
                hierro = 50;
                descontento = 50;
                break;
            case 3:
                madera = 25;
                carbon = 0;
                hierro = 20;
                descontento = 75;
                break;
            default:
                break;
            //juego
        }
        do {
            System.out.println("");
            System.out.println("");

            System.out.println("dia: " + dia);
            System.out.println("poblacion: " + poblacion + "   casas: " + casa + "     madera: " + madera + "      hierro: " + hierro + "      carbon: " + carbon);
            int sinTecho = poblacion - (10 * casa);
            if (sinTecho < 0) {
                sinTecho = 0;
            }
            System.out.println("sin techo: " + sinTecho + "     descontento: " + descontento);
            System.out.println("edificios de produccion: " + "aserradero ");
            //acciones
            System.out.println("1.construir     2.pasar dia     3.(futura accion)");
            resp = sc.nextInt();
            
            switch (resp) {
                case 1:
                    System.out.println("1. casa 2.edificio de produccion 3.retroceder");
                    resp = sc.nextInt();
                    switch (resp) {
                        case 1:
                            if (madera >= 25) {
                                madera = madera - 25;
                                casa++;

                            } else {
                                System.out.println("recursos insuficientes");
                            }
                            
                            break;

                        case 2:
                            System.out.println("1.madera 2.hierro 3.carbon 4.retroceder");
                            resp = sc.nextInt();
                            switch (resp) {
                                case 1:
                                    if (madera >=10 && hierro >=20) {
                                        aserradero++;
                                        madera = madera -10;
                                        hierro = hierro - 20;
                                    }else{
                                        System.out.println("recursos insuficientes");
                                    }
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                            }
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("pasar dia? Y/N");
                    sc.nextLine();
                    String pass = sc.nextLine();
                    if (pass.equalsIgnoreCase("y")) {
                        dia++;
                        madera = madera + (aserradero * 10);
                        
                        if (sinTecho > 0){
                        descontento = descontento +((sinTecho/10) *5);
                        }else{
                            descontento = descontento -5;
                        }
                        
                        
                        
                        
                        if(descontento < -1){
                            descontento = 0;
                        }
                    }
                    break;
                case 3:
                    System.out.println("en desarrollo vuelve mas tarde");
                    break;
                default:
                    break;
            }
        } while (descontento < 100);
    }
}
