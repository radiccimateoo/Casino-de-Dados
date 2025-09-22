/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie_interfaz_grafica;
import java.util.List;
import java.util.Random; 
import java.util.stream.Collectors;
/**
 * Atributos Clase Jugador
 * private String nombre;
    private int dinero;
    private int partidasGanadas;

   
 * @author Ceciia
 */
// CONSIGNA 3: JUGADOR CASINO
public class JugadorCasino extends Jugador{
      
       private final Random random;
    
     //Constructor:
        public JugadorCasino(String nombre, int dineroInicial) {
        super("Casino", dineroInicial); // Nombre fijo "Casino"
        this.random= new Random();
      
    }
   
// Implementación del método abstracto para obtener el tipo de jugador
    @Override
    public String obtenerTipoJugador() {
        return "El Casino";
    }

    // Implementación del método abstracto para calcular la apuesta
        @Override   
        public int calcularApuesta() {
        return 0; // El casino no apuesta dinero
    }
        
        //Habilidad especial: dados cargados (40% probabilidad de sacar 6 en cada dado)
    public int tirarDadoCargado() {
        if (random.nextDouble() < 0.4) {  
            return 6;
        } else {
            return random.nextInt(6) + 1; // valor normal 1–6
        }
    }

    // Método para lanzar dos dados cargados
    public int lanzarDadosCargados() {
        int dado1 = tirarDadoCargado();
        int dado2 = tirarDadoCargado();
        System.out.println("Casino tiró dados: " + dado1 + " + " + dado2 + " = " + (dado1 + dado2));
        return (dado1 + dado2);
    }
    
     // Nuevo método para seleccionar un jugador a confundir
    public Jugador seleccionarJugadorAConfundir(List<Jugador> jugadores) {
        if (new Random().nextDouble() < 0.3) { // 30% probabilidad de activar
            // Filtra a los jugadores, excluyendo al propio Casino
            List<Jugador> jugadoresSinCasino = jugadores.stream()
                .filter(j -> !(j instanceof JugadorCasino))
                .collect(Collectors.toList());

            if (!jugadoresSinCasino.isEmpty()) {
                return jugadoresSinCasino.get(new Random().nextInt(jugadoresSinCasino.size()));
            }
        }
        return null; // Devuelve null si no se activa la habilidad
    }
}

