package pw.xbuhari.www.aacs.listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.UUID;

public class MoveListener implements Listener {

    private HashMap<UUID, Location> firstLocations;

    public MoveListener() {
        this.firstLocations = new HashMap<>();
    }


    @EventHandler
    public void onMove(PlayerMoveEvent e) {

    }

}
