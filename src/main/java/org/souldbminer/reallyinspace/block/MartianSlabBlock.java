

package org.souldbminer.reallyinspace.block;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag
public class MartianSlabBlock extends RisModElements.ModElement {

	@ObjectHolder("ris:martian_slab")
	public static final Block block = null;


	public MartianSlabBlock (RisModElements instance) {
		super(instance, 19);

	}

	@Override public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties()
		                             .group(RISItemGroup.tab)
		                             ).setRegistryName(block.getRegistryName()));
	}



	public static class CustomBlock extends
				SlabBlock
 {


		public CustomBlock() {
			super(

			Block.Properties.create(Material.WOOD)
					.sound(SoundType.WOOD)
					.hardnessAndResistance(2f, 3f)
					.lightValue(0)
			);


			setRegistryName("martian_slab");
		}
















		@Override public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
		}










			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
			}













	}



}