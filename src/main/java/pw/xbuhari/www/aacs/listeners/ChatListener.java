package pw.xbuhari.www.aacs.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import pw.xbuhari.www.aacs.Main;
import pw.xbuhari.www.aacs.Utils;

import java.util.UUID;

public class ChatListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent e) {
        if (e.isCancelled()) {
            return;
        }
        UUID playerUUID = e.getPlayer().getUniqueId();
        Player player = e.getPlayer();
        if (!Main.getPlugin().getAfkDB().hasPlayer(playerUUID)) {
            return;
        }
        e.setCancelled(true);
        Utils.sndList(player, "lang.chat_protect_message", new String[]{"%block%", String.valueOf(Math.round(Main.getPlugin().getConfig().getDouble("settings.how_many_blocks_move_needed", 1.0)))});
    }
}
