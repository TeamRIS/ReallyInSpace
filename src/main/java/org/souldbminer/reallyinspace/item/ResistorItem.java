
package org.souldbminer.reallyinspace.item;

@RisModElements.ModElement.Tag public class ResistorItem extends RisModElements.ModElement{

	@ObjectHolder("ris:resistor")
	public static final Item block = null;

	public ResistorItem(RisModElements instance) {
		super(instance, 227);

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
			setRegistryName("resistor");
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
