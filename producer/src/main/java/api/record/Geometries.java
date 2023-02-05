package api.record;

import com.fasterxml.jackson.databind.JsonNode;

public record Geometries(
        String type,
        JsonNode coordinates
) {}
