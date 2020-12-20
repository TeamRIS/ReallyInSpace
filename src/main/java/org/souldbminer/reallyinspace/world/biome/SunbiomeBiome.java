
package org.souldbminer.reallyinspace.world.biome;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag public class SunbiomeBiome extends RisModElements.ModElement{

	@ObjectHolder("ris:sunbiome")
	public static final CustomBiome biome = null;

	public SunbiomeBiome (RisModElements instance) {
		super(instance, 83);
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
				.temperature(2f)
				.precipitation(Biome.RainType.RAIN)
				.category(Biome.Category.NONE)
				.waterColor(4159204)
				.waterFogColor(329011)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
				CompressedmagmaBlock.block.getDefaultState(), CompressedmagmaBlock.block.getDefaultState(), CompressedmagmaBlock.block.getDefaultState()))
			);

			setRegistryName("sunbiome");























		}




	}


}
