/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ie_interfaz_grafica;
import java.util.*;

/**
 *
 * @author usuario
 */
public class IE_INTERFAZ_GRAFICA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        Casino casino = new Casino();

        System.out.println(" ¡Bienvenidos al Casino de Dados! ");

        // Crear jugadores
        int n;
        while (true) {
            System.out.print("¿Cuántos jugadores participarán? (2-4): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                scanner.nextLine(); // limpiar el \n
                if (n >= 2 && n <= 4) break;
                System.out.println("Número inválido. Debe ser 2, 3 o 4.");
            } else {
                System.out.println("Entrada inválida. Ingrese un número.");
                scanner.nextLine(); // descartar lo que se haya escrito
            }
        }


        for (int i = 1; i <= n; i++) {
            System.out.print("Nombre del jugador " + i + ": ");
            String nombre = scanner.nextLine();

            System.out.print("Tipo (1=Novato, 2=Experto, 3=VIP): ");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            Jugador jugador = casino.crearJugador(nombre, tipo);
            casino.agregarJugador(jugador);
        }
        
        System.out.print("\n Ingrese la cantidad de partidas que quiere jugar: ");
        int cantPartidas = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("\n*************************************");
        System.out.println("\nComienza el juego!");
        casino.jugar(cantPartidas);

        scanner.close();
    }
    
}
