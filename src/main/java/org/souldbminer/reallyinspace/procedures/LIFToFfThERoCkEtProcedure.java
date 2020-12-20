package org.souldbminer.reallyinspace.procedures;

@RisModElements.ModElement.Tag
public class LIFToFfThERoCkEtProcedure extends RisModElements.ModElement{

	public LIFToFfThERoCkEtProcedure (RisModElements instance) {
		super(instance, 232);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure LIFToFfThERoCkEt!");
			return;
		}
		if(dependencies.get("x") == null) {
			if(!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure LIFToFfThERoCkEt!");
			return;
		}
		if(dependencies.get("y") == null) {
			if(!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure LIFToFfThERoCkEt!");
			return;
		}
		if(dependencies.get("z") == null) {
			if(!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure LIFToFfThERoCkEt!");
			return;
		}
		if(dependencies.get("world") == null) {
			if(!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure LIFToFfThERoCkEt!");
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

		if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.LEVITATION,(int) 3600,(int) 3, (true), (true)));if(!world.getWorld().isRemote && world.getWorld().getServer() != null) {
		world.getWorld().getServer().getCommandManager().handleCommand(
			new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO,
				(ServerWorld) world, 4, "", new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(), "give @p ris:rc");
}

	}

	

}
