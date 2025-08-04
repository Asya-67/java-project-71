package hexlet.code;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Comparator;

public class Plainform {
    public static String format(List<DifferenceContainer> diffs) {
        return diffs.stream()
                .filter(d -> d.getStatus() != DifferenceContainer.Status.UNCHANGED)
                .sorted(Comparator.comparing(DifferenceContainer::getKey))
                .map(d -> {
                    String key = d.getKey();
                    Object oldVal = toPlainString(d.getOldValue());
                    Object newVal = toPlainString(d.getNewValue());

                    return switch (d.getStatus()) {
                        case ADDED -> "Property '" + key + "' was added with value: " + newVal;
                        case REMOVED -> "Property '" + key + "' was removed";
                        case CHANGED -> "Property '" + key + "' was updated. From " + oldVal + " to " + newVal;
                        default -> throw new RuntimeException("Unknown status: " + d.getStatus());
                    };
                })
                .collect(Collectors.joining("\n"));
    }

    private static String toPlainString(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof List<?> || value instanceof Map<?, ?>) {
            return "[complex value]";
        } else {
            return value.toString();
        }
    }
}
