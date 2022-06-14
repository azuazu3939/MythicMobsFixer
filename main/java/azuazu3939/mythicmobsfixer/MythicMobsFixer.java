package azuazu3939.mythicmobsfixer;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MythicMobsFixer extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerEvent(), this);
        pluginManager.registerEvents(new PlayerJoinSetupEvent(), this);
    }
}


