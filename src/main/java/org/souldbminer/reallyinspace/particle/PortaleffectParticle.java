
package org.souldbminer.reallyinspace.particle;

@RisModElements.ModElement.Tag
public class PortaleffectParticle extends RisModElements.ModElement{

	public static final BasicParticleType particle = new BasicParticleType(false);

	public PortaleffectParticle (RisModElements instance) {
		super(instance, 68);

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent public void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
		event.getRegistry().register(particle.setRegistryName("portaleffect"));
	}

	@OnlyIn(Dist.CLIENT) @SubscribeEvent public void registerParticle(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
	}

	@OnlyIn(Dist.CLIENT) private static class CustomParticle extends SpriteTexturedParticle {

		private final IAnimatedSprite spriteSet;

		protected CustomParticle(World world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
			super(world, x, y, z);
			this.spriteSet = spriteSet;

			this.setSize((float) 0.2, (float) 0.2);
			this.particleScale *= (float) 1;

			this.maxAge = 7;

			this.particleGravity = (float) 0;
			this.canCollide = true;

			this.motionX = vx * 1;
			this.motionY = vy * 1;
			this.motionZ = vz * 1;

			this.selectSpriteRandomly(spriteSet);
		}


		@Override public IParticleRenderType getRenderType() {
			return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
		}

		@Override public void tick() {
			super.tick();


		}

	}

	@OnlyIn(Dist.CLIENT) private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public CustomParticleFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

}
