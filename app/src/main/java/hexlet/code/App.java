package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Map;

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
    private String format = "stylish";

    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }

    @Override
    public Integer call() throws Exception {
        Map<String, Object> data1 = Parser.parse(filePath1);
        Map<String, Object> data2 = Parser.parse(filePath2);
        String diff = Differ.generate(data1, data2);
        System.out.println(diff);

        return 0;
    }
}
