

package org.souldbminer.reallyinspace.block;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag
public class MercsoilBlock extends RisModElements.ModElement {

	@ObjectHolder("ris:mercsoil")
	public static final Block block = null;


	public MercsoilBlock (RisModElements instance) {
		super(instance, 13);

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
					.sound(SoundType.GROUND)
					.hardnessAndResistance(1f, 10f)
					.lightValue(0)
			);


			setRegistryName("mercsoil");
		}


























			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}













	}



}
