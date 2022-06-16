package azuazu3939.mythicmobsfixer;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.items.MythicItem;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.Objects;

public final class MythicMobsFixer extends JavaPlugin {

    private static MythicMobsFixer instance;

    public MythicMobsFixer() {
        instance = this;
    }

    public static MythicMobsFixer getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("mmf")).setExecutor(new MythicMobsFixerCommand());
        Objects.requireNonNull(this.getCommand("mmf")).setTabCompleter(new MythicMobsFixerTab());
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerEvent(), this);
        pluginManager.registerEvents(new PlayerJoinSetupEvent(), this);
        this.saveDefaultConfig();
        this.saveConfig();
    }

    @Override
    public void onDisable() {
        this.saveDefaultConfig();
        this.saveConfig();
    }
}
