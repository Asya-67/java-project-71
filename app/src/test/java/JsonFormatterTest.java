package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonFormatterTest {
    @Test
    public void jsonTestFormat() throws JsonProcessingException {
        DifferenceContainer diff1 = new DifferenceContainer(
                "key1",
                "oldVal1",
                "newVal1",
                DifferenceContainer.Status.CHANGED);
        DifferenceContainer diff2 = new DifferenceContainer(
                "key2",
                null,
                "val2",
                DifferenceContainer.Status.ADDED);
        List<DifferenceContainer> diffs = List.of(diff1, diff2);

        String json = JsonFormatter.format(diffs);

        ObjectMapper mapper = new ObjectMapper();
        List<?> parsed = mapper.readValue(json, List.class);

        assertThat(parsed).hasSize(2);
        assertThat(parsed.toString()).contains("key1", "oldVal1", "newVal1", "CHANGED", "key2", "val2", "ADDED");
    }
}
