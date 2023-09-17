package fr.Boulldogo.AzuriomSkinApiBungeecord;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.event.EventHandler;

public class JoinListener implements Listener {

    private final Main plugin;

    public JoinListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLogin(PostLoginEvent event) {
        ProxiedPlayer player = event.getPlayer();
        String playerName = player.getName();

        String skinUrl = plugin.getConfigManager().getString("skin_api_url").replace("{player}", playerName);

        String command = "skin set " + playerName + " " + skinUrl;
        plugin.getProxy().getPluginManager().dispatchCommand(plugin.getProxy().getConsole(), command);

        if (plugin.getConfigManager().getBoolean("send_success_message")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfigManager().getString("success_message")));
        }

        if (plugin.getConfigManager().getBoolean("send_console_logs")) {
            plugin.getLogger().info(ChatColor.translateAlternateColorCodes('&', "Skin de " + playerName + " changé avec succès."));
        }
    }
}
