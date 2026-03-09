package servicio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultaMoneda {

    private String apiKey = "07e0a5159cc160c78cdc5e34";

    public double obtenerTasa(String monedaBase, String monedaDestino) {

        try {

            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaBase + "/" + monedaDestino;

            HttpClient cliente = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            return json.get("conversion_rate").getAsDouble();

        } catch (Exception e) {
            System.out.println("Error al consultar la API");
            e.printStackTrace();
            return 0;
        }
    }
}