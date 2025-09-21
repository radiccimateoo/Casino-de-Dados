package ie_interfaz_grafica;
import java.util.*;
import java.io.*;

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
        
        /*
        aca implementamos primera mejora (consigna 1), se entiende que por cada partida hay x
        cantidad de rondas, para hacerlo mas rapido establecemos como valores
        fijos 8 partidas y 3 rondas por partida, para hacer un historial largo
        */
        
        /*
        System.out.print("\n Ingrese la cantidad de partidas que quiere jugar: ");
        int cantPartidas = scanner.nextInt();
        scanner.nextLine();
        */
        
        System.out.println("\n*************************************");
        System.out.println("\nComienza el juego!");
        int cantPartidas = 8;
        // Guardar la lista de detalles de partidas en la variable
        List<String> detalles = casino.jugar(cantPartidas);
        
        // Recorrer cada detalle y guardarlo en archivo historial_partidas.txt
        for (String detalle : detalles) {
            guardarPartida(detalle);
        }
        
        // CONSIGNA 4: 
        // Se elimina el metodo mostrarHistorial
        // Se pasa el objeto casino el cual tiene los datos para generar el reporte
        System.out.println("\n\nJuego terminado. Generando reporte final...");
        Reporte.generarReporteFinal(casino, cantPartidas);


        scanner.close();
    }
    
    // Método para guardar el detalle de cada partida en un archivo txt
    public static void guardarPartida(String detalle) {
        String nombreArchivo = "historial_partidas.txt";
        List<String> partidas = new ArrayList<>();

        // Leer el archivo existente
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) partidas.add(linea);
            } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }
        }

        partidas.add(detalle);

        // Mantener solo las últimas 5
        if (partidas.size() > 5) partidas = partidas.subList(partidas.size() - 5, partidas.size());

        // Reescribir archivo
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (String p : partidas) writer.write(p + "\n");
        } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }
    }
    
    // Método para mostrar los últimos 5 registros del historial
    public static void mostrarHistorial() {
        String nombreArchivo = "historial_partidas.txt";
        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            System.out.println("El archivo " + nombreArchivo + " no existe.");
            return;
        }

        List<String> partidas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                partidas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        if (partidas.isEmpty()) {
            System.out.println("No hay registros en el archivo.");
            return;
        }

        System.out.println("\n--- Últimas 5 partidas registradas ---");
        int total = partidas.size();
        int limite = Math.max(0, total - 5); // calculamos hasta dónde mostrar

        for (int i = total - 1; i >= limite; i--) {
            System.out.println(partidas.get(i));
        }
    }
    

}
