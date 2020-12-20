

package org.souldbminer.reallyinspace.block;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag
public class GalaxiumOreBlock extends RisModElements.ModElement {

	@ObjectHolder("ris:galaxium_ore")
	public static final Block block = null;


	public GalaxiumOreBlock (RisModElements instance) {
		super(instance, 22);

	}

	@Override public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties()
		                             .group(RISItemGroup.tab)
		                             ).setRegistryName(block.getRegistryName()));
	}



	public static class CustomBlock extends
				Block
 {


		public CustomBlock() {
			super(

			Block.Properties.create(Material.ROCK)
					.sound(SoundType.STONE)
					.hardnessAndResistance(3f, 5f)
					.lightValue(0)
					.harvestLevel(2)
					.harvestTool(ToolType.PICKAXE)
			);


			setRegistryName("galaxium_ore");
		}


























			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(GalaxiumDustItem.block, (int)(3)));
			}













	}


	@Override public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {

			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new OreFeature(OreFeatureConfig::deserialize) {
				@Override public boolean place(IWorld world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
					DimensionType dimensionType = world.getDimension().getType();
					boolean dimensionCriteria = false;

							if(dimensionType == MercdimDimension.type)
								dimensionCriteria = true;

					if(!dimensionCriteria)
						return false;


					return super.place(world, generator, rand, pos, config);
			}}.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("galaxium_ore", "galaxium_ore", blockAt -> {
						boolean blockCriteria = false;
						if(blockAt.getBlock() == MercsoilBlock.block.getDefaultState().getBlock())
							blockCriteria = true;
						return blockCriteria;
					}), block.getDefaultState(), 1))
				.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 1, 1, 63)))
			);
		}
	}

}
