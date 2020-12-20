

package org.souldbminer.reallyinspace.block;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag
public class CH16LogBlock extends RisModElements.ModElement {

	@ObjectHolder("ris:ch_16_log")
	public static final Block block = null;


	public CH16LogBlock (RisModElements instance) {
		super(instance, 167);

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

			Block.Properties.create(Material.WOOD)
					.sound(SoundType.WOOD)
					.hardnessAndResistance(2f, 2f)
					.lightValue(0)
					.harvestLevel(0)
					.harvestTool(ToolType.AXE)
			);


			setRegistryName("ch_16_log");
		}
















		@Override public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
		}






        @Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
		}




			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}













	}



}
