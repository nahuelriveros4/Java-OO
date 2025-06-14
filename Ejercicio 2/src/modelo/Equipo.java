/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.*;

public class Equipo implements IDeporte{
    private String nombre;
    private List<Deportista> integrantes;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.integrantes = new ArrayList<>();
    }
    
    @Override
    public boolean conformar(List<Deportista> datos) {
        if (datos.size() >= CANTIDAD_MINIMA) {
            this.integrantes = datos;
            numeroDeportista();
            return true;
        }
        return false;
    }
    
    @Override
    public void numeroDeportista() {
        for (int i = 0; i < integrantes.size(); i++) {
            integrantes.get(i).setNumeroJugador(i + 1);
        }
    }
    @Override
    public void mostrar() {
        System.out.println("Equipo: " + nombre);
        for (Deportista d : integrantes) {
            System.out.println(" - " + d);
        }
    }
}
