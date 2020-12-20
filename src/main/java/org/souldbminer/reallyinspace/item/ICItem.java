
package org.souldbminer.reallyinspace.item;

@RisModElements.ModElement.Tag public class ICItem extends RisModElements.ModElement{

	@ObjectHolder("ris:ic")
	public static final Item block = null;

	public ICItem(RisModElements instance) {
		super(instance, 225);

	}


	@Override public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties()
					.group(RISItemGroup.tab)
					.maxStackSize(64)
					.rarity(Rarity.COMMON)
			);
			setRegistryName("ic");
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














	}


}
