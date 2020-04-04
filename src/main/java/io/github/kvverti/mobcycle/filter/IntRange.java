package io.github.kvverti.mobcycle.filter;

public final class IntRange {
    public final int min;
    public final int max;

    public IntRange(int min, int max) {
        if(max < min) {
            throw new IllegalArgumentException("max < min");
        }
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IntRange) {
            IntRange o = (IntRange)obj;
            return this.min == o.min && this.max == o.max;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return min * 31 + max;
    }
}
