package api.record;

public record Impact(
        String direction,
        String impactType,
        String delay,
        String speedLimitOnSite
) {
}
