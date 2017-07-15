package ejer11_t7_3enrayaobjetos;

import java.util.Scanner;

/**
 *
 * @author IsmA
 */
public class Test {    


    public static int pedirFila(){
               
        Scanner entrada = new Scanner(System.in);        
        System.out.print("Fila : ");
        return entrada.nextInt() - 1;
    }
    
      public static int pedirColumna(){
        
        Scanner entrada = new Scanner(System.in);
        System.out.print("Columna : ");
        return entrada.nextInt() - 1;
    }
  

    public static void main(String[] args) {     

        Casilla[][] arrayCasillas = new Casilla[3][3];
        Tablero tablero = new Tablero();
        tablero.presentacion(tablero, arrayCasillas);
        
        tablero.rellenarTablero(tablero, arrayCasillas);
        
    }

}
