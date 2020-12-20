
package org.souldbminer.reallyinspace.item;

@RisModElements.ModElement.Tag public class ItemFixerItem extends RisModElements.ModElement{

	@ObjectHolder("ris:item_fixer")
	public static final Item block = null;

	public ItemFixerItem(RisModElements instance) {
		super(instance, 247);

	}


	@Override public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties()
					.group(RISItemGroup.tab)
					.maxStackSize(64)
					.rarity(Rarity.EPIC)
			);
			setRegistryName("item_fixer");
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




		@Override public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Turns Items into Blocks"));
		}

		@Override public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();


    {
		Map<String, Object> $_dependencies = new HashMap<>();

	    	    $_dependencies.put("x",x);
	    	    $_dependencies.put("y",y);
	    	    $_dependencies.put("z",z);
	    	    $_dependencies.put("world",world);


        ItemConverterProcedure.executeProcedure($_dependencies);
	}
			return ar;
		}









	}


}
