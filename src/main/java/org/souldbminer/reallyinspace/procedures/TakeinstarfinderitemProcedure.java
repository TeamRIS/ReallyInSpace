package org.souldbminer.reallyinspace.procedures;

@RisModElements.ModElement.Tag
public class TakeinstarfinderitemProcedure extends RisModElements.ModElement{

	public TakeinstarfinderitemProcedure (RisModElements instance) {
		super(instance, 237);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Takeinstarfinderitem!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if(entity instanceof ServerPlayerEntity) {
	Container _current = ((ServerPlayerEntity) entity).openContainer;
	if(_current instanceof Supplier) {
		Object invobj = ((Supplier) _current).get();
		if(invobj instanceof Map) {
			((Slot) ((Map) invobj).get((int)(1))).putStack(ItemStack.EMPTY);
			_current.detectAndSendChanges();
		}
	}
}

	}

	

}
