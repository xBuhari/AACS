package pw.xbuhari.www.aacs.listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pw.xbuhari.www.aacs.Main;

import java.util.HashMap;
import java.util.UUID;

public class MoveListener implements Listener {
    private final HashMap<UUID, Location> firstLocations;

    public MoveListener() {
        this.firstLocations = new HashMap<>();
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.isCancelled()) {
            return;
        }
        UUID playerUUID = e.getPlayer().getUniqueId();
        if (!Main.getPlugin().getAfkDB().hasPlayer(playerUUID)) {
            return;
        }
        if (!this.firstLocations.containsKey(playerUUID)) {
            this.firstLocations.put(playerUUID, e.getTo());
            return;
        }
        if (this.checkLocations(playerUUID, e.getTo())) {
            Main.getPlugin().getAfkDB().remPlayer(playerUUID);
            this.firstLocations.remove(playerUUID);
        }
    }

    private boolean checkLocations(UUID player, Location loc) {
        Location firstLoc = this.firstLocations.get(player);
        if (firstLoc == null || loc == null) {
            return false;
        }
        if (!firstLoc.getWorld().getName().equalsIgnoreCase(loc.getWorld().getName())) {
            return true;
        }
        return firstLoc.distance(loc) >= Main.getPlugin().getConfig().getDouble("settings.how_many_blocks_move_needed", 1.0);
    }

}
