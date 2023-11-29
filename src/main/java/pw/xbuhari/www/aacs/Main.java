package pw.xbuhari.www.aacs;

import org.bukkit.plugin.java.JavaPlugin;
import pw.xbuhari.www.aacs.cmds.AacsCMD;
import pw.xbuhari.www.aacs.db.AfkDB;
import pw.xbuhari.www.aacs.listeners.ChatListener;
import pw.xbuhari.www.aacs.listeners.LoginListener;
import pw.xbuhari.www.aacs.listeners.MoveListener;

public class Main extends JavaPlugin {

    private static Main plugin;

    private AfkDB afkDB;

    @Override
    public void onEnable() {
        plugin = this;
        this.setup();
    }

    public void reload() {
        this.saveDefaultConfig();
        this.reloadConfig();
    }

    private void setup() {
        this.afkDB = new AfkDB();
        this.saveDefaultConfig();
        getCommand("aacs").setExecutor(new AacsCMD());
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new LoginListener(), this);
        getServer().getPluginManager().registerEvents(new MoveListener(), this);
        this.getLogger().info("Loaded successfully.");
        this.getLogger().info("If you have any questions, contact me on Discord: xbuhari");

    }

    public AfkDB getAfkDB() {
        return afkDB;
    }

    public static Main getPlugin() {
        return plugin;
    }
}
