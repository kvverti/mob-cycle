package io.github.kvverti.mobcycle.properties;

import net.minecraft.entity.Entity;

/**
 * A rule for random entity texture selection. Rules influence how a random
 * entity texture is chosen. Rules may use any information available through
 * the entity, including any (client) world state. Instances derived from
 * this interface are expected to be deserialized from MobCycle JSON or
 * Optifine/RandoMobs properties files.
 */
@FunctionalInterface
public interface TextureSelectionRule<T extends Entity> {

    /**
     * Returns true if the entity follows this rule, false otherwise.
     */
    boolean test(T entity);

    /**
     * Composes this rule with the given rule. The given rule is only run
     * if this rule allows a given entity.
     */
    default <U extends T> TextureSelectionRule<U> and(TextureSelectionRule<? super U> rule) {
        return e -> this.test(e) && rule.test(e);
    }

    /**
     * Returns a rule that always allows all entities.
     */
    static <T extends Entity> TextureSelectionRule<T> always() {
        return e -> true;
    }
}
