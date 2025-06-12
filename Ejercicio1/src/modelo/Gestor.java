/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.List;
import modelo.ViajeroFrecuente;
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
    
    public void mostrarViajero(){
        System.out.print("Ingrese Numero del Viajero: ");
        int xNumero = scanner.nextInt();
        scanner.nextLine();
        
        int i = 0;
        boolean encontrado = false;
        while (i < gestorViajeros.size()) {
            ViajeroFrecuente viajero = gestorViajeros.get(i);
            if(viajero.getNumero().equals(xNumero)){
            encontrado = true;
            System.out.println(viajero.toString());
            }
            i++;
        }
        if(!encontrado){
        System.out.println("Viajero no encontrado con el numero ingresado");
        }
    }

    public int consultarMillas() {
        System.out.print("Ingrese DNI del viajero: ");
        String xDNI = scanner.nextLine();
        int i = 0;
        while (i < gestorViajeros.size()) {
            ViajeroFrecuente viajero = gestorViajeros.get(i);
            if (viajero.getDNI().equals(xDNI)) {
                return viajero.getMillas();
            }
            i++;
        }
        System.out.println("Viajero no encontrado con el DNI ingresado");
        return - 1;
    }

    public void acumMillas(){
        System.out.print("Ingrese DNI del viajero: ");
        String xDNI = scanner.nextLine();
        int i = 0;
        boolean encontrado = false;
        while(i < gestorViajeros.size()){
            ViajeroFrecuente viajero = gestorViajeros.get(i);
            if (viajero.getDNI().equals(xDNI)){
                encontrado = true;
                System.out.print("Ingrese cantidad de millas: ");
                int xmillas = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Millas actuales: " + viajero.acumularMillas(xmillas));
            }
            i++;
        }
        if(!encontrado){
        System.out.println("Viajero no encontrado con el DNI ingresado");
        }
    }
    public void canjeaMillas(){
        System.out.print("Ingrese DNI del viajero: ");
        String xDNI = scanner.nextLine();
        int i = 0;
        boolean encontrado = false;
        while(i < gestorViajeros.size()){
            ViajeroFrecuente viajero = gestorViajeros.get(i);
            if (viajero.getDNI().equals(xDNI)){
                encontrado = true;
                System.out.print("Ingrese cantidad de millas: ");
                int xmillas = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Millas actuales: " + viajero.canjearMillas(xmillas));
            }
            i++;
        }
        if(!encontrado){
        System.out.println("Viajero no encontrado con el DNI ingresado");
        }
    }

    public void mostrarViajeroMayor(){
        if (gestorViajeros.isEmpty()){
            System.out.println(("No hay viajeros "));
            return;
        }
        List<ViajeroFrecuente> mejoresViajeros = new ArrayList<>();
        int maxMillas = -1;

        //Encontrar la mayor cantidad de millas
        for (ViajeroFrecuente viajero : gestorViajeros){
            if (viajero.getMillas() > maxMillas) {
                maxMillas = viajero.getMillas();
                mejoresViajeros.clear(); // nuevo max, limpia lista
                mejoresViajeros.add(viajero);
            } else if (viajero.getMillas() == maxMillas){
                mejoresViajeros.add(viajero); // agregamos otro viajero con la misma cantidad
            }
        }
        //Mostrar resultado
        System.out.println("Viajero(s) con mas millas (" + maxMillas +"):");
        for (ViajeroFrecuente v : mejoresViajeros){
            System.out.println(v.toString());
        }
    }
}   