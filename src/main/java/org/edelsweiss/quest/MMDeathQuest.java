package org.edelsweiss.quest;

import net.advancedplugins.bp.impl.actions.containers.ExternalActionContainer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MMDeathQuest extends ExternalActionContainer {
    public MMDeathQuest(JavaPlugin plugin) {
        super(plugin, "mmstats");
    }

    public void onPlayerDeath(Player player) {
        if (player == null) return;

        Bukkit.getLogger().info("DEBUG: Death battle pass triggered");

        super.executionBuilder("death")
                .player(player)
                .progressSingle()
                .buildAndExecute();
    }
}
