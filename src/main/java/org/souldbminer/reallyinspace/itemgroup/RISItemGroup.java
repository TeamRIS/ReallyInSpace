
package org.souldbminer.reallyinspace.itemgroup;

import org.souldbminer.reallyinspace.block.PortalBlock;
import org.souldbminer.reallyinspace.RisModElements;

@RisModElements.ModElement.Tag
public class RISItemGroup extends RisModElements.ModElement {
	public RISItemGroup(RisModElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabris") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PortalBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
