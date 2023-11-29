package pw.xbuhari.www.aacs;

import org.bukkit.ChatColor;

public class Utils {

    public static String cnf(String section) {
        return clr(Main.getPlugin().getConfig().getString(section, ""));
    }

    public static String clr(String txt) {
        return ChatColor.translateAlternateColorCodes('&', txt);
    }

}
