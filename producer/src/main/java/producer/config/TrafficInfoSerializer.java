package producer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import producer.TrafficInfo;

public class TrafficInfoSerializer implements Serializer<TrafficInfo> {
    final private ObjectMapper objectMapper = new ObjectMapper();

    public byte[] serialize(String topic, TrafficInfo data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SerializationException("Error serializing data");
        }
    }
}
