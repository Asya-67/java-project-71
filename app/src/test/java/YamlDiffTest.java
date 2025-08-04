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

    @Test
    public void testNestedYaml() throws Exception {
        String filepath1 = "src/test/resources/filepath1.yml";
        String filepath2 = "src/test/resources/filepath2.yml";

        Map<String, Object> data1 = Parser.parse(filepath1);
        Map<String, Object> data2 = Parser.parse(filepath2);

        String expected = """
{
    chars1: [a, b, c]
  - chars2: [d, e, f]
  + chars2: false
  - checked: false
  + checked: true
  - default: null
  + default: [value1, value2]
  - id: 45
  + id: null
  - key1: value1
  + key2: value2
    numbers1: [1, 2, 3, 4]
  - numbers2: [2, 3, 4, 5]
  + numbers2: [22, 33, 44, 55]
  - numbers3: [3, 4, 5]
  + numbers4: [4, 5, 6]
  + obj1: {nestedKey=value, isNested=true}
  - setting1: Some value
  + setting1: Another value
  - setting2: 200
  + setting2: 300
  - setting3: true
  + setting3: none
}
                """;

        String actual = Differ.generate(data1, data2);
        System.out.println("=== ACTUAL OUTPUT ===");
        System.out.println(actual);
        System.out.println("======================");
        assertEquals(expected.strip(), actual.strip());
    }

}
