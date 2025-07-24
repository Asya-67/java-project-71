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

@Command(
        name = "App",
        mixinStandardHelpOptions = true,
        version = "App 1.0",
        description = "Compares two configuration files and shows a difference."
)

public class App implements Runnable {

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
    @Override
    public void run() {
        try {
            Map<String, Object> data1 = parse(filePath1);
            Map<String, Object> data2 = parse(filePath2);
            System.out.println("File 1 content: " + data1);
            System.out.println("File 2 content: " + data2);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static Map<String, Object> parse(String filePath) throws Exception{
        String content = Files.readString(Paths.get(filePath));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Map.class);
    }
}
