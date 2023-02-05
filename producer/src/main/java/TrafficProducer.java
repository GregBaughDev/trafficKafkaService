import api.TrafficAPI;
import api.record.Response;

public class TrafficProducer {
    public static void main(String[] args) {
        TrafficAPI api = new TrafficAPI();
        Response response = api.getDataResponse();

        System.out.println("Traffic producer");
        System.out.println(response.features().get(0).geometry().geometries());
    }
}
