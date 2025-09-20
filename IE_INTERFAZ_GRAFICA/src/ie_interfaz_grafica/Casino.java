package ie_interfaz_grafica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
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
    
    /* por x cantidad de partidas siempre se juegan 3 rondas
       ahora devuelve una lista tipo string del detalle de cada ganador
       ademas de mostrarlo por consola, para este metodo ser tratado en la clase
       main, para guardar la partida completa
    */
    public List<String> jugar(int cantPartidas) {
        List<String> detalles = new ArrayList<>();

        for (int i = 1; i <= cantPartidas; i++) {
            System.out.println("\n=== Partida " + i + " ===");

            // Siempre 3 rondas fijas
            JuegoDados juego = new JuegoDados(jugadores);
            for (int r = 1; r <= 3; r++) {
                System.out.println("\n---- Ronda " + r);
                juego.jugarRonda();
            }

            // Mostrar estado de los jugadores después de la partida
            System.out.println("\nEstado después de la partida " + i + ":");
            for (Jugador j : jugadores) {
                System.out.println(j.getNombreConTipo() + " - Dinero: $" + j.getDinero());
            }

            // Determinar ganador de la partida
            Jugador ganador = jugadores.get(0);
            for (Jugador j : jugadores) {
                if (j.getDinero() > ganador.getDinero()) {
                    ganador = j;
                }
            }

            // Construir el detalle con StringBuilder
            StringBuilder detalle = new StringBuilder();
            detalle.append("PARTIDA #").append(i).append(" - Jugadores: ");
            for (int j = 0; j < jugadores.size(); j++) {
                detalle.append(jugadores.get(j).getNombre());
                if (j < jugadores.size() - 1) {
                    detalle.append(", ");
                }
            }
            //el ganador se basa en quien tiene mas plata al final de la partida
            detalle.append(" | Ganador: ").append(ganador.getNombreConTipo());
            detalle.append(" | Rondas: 3");

            // Guardamos el detalle en la lista
            detalles.add(detalle.toString());

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
        Jugador ganadorFinal = jugadores.get(0);
        for (Jugador j : jugadores) {
            if (j.getDinero() > ganadorFinal.getDinero()) {
                ganadorFinal = j;
            }
        }
        System.out.println("\n¡El ganador final es " + ganadorFinal.getNombreConTipo() + " con $" + ganadorFinal.getDinero() + "!");

        return detalles; // devolvemos los detalles para usarlos en main
    }
    
}
