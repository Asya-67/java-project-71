package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YamlDiffTest {
    @Test
    public void testYML() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";

        Map<String, Object> data1 = Parser.parse(filepath1);
        Map<String, Object> data2 = Parser.parse(filepath2);

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
        String actual = Differ.generate(data1, data2);
        System.out.println("=== ACTUAL OUTPUT ===");
        System.out.println(actual);
        System.out.println("======================");
        assertEquals(expected.strip(), actual.strip());
    }
}
