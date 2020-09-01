package me.noeffort.cookehcrafting.recipe;

import me.noeffort.cookehcrafting.CookehCrafting;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class CookehShapelessRecipe
{
    private static CookehShapelessRecipe instance;
    private ShapelessRecipe recipe;

    /*
    Design is very similar to CookehShapedRecipe.
    See that first, before exploring this class.
     */
    private CookehShapelessRecipe()
    {
        NamespacedKey key = new NamespacedKey(CookehCrafting.getInstance(), "recipe_cookeh_shapeless");
        // ... = new ShapelessRecipe(NamespacedKey, ItemStack -> result);
        this.recipe = new ShapelessRecipe(key, new ItemStack(Material.APPLE, 1));
        /*
        With shapeless recipes, you only need to
        define what items you need, not where to
        put them. Very easy!
         */
        this.recipe.addIngredient(Material.DIAMOND_HOE);
    }

    public ShapelessRecipe getRecipe()
    {
        return this.recipe;
    }

    public static CookehShapelessRecipe getInstance()
    {
        instance = (instance == null) ? new CookehShapelessRecipe() : instance;
        return instance;
    }
}
