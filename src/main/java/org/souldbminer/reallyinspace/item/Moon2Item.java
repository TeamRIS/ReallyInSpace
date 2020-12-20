
package org.souldbminer.reallyinspace.item;

public class Moon2Item extends Item {

	@ObjectHolder("ris:moon_2")
	public static final Item block = null;

	public Moon2Item() {
		super(new Item.Properties().group(RISItemGroup.tab).maxDamage(64));
	}

	@Override public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity entity = context.getPlayer();
		BlockPos pos = context.getPos().offset(context.getFace());
		ItemStack itemstack = context.getItem();
		World world = context.getWorld();
		if (!entity.canPlayerEdit(pos, context.getFace(), itemstack)) {
			return ActionResultType.FAIL;
		} else {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			if (world.isAirBlock(pos) &&         true
)
				Moon2Dimension.portal.portalSpawn(world, pos);


			itemstack.damageItem(1, entity, c -> c.sendBreakAnimation(context.getHand()));
			return ActionResultType.SUCCESS;
		}
	}
}

