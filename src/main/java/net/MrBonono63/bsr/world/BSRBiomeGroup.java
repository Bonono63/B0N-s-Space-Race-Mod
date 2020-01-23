package net.MrBonono63.bsr.world;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

import java.util.ArrayList;
import java.util.List;

public class BSRBiomeGroup {
    private static List<BSRBiomeGroup> BSRBiomeGroups = new ArrayList<BSRBiomeGroup>();
    private static Int2ObjectMap<BSRBiomeGroup> reverseMap = new Int2ObjectArrayMap<BSRBiomeGroup>();
    private final int id;
    private double weightTotal = 0;
    private List<WeightedBiomeEntry> entries = new ArrayList<WeightedBiomeEntry>();

    public BSRBiomeGroup(int id) {
        this.id = id;
    }

    public static int pickRandomBiomeGroup(LayerRandomnessSource rand) {
        return BSRBiomeGroups.get(rand.nextInt(BSRBiomeGroups.size())).id;
    }

    public static BSRBiomeGroup getById(int id) {
        return reverseMap.get(id);
    }

    public static BSRBiomeGroup addBiomeGroup(BSRBiomeGroup group) {
        BSRBiomeGroups.add(group);
        reverseMap.put(group.id, group);
        return group;
    }

    public int getId() {
        return id;
    }

    public Biome pickBiome(LayerRandomnessSource random) {
        double randVal = (double) random.nextInt(Integer.MAX_VALUE) * weightTotal / (double) Integer.MAX_VALUE;
        int i = -1;
        while (randVal >= 0) {
            ++i;
            randVal -= entries.get(i).weight;
        }
        return entries.get(i).biome;
    }

    public BSRBiomeGroup addBiome(Biome biome, double weight) {
        this.weightTotal += weight;
        this.entries.add(new WeightedBiomeEntry(biome, weight));

        return this;
    }

    static class WeightedBiomeEntry {
        final Biome biome;
        final double weight;

        WeightedBiomeEntry(Biome biome, double weight) {
            this.biome = biome;
            this.weight = weight;
        }
    }
}
