package fr.malu.tntmod.client.renderer.entity;

import fr.malu.tntmod.TNTMod;
import fr.malu.tntmod.item.ModItems;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TNTArrowRenderer extends ArrowRenderer {


    public TNTArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity pEntity) {
        Item referenceItem = ModItems.TNT_ARROW.get();
        return new ResourceLocation(TNTMod.MODID, "textures/entity/projectiles/tnt_arrow.png");
    }
}
