package noessentials;

import noessentials.command.Command_Enderchest;
import noessentials.command.Command_Feed;
import noessentials.command.Command_Gamemode;
import noessentials.command.Command_Heal;
import noessentials.external.InitializeManager;
import noessentials.listener.Event_Join;
import noessentials.utils.Data;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This is the main class of the plugin
 *
 * @author KeksGauner
 */
public final class Main extends JavaPlugin {
    private static Main instance;
    private static JavaPlugin plugin;

    public static JavaPlugin getPlugin() { return plugin; }
    public static Main getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this; plugin = this;
        Data.init();

        InitializeManager im = new InitializeManager();
        // Register a Command
        String pluginPrefix = "noessentials";
        im.registerCommand(pluginPrefix, new Command_Gamemode("gm"));
        im.registerCommand(pluginPrefix, new Command_Enderchest("ec"));
        im.registerCommand(pluginPrefix, new Command_Feed("feed"));
        im.registerCommand(pluginPrefix, new Command_Heal("heal"));

        // Register a Event
        im.registerEvent(this, new Event_Join());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
