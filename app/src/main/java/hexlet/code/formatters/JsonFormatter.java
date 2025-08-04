package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonFormatter {
    public static String format(List<DifferenceContainer> diffs) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(diffs);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize diffs to JSON", e);
        }
    }
}
