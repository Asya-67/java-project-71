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

    /**
     * @param key      ключ
     * @param oldValue старое значение (может быть null)
     * @param newValue новое значение (может быть null)
     * @param status   статус изменения
     */
    public DifferenceContainer(String key, Object oldValue, Object newValue, Status status) {
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.status = status;
    }

    /**
     * @return ключ
     */
    public String getKey() {
        return key;
    }

    /**
     * @return старое значение (может быть null)
     */
    public Object getOldValue() {
        return oldValue;
    }

    /**
     * @return новое значение (может быть null)
     */
    public Object getNewValue() {
        return newValue;
    }

    /**
     * @return статус изменения
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param key новый ключ
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @param oldValue новое старое значение
     */
    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    /**
     * @param newValue новое значение
     */
    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    /**
     * @param status новый статус
     */
    public void setStatus(Status status) {
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
