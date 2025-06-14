/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;
import modelo.*;
import java.util.ArrayList;
import java.util.List;

public class interfaces {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato();
        List< IDeporte> deportes = new ArrayList<>();

       // Leer deportistas desde archivos CSV
        List<Deportista> futbolistas = campeonato.leerArchivo("inscriptosFutbol.csv");
        List<Deportista> pinponistas = campeonato.leerArchivo("inscriptosPinPon.csv");

        // Crear equipos de 5 personas para Futsal
        List<IDeporte> equipos = campeonato.creaEquipos(futbolistas, 5);
        deportes.addAll(equipos);

        // Crear parejas de 2 personas para Pin Pon
        List<IDeporte> parejas = campeonato.creaParejas(pinponistas);
        deportes.addAll(parejas);

        // Mostrar todo usando polimorfismo
        mover(deportes);
    }

    private static void mover(List<IDeporte> lista) {
        for (IDeporte d : lista) {
            d.mostrar();  // método definido en la interfaz
        }
    }
        
}


