package models;

public enum Limits {
    MIN_LIMIT(0), MAX_LIMIT(100);
    private int value;

    Limits(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
