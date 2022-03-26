package fr.malu.tntmod.world.entity;

import fr.malu.tntmod.TNTMod;
import fr.malu.tntmod.world.entity.projectiles.TNTArrow;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, TNTMod.MODID);

    public static final RegistryObject<EntityType<TNTArrow>> TNT_ARROW = ENTITIES.register("tnt_arrow", () -> EntityType.Builder.<TNTArrow>of(TNTArrow::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(TNTMod.MODID, "tnt_arrow").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

}
