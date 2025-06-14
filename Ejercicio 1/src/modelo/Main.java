/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Gestor gestor = new Gestor();
        int opcion;
        
        do{
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cargar nuevo viajero");
            System.out.println("2. Mostrar viajero");
            System.out.println("3. Consultar Millas");
            System.out.println("4. Acumular Millas");
            System.out.println("5. Canjear Millas");
            System.out.println("6. Mostrar viajero con mas Millas");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    gestor.cargarViajero();
                    break;
                case 2:
                    gestor.mostrarViajero();
                    break;
                case 3:
                    System.out.println("Cantidad de millas: "+ gestor.consultarMillas());
                    break;
                case 4:
                    gestor.acumMillas();
                    break;
                case 5:
                    gestor.canjeaMillas();
                    break;   
                case 6:
                    gestor.mostrarViajeroMayor();
                    break;    
                case 7:
                    System.out.println("Usted esta saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opcion != 7);
        scanner.close();
    }
}

