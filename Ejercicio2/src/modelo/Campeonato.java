/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Campeonato {
    public static final String SEPARADOR=",";

    public List<Deportista> leerArchivo(String nomArchivo) {
    List<Deportista> lista = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(nomArchivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) continue; // Salta líneas vacías

            String[] partes = linea.split(SEPARADOR);
            if (partes.length >= 2) {
                String nombre = partes[0].trim();
                String dni = partes[1].trim();

                if (nombre.isEmpty()) {
                        throw new ValidacionDeportistaException("Nombre vacío en la línea: " + linea);
                }
                if (dni.isEmpty()) {
                    throw new ValidacionDeportistaException.DniVacio("DNI vacío en la línea: " + linea);
                }

                lista.add(new Deportista(nombre, dni));
            } else {
                System.out.println("Línea con formato inválido: " + linea);
            }
        }
        if (lista.size() < 2) {
            throw new ValidacionDeportistaException.CantidadInsuficiente("Se necesitan al menos 2 deportistas.");
        }
    } catch (ValidacionDeportistaException e) {
            System.out.println("Error: " + e.getMessage());
    } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    }
    return lista;
}

    public List<IDeporte> creaEquipos(List<Deportista> datos, int cantJugadores) {
        List<IDeporte> equipos = new ArrayList<>();
        int contador = 1;
        for (int i = 0; i < datos.size(); i += cantJugadores) {
            int fin = Math.min(i + cantJugadores, datos.size());
            List<Deportista> sublista = datos.subList(i, fin);
            Equipo equipo = new Equipo("Equipo " + contador++);
            if (equipo.conformar(sublista)) {
                equipo.numeroDeportista();
                equipos.add(equipo);
            }
        }
        return equipos;
    }

    public List<IDeporte> creaParejas(List<Deportista> datos) {
        List<IDeporte> parejas = new ArrayList<>();
        for (int i = 0; i < datos.size(); i += 2) {
            if (i + 1 < datos.size()) {
                List<Deportista> parejaDatos = datos.subList(i, i + 2);
                Pareja pareja = new Pareja();
                if (pareja.conformar(parejaDatos)) {
                    pareja.numeroDeportista();
                    parejas.add(pareja);
                }
            }
        }
        return parejas;
    }
    public void numerar(List<Deportista> datos) {
        for (int i = 0; i < datos.size(); i++) {
            datos.get(i).setNumeroJugador(i + 1);
        }
    }

    public void mostrar(List<IDeporte> datos) {
        for (IDeporte d : datos) {
            d.mostrar();
            System.out.println("-----");
        }
    }
}
