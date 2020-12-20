

package org.souldbminer.reallyinspace.block;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag
public class GalaxiumBlockBlock extends RisModElements.ModElement {

	@ObjectHolder("ris:galaxium_block")
	public static final Block block = null;


	public GalaxiumBlockBlock (RisModElements instance) {
		super(instance, 23);

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

			Block.Properties.create(Material.IRON)
					.sound(SoundType.METAL)
					.hardnessAndResistance(5f, 10f)
					.lightValue(0)
					.harvestLevel(2)
					.harvestTool(ToolType.PICKAXE)
			);


			setRegistryName("galaxium_block");
		}













		@Override public boolean isBeaconBase(BlockState state, IWorldReader world, BlockPos pos, BlockPos beacon) {
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
