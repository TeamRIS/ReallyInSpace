

package org.souldbminer.reallyinspace.block;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag
public class CH15FenceBlock extends RisModElements.ModElement {

	@ObjectHolder("ris:ch_15_fence")
	public static final Block block = null;


	public CH15FenceBlock (RisModElements instance) {
		super(instance, 137);

	}

	@Override public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties()
		                             .group(RISItemGroup.tab)
		                             ).setRegistryName(block.getRegistryName()));
	}



	public static class CustomBlock extends
				FenceBlock
 {


		public CustomBlock() {
			super(

			Block.Properties.create(Material.WOOD)
					.sound(SoundType.WOOD)
					.hardnessAndResistance(2f, 3f)
					.lightValue(0)
			);


			setRegistryName("ch_15_fence");
		}

		@Override public boolean canConnect(BlockState state, boolean checkattach, Direction face) {
    	  boolean flag = state.getBlock() instanceof FenceBlock && state.getMaterial() == this.material;
    	  boolean flag1 = state.getBlock() instanceof FenceGateBlock && FenceGateBlock.isParallel(state, face);
    	  return !cannotAttach(state.getBlock()) && checkattach || flag || flag1;
   		}















		@Override public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
		}










			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}













	}



}
