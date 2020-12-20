
package org.souldbminer.reallyinspace.command;

@RisModElements.ModElement.Tag
public class ReallyinspaceCommand extends RisModElements.ModElement{

	public ReallyinspaceCommand (RisModElements instance) {
		super(instance, 165);
	}

	@Override public void serverLoad(FMLServerStartingEvent event) {
		event.getCommandDispatcher().register(customCommand());
	}

	private LiteralArgumentBuilder<CommandSource> customCommand() {
        return LiteralArgumentBuilder.<CommandSource>literal("risdebug")
			.requires(s -> s.hasPermissionLevel(4))
			.then(Commands.argument("arguments", StringArgumentType.greedyString())
            .executes(this::execute)
        	)
            .executes(this::execute)
			;
    }

    private int execute(CommandContext<CommandSource> ctx) {
		ServerWorld world = ctx.getSource().getWorld();

		double x = ctx.getSource().getPos().getX();
		double y = ctx.getSource().getPos().getY();
		double z = ctx.getSource().getPos().getZ();

		Entity entity = ctx.getSource().getEntity();
		if (entity == null)
			entity = FakePlayerFactory.getMinecraft(world);

		HashMap<String, String> cmdparams = new HashMap<>();
		int[] index = { -1 };
		Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
			if(index[0] >= 0)
				cmdparams.put(Integer.toString(index[0]), param);
			index[0]++;
		});

    {
		Map<String, Object> $_dependencies = new HashMap<>();

	    	    $_dependencies.put("entity",entity);
	    	    $_dependencies.put("x",x);
	    	    $_dependencies.put("y",y);
	    	    $_dependencies.put("z",z);
	    	    $_dependencies.put("world",world);


        RiscommandProcedure.executeProcedure($_dependencies);
	}

		return 0;
	}

}
