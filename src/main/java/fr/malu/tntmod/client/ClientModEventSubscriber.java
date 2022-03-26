package fr.malu.tntmod.client;

import fr.malu.tntmod.TNTMod;
import fr.malu.tntmod.client.renderer.entity.TNTArrowRenderer;
import fr.malu.tntmod.world.entity.ModEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TNTMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityType.TNT_ARROW.get(), TNTArrowRenderer::new);
    }

}
