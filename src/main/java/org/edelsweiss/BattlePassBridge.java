package org.edelsweiss;

import io.github.battlepass.BattlePlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.edelsweiss.quest.*;

public class BattlePassBridge {
  private final JavaPlugin plugin;
  private boolean enabled;

  public BattlePassBridge(JavaPlugin plugin) {
    this.plugin = plugin;
  }

  public void setup() {
    if (!Bukkit.getPluginManager().isPluginEnabled("BattlePass")) {
      enabled = false;
      return;
    }

    BattlePlugin.getPlugin().getActionRegistry().quest(MMDeathQuest::new);
    BattlePlugin.getPlugin().getActionRegistry().quest(MMKillQuest::new);
    BattlePlugin.getPlugin().getActionRegistry().quest(MMGoldQuest::new);
    BattlePlugin.getPlugin().getActionRegistry().quest(MMWinQuest::new);

    enabled = true;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void win(org.bukkit.entity.Player p) {
    if (!enabled || p == null) return;
    new MMWinQuest(plugin).onPlayerWin(p);
  }

  public void kill(org.bukkit.entity.Player p) {
    if (!enabled || p == null) return;
    new MMKillQuest(plugin).onPlayerKill(p);
  }

  public void death(org.bukkit.entity.Player p) {
    if (!enabled || p == null) return;
    new MMDeathQuest(plugin).onPlayerDeath(p);
  }

  public void gold(org.bukkit.entity.Player p, int amount) {
    if (!enabled || p == null || amount <= 0) return;
    new MMGoldQuest(plugin).onPlayerCollectGold(p, amount);
  }
}
