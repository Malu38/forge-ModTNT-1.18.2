package fr.malu.tntmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModTab {

    public static final CreativeModeTab TNTMOD_TAB = new CreativeModeTab("tntmod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.TNT);
        }
    };

}
