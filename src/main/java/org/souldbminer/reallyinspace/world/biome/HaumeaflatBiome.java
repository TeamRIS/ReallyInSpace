
package org.souldbminer.reallyinspace.world.biome;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag public class HaumeaflatBiome extends RisModElements.ModElement{

	@ObjectHolder("ris:haumeaflat")
	public static final CustomBiome biome = null;

	public HaumeaflatBiome (RisModElements instance) {
		super(instance, 149);
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
				Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState(), Blocks.STRIPPED_SPRUCE_WOOD.getDefaultState(), Blocks.STRIPPED_SPRUCE_WOOD.getDefaultState()))
			);

			setRegistryName("haumeaflat");

			DefaultBiomeFeatures.addCarvers(this);






















		}




	}


}