package io.github.kvverti.mobcycle.properties;

final class IntRange {
    final int min;
    final int max;

    IntRange(int min, int max) {
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
