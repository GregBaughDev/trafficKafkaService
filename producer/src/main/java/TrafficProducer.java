import api.TrafficAPI;
import api.record.Response;
import org.apache.kafka.clients.producer.ProducerRecord;
import producer.TrafficInfo;
import producer.config.TrafficProducerConfig;

public class TrafficProducer {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("******Traffic producer******");

        TrafficAPI api = new TrafficAPI();
        Response response = api.getDataResponse();

        TrafficProducerConfig producerConfig = new TrafficProducerConfig();

        while (true) {
            response.features().stream().limit(10).forEach(feature -> {
                ProducerRecord<String, TrafficInfo> trafficProducer = new ProducerRecord<>(
                        "traffic_info", new TrafficInfo(
                        feature.properties().closedRoadName(),
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
            });
            Thread.sleep(60000);
        }
    }
}
