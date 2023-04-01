import api.TrafficAPI;
import api.record.Response;
import org.apache.kafka.clients.producer.ProducerRecord;
import producer.TrafficInfo;
import producer.config.TrafficProducerConfig;

import java.util.concurrent.TimeUnit;

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
                    System.out.println("Message: " + trafficProducer);
                    System.out.println("***Message sent***");
                });
                producerConfig.producer().flush();
                TimeUnit.MINUTES.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}