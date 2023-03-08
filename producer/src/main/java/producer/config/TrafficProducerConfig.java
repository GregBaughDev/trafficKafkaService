package producer.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import producer.TrafficInfo;

import java.util.Properties;

public class TrafficProducerConfig {
//    private final String bootstrapServers = "localhost:29092";
    private final String bootstrapServers = "kafka:9092";

    private Properties producerConfig() {
        final Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, TrafficInfoSerializer.class);
        return properties;
    }

    public KafkaProducer<String, TrafficInfo> producer() {
        return new KafkaProducer<>(producerConfig());
    }
}
