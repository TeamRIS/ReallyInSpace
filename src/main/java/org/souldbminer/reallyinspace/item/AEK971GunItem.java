
package org.souldbminer.reallyinspace.item;

@RisModElements.ModElement.Tag public class AEK971GunItem extends RisModElements.ModElement{

	@ObjectHolder("ris:aek_971_gun")
	public static final Item block = null;

	public AEK971GunItem(RisModElements instance) {
		super(instance, 250);

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
			setRegistryName("aek_971_gun");
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

			@Override public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
				Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot);
				if (slot == EquipmentSlotType.MAINHAND) {
					multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "item_damage", (double) -2, AttributeModifier.Operation.ADDITION));
					multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "item_attack_speed", -2.4, AttributeModifier.Operation.ADDITION));
				}
				return multimap;
			}



		@Override public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("From Battlefield Bad Company 1. Shoots Bullets"));
		}










	}


}
