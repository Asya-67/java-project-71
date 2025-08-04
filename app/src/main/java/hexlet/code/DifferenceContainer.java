package hexlet.code;

import java.util.Objects;

public final class DifferenceContainer {
    public enum Status {
        UNCHANGED,
        ADDED,
        CHANGED,
        REMOVED
    }
    private String key;
    private Object oldValue;
    private Object newValue;
    private Status status;

    public DifferenceContainer(
            String key,
            Object oldValue,
            Object newValue,
            hexlet.code.DifferenceContainer.Status status
    ) {
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.status = status;
    }

    public java.lang.String getKey() {
        return key;
    }

    public java.lang.Object getOldValue() {
        return oldValue;
    }

    public java.lang.Object getNewValue() {
        return newValue;
    }

    public hexlet.code.DifferenceContainer.Status getStatus() {
        return status;
    }

    public void setKey(java.lang.String key) {
        this.key = key;
    }

    public void setOldValue(java.lang.Object oldValue) {
        this.oldValue = oldValue;
    }

    public void setNewValue(java.lang.Object newValue) {
        this.newValue = newValue;
    }

    public void setStatus(hexlet.code.DifferenceContainer.Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DifferenceContainer)) {
            return false;
        }
        DifferenceContainer that = (DifferenceContainer) o;
        return Objects.equals(key, that.key)
                && Objects.equals(oldValue, that.oldValue)
                && Objects.equals(newValue, that.newValue)
                && status == that.status;
    }
    @Override
    public int hashCode() {
        return Objects.hash(key, oldValue, newValue, status);
    }
    @Override
    public String toString() {
        return "DifferenceContainer{"
                + "key='" + key + '\''
                + ", oldValue=" + oldValue
                + ", newValue=" + newValue
                + ", status=" + status
                + '}';
    }
}
