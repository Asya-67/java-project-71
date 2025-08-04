package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Objects;


public class DiffAction {
    public static List<DifferenceContainer> buildDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());
        List<DifferenceContainer> diffList = new ArrayList<>();

        for (String key : allKeys) {
            boolean hasKey1 = data1.containsKey(key);
            boolean hasKey2 = data2.containsKey(key);

            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (hasKey1 && !hasKey2) {
                diffList.add(new DifferenceContainer(key, value1, null, DifferenceContainer.Status.REMOVED));
            } else if (!hasKey1 && hasKey2) {
                diffList.add(new DifferenceContainer(key, null, value2, DifferenceContainer.Status.ADDED));
            } else if (!Objects.equals(value1, value2)) {
                diffList.add(new DifferenceContainer(key, value1, value2, DifferenceContainer.Status.CHANGED));
            } else {
                diffList.add(new DifferenceContainer(key, value1, value2, DifferenceContainer.Status.UNCHANGED));
            }
        }
        return diffList;
    }
}
