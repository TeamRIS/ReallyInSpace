

package org.souldbminer.reallyinspace.block;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag
public class CompressedmagmaBlock extends RisModElements.ModElement {

	@ObjectHolder("ris:compressedmagma")
	public static final Block block = null;


	public CompressedmagmaBlock (RisModElements instance) {
		super(instance, 24);

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
					.hardnessAndResistance(1f, 10f)
					.lightValue(0)
			);


			setRegistryName("compressedmagma");
		}



















		@Override public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
        	return MaterialColor.ORANGE_TERRACOTTA;
    	}







			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}













	}



}
