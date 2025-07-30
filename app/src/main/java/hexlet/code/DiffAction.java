package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Objects;


public class DiffAction {
    public static List<DiffSecond> buildDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());
        List<DiffSecond> diffList = new ArrayList<>();

        for (String key : allKeys) {
            boolean hasKey1 = data1.containsKey(key);
            boolean hasKey2 = data2.containsKey(key);

            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (hasKey1 && !hasKey2) {
                diffList.add(new DiffSecond(key, value1, null, DiffSecond.Status.REMOVED));
            } else if (!hasKey1 && hasKey2) {
                diffList.add(new DiffSecond(key, null, value2, DiffSecond.Status.ADDED));
            } else if (!Objects.equals(value1, value2)) {
                diffList.add(new DiffSecond(key, value1, value2, DiffSecond.Status.CHANGED));
            } else {
                diffList.add(new DiffSecond(key, value1, value2, DiffSecond.Status.UNCHANGED));
            }
        }
        return diffList;
    }
}
