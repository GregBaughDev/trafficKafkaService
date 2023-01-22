package api;

import api.dao.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class TrafficAPI {
    private final String vicRoadsUrl = "https://data-exchange-api.vicroads.vic.gov.au/opendata/disruptions/v1/planned?format=GeoJson";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private HttpRequest getDataRequest() {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(vicRoadsUrl))
                .header("Ocp-Apim-Subscription-Key", "API KEY")
                .GET()
                .build();
    }

    public String getSendDataRequest() {
        try {
            HttpResponse<String> response = client.send(getDataRequest(), HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.exit(0);
            return null;
        }
    }

    public List<Response> getDataResponse() {
        try {
            return objectMapper.readValue(getSendDataRequest(), objectMapper.getTypeFactory().constructCollectionType(List.class, Response.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };
}
