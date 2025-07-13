package org.edelsweiss.quest;

import net.advancedplugins.bp.impl.actions.containers.ExternalActionContainer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MMKillQuest extends ExternalActionContainer {
    public MMKillQuest(JavaPlugin plugin) {
        super(plugin, "mmstats");
    }

    public void onPlayerKill(Player player) {
        if (player == null) return;

        super.executionBuilder("kill")
                .player(player)
                .progressSingle()
                .buildAndExecute();
    }
}
