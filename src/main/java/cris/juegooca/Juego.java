/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cris.juegooca;

import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class Juego {

    private final Tablero tablero;
    private final ControladorJugadores cj;

    // Crea el juego a partir del tablero y la  lista de jugadores
    // Pone a los jugadores en la casilla de salida
    public Juego(Tablero tablero, ControladorJugadores controlador) {
        this.tablero = tablero;
        this.cj = controlador;
        // Coloca a los jugadores en la casilla de salida
        for (Jugador aux : cj.getTodosJugadores()) {
            this.tablero.getCasilla(1).ponerJugador(aux);
        }

    }

    private static boolean terminar(ArrayList<Jugador> prueba) {
        boolean sol = false;
        for (Jugador j : prueba) {
            if (j.ganaPartida()) {
                sol = true;
            }
        }
        return sol;

    }

    public static void main(String[] args) {

        // Se crea el juego
        String[] nombres = {"J1", "J2", "J3"};
        
        ControladorJugadores cj = new ControladorJugadores(nombres);
        
        Tablero tablero = new Tablero();
        
        Juego juego = new Juego(tablero, cj);
        
        ArrayList<Jugador> aux = cj.getTodosJugadores();

        do {
            // Imprime el estado del tablero inicialmente
            Vista.mostrarTablero(juego.getTablero());
            for (Jugador jugador : aux) {
            	do {
                tablero.getCasilla(jugador.getCasillaActual()).quitarJugador(jugador);
                
                jugador.tirarDado();
                
                jugador.mover(jugador.getTirada());
                
                Vista.informarTirada(jugador);
                
                Vista.informarProgreso(jugador);
                
                jugador.mover(tablero.getCasilla(jugador.getCasillaActual()).getTipo().getSiguienteMovimiento());
                
    //Haz un bucle para que se ejecute
                
                jugador.setTurnosSinJugar(tablero.getCasilla(jugador.getCasillaActual()).getTipo().getTurnosSinJugar());
                
                tablero.getCasilla(jugador.getCasillaActual()).ponerJugador(jugador);
                
            	}while(tablero.getCasilla(jugador.getCasillaActual()).getTipo().isTiradaExtra());
            }
        } while (!terminar(aux));

    }

    public Tablero getTablero() {
        return tablero;
    }

    public ControladorJugadores getCj() {
        return cj;
    }

}
