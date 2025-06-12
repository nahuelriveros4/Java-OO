/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class ViajeroFrecuente {
    private Integer numero;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer millas;

    public ViajeroFrecuente() {
    }

    public ViajeroFrecuente(Integer numero, String dni, String nombre, String apellido, Integer millas) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.millas = millas;
    }

    public Integer getMillas() {
        return millas;
    }

    public Integer acumularMillas(Integer xmillas) {
        this.millas += xmillas;
        return millas;
    }
    
    public Integer canjearMillas(Integer xmillas){
        if  (this.millas >= xmillas){
                this.millas -= xmillas;
            }else System.out.println("Error, las millas son insuficientes");
            return this.millas;    
    }

    public Integer getNumero() {
        return numero;
    }
    
    public String getDNI(){
        return dni;
    }
    @Override
    public String toString() {
        return "Numero: " + numero +
           ", DNI: " + dni +
           ", Nombre: " + nombre +
           ", Apellido: " + apellido +
           ", Millas: " + millas;
    }
}
