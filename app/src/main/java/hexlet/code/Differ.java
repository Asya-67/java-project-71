package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
        StringBuilder strb = new StringBuilder();
        strb.append("{\n");

        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        for (String key : allKeys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value1 != null && value2 != null && value1.equals(value2)) {
                strb.append("    ")
                        .append(key).append(": ").append(stringify(value1)).append("\n");
            } else if (value1 != null && value2 == null) {
                strb.append("  - ")
                        .append(key).append(": ").append(stringify(value1)).append("\n");
            } else if (value1 == null && value2 != null) {
                strb.append("  + ")
                        .append(key).append(": ").append(stringify(value2)).append("\n");
            } else {
                strb.append("  - ")
                        .append(key).append(": ").append(stringify(value1)).append("\n");
                strb.append("  + ")
                        .append(key).append(": ").append(stringify(value2)).append("\n");
            }
        }

        strb.append("}");
        return strb.toString();
    }

    private static String stringify(Object value) {
        return value == null ? "null" : value.toString();
    }
}
