package pw.xbuhari.www.aacs.db;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class AfkDB {
    private final HashSet<UUID> afkPlayers;

    public AfkDB() {
        this.afkPlayers = new HashSet<>();
    }

    public void addPlayer(UUID player) {
        this.afkPlayers.add(player);
    }

    public void remPlayer(UUID player) {
        this.afkPlayers.remove(player);
    }

    public HashSet<UUID> getAfkPlayers() {
        return afkPlayers;
    }
}
