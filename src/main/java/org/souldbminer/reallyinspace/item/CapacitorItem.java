
package org.souldbminer.reallyinspace.item;

import org.souldbminer.reallyinspace.itemgroup.RISItemGroup;
import org.souldbminer.reallyinspace.RisModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@RisModElements.ModElement.Tag
public class CapacitorItem extends RisModElements.ModElement {
	@ObjectHolder("ris:capacitor")
	public static final Item block = null;
	public CapacitorItem(RisModElements instance) {
		super(instance, 226);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(RISItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("capacitor");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
