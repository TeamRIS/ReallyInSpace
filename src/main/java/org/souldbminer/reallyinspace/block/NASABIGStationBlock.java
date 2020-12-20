

package org.souldbminer.reallyinspace.block;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag
public class NASABIGStationBlock extends RisModElements.ModElement {

	@ObjectHolder("ris:nasabig_station")
	public static final Block block = null;


	public NASABIGStationBlock (RisModElements instance) {
		super(instance, 212);

	}

	@Override public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties()
		                             .group(RISItemGroup.tab)
		                             ).setRegistryName(block.getRegistryName()));
	}



	public static class CustomBlock extends
				Block
 {


		public CustomBlock() {
			super(

			Block.Properties.create(Material.IRON)
					.sound(SoundType.METAL)
					.hardnessAndResistance(1f, 10f)
					.lightValue(0)
					.harvestLevel(1)
					.harvestTool(ToolType.PICKAXE)
			);


			setRegistryName("nasabig_station");
		}


























			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

		@Override public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean moving) {
			super.onBlockAdded(state, world, pos, oldState, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, this.tickRate(world));
		}


		@Override public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
			super.tick(state, world, pos, random);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
    {
		Map<String, Object> $_dependencies = new HashMap<>();

	    	    $_dependencies.put("x",x);
	    	    $_dependencies.put("y",y);
	    	    $_dependencies.put("z",z);
	    	    $_dependencies.put("world",world);


        Rmaker2Procedure.executeProcedure($_dependencies);
	}
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, this.tickRate(world));
		}

		@OnlyIn(Dist.CLIENT) @Override
		public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
			super.animateTick(state, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
if(        true
)
	for (int l = 0; l < 4; ++l) {
	    double d0 = (x + random.nextFloat());
	    double d1 = (y + random.nextFloat());
	    double d2 = (z + random.nextFloat());
	    int i1 = random.nextInt(2) * 2 - 1;
	    double d3 = (random.nextFloat() - 0.5D) * 0.5D;
	    double d4 = (random.nextFloat() - 0.5D) * 0.5D;
	    double d5 = (random.nextFloat() - 0.5D) * 0.5D;
	    world.addParticle(PortaleffectParticle.particle, d0, d1, d2, d3, d4, d5);
	}
		}









	}



}
