package com.scattercat.pixelrealms.datagen;

import com.scattercat.pixelrealms.PixelRealms;
import com.scattercat.pixelrealms.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PixelRealms.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.LIGHTORB.get());
        basicItem(ModItems.RAW_LIGHTORB.get());

        basicItem(ModItems.CHISEL.get());
    }
}
