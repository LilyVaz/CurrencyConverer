import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultasTasaCambio {
    private static final String apiKey= "7959c5ab7609c587c44c1696";
    private static final String baseUrl= "https://v6.exchangerate-api.com/v6/";
    public TasaCambio obtenerTasaCambio(String baseCurrency, String targetCurrency )throws Exception{
        String url=baseUrl+apiKey+"/latest/"+baseCurrency;

        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());

        if (response.statusCode()==200){
            JsonObject tasaJson= new Gson().fromJson(response.body(), JsonObject.class);
            double tasa= tasaJson.getAsJsonObject("conversion_rates").get(targetCurrency).getAsDouble();
            return new TasaCambio(baseCurrency, targetCurrency,tasa);
        }else {
            throw new RuntimeException("Error de solicitud"+response.statusCode());
        }
    }
}
