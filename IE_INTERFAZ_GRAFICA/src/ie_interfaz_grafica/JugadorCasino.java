/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie_interfaz_grafica;

/**
 * Atributos Clase Jugador
 * private String nombre;
    private int dinero;
    private int partidasGanadas;

    // Constructor
    public Jugador(String nombre, int dineroInicial) {
        this.nombre = nombre;
        this.dinero = Math.max(0, dineroInicial); 
        this.partidasGanadas = 0;
    }
 * @author Ceciia
 */
// CONSIGNA 3: JUGADOR CASINO
public class JugadorCasino extends Jugador{
     //Constructor:
        public JugadorCasino(String nombre, int dineroInicial) {
        super("Casino", dineroInicial); // Nombre fijo "Casino"
    }
        
}
