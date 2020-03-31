package io.github.kvverti.mobcycle.properties;

import java.util.Collections;
import java.util.Set;
import java.util.regex.Pattern;

import net.fabricmc.fabric.api.util.TriState;

import net.minecraft.util.DyeColor;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.biome.Biome;

/**
 * Represents single set of texture selection data loaded from either
 * Mob Cycle JSON file or an Optifine/RandoMobs properties file.
 * @deprecated may be removed
 */
@Deprecated
final class DefaultTextureSelectionData {

    private final Set<WeightedTexture> weightedTextures;

    private final Set<Biome> allowedBiomes;

    private final Set<IntRange> allowedHeightRanges;

    private final Pattern allowedNamePattern;

    private final Set<VillagerProfession> allowedProfessions;

    private final Set<DyeColor> allowedCollarColors;

    private final TriState forBabies;

    private final Set<IntRange> allowedHealthRanges;

    private final Set<IntRange> allowedMoonPhases;

    private final Set<IntRange> allowedDayTimes;

    private final Set<String> allowedWeather;

    private DefaultTextureSelectionData() {
        this.weightedTextures = Collections.emptySet();
        this.allowedBiomes = Collections.emptySet();
        this.allowedHeightRanges = Collections.emptySet();
        this.allowedNamePattern = Pattern.compile(".*");
        this.allowedProfessions = Collections.emptySet();
        this.allowedCollarColors = Collections.emptySet();
        this.forBabies = TriState.DEFAULT;
        this.allowedHealthRanges = Collections.emptySet();
        this.allowedMoonPhases = Collections.emptySet();
        this.allowedDayTimes = Collections.emptySet();
        this.allowedWeather = Collections.emptySet();
    }
}
