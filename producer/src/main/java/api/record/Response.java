package api.record;

import java.util.List;

public record Response(
    String type,
    List<Feature> features
) {}
