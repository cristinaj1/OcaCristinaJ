/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cris.juegooca;

/**
 *
 * @author Cris
 */
public class Vista {
    public static void mostrarTablero(Tablero t){
        System.out.println(t.toString());
    }
    
    public static void informarTirada(Jugador j){
        System.out.println(j.getNombre() + " ha tirado un " + j.getTirada());
    }
    
    public static void informarProgreso(Jugador j){
        System.out.println(j.getNombre() + " se mueve a la casilla " + j.getCasillaActual());
    }
    
}
