
package org.souldbminer.reallyinspace.world.biome;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag public class CenturibiomeBiome extends RisModElements.ModElement{

	@ObjectHolder("ris:centuribiome")
	public static final CustomBiome biome = null;

	public CenturibiomeBiome (RisModElements instance) {
		super(instance, 86);
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
				.temperature(2f)
				.precipitation(Biome.RainType.NONE)
				.category(Biome.Category.NONE)
				.waterColor(4159204)
				.waterFogColor(329011)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
				Blocks.WHITE_CONCRETE.getDefaultState(), Blocks.LIGHT_BLUE_CONCRETE.getDefaultState(), Blocks.LIGHT_BLUE_CONCRETE.getDefaultState()))
			);

			setRegistryName("centuribiome");

			DefaultBiomeFeatures.addCarvers(this);






















		}




	}


}
