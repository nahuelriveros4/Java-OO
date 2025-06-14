/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Main {
    public static void main(String[] args){
        Gestor gestor = new Gestor();
        // Cargar viajeros manualmente o con un bucle
        gestor.cargarViajero();
        gestor.cargarViajero(); // etc.

        System.out.println("\nOrdenados por millas:");
        gestor.mostrarOrdenadosPorMillas();

        System.out.println("\nNombres con más de 200 millas:");
        gestor.mostrarNombresConMasDe200Millas();

        System.out.println("\nViajero con más millas:");
        gestor.mostrarViajeroConMasMillas();

    }
    
}

