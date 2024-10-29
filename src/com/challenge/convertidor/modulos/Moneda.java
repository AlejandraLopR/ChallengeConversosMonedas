package com.challenge.convertidor.modulos;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Moneda {
    private  String result;
    private Map<String,Double> valor;

    public Moneda(MonedaExchange monedaAPI){
        this.result = monedaAPI.result();
        this.valor = monedaAPI.conversion_rates();
    }

    public Moneda(String nombre, Map<String, Double> valor){
        this.result = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return result;
    }

    public void setNombre(String nombre) {
        this.result = nombre;
    }

    public Map<String, Double> getValor() {
        return valor;
    }
    public double consultaValor(String key ){
        return valor.get(key);
    }

    public void mostrar(){
        for (Map.Entry<String,Double> entry : valor.entrySet()){
            System.out.println("Moneda: "+ entry.getKey()+", Valor: "+entry.getValue() );
        }
    }

    public void setValor(Map<String, Double> valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Moneda{" + "nombre='" + result + '\'' + ", valor=" + valor +
                '}';
    }

}
