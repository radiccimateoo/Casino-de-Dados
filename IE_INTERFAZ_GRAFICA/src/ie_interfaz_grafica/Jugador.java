/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie_interfaz_grafica;

/**
 *
 * @author Alumno
 */
public abstract class Jugador {
    private String nombre;
    private int dinero;
    private int partidasGanadas;

    // Constructor
    public Jugador(String nombre, int dineroInicial) {
        this.nombre = nombre;
        this.dinero = Math.max(0, dineroInicial); 
        this.partidasGanadas = 0;
    }

    public String getNombre() { return nombre; }

    public int getDinero() { return dinero; }

    public int getPartidasGanadas() { return partidasGanadas; }

    public void setDinero(int dinero) {
        if (dinero >= 0) {
            this.dinero = dinero;
        }
    }

    public void sumarVictoria() { partidasGanadas++; }

    public void ganar(int cantidad) {
        if (cantidad > 0) {
            dinero += cantidad;
        }
    }

    public void perder(int cantidad) {
        if (cantidad > 0) {
            dinero -= cantidad;
            if (dinero < 0) {
                dinero = 0; // No puede quedar en negativo
            }
        }
    }

    // Método para mostrar nombre + tipo
    public String getNombreConTipo() {
        return nombre + " (" + obtenerTipoJugador() + ")";
    }

    //Métodos abstractos que deben implementar las subclases
    public abstract int calcularApuesta();

    public abstract String obtenerTipoJugador();
}
