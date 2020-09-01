/*
The package format is different depending
on who you work for. If it's a personal
or commission project, it is usually:
    me.<GitHub Username>.<Plugin Name>
If this is for a server or company, it is:
    <Top-Level Domain (com/net/org)>.<Website Name>.<Plugin Name>
    (org.hamsr.cookehcrafting) -> Equivalent for my domain
Since this project will not be displayed as
a project made by or for my server's domain, I
used the personal project format.
 */
package me.noeffort.cookehcrafting;

import me.noeffort.cookehcrafting.recipe.CookehShapedRecipe;
import me.noeffort.cookehcrafting.recipe.CookehShapelessRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

/*
The main class name should always match what
you intend to name the plugin. This is just
quality-of-life for other developers reading
your code. All main classes in Spigot-API
extend the JavaPlugin class.
 */
public class CookehCrafting extends JavaPlugin
{
    private static CookehCrafting instance;

    // This refers to the plugin.yml file
    protected PluginDescriptionFile description = this.getDescription();

    /*
    Any logic you want to do when the plugin
    starts loading. Usually good to send a
    message saying the plugin has started.
     */
    public void onEnable()
    {
        // First line, always
        instance = this;
        this.getLogger().info(description.getName() + " " + description.getVersion() + " enabled!");

        /*
        Always register recipes last if you intend
        to remove any default recipes from the game.
         */
        this.getServer().addRecipe(CookehShapedRecipe.getInstance().getRecipe());
        this.getServer().addRecipe(CookehShapelessRecipe.getInstance().getRecipe());
    }

    public void onDisable()
    {
        // Do this in case the plugin fails to load
        this.getServer().resetRecipes();

        // Last line, always
        instance = null;
    }

    /*
    This is a getter for the main class of the
    plugin. We assign the instance variable to
    'this' (the class) and create a getter here.
    This is a design format called the Singleton
    format - which is useful for classes you only
    want one instance of.
     */
    public static CookehCrafting getInstance()
    {
        return instance;
    }
}
