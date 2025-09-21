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
        
        //consigna 3: HobilidadConfusión - elección del jugador confundido
        Jugador jugadorConfundido = null;

        // Obtener la instancia del JugadorCasino asumiendo que es el primer jugador
        JugadorCasino casino = (JugadorCasino) jugadores.get(0);

        // Ejecutar la habilidad de confundir del casino
        jugadorConfundido = casino.seleccionarJugadorAConfundir(jugadores);
        if (jugadorConfundido != null) {
            System.out.println("¡El Casino confunde a " + jugadorConfundido.getNombreConTipo() + "!");
        }

        //Fin elección
    
        System.out.println("\nApuestas y lanzamientos:");
        for (Jugador jugador : jugadores) {
            int apuesta = jugador.calcularApuesta();
            if (apuesta > jugador.getDinero()) apuesta = jugador.getDinero();
            jugador.perder(apuesta);
            pozo += apuesta;

           int tiro1, tiro2, suma;

           // consigna 3: Se incorpora el tiro de dados cargados del jugadorCasino
            // Lógica de tirada de dados
              if (jugador instanceof JugadorCasino) {
                  // El casino usa su método de dados cargados
                  tiro1 = casino.tirarDadoCargado();
                  tiro2 = casino.tirarDadoCargado();
              } else {
                  // Jugadores normales tiran dados comunes
                  tiro1 = dado.tirar();
                  tiro2 = dado.tirar();
              }

              // Aplica la penalización si el jugador actual es el confundido
              if (jugador.equals(jugadorConfundido)) {
                  tiro1 = Math.max(1, tiro1 - 1);
                  tiro2 = Math.max(1, tiro2 - 1);
                  System.out.println("El efecto de la confusión le reduce el puntaje a " + jugador.getNombreConTipo() + ". Nuevo tiro: " + tiro1 + " + " + tiro2 + ".");
              }

              suma = tiro1 + tiro2;
              System.out.println(jugador.getNombreConTipo() + " apostó $" + apuesta + " y sacó " + tiro1 + " + " + tiro2 + " = " + suma);

              // Lógica del VIP si corresponde
              if (jugador instanceof JugadorVIP vip) {
                   if (vip.puedeRepetir() && suma < 8) {
                      System.out.println("→ " + vip.getNombreConTipo() + " decide usar su re-roll...");
                      tiro1 = dado.tirar();
                      tiro2 = dado.tirar();
                      // OJO: El re-roll del VIP no se penaliza en esta estructura
                      suma = tiro1 + tiro2; 
                      System.out.println("Nuevo tiro: " + tiro1 + " + " + tiro2 + " = " + suma);
                      vip.usarRepeticion();
                  }
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
