
package org.souldbminer.reallyinspace.painting;

@RisModElements.ModElement.Tag
public class RocketpaintingPainting extends RisModElements.ModElement{

	public RocketpaintingPainting (RisModElements instance) {
		super(instance, 75);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}
	
	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("rocketpainting"));
	}

}
