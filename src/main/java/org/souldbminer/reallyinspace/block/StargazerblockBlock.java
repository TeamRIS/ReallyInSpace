

package org.souldbminer.reallyinspace.block;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag
public class StargazerblockBlock extends RisModElements.ModElement {

	@ObjectHolder("ris:stargazerblock")
	public static final Block block = null;


	public StargazerblockBlock (RisModElements instance) {
		super(instance, 236);

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
					.hardnessAndResistance(1f, 10f)
					.lightValue(0)
			);


			setRegistryName("stargazerblock");
		}


























			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}













	}



}
