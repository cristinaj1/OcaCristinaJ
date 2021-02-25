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
public class ControladorJugadores {
    private ArrayList<Jugador> listaJugadores;

    // A partir de un array de nombres crea la lista de jugadores
    public ControladorJugadores(String[] listaNombres) {
        listaJugadores = new ArrayList<>();
        // Para cada nombre de la lista de nombres crea un jugador con ese
        // nombre y se a añade a a la listaJugadores
        for (String nombre : listaNombres) {
            listaJugadores.add(new Jugador(nombre));
        }

    }

    @Override
    public String toString() {
        String tmp = "";
        for (Jugador j : listaJugadores) {
            tmp += j.toString() + "\n";
        }
        return tmp;
    }

    // Devuelve al jugador que le toca
    // Se encarga de ir gestionando al jugador que le toca
    public Jugador getJugadorSiguiente() {
        Jugador aux = listaJugadores.remove(0);
        listaJugadores.add(aux);
        return aux;
    }

    public ArrayList<Jugador> getTodosJugadores(){
        return listaJugadores;
    }
    
}
