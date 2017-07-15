/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer11_t7_3enrayaobjetos;

/**
 *
 * @author IsmA
 */
public class Tablero {

    private Casilla[][] arrayTablero;

    public Tablero() {
    }

    public Casilla[][] getArrayCasillas() {
        return arrayTablero;
    }

    public void setArrayCasillas(Casilla[][] arrayCasillas) {
        this.arrayTablero = arrayCasillas;
    }

    public void presentacion(Tablero tablero, Casilla arrayCasillas[][]) {

        //Presentación del tablero antes de empezar.
        boolean ocupado = false;
        String ficha = " ";

        System.out.println("           @@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("           @ ¡3EnRaya OBJETOS! @@");
        System.out.println("           @@@@@@@@@@@@@@@@@@@@@@\n");

        for (int i = 0; i < arrayCasillas.length; i++) {
            for (int j = 0; j < arrayCasillas.length; j++) {

                arrayCasillas[i][j] = new Casilla(ficha, ocupado);

            }
        }

        tablero.setArrayCasillas(arrayCasillas);// Se manda el array de las casillas iniales siendo esta la variable del objeto tablero 
        tablero.mostrarTrablero();

        System.out.println("¡Jugador comienza turno y juega la ficha 0!");

    }

    public void mostrarTrablero() {

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@aaa");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@@@aa");

        for (int i = 0; i < arrayTablero.length; i++) {

            System.out.println("");

            for (int j = 0; j < arrayTablero.length; j++) {

                if (j == 2) { //si j vale 2 imprime el print del else (estética).
                    System.out.print("~~~~~~   " + arrayTablero[i][j].getFicha() + "   ~~~@@@a");
                } else {
                    System.out.print("~~~~~~   " + arrayTablero[i][j].getFicha() + "   ");
                }
            }

        }
        System.out.println("");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@@a");

    }

    public void rellenarTablero(Tablero tablero, Casilla[][] arrayCasillas) { //El tablero se rellenará con los métodos movimiento Jugado o Máquina.

        int turno = 0;
        //mientras que no haya ganador o el turno no llege 9, rellena el tablero con los métodos de movimientoJu/Ma.
        do {

            tablero.movimientoJugador(tablero, arrayCasillas);
            turno++;
            //mientras que no haya ganador o el turno no llege 9, rellena el tablero con el método movimiento Máquina.
            if ((saberGanador(tablero) == false) && (turno != 9)) {
                tablero.movimientoMaquina(tablero, arrayCasillas);
                turno++;
            }

        } while (saberGanador(tablero) == false && turno != 9);
        //Si ha llegado al turno 9 y no hay ganador será empate.
        if (turno == 9 && saberGanador(tablero) == false) {
            System.out.println("~~~~~~~~~~~~~~~ ¡¡Empate!! ~~~~~~~~~~~~~");
            System.out.println("   ~~~~~~~~~~ @@@@@@@@@@@@@@@@ ~~~~~~~~~~");
        }
    }

    public void movimientoJugador(Tablero tablero, Casilla[][] arrayCasillas) {

        String fichaJugador = "O";
        int fila, columna;
        boolean validacion;

        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@aaa");
        System.out.println("   ~~~~~~~~~~ Mueve el jugador ~~~~~~~~~~");

        do {
            // Pedimos fila y columna con los métodos de Test.
            fila = Test.pedirFila();
            columna = Test.pedirColumna();
            // Comprobamos si la posicion el array esta ocupada obteniendolo de la clase Casilla.
            if (arrayCasillas[fila][columna].getOcupada() == true) {
                System.out.println("Esa posicón está ocupada.");
                validacion = false;//Nos impedirá salir del bucle.
            } else {//Si no esta ocupada creamos una Clase ficha en esa posición.
                validacion = true;// Ocupamos la posición del array con true, dandole el valor de casilla ocupada.
                arrayCasillas[fila][columna] = new Casilla(fichaJugador, validacion);

            }
        } while (validacion == false);

        System.out.println("El jugador puso su ficha en [" + (fila + 1) + "][" + (columna + 1) + "] \n");// + 1 para que muestre la posión por encima
        tablero.mostrarTrablero();
        // Si al colocar la ficha, el métedo saberGanador devolve true entrará al if y finalizará el programa.
        if (saberGanador(tablero) == true) {
            System.out.println("~~~~~~~~~~~~~~~ ¡¡Ganaste!! ~~~~~~~~~~~~~");
            System.out.println("   ~~~~~~~~~~ @@@@@@@@@@@@@@@@ ~~~~~~~~~~");
        }

    }

