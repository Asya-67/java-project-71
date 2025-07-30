package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testGenerateDiffWithFlatJsonFiles() throws Exception {
        InputStream file1 = getClass().getClassLoader().getResourceAsStream("file1.json");
        InputStream file2 = getClass().getClassLoader().getResourceAsStream("file2.json");
        if (file1 == null || file2 == null) {
            throw new IllegalArgumentException("Test resource files not found");
        }

        Map<String, Object> data1 = mapper.readValue(file1, Map.class);
        Map<String, Object> data2 = mapper.readValue(file2, Map.class);

        String expected = """
{
  - follow: false
    host: hexlet.io
  - proxy: 123.234.53.22
  - timeout: 50
  + timeout: 20
  + verbose: true
}
            """;

        App app = new App();
        String actual = Differ.generate(data1, data2);
        System.out.println("=== ACTUAL OUTPUT ===");
        System.out.println(actual);
        System.out.println("======================");
        assertEquals(expected.strip(), actual.strip());
    }
}
