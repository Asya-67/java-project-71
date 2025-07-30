package hexlet.code;

import java.util.Map;
import java.util.List;

public class Differ {
    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
        List<DiffSecond> diff = DiffAction.buildDiff(data1, data2);
        return StylishFormatter.format(diff);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> data1 = Parser.parse(filePath1);
        Map<String, Object> data2 = Parser.parse(filePath2);
        return generate(data1, data2);
    }
}
