package me.noeffort.cookehcrafting.recipe;

import me.noeffort.cookehcrafting.CookehCrafting;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/*
The class name should be formatted to where
it's the name of the item in pascal case*, with
the word 'recipe' at the end. It also belongs
in its own package. Commands, EventHandlers and
more follow this same format.

https://www.chaseadams.io/posts/most-common-programming-case-types/
 */
public class CookehShapedRecipe
{
    private static CookehShapedRecipe instance;
    private ShapedRecipe recipe;

    /*
    A private constructor means that we won't be
    able to call ... = new CookehShapedRecipe()
    from outside of this class. This is ok since
    we use the Singleton design format here again.
     */
    private CookehShapedRecipe()
    {
        /*
        The key string should match the class name, but
        backwards and in snake case. All recipes require
        a NamespacedKey to go along with them.
         */
        NamespacedKey key = new NamespacedKey(CookehCrafting.getInstance(), "recipe_cookeh_shaped");
        // ... = new ShapedRecipe(NamespacedKey, ItemStack -> result);
        this.recipe = new ShapedRecipe(key, new ItemStack(Material.HAY_BLOCK, 1));

        // Letters here are up to you, try to make sense
        this.recipe.shape(" R ", "RPR", "CCC");
        this.recipe.setIngredient(' ', Material.AIR);
        this.recipe.setIngredient('R', Material.BLAZE_ROD);
        this.recipe.setIngredient('P', Material.BLAZE_POWDER);
        this.recipe.setIngredient('C', Material.COBBLESTONE);
    }

    public ShapedRecipe getRecipe()
    {
        return this.recipe;
    }

    public static CookehShapedRecipe getInstance()
    {
        /*
        This is an inline if statement. There are plenty of
        resources online about these, but the idea is:
        <variable to assign> = <condition> ? <if true> : <if false>;
        In this case, if instance is null we make a new CookehShapedRecipe,
        otherwise get the already-assigned instance;
         */
        instance = (instance == null) ? new CookehShapedRecipe() : instance;
        return instance;
    }
}
