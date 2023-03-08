package api;

import api.record.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TrafficAPI {
    private final String vicRoadsUrl = "https://data-exchange-api.vicroads.vic.gov.au/opendata/disruptions/v1/planned?format=GeoJson";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private HttpRequest getDataRequest() {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(vicRoadsUrl))
                .header("Ocp-Apim-Subscription-Key", "APIKEY")
                .GET()
                .build();
    }

    public String getSendDataRequest() {
        try {
            HttpResponse<String> response = client.send(getDataRequest(), HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.getStackTrace();
            System.exit(0);
            return null;
        }
    }

    public Response getDataResponse() {
        try {
            return objectMapper.readValue(getSendDataRequest(), Response.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
