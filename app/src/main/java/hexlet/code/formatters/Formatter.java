package hexlet.code;

import hexlet.code.Plainform;
import hexlet.code.StylishFormatter;
import hexlet.code.DiffSecond;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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