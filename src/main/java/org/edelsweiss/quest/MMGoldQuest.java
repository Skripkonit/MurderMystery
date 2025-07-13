package org.edelsweiss.quest;

import net.advancedplugins.bp.impl.actions.containers.ExternalActionContainer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MMGoldQuest extends ExternalActionContainer {

    public MMGoldQuest(JavaPlugin plugin) {
        super(plugin, "mmstats");
    }

    public void onPlayerCollectGold(Player player, int amount) {
        if (player == null || amount <= 0) return;

        super.executionBuilder("gold")
                .player(player)
                .progress(amount) // +amount к прогрессу
                .buildAndExecute();
    }
}