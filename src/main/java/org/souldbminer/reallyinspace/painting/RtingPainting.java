
package org.souldbminer.reallyinspace.painting;

@RisModElements.ModElement.Tag
public class RtingPainting extends RisModElements.ModElement{

	public RtingPainting (RisModElements instance) {
		super(instance, 77);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}
	
	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("rting"));
	}

}
