package pw.xbuhari.www.aacs;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {

    public static String clr(String txt) {
        return ChatColor.translateAlternateColorCodes('&', txt);
    }

    public static void sndList(CommandSender player, String cnf, String[]... replaces) {
        if (!Main.getPlugin().getConfig().isSet(cnf)) {
            return;
        }
        for (String _msg : Main.getPlugin().getConfig().getStringList(cnf)) {
            if (replaces.length>0) {
                String msg = clr(_msg);
                for (String[] _replaces : replaces) {
                    msg = msg.replace(_replaces[0], _replaces[1]);
                }
                player.sendMessage(msg);
                continue;
            }
            player.sendMessage(clr(_msg));
        }
    }

}
