package pw.xbuhari.www.aacs.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pw.xbuhari.www.aacs.Main;
import pw.xbuhari.www.aacs.Utils;

public class AacsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
        if (sender.isOp() || sender.hasPermission("aacs.admin")) {
            if (args.length != 1) {
                Utils.sndList(sender, "lang.aacs_command_usage");
                return false;
            }
            if (!args[0].equalsIgnoreCase("reload")) {
                Utils.sndList(sender, "lang.aacs_command_usage");
                return false;
            }
            Main.getPlugin().reload();
            Utils.sndList(sender, "lang.aacs_reloaded_message");
            return false;
        }
        Utils.sndList(sender, "lang.permission_error_message");
        return false;
    }
}
