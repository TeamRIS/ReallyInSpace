package org.souldbminer.reallyinspace.procedures;

@RisModElements.ModElement.Tag
public class OPenCraftinggridProcedure extends RisModElements.ModElement{

	public OPenCraftinggridProcedure (RisModElements instance) {
		super(instance, 252);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure OPenCraftinggrid!");
			return;
		}
		if(dependencies.get("x") == null) {
			if(!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure OPenCraftinggrid!");
			return;
		}
		if(dependencies.get("y") == null) {
			if(!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure OPenCraftinggrid!");
			return;
		}
		if(dependencies.get("z") == null) {
			if(!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure OPenCraftinggrid!");
			return;
		}
		if(dependencies.get("world") == null) {
			if(!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure OPenCraftinggrid!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				IWorld world = (IWorld) dependencies.get("world");

		{
	Entity _ent = entity;
	if(_ent instanceof ServerPlayerEntity) {
		BlockPos _bpos = new BlockPos((int)x,(int)y,(int)z);
		NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
			@Override public ITextComponent getDisplayName() {
				return new StringTextComponent("Rocketcreator");
			}
			@Override public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
				return new RocketcreatorGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
			}
		}, _bpos);
	}
}


	}

	

}