package hexlet.code;

import java.util.List;

public class StylishFormatter {
    public static String format(List<DiffSecond> diffList) {
        System.out.println("Stylish formatter is used");
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (DiffSecond diff : diffList) {
            String key = diff.getKey();
            Object oldValue = diff.getOldValue();
            Object newValue = diff.getNewValue();
            DiffSecond.Status status = diff.getStatus();

            switch (status) {
                case UNCHANGED:
                    sb.append("    ").append(key).append(": ").append(oldValue).append("\n");
                    break;
                case ADDED:
                    sb.append("  + ").append(key).append(": ").append(newValue).append("\n");
                    break;
                case REMOVED:
                    sb.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                    break;
                case CHANGED:
                    sb.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                    sb.append("  + ").append(key).append(": ").append(newValue).append("\n");
                    break;
                default:
                    break;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private static String stringify(Object value) {
        if (value == null) {
            return "null";
        }
        return value.toString();
    }
}
