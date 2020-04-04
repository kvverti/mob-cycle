package io.github.kvverti.mobcycle.filter;

import java.util.function.ToIntFunction;

import net.minecraft.entity.Entity;

/**
 * A filter factory for filters that restrict some entity property
 * to an inclusive range.
 */
public final class RangeFilterFactory<T extends Entity> extends EntityFilterFactory<T, IntRange> {

    private final ToIntFunction<? super T> extractor;

    public RangeFilterFactory(ToIntFunction<? super T> extractor) {
        super(IntRange.class);
        this.extractor = extractor;
    }

    @Override
    protected <U extends T> EntityFilter<U> makeFilter(IntRange params) {
        return entity -> {
            int value = extractor.applyAsInt(entity);
            return params.min <= value && value <= params.max;
        };
    }
}