    public void movimientoMaquina(Tablero tablero, Casilla[][] arrayCasillas) {

        String fichaMaquina = "X";
        int fila, columna;
        boolean ocupada;

        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@aaa");
        System.out.println("   ~~~~~~~~~~ Mueve la máquina ~~~~~~~~~~");

        do {

            fila = ((int) Math.floor(Math.random() * 3));
            columna = ((int) Math.floor(Math.random() * 3));

            if (arrayCasillas[fila][columna].getOcupada() == true) {
                ocupada = false;
            } else {
                ocupada = true;
                arrayCasillas[fila][columna] = new Casilla(fichaMaquina, ocupada);
            }

        } while (ocupada == false);

        System.out.println("     La máquina puso su ficha en [" + (fila + 1) + "][" + (columna + 1) + "] \n");
        tablero.mostrarTrablero();

        if (saberGanador(tablero) == true) {
            System.out.println("~~~~~~~~~~ ¡¡No has podido ganar!! ~~~~~~~~~");
        }

    }

    public boolean saberGanador(Tablero tablero) {
        //Cada vez que se llame a este metodo comprobará si las posiciones indicadas coinciden
        // si es así pondrá la variable ganador a true y la devolverá en caso contrario devolverá el valor inicializado.

        boolean ganador = false;

        if ((arrayTablero[0][0].getFicha() == arrayTablero[0][1].getFicha()) && (arrayTablero[0][1].getFicha() == arrayTablero[0][2].getFicha())) {
            if (arrayTablero[0][0].getFicha() != " ") {// Si las partes comprobadas contienen el espacio de vacío, se ignora la comprobación.
                ganador = true;
            }

        }
        if ((arrayTablero[1][0].getFicha() == arrayTablero[1][1].getFicha()) && (arrayTablero[1][1].getFicha() == arrayTablero[1][2].getFicha())) {
            if (arrayTablero[1][0].getFicha() != " ") {
                ganador = true;
            }
        }
        if ((arrayTablero[2][0].getFicha() == arrayTablero[2][1].getFicha()) && (arrayTablero[2][1].getFicha() == arrayTablero[2][2].getFicha())) {
            if (arrayTablero[2][0].getFicha() != " ") {
                ganador = true;
            }
        }
        if ((arrayTablero[0][0].getFicha() == arrayTablero[1][0].getFicha()) && (arrayTablero[1][0].getFicha() == arrayTablero[2][0].getFicha())) {
            if (arrayTablero[0][0].getFicha() != " ") {
                ganador = true;
            }
        }
        if ((arrayTablero[0][1].getFicha() == arrayTablero[1][1].getFicha()) && (arrayTablero[1][1].getFicha() == arrayTablero[2][1].getFicha())) {
            if (arrayTablero[0][1].getFicha() != " ") {
                ganador = true;
            }
        }
        if ((arrayTablero[0][2].getFicha() == arrayTablero[1][2].getFicha()) && (arrayTablero[1][2].getFicha() == arrayTablero[2][2].getFicha())) {
            if (arrayTablero[0][2].getFicha() != " ") {
                ganador = true;
            }
        }
        if ((arrayTablero[0][0].getFicha() == arrayTablero[1][1].getFicha()) && (arrayTablero[1][1].getFicha() == arrayTablero[2][2].getFicha())) {
            if (arrayTablero[1][1].getFicha() != " ") {
                ganador = true;
            }
        }
        if ((arrayTablero[2][0].getFicha() == arrayTablero[1][1].getFicha()) && (arrayTablero[1][1].getFicha() == arrayTablero[0][2].getFicha())) {
            if (arrayTablero[1][1].getFicha() != " ") {
                ganador = true;
            }
        }

        return ganador;
    }

}
