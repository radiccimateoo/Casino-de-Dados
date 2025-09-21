package ie_interfaz_grafica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random; 
import java.util.stream.Collectors;
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

    public List<Jugador> jugarRonda() {
        int pozo = 0;
        HashMap<Jugador, Integer> resultados = new HashMap<>();
        
        

        System.out.println("\nApuestas y lanzamientos:");
        for (Jugador jugador : jugadores) {
            int apuesta = jugador.calcularApuesta();
            if (apuesta > jugador.getDinero()) apuesta = jugador.getDinero();
            jugador.perder(apuesta);
            pozo += apuesta;

           int tiro1, tiro2, suma;

           // consigna 3: Se incorpora el tiro de dados cargados del jugadorCasino
            if (jugador instanceof JugadorCasino casino) {
                //  JugadorCasino usa sus dados cargados
                suma = casino.lanzarDadosCargados();               

            } 
            // Lógica para JugadorVIP (la segunda excepción)
        else if (jugador instanceof JugadorVIP vip) {
            tiro1 = dado.tirar();
            tiro2 = dado.tirar();
            suma = tiro1 + tiro2;
            
            System.out.println(jugador.getNombreConTipo() + " apostó $" + apuesta +
                               " y sacó " + tiro1 + " + " + tiro2 + " = " + suma);
            
            if (vip.puedeRepetir() && suma < 8) {
                System.out.println("→ " + vip.getNombreConTipo() + " decide usar su re-roll...");
                tiro1 = dado.tirar();
                tiro2 = dado.tirar();
                suma = tiro1 + tiro2;
                System.out.println("Nuevo tiro: " + tiro1 + " + " + tiro2 + " = " + suma);
                vip.usarRepeticion();
            }
        }
        // Lógica para todos los demás jugadores genéricos (Novato, Experto)
        else {
            tiro1 = dado.tirar();
            tiro2 = dado.tirar();
            suma = tiro1 + tiro2;
            
            System.out.println(jugador.getNombreConTipo() + " apostó $" + apuesta +
                               " y sacó " + tiro1 + " + " + tiro2 + " = " + suma);
        }

        resultados.put(jugador, suma);
    }

        // Determinar puntaje más alto
        int maxPuntaje = resultados.values().stream().max(Integer::compare).orElse(0);
        ArrayList<Jugador> ganadores = new ArrayList<>();
        for (Jugador j : resultados.keySet()) {
            if (resultados.get(j) == maxPuntaje) ganadores.add(j);
        }

        // Repartir pozo
        int premioPorJugador = pozo / ganadores.size();
        System.out.println("\nGanador(es) de la ronda:");
        for (Jugador ganador : ganadores) {
            ganador.ganar(premioPorJugador);
            System.out.println("-> " + ganador.getNombreConTipo() + " gana $" + premioPorJugador);
        }
        
        // Mostrar estado de dinero de cada jugador al final de la ronda
        System.out.println("\nEstado de dinero de los jugadores tras la ronda:");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombreConTipo() + ": $" + j.getDinero());
        }

        // Resetear re-roll VIP
        for (Jugador j : jugadores) if (j instanceof JugadorVIP) ((JugadorVIP) j).resetearRepeticion();

        return ganadores; // Devuelve todos los ganadores de la ronda
    }


    
}
