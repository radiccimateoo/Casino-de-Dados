package ie_interfaz_grafica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.HashMap;
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

            // Inicializamos contador de rondas ganadas por jugador para esta partida
            HashMap<Jugador, Integer> rondasGanadas = new HashMap<>();
            for (Jugador j : jugadores) {
                rondasGanadas.put(j, 0);
            }

            // 3 rondas fijas
            JuegoDados juego = new JuegoDados(jugadores);
            for (int r = 1; r <= 3; r++) {
                System.out.println("\n---- Ronda " + r);
                List<Jugador> ganadoresRonda = juego.jugarRonda();
                for (Jugador g : ganadoresRonda) {
                    rondasGanadas.put(g, rondasGanadas.get(g) + 1);
                }
            }

            // Determinar ganador de la partida según rondas ganadas
            Jugador ganadorPartida = jugadores.get(0);
            int maxRondas = rondasGanadas.get(ganadorPartida);
            for (Jugador j : jugadores) {
                if (rondasGanadas.get(j) > maxRondas) {
                    ganadorPartida = j;
                    maxRondas = rondasGanadas.get(j);
                }
            }

            // Construir detalle
            StringBuilder detalle = new StringBuilder();
            detalle.append("PARTIDA #").append(i).append(" - Jugadores: ");
            for (int j = 0; j < jugadores.size(); j++) {
                detalle.append(jugadores.get(j).getNombre());
                if (j < jugadores.size() - 1) detalle.append(", ");
            }
            detalle.append(" | Ganador: ").append(ganadorPartida.getNombreConTipo());
            detalle.append(" | Rondas ganadas: ").append(maxRondas).append(" de 3");

            detalles.add(detalle.toString());
        }

        return detalles;
    }

    
}
