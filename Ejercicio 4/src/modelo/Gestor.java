/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Gestor {
    private List<ViajeroFrecuente>gestorViajeros; /*Es una lista donde se van a guardar objetos de tipo Alumno.
Se usa List como tipo genérico (una interfaz), pero internamente se inicializa como un ArrayList (una implementación concreta de lista).*/
    Scanner scanner = new Scanner(System.in);
    
    public Gestor() {
        gestorViajeros= new ArrayList<>();/*Este es el constructor de la clase. Se ejecuta automáticamente cuando creás un objeto GestorAlumnos.
Inicializa la lista gestorAlumnos como una lista vacía.*/
    }
    
    public void cargarViajero(){
        System.out.print("Ingrese Numero del viajero: ");
        int numero = scanner.nextInt();  // Usamos nextInt() para leer un número
        scanner.nextLine(); // Consumimos el salto de línea pendiente

        System.out.print("Ingrese DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese cantidad de millas: ");
        int millas = scanner.nextInt();
        scanner.nextLine(); // Consumimos el salto de línea pendiente
        
        ViajeroFrecuente unViajero = new ViajeroFrecuente(numero,dni,nombre,apellido,millas);
        gestorViajeros.add(unViajero);
        System.out.println(" Viajero cargado con exito.");
    }

    // b. Mostrar los datos de los viajeros ordenados por la cantidad de millas
    public void mostrarOrdenadosPorMillas() {
        gestorViajeros.stream()
            .sorted(Comparator.comparingInt(ViajeroFrecuente::getMillas).reversed())
            .forEach(System.out::println);
    }
    // c. Mostrar los nombres de los viajeros que tienen más de 200 millas
    public void mostrarNombresConMasDe200Millas() {
        gestorViajeros.stream()
        .filter(v -> v.getMillas() > 200)
        .map(v -> v.getNombre() + " " + v.getApellido())
        .forEach(System.out::println);
    }

// d. Obtener el viajero que tiene más millas
    public void mostrarViajeroConMasMillas() {
        gestorViajeros.stream()
        .max(Comparator.comparingInt(ViajeroFrecuente::getMillas))
        .ifPresent(System.out::println);
    }
}   