
package org.souldbminer.reallyinspace.item;

@RisModElements.ModElement.Tag public class RantiumDustItem extends RisModElements.ModElement{

	@ObjectHolder("ris:rantium_dust")
	public static final Item block = null;

	public RantiumDustItem(RisModElements instance) {
		super(instance, 94);

	}


	@Override public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties()
					.group(ItemGroup.MISC)
					.maxStackSize(64)
					.rarity(Rarity.COMMON)
			);
			setRegistryName("rantium_dust");
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