package hexlet.code;

import java.util.List;

public class Formatter {
    public static String format(List<DiffSecond> diffs, String formatName) {
        if (formatName == null || formatName.isEmpty()) {
            formatName = "stylish";
        }

        switch (formatName) {
            case "plain":
                return Plainform.format(diffs);
            case "stylish":
                return StylishFormatter.format(diffs);
            default:
                throw new IllegalArgumentException("Unknown format: " + formatName);
        }
    }
}
