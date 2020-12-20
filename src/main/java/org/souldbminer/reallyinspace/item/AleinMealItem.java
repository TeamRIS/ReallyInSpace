
package org.souldbminer.reallyinspace.item;

@RisModElements.ModElement.Tag
public class AleinMealItem extends RisModElements.ModElement{

	@ObjectHolder("ris:alein_meal")
	public static final Item block = null;

	public AleinMealItem (RisModElements instance) {
		super(instance, 163);
	}

	@Override public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(RISItemGroup.tab).maxStackSize(64).rarity(Rarity.RARE)
				.food((new Food.Builder()).hunger(8).saturation(0.3f)
				
				
				.build()
			));
			setRegistryName("alein_meal");
		}



		@Override public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}






	}

}
