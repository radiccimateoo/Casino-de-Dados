/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie_interfaz_grafica;
import java.util.Random; 
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
        return "Casino";
    }

    // Implementación del método abstracto para calcular la apuesta
        @Override   
        public int calcularApuesta() {
        return 0; // El casino no apuesta dinero
    }
        
        //Habilidad especial: dados cargados (40% probabilidad de sacar 6 en cada dado)
    public int tirarDadoCargado() {
        if (random.nextDouble() < 0.4) {  
            return 6; // 40% de probabilidad
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
}

