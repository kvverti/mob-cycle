package io.github.kvverti.mobcycle.filter;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.util.List;

import net.minecraft.entity.Entity;

/**
 * A higher order factory that composes homogeneous filters created
 * from another factory. This factory creates filters that return true
 * if any of the inner filters returns true. As a special case, if there
 * are no inner filters, the created filter always returns true.
 */
public final class ComposedFilterFactory<T extends Entity, S> extends EntityFilterFactory<T, List<S>> {

    private final EntityFilterFactory<T, S> inner;

    @SuppressWarnings("serial")
    public ComposedFilterFactory(EntityFilterFactory<T, S> inner) {
        super(new TypeToken<List<S>>(){}
            .where(new TypeParameter<S>(){}, inner.getSerializedType()));
        this.inner = inner;
    }

    @Override
    protected <U extends T> EntityFilter<U> makeFilter(List<S> params) {
        if(params.isEmpty()) {
            return EntityFilter.always();
        } else {
            return entity -> {
                for(S s : params) {
                    if(inner.makeFilter(s).test(entity)) {
                        return true;
                    }
                }
                return false;
            };
        }
    }
}
