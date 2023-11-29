package pw.xbuhari.www.aacs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import pw.xbuhari.www.aacs.Main;

import java.util.UUID;

public class LoginListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        if (!e.getResult().equals(PlayerLoginEvent.Result.ALLOWED)) {
            return;
        }
        if (e.getPlayer().isOp() || e.getPlayer().hasPermission("aacs.bypass")) {
            return;
        }
        UUID playerUUID = e.getPlayer().getUniqueId();
        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> Main.getPlugin().getAfkDB().addPlayer(playerUUID), Main.getPlugin().getConfig().getLong("settings.login_after_ticks"));
    }
}
