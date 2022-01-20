/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca;

/**
 *
 * @author jjxe
 */
import java.io.*;
import java.util.Scanner;

class Ficha implements Serializable{
    int position, player;
    String name;
    boolean win;
}

class Casilla implements Serializable{
    int position;
    int type; //0-Salida 1- Normal 2-Oca 3-Puente 4-Dados 5-Stop 6-Muerte
    boolean win;
}

public class Oca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CONSTANTES
        final int MAXPLAYERS = 4;
        final int CASILLAS = 64;
        
        //ARAYS
        Ficha[] fichas = new Ficha[MAXPLAYERS];
        Casilla[] casillas = new Casilla[CASILLAS];
        
        //VARIABLES
        int option;
        int players;
        boolean gameEnd = false;
        Scanner entrada = new Scanner(System.in);
        
        
        //CARGADO DE TABLERO
        cargarTablero(casillas);
        
        do{
            option = menuInicio(entrada);
            
            switch(option){
                case 1:
                    players = jugadores(entrada, MAXPLAYERS);
                    nombresJugadores(entrada, fichas, players, MAXPLAYERS);
                    
                    while(!gameEnd){
                        
                    }
                    
                    break;
                
                case 2:
                    System.out.println("¡Hasta la próxima!");
                    break;
            }
        }while(option != 2);
    }
    
    //MENÚ DE INICIO
    public static int menuInicio(Scanner entrada){
        int option;
        
        System.out.println("JUEGO DE LA OCA");
        System.out.println("***************");
        System.out.println(" ");
        System.out.println("1.Jugar");
        System.out.println("2.Salir");
        
        option = entrada.nextInt();
        return option;
    }
    
    //NÚMERO DE JUGADORES
    public static int jugadores(Scanner entrada, int MAXPLAYERS){
        int players;
        
        do{
            System.out.println("¿Cuántos jugadores van a jugar? 1-"+MAXPLAYERS);
            players = entrada.nextInt();
        }while(players < 1 || players > MAXPLAYERS);
        
        return players;
    }
    
    //NOMBRE DE JUGADORES
    public static void nombresJugadores(Scanner entrada, Ficha[] fichas, int players, int MAXPLAYERS){
        for (int i = 0; i<MAXPLAYERS; i++){
            fichas[i] = new Ficha();
            fichas[i].position = 0;
            fichas[i].player = i+1;
            
            if(fichas[i].player < players){  
                System.out.println("¿Cómo se va a llamar el jugador "+fichas[i].player+"?");
                fichas[i].name = entrada.nextLine();
            }
            else{
                fichas[i].name = "IA "+(i+1);
            }
        
        }
    }
    
    //JUEGO HUMANOS
    public static void comienzoPartida(){
        
    }
    
    //CARGADO DE TABLERO
    public static void cargarTablero(Casilla[] casillas){
        for (int i = 0; i<casillas.length; i++){
            casillas[i] = new Casilla();
            casillas[i].position = i;

            //SALIDA
            if(i == 0){
                casillas[i].type = i;
            }
            
            //NORMALES
            else if(i != 5 && i != 6 && i != 9 && i != 12 && i != 13 && i != 14 && i != 18 && i != 23 && i != 26 && i != 27 && i != 31 && i != 32 && 
                    i != 36 && i != 41 && i != 42 && i != 45 && i != 50 && i != 52 && i != 53 && i != 54 && i != 58 && i != 59 && i != 63){
                casillas[i].type = 1;
            }
            
            //OCAS
            else if(i == 5 || i == 9 || i == 14 || i == 18 || i == 23 || i == 27 || i == 32 || i == 36 || i == 41 || i == 45 || i == 59 || i == 63){
                casillas[i].type = 2;
            }
            
            //PUENTES
            else if(i == 6 || i == 12){
                casillas[i].type = 3;
            }
            
            //DADOS
            else if(i == 26 || i == 53){
                casillas[i].type = 4;
            }
            
            //STOP
            else if(i == 13 || i == 42 ||i == 52){
                casillas[i].type = 5;
            }
            
            //MUERTE
            else if(i == 31 || i == 58){
                casillas[i].type = 6;
            }
        }
    }

}
