package com.challenge.convertidor.principal;

import com.challenge.convertidor.modulos.Moneda;
import com.challenge.convertidor.modulos.MonedaExchange;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        var valor ="";
        var key = "a28e443fc4addce0d1100f44";
        String direccion;
        double valorMoneda;
        double cantidad;
        var opc = 1;



        while (opc!=7 ) {
            ApiConsulta consultaApi = new ApiConsulta();

            //scanner.nextLine();
            System.out.println("\n\n**********************************************************************");
            System.out.println("Sea Bienvenido/a al Conversor de monedas =)");
            System.out.println("1) Dólar => Peso mexicano");
            System.out.println("2) Peso mexicano => Dólar");
            System.out.println("3) Real Brasileño => Dólar");
            System.out.println("4) Peso Colombiano => Dólar");
            System.out.println("5) Euros  => Peso mexicano");
            System.out.println("6) Otro....");
            System.out.println("7) Salir");

            System.out.println("Eligue la Opcion Valida: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        direccion = "https://v6.exchangerate-api.com/v6/" + key + "/latest/" + "usd";
                        MonedaExchange monedas = consultaApi.consultar(direccion);
                        Moneda monedaConvertir = new Moneda(monedas);
                        valorMoneda = monedaConvertir.consultaValor("MXN");
                        System.out.println("Convertir de Dolar a Pesos!");
                        System.out.println("Ingrese el valor que desea Convertir: ");
                        cantidad = scanner.nextDouble();
                        System.out.println("El valor de " + cantidad+ " [USD] corresponde al valor final de =>>" + cantidad * valorMoneda + "[MXN]");
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error de la URI, verifique la direccion");
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        direccion = "https://v6.exchangerate-api.com/v6/" + key + "/latest/" + "MXN";
                        MonedaExchange monedas = consultaApi.consultar(direccion);
                        Moneda monedaConvertir = new Moneda(monedas);
                        valorMoneda = monedaConvertir.consultaValor("USD");
                        System.out.println("Ingrese el valor que desea Convertir: ");
                        cantidad = scanner.nextDouble();
                        System.out.println("El valor de " + cantidad + " [MXN] corresponde al valor final de =>> " + (cantidad * valorMoneda) + "[USD]");
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error de la URI, verifique la direccion");
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    try {
                        direccion = "https://v6.exchangerate-api.com/v6/" + key + "/latest/" + "BRL";
                        MonedaExchange monedas = consultaApi.consultar(direccion);
                        Moneda monedaConvertir = new Moneda(monedas);
                        valorMoneda = monedaConvertir.consultaValor("USD");
                        System.out.println("Ingrese el valor que desea Convertir: ");
                        cantidad = scanner.nextDouble();
                        System.out.println("El valor de " + cantidad + " [BRL] corresponde al valor final de =>> " + (cantidad * valorMoneda) + "[USD]");
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error de la URI, verifique la direccion");
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    try {
                        direccion = "https://v6.exchangerate-api.com/v6/" + key + "/latest/" + "COP";
                        MonedaExchange monedas = consultaApi.consultar(direccion);
                        Moneda monedaConvertir = new Moneda(monedas);
                        valorMoneda = monedaConvertir.consultaValor("USD");
                        System.out.println("Ingrese el valor que desea Convertir: ");
                        cantidad = scanner.nextDouble();
                        System.out.println("El valor de " + cantidad + " [COP] corresponde al valor final de =>> " + (cantidad * valorMoneda) + "[USD]");
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error de la URI, verifique la direccion");
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    try {
                        direccion = "https://v6.exchangerate-api.com/v6/" + key + "/latest/" + "EUR";
                        MonedaExchange monedas = consultaApi.consultar(direccion);
                        Moneda monedaConvertir = new Moneda(monedas);
                        valorMoneda = monedaConvertir.consultaValor("MXN");
                        System.out.println("Ingrese el valor que desea Convertir: ");
                        cantidad = scanner.nextDouble();
                        System.out.println("El valor de " + cantidad + " [EUR] corresponde al valor final de =>> " + (cantidad * valorMoneda) + "[MXN]");
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error de la URI, verifique la direccion");
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 6:
                    try {
                        System.out.println("Escribe el nombre de la moneda a convertir");
                        var busqueda = scanner.next();

                        direccion = "https://v6.exchangerate-api.com/v6/" + key + "/latest/" + busqueda.toUpperCase();
                        MonedaExchange monedas = consultaApi.consultar(direccion);
                        Moneda monedaConvertir = new Moneda(monedas);
                        System.out.println("A que moneda desa convertir (solo se ingresa avrebiaciones como MXN O EUR): ");
                        valor = scanner.next();
                        valorMoneda = monedaConvertir.consultaValor(valor.toUpperCase());
                        System.out.println("Ingrese el valor que desea Convertir: ");
                        cantidad = scanner.nextDouble();
                        System.out.println("El valor de " + cantidad + " [" + busqueda.toUpperCase() + "] corresponde al valor final de =>> " + (cantidad * valorMoneda) + " [" + valor.toUpperCase() + "]");
                    }catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error de la URI, verifique la direccion");
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("No se ecnuntra disponible esta opción.");

            }


        }

    }
}
