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
public class Casilla {

    private String ficha;
    private boolean ocupada;

    public Casilla() {
    }

    public Casilla(String ficha, boolean ocupada) {
        this.ficha = ficha;
        this.ocupada = ocupada;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
        public boolean getOcupada() {
        return this.ocupada ;
    }

}
