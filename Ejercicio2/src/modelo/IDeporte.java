/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.List;

public interface IDeporte {
    int CANTIDAD_MINIMA = 2;

    boolean conformar(List<Deportista> integrantes);
    void mostrar();
    void numeroDeportista();
}

