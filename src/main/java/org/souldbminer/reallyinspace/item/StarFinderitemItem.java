
package org.souldbminer.reallyinspace.item;

@RisModElements.ModElement.Tag public class StarFinderitemItem extends RisModElements.ModElement{

	@ObjectHolder("ris:star_finderitem")
	public static final Item block = null;

	public StarFinderitemItem(RisModElements instance) {
		super(instance, 238);

	}


	@Override public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties()
					.group(RISItemGroup.tab)
					.maxStackSize(64)
					.rarity(Rarity.RARE)
			);
			setRegistryName("star_finderitem");
		}


		@Override public int getItemEnchantability() {
			return 0;
		}

		@Override public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}


		@Override @OnlyIn(Dist.CLIENT) public boolean hasEffect(ItemStack itemstack) {
			return true;
		}












	}


}
