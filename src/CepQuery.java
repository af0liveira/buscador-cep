import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class CepQuery {

    public Address retrieveAddress(String cep) {
        String url = String.format("https://viacep.com.br/ws/%s/json/",
                                   cep.replaceAll("[^0-9]", ""));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("RESPONSE: " + response.statusCode() + response.toString());
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to retrieve URL: " + url);
        }
        
        Address address = null;
        try {
            address = new Gson().fromJson(response.body(), Address.class);
        } catch (com.google.gson.JsonSyntaxException e) {
            System.out.println("FUDEU! " + e.getMessage());
        }

        return address;
    }

}
