
package org.souldbminer.reallyinspace.world.biome;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag public class MoonBiomesBiome extends RisModElements.ModElement{

	@ObjectHolder("ris:moon_biomes")
	public static final CustomBiome biome = null;

	public MoonBiomesBiome (RisModElements instance) {
		super(instance, 158);
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
				Blocks.POLISHED_ANDESITE.getDefaultState(), Blocks.BLUE_ICE.getDefaultState(), Blocks.BLUE_ICE.getDefaultState()))
			);

			setRegistryName("moon_biomes");

			DefaultBiomeFeatures.addCarvers(this);






















		}




	}


}
