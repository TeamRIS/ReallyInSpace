
package org.souldbminer.reallyinspace.world.biome;

import net.minecraft.block.material.Material;

@RisModElements.ModElement.Tag public class MarsflatBiome extends RisModElements.ModElement{

	@ObjectHolder("ris:marsflat")
	public static final CustomBiome biome = null;

	public MarsflatBiome (RisModElements instance) {
		super(instance, 61);
	}

	@Override public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override public void init(FMLCommonSetupEvent event) {
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f)
				.depth(0.1f)
				.scale(0.2f)
				.temperature(0.5f)
				.precipitation(Biome.RainType.RAIN)
				.category(Biome.Category.NONE)
				.waterColor(4159204)
				.waterFogColor(329011)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
				MartianStoneBlock.block.getDefaultState(), MartianStoneBlock.block.getDefaultState(), MartianStoneBlock.block.getDefaultState()))
			);

			setRegistryName("marsflat");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);












			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));

			this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(20, 0.3D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));


				addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new CustomTreeFeature()
						.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MartianLogBlock.block.getDefaultState()), new SimpleBlockStateProvider(MartianLogBlock.block.getDefaultState()))).baseHeight(7).setSapling((net.minecraftforge.common.IPlantable)Blocks.JUNGLE_SAPLING).build())
						.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));






		}




	}

	static class CustomTreeFeature extends AbstractTreeFeature<BaseTreeFeatureConfig> {

		CustomTreeFeature() {
			super(BaseTreeFeatureConfig::deserialize);
		}

		@Override protected boolean place(IWorldGenerationReader worldgen, Random rand, BlockPos position, Set<BlockPos> changedBlocks, Set<BlockPos> changedBlocks2, MutableBoundingBox bbox, BaseTreeFeatureConfig conf) {
			if (!(worldgen instanceof IWorld))
				return false;

			IWorld world = (IWorld) worldgen;

			int height = rand.nextInt(5) + 7;
			boolean spawnTree = true;

			if (position.getY() >= 1 && position.getY() + height + 1 <= world.getHeight()) {
				for (int j = position.getY(); j <= position.getY() + 1 + height; j++) {
					int k = 1;

					if (j == position.getY())
						k = 0;

					if (j >= position.getY() + height - 1)
						k = 2;

					for (int px = position.getX() - k; px <= position.getX() + k && spawnTree; px++) {
						for (int pz = position.getZ() - k; pz <= position.getZ() + k && spawnTree; pz++) {
							if (j >= 0 && j < world.getHeight()) {
								if (!this.isReplaceable(world, new BlockPos(px, j, pz))) {
									spawnTree = false;
								}
							} else {
								spawnTree = false;
							}
						}
					}
				}
				if (!spawnTree) {
					return false;
				} else {
					Block ground = world.getBlockState(position.add(0, -1, 0)).getBlock();
					Block ground2 = world.getBlockState(position.add(0, -2, 0)).getBlock();
					if (!((ground == MartianStoneBlock.block.getDefaultState().getBlock()
							|| ground == MartianStoneBlock.block.getDefaultState().getBlock())
							&& (ground2 == MartianStoneBlock.block.getDefaultState().getBlock()
							|| ground2 == MartianStoneBlock.block.getDefaultState().getBlock())
						))
						return false;

					BlockState state = world.getBlockState(position.down());
					if (position.getY() < world.getHeight() - height - 1) {
						setTreeBlockState(changedBlocks, world, position.down(), MartianStoneBlock.block.getDefaultState(), bbox);

						for (int genh = position.getY() - 3 + height; genh <= position.getY() + height; genh++) {
							int i4 = genh - (position.getY() + height);
							int j1 = (int) (1 - i4 * 0.5);

							for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1) {
								for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2) {
									int j2 = i2 - position.getZ();

									if (Math.abs(position.getX()) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0) {
										BlockPos blockpos = new BlockPos(k1, genh, i2);
										state = world.getBlockState(blockpos);

										if (state.getBlock().isAir(state, world, blockpos)
												|| state.getMaterial().blocksMovement()
												|| state.isIn(BlockTags.LEAVES)
												|| state.getBlock() == MartianLeavesBlock.block.getDefaultState().getBlock()
												|| state.getBlock() == MartianLogBlock.block.getDefaultState().getBlock()) {
											setTreeBlockState(changedBlocks, world,
													blockpos, MartianLogBlock.block.getDefaultState(), bbox);
										}
									}
								}
							}
						}



						for (int genh = 0; genh < height; genh++) {
							BlockPos genhPos = position.up(genh);
							state = world.getBlockState(genhPos);

							setTreeBlockState(changedBlocks, world, genhPos, MartianLogBlock.block.getDefaultState(), bbox);

							if (state.getBlock().isAir(state, world, genhPos)
										|| state.getMaterial().blocksMovement()
										|| state.isIn(BlockTags.LEAVES)
										|| state.getBlock() == MartianLeavesBlock.block.getDefaultState().getBlock()
										|| state.getBlock() == MartianLogBlock.block.getDefaultState().getBlock()){

							}
						}


						if (rand.nextInt(4) == 0 && height > 5) {
							for (int hlevel = 0; hlevel < 2; hlevel++) {
								for (Direction Direction : Direction.Plane.HORIZONTAL) {
									if (rand.nextInt(4 - hlevel) == 0) {
										Direction dir = Direction.getOpposite();
										setTreeBlockState(changedBlocks, world, position.add(dir.getXOffset(), height - 5 + hlevel,
														dir.getZOffset()), MartianLeavesBlock.block.getDefaultState(), bbox);
									}
								}
							}
						}

						return true;
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		}

		private void addVines(IWorld world, BlockPos pos, Set<BlockPos> changedBlocks, MutableBoundingBox bbox) {
			setTreeBlockState(changedBlocks, world, pos, MartianLeavesBlock.block.getDefaultState(), bbox);
			int i = 5;
			for (BlockPos blockpos = pos.down(); world.isAirBlock(blockpos) && i > 0; --i) {
				setTreeBlockState(changedBlocks, world, blockpos, MartianLeavesBlock.block.getDefaultState(), bbox);
				blockpos = blockpos.down();
			}
		}

		private boolean canGrowInto(Block blockType) {
        	return blockType.getDefaultState().getMaterial() == Material.AIR ||
					blockType == MartianLogBlock.block.getDefaultState().getBlock() ||
					blockType == MartianLogBlock.block.getDefaultState().getBlock() ||
					blockType == MartianStoneBlock.block.getDefaultState().getBlock() ||
					blockType == MartianStoneBlock.block.getDefaultState().getBlock();
		}

		private boolean isReplaceable(IWorld world, BlockPos pos) {
			BlockState state = world.getBlockState(pos);
        	return state.getBlock().isAir(state, world, pos) || canGrowInto(state.getBlock()) || !state.getMaterial().blocksMovement();
		}

		private void setTreeBlockState(Set<BlockPos> changedBlocks, IWorldWriter world, BlockPos pos, BlockState state, MutableBoundingBox mbb) {
			super.func_227217_a_(world, pos, state, mbb);
			changedBlocks.add(pos.toImmutable());
		}

	}

}