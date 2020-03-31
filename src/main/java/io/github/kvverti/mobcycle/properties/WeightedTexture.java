package io.github.kvverti.mobcycle.properties;

import java.util.Objects;

import net.minecraft.util.Identifier;

final class WeightedTexture {
    final Identifier texture;
    final int weight;

    WeightedTexture(Identifier texture, int weight) {
        if(weight <= 0) {
            throw new IllegalArgumentException("weight <= 0");
        }
        this.texture = Objects.requireNonNull(texture);
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof WeightedTexture) {
            WeightedTexture o = (WeightedTexture)obj;
            return this.weight == o.weight && Objects.equals(this.texture, o.texture);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return texture.hashCode() * 31 + weight;
    }
}
