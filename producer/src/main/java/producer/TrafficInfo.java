package producer;

public record TrafficInfo(
        // Add @JsonProperty to deserializer
        String closedRoadName,
        String intersectionRoadName,
        String localGovernmentArea,
        String eventType,
        String eventDueTo,
        String direction,
        String impact,
        String delay,
        String speedLimit,
        String start,
        String end,
        String description
) {}
