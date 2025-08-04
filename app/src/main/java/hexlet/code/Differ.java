package hexlet.code;

import java.util.Map;
import java.util.List;

public class Differ {
    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
        List<DifferenceContainer> diff = DiffAction.buildDiff(data1, data2);
        return Formatter.format(diff, "stylish");
    }
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> data1 = Parser.parse(filePath1);
        Map<String, Object> data2 = Parser.parse(filePath2);
        List<DifferenceContainer> diff = DiffAction.buildDiff(data1, data2);
        return Formatter.format(diff, format);
    }
}
