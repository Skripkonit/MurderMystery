package org.edelsweiss.quest;

import net.advancedplugins.bp.impl.actions.containers.ExternalActionContainer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MMWinQuest extends ExternalActionContainer {
    public MMWinQuest(JavaPlugin plugin) {
        super(plugin, "mmstats");
    }

    // Этот метод вызывается из слушателя при победе
    public void onPlayerWin(Player player) {
        if (player == null) return;

        super.executionBuilder("win")
                .player(player)
                .progressSingle() // +1 к прогрессу
                .buildAndExecute();
    }
}
