package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws Exception {
        String content = Files.readString(Paths.get(filePath));
        ObjectMapper mapper;

        if (filePath.endsWith(".json")) {
            mapper = new ObjectMapper();
        } else if (filePath.endsWith(".yaml") || filePath.endsWith(".yml")) {
            mapper = new ObjectMapper(new YAMLFactory());
        } else {
            throw new RuntimeException("Unsupported file format: " + filePath);
        }
        return mapper.readValue(content, Map.class);
    }
}
