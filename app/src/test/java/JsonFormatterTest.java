package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonFormatterTest {
    @Test
    public void jsonTestFormat() throws JsonProcessingException {
        DiffSecond diff1 = new DiffSecond("key1", "oldVal1", "newVal1", DiffSecond.Status.CHANGED);
        DiffSecond diff2 = new DiffSecond("key2", null, "val2", DiffSecond.Status.ADDED);
        List<DiffSecond> diffs = List.of(diff1, diff2);

        String json = JsonFormatter.format(diffs);

        ObjectMapper mapper = new ObjectMapper();
        List<?> parsed = mapper.readValue(json, List.class);

        assertThat(parsed).hasSize(2);
        assertThat(parsed.toString()).contains("key1", "oldVal1", "newVal1", "CHANGED", "key2", "val2", "ADDED");
    }
}
