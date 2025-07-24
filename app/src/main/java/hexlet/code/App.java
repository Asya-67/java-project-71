package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;

@Command(
        name = "App",
        mixinStandardHelpOptions = true,
        version = "App 1.0",
        description = "Compares two configuration files and shows a difference."
)

public class App implements Callable<Integer> {

    @Parameters(
            index = "0",
            paramLabel = "filepath1",
            description = "path to first file"
    )
    private String filePath1;

    @Parameters(
            index = "1",
            paramLabel = "filepath2",
            description = "path to second file"
    )
    private String filePath2;

    @Option(
            names = {"-f", "--format"},
            description = "output format [default: ${DEFAULT-VALUE}]",
            defaultValue = "stylish"
    )
    private String format;

    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }

    private static Map<String, Object> parse(String filePath) throws Exception {
        String content = Files.readString(Paths.get(filePath));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Map.class);}

    @Override
    public Integer call() throws Exception {
        Map<String, Object> data1 = parse(filePath1);
        Map<String, Object> data2 = parse(filePath2);
        String diff = generateDiff(data1, data2);
        System.out.println(diff);

        return 0;
    }

    private String generateDiff(Map<String, Object> data1, Map<String, Object> data2) {
        StringBuilder strb = new StringBuilder();
        strb.append("{\n");

        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        for (String key : allKeys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value1 != null && value2 != null && value1.equals(value2)) {
                strb.append("   ").append(key).append(": ").append(value1).append("\n");
            } else if (value1 != null && value2 == null) {
                strb.append("  - ").append(key).append(": ").append(value1).append("\n");
            } else if (value1 == null && value2 != null) {
                strb.append("  + ").append(key).append(": ").append(value2).append("\n");
            } else {
                strb.append("  - ").append(key).append(": ").append(value1).append("\n");
                strb.append("  + ").append(key).append(": ").append(value2).append("\n");
            }
        }
        strb.append("}");
        return strb.toString();
    }
}
