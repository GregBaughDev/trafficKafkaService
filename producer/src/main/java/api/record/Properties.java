package api.record;

public record Properties(
        String closedRoadName,
        String startIntersectionRoadName,
        String startIntersectionLocality,
        String localGovernmentArea,
        String rmaClass,
        String eventType,
        String eventDueTo,
        Impact impact,
        Duration duration,
        String description
) {}
