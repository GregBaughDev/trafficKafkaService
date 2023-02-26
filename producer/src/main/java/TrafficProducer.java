import api.TrafficAPI;
import api.record.Response;
import org.apache.kafka.clients.producer.ProducerRecord;
import producer.TrafficInfo;
import producer.config.TrafficProducerConfig;

public class TrafficProducer {
    public static void main(String[] args) {
        System.out.println("******Traffic producer******");

        TrafficAPI api = new TrafficAPI();
        Response response = api.getDataResponse();

        TrafficProducerConfig producerConfig = new TrafficProducerConfig();

        while (true) {
            try {
                response.features().stream().limit(10).forEach(feature -> {
                    ProducerRecord<String, TrafficInfo> trafficProducer = new ProducerRecord<>(
                            "traffic_info", new TrafficInfo(
                            feature.properties().closedRoadName() + ":::::::Greg update&",
                            feature.properties().startIntersectionRoadName(),
                            feature.properties().localGovernmentArea(),
                            feature.properties().eventType(),
                            feature.properties().eventDueTo(),
                            feature.properties().impact().direction(),
                            feature.properties().impact().impactType(),
                            feature.properties().impact().delay(),
                            feature.properties().impact().speedLimitOnSite(),
                            feature.properties().duration().start(),
                            feature.properties().duration().end(),
                            feature.properties().description()
                    )
                    );
                    producerConfig.producer().send(trafficProducer);
                    System.out.println("***Message sent***");
                });
                producerConfig.producer().flush();
                Thread.sleep(60000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
// TO DO: REALISED THAT ONLY ONE MESSAGE IS COMING THROUGH IN DOCKER
// PRINT OUT THE MESSAGE TO SEE IF THERE'S SOME ISSUE IN THE DOCKER APP
