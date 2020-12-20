

package org.souldbminer.reallyinspace.block;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag
public class CH14LeavesBlock extends RisModElements.ModElement {

	@ObjectHolder("ris:ch_14_leaves")
	public static final Block block = null;


	public CH14LeavesBlock (RisModElements instance) {
		super(instance, 118);

	}

	@Override public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties()
		                             .group(RISItemGroup.tab)
		                             ).setRegistryName(block.getRegistryName()));
	}



	public static class CustomBlock extends
				LeavesBlock
 {


		public CustomBlock() {
			super(

			Block.Properties.create(Material.LEAVES)
					.sound(SoundType.PLANT)
					.hardnessAndResistance(0.2f, 0.2f)
					.lightValue(0)
					.notSolid()
			);


			setRegistryName("ch_14_leaves");
		}
















		@Override public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 30;
		}










			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}













	}



}
