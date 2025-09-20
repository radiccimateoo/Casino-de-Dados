package ie_interfaz_grafica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author usuario
 */
public class JuegoDados {
    
    private ArrayList<Jugador> jugadores;
    private Dado dado;

    public JuegoDados(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.dado = new Dado();
    }

    public void jugarRonda() {
        int pozo = 0;
        HashMap<Jugador, Integer> resultados = new HashMap<>();

        System.out.println("\nApuestas y lanzamientos:");
        for (Jugador jugador : jugadores) {
            int apuesta = jugador.calcularApuesta();

            // Ajustar si no tiene suficiente dinero
            if (apuesta > jugador.getDinero()) {
                apuesta = jugador.getDinero();
            }

            jugador.perder(apuesta);
            pozo += apuesta;

            // Lanzamiento inicial (dos dados)
            int tiro1 = dado.tirar();
            int tiro2 = dado.tirar();
            int suma = tiro1 + tiro2;

            System.out.println(jugador.getNombreConTipo() + " apostó $" + apuesta + " y sacó " + tiro1 + " + " + tiro2 + " = " + suma);

            // Si es VIP, puede usar re-roll
            if (jugador instanceof JugadorVIP) {
                JugadorVIP vip = (JugadorVIP) jugador;
                if (vip.puedeRepetir()) {
                    // Estrategia simple: repetir si la suma es menor a 8
                    if (suma < 8) {
                        System.out.println("→ " + vip.getNombreConTipo() + " decide usar su re-roll...");
                        tiro1 = dado.tirar();
                        tiro2 = dado.tirar();
                        suma = tiro1 + tiro2;
                        System.out.println("Nuevo tiro: " + tiro1 + " + " + tiro2 + " = " + suma);
                        vip.usarRepeticion();
                    }
                }
            }

            resultados.put(jugador, suma);
        }

        // Determinar el puntaje más alto
        int maxPuntaje = 0;
        for (int puntos : resultados.values()) {
            if (puntos > maxPuntaje) {
                maxPuntaje = puntos;
            }
        }

        // Identificar ganadores
        ArrayList<Jugador> ganadores = new ArrayList<>();
        for (Jugador jugador : resultados.keySet()) {
            if (resultados.get(jugador) == maxPuntaje) {
                ganadores.add(jugador);
            }
        }

        // Repartir el pozo
        int premioPorJugador = pozo / ganadores.size();
        System.out.println("\nGanador(es):");
        for (Jugador ganador : ganadores) {
            ganador.ganar(premioPorJugador);
            ganador.sumarVictoria();
            System.out.println("-> " + ganador.getNombreConTipo() + " gana $" + premioPorJugador);
        }

        // Resetear re-roll para VIPs (para la próxima ronda)
        for (Jugador jugador : jugadores) {
            if (jugador instanceof JugadorVIP) {
                ((JugadorVIP) jugador).resetearRepeticion();
            }
        }
    }
    
}
