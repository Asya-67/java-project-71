package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlainformTest {
    @Test
    void testPlainForm() throws Exception {
        String expected = Files.readString(Path.of("src/test/resources/Plain.txt"));
        String actual = Differ.generate("src/test/resources/filepath1.yml",
                "src/test/resources/filepath2.yml", "plain");
        assertEquals(normalize(expected), normalize(actual));
    }
    private static String normalize(String str) {
        return str.replace("\r\n", "\n").trim();
    }
}
