package io.github.kvverti.mobcycle.filter;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import net.minecraft.entity.Entity;

/**
 * An entity filter factory manages the creation of {@link EntityFilter}
 * objects. Entity filters have a well-defined serialized form
 * that corresponds to the parameters found in MobCycle JSON or Optifine
 * properties files.
 *
 * @param <T> the types of entities the resulting filters act on
 * @param <S> (internal) the type of the intermediate serialized form
 */
public abstract class EntityFilterFactory<T extends Entity, S> {

    private final TypeToken<S> serializedType;

    protected EntityFilterFactory(Class<S> serializedType) {
        this(TypeToken.of(serializedType));
    }

    protected EntityFilterFactory(TypeToken<S> serializedType) {
        this.serializedType = serializedType;
    }

    public final TypeToken<S> getSerializedType() {
        return serializedType;
    }

    public final <U extends T> EntityFilter<U> filterFromJson(JsonElement json, Gson gson) {
        S s = gson.fromJson(json, serializedType.getType());
        return makeFilter(s);
    }

    protected abstract <U extends T> EntityFilter<U> makeFilter(S params);
}
