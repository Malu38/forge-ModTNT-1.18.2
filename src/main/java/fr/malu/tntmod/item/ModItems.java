package fr.malu.tntmod.item;

import fr.malu.tntmod.TNTMod;
import fr.malu.tntmod.item.custom.TNTArrowItem;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TNTMod.MODID);

    public static final RegistryObject<Item> TNT_NUGGET = ITEMS.register("tnt_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TNTMOD_TAB)));

    public static final RegistryObject<Item> TNT_ARROW = ITEMS.register("tnt_arrow",
            () -> new TNTArrowItem(new Item.Properties().tab(ModCreativeModTab.TNTMOD_TAB), 1.5f));

    public static final RegistryObject<Item> TNT_BOW = ITEMS.register("tnt_bow",
            () -> new BowItem(new Item.Properties().tab(ModCreativeModTab.TNTMOD_TAB).durability(500)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
