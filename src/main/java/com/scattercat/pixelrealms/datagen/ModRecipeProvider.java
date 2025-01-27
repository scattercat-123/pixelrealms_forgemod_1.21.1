package com.scattercat.pixelrealms.datagen;

import com.scattercat.pixelrealms.PixelRealms;
import com.scattercat.pixelrealms.block.ModBlocks;
import com.scattercat.pixelrealms.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> LIGHT_SMELTABLES = List.of(ModItems.LIGHTORB.get(),
                ModBlocks.LIGHT_ORE.get(), ModBlocks.LIGHT_DEEPSLATE_ORE.get());


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.LIGHTORB.get())
                .unlockedBy(getHasName(ModItems.LIGHTORB.get()), has(ModItems.LIGHTORB.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIGHTORB.get(), 9)
                .requires(ModBlocks.LIGHT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLOCK.get()), has(ModBlocks.LIGHT_BLOCK.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, LIGHT_SMELTABLES, RecipeCategory.MISC, ModItems.LIGHTORB.get(), 0.25f, 200, "light");
        oreBlasting(pRecipeOutput, LIGHT_SMELTABLES, RecipeCategory.MISC, ModItems.LIGHTORB.get(), 0.25f, 100, "light");

        stairBuilder(ModBlocks.LIGHT_STAIR.get(), Ingredient.of(ModItems.LIGHTORB.get())).group("light")
                .unlockedBy(getHasName(ModItems.LIGHTORB.get()), has(ModItems.LIGHTORB.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_SLAB.get(), ModItems.LIGHTORB.get());

        buttonBuilder(ModBlocks.LIGHT_BUTTON.get(), Ingredient.of(ModItems.LIGHTORB.get())).group("light")
                .unlockedBy(getHasName(ModItems.LIGHTORB.get()), has(ModItems.LIGHTORB.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.LIGHT_PRESSURE_PLATE.get(), ModItems.LIGHTORB.get());

        fenceBuilder(ModBlocks.LIGHT_FENCE.get(), Ingredient.of(ModItems.LIGHTORB.get())).group("light")
                .unlockedBy(getHasName(ModItems.LIGHTORB.get()), has(ModItems.LIGHTORB.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.LIGHT_FENCE_GATE.get(), Ingredient.of(ModItems.LIGHTORB.get())).group("light")
                .unlockedBy(getHasName(ModItems.LIGHTORB.get()), has(ModItems.LIGHTORB.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_WALL.get(), ModItems.LIGHTORB.get());

        doorBuilder(ModBlocks.LIGHT_DOOR.get(), Ingredient.of(ModItems.LIGHTORB.get())).group("light")
                .unlockedBy(getHasName(ModItems.LIGHTORB.get()), has(ModItems.LIGHTORB.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.LIGHT_TRAPDOOR.get(), Ingredient.of(ModItems.LIGHTORB.get())).group("light")
                .unlockedBy(getHasName(ModItems.LIGHTORB.get()), has(ModItems.LIGHTORB.get())).save(pRecipeOutput);

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, PixelRealms.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}