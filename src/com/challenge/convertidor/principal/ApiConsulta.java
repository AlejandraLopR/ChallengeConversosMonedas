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

public class ApiConsulta {
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public MonedaExchange consultar(String direccion) throws IOException, InterruptedException {
            //Configura el cliente, y se cra una instancia de el
            HttpClient client =HttpClient.newHttpClient();

            //Se configura el encabezado y el  cuerpo
            HttpRequest request = HttpRequest.newBuilder().
                    uri(URI.create(direccion)).
                    build();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            //System.out.println(json);

            MonedaExchange monedas =gson.fromJson(json, MonedaExchange.class);
            return monedas;
            //Moneda monedaConvertir =new Moneda(monedas);


        /*}catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Error de la URI, verifique la direccion");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }
}
