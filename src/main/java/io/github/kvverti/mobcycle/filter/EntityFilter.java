package io.github.kvverti.mobcycle.filter;

import net.minecraft.entity.Entity;

/**
 * A filter for random entity texture selection. Filters influence how a random
 * entity texture is chosen. Filters may use any information available through
 * the entity, including any (client) world state. Instances derived from
 * this interface are expected to be deserialized from MobCycle JSON or
 * Optifine/RandoMobs properties files.
 */
@FunctionalInterface
public interface EntityFilter<T extends Entity> {

    /**
     * Returns true if the entity follows this filter, false otherwise.
     */
    boolean test(T entity);

    /**
     * Composes this filter with the given filter. The given filter is only run
     * if this filter allows a given entity.
     */
    default <U extends T> EntityFilter<U> and(EntityFilter<? super U> filter) {
        return e -> this.test(e) && filter.test(e);
    }

    /**
     * Returns a filter that always allows all entities.
     */
    static <T extends Entity> EntityFilter<T> always() {
        return e -> true;
    }
}
