package com.aluracurso.conversorMoneda.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Convertidor {
    private static  HttpClient client = HttpClient.newHttpClient();

    public static Cambios getValorCambios(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new IOException("Unexpected response code: " + response.statusCode());
        }
        return parseJsonResponse(response.body());
    }
    private static Cambios parseJsonResponse(String jsonResponse) {
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, Cambios.class);
    }
    public static double convertirMoneda(Cambios valor, String desde, String hacia, double cantidad) {
        if (valor.getConversionRates().containsKey(desde) && valor.getConversionRates().containsKey(hacia)) {
            double precioDesde = valor.getConversionRates().get(desde);
            double precioHasta = valor.getConversionRates().get(hacia);
            System.out.println("valor "+ desde + "= "+ precioDesde +"\nvalor"+ hacia +"= " +precioHasta + "\n");
            return ( precioHasta/ precioDesde) * cantidad;
        } else {
            throw new IllegalArgumentException("Moneda no soportada.");
        }
    }


}