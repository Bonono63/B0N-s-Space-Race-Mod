package net.MrBonono63.bsr.world.feature;

import net.MrBonono63.bsr.registry.BSRFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.FlowerFeature;

public class BSRBiomeFeatures {

    public static <F extends FeatureConfig, D extends DecoratorConfig> ConfiguredFeature<?, ?> configureFeature(Feature<F> feature, F featureConfig, Decorator<D> decorator, D decoratorConfig) {
        Feature<DecoratedFeatureConfig> feature2 = feature instanceof FlowerFeature ? Feature.DECORATED_FLOWER : Feature.DECORATED;
        return new ConfiguredFeature(feature2, new DecoratedFeatureConfig(feature.configure(featureConfig), decorator.configure(decoratorConfig)));
    }

    public static void addAsteroids(Biome biome) {
        biome.addFeature(GenerationStep.Feature.RAW_GENERATION, configureFeature(BSRFeatures.ASTEROID, FeatureConfig.DEFAULT, Decorator.COUNT_RANGE, new RangeDecoratorConfig(1, 1, 1, 1)));
    }
}