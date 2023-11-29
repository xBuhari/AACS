package pw.xbuhari.www.aacs;

import org.bukkit.plugin.java.JavaPlugin;
import pw.xbuhari.www.aacs.db.AfkDB;

public class Main extends JavaPlugin {

    private static Main plugin;

    private AfkDB afkDB;

    @Override
    public void onEnable() {
        plugin = this;
        this.afkDB = new AfkDB();
    }

    public AfkDB getAfkDB() {
        return afkDB;
    }

    public static Main getPlugin() {
        return plugin;
    }
}
