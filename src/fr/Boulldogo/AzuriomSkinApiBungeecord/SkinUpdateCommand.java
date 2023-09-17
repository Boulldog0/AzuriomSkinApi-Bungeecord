package fr.Boulldogo.AzuriomSkinApiBungeecord;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SkinUpdateCommand extends Command {

    private final Main plugin;

    public SkinUpdateCommand(Main plugin) {
        super("skin-update");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if (player.hasPermission("azuriomskinapi.skin-update")) { 
                String playerName = player.getName();
                String skinUrl = plugin.getConfigManager().getString("skin_api_url").replace("{player}", playerName);
                String commandToExecute = "skin set " + playerName + " " + skinUrl;

                plugin.getProxy().getPluginManager().dispatchCommand(plugin.getProxy().getConsole(), commandToExecute);

                if (plugin.getConfigManager().getBoolean("send_success_message")) {
                    String successMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfigManager().getString("success_message"));
                    player.sendMessage(successMessage);
                }

                if (plugin.getConfigManager().getBoolean("send_console_logs")) {
                    String logMessage = ChatColor.translateAlternateColorCodes('&', "Skin de " + playerName + " changé avec succès.");
                    plugin.getLogger().info(logMessage);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Seuls les joueurs peuvent utiliser cette commande !");
        }
    }
}