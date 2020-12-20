
package org.souldbminer.reallyinspace.world.biome;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag public class MoonbiomeBiome extends RisModElements.ModElement{

	@ObjectHolder("ris:moonbiome")
	public static final CustomBiome biome = null;

	public MoonbiomeBiome (RisModElements instance) {
		super(instance, 91);
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
				.temperature(1f)
				.precipitation(Biome.RainType.NONE)
				.category(Biome.Category.NONE)
				.waterColor(4159204)
				.waterFogColor(329011)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
				MoonStoneBlock.block.getDefaultState(), MoonStoneBlock.block.getDefaultState(), MoonStoneBlock.block.getDefaultState()))
			);

			setRegistryName("moonbiome");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addOres(this);






















		}




	}


}
