// Need to sort out the above
// Use jackson for accessing the data

import api.TrafficAPI;

import java.util.List;

public class TrafficProducer {
    public static void main(String[] args) {
        TrafficAPI api = new TrafficAPI();
        List<ResponseWrapper> response = api.getDataResponse();

        System.out.println("Traffic producer");
        System.out.println(response.reps get(0).getDetails().get("description"));

    }
}
