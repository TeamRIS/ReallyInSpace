
package org.souldbminer.reallyinspace.world.biome;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag public class VenusBiome extends RisModElements.ModElement{

	@ObjectHolder("ris:venus")
	public static final CustomBiome biome = null;

	public VenusBiome (RisModElements instance) {
		super(instance, 57);
	}

	@Override public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override public void init(FMLCommonSetupEvent event) {
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f)
				.depth(0.1f)
				.scale(0.2f)
				.temperature(0.5f)
				.precipitation(Biome.RainType.RAIN)
				.category(Biome.Category.NONE)
				.waterColor(4159204)
				.waterFogColor(329011)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
				Blocks.MAGMA_BLOCK.getDefaultState(), CompressedmagmaBlock.block.getDefaultState(), CompressedmagmaBlock.block.getDefaultState()))
			);

			setRegistryName("venus");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addOres(this);












			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));

			this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(20, 0.3D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));








		}




	}


}