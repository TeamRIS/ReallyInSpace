
package org.souldbminer.reallyinspace.world.biome;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag public class UranusbiomeBiome extends RisModElements.ModElement{

	@ObjectHolder("ris:uranusbiome")
	public static final CustomBiome biome = null;

	public UranusbiomeBiome (RisModElements instance) {
		super(instance, 69);
	}

	@Override public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override public void init(FMLCommonSetupEvent event) {
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0f)
				.depth(0.1f)
				.scale(0.2f)
				.temperature(-1f)
				.precipitation(Biome.RainType.NONE)
				.category(Biome.Category.NONE)
				.waterColor(4159204)
				.waterFogColor(329011)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
				Blocks.BLUE_ICE.getDefaultState(), Blocks.FROSTED_ICE.getDefaultState(), Blocks.FROSTED_ICE.getDefaultState()))
			);

			setRegistryName("uranusbiome");

			DefaultBiomeFeatures.addCarvers(this);








			this.addStructure(Feature.IGLOO.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));



			this.addStructure(Feature.OCEAN_RUIN.withConfiguration(new OceanRuinConfig(OceanRuinStructure.Type.COLD, 0.3F, 0.9F)));











		}




	}


}
