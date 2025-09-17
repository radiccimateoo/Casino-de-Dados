package ie_interfaz_grafica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class Casino {
    
    private ArrayList<Jugador> jugadores;

    public Casino() {
        jugadores = new ArrayList<>();
    }

    public Jugador crearJugador(String nombre, int tipo) {
        int dineroInicial = 500; // Todos empiezan con $500
        switch (tipo) {
            case 1 -> {
                return new JugadorNovato(nombre, dineroInicial);
            }
            case 2 -> {
                return new JugadorExperto(nombre, dineroInicial);
            }
            case 3 -> {
                return new JugadorVIP(nombre, dineroInicial);
            }
            default -> {
                System.out.println("Tipo inválido, se asignará como Novato.");
                return new JugadorNovato(nombre, dineroInicial);
            }
        }
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void jugar() {
        System.out.println("\nComienza el juego!");
        int rondas = 3;

        for (int i = 1; i <= rondas; i++) {
            System.out.println("\n=== Ronda " + i + " ===");
            JuegoDados juego = new JuegoDados(jugadores);
            juego.jugarRonda();

            // Mostrar estado de los jugadores
            System.out.println("\nEstado después de la ronda " + i + ":");
            for (Jugador j : jugadores) {
                System.out.println(j.getNombreConTipo() + " - Dinero: $" + j.getDinero());
            }

            // Verificar si alguien se quedó sin dinero
            boolean alguienSinDinero = false;
            for (Jugador j : jugadores) {
                if (j.getDinero() <= 0) {
                    alguienSinDinero = true;
                    break;
                }
            }
            if (alguienSinDinero) {
                System.out.println("\nUn jugador se quedó sin dinero. ¡Fin del juego!");
                break;
            }
        }

        // Anunciar ganador final
        Jugador ganador = jugadores.get(0);
        for (Jugador j : jugadores) {
            if (j.getDinero() > ganador.getDinero()) {
                ganador = j;
            }
        }
        System.out.println("\n¡El ganador final es " + ganador.getNombreConTipo() + " con $" + ganador.getDinero() + "!");
    }
    
}
