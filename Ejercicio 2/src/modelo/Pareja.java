/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.*;

public class Pareja implements IDeporte{
    private List<Deportista> integrantes;

    public Pareja() {
    }

    @Override
    public boolean conformar(List<Deportista> integrantes) {
        if (integrantes.size() >= CANTIDAD_MINIMA) {
            this.integrantes = integrantes;
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
        System.out.println("Pareja:");
        for (Deportista d : integrantes) {
            System.out.println(" - " + d);
        }
    }
    
}


