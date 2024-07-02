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
                String commandBefore = "skin set " + playerName + " " + skinUrl + ".png";
                String commandNow = "skin set " + skinUrl + " " + playerName + ".png";
                
                boolean beforeCommand = plugin.getConfigManager().getBoolean("use-ancient-command");
                
                if (!beforeCommand) {
                plugin.getProxy().getPluginManager().dispatchCommand(plugin.getProxy().getConsole(), commandNow);
                } else {
                plugin.getProxy().getPluginManager().dispatchCommand(plugin.getProxy().getConsole(), commandBefore);
                }

                if (plugin.getConfigManager().getBoolean("send_success_message")) {
                    String successMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfigManager().getString("success_message"));
                    player.sendMessage(successMessage);
                }

                if (plugin.getConfigManager().getBoolean("send_console_logs")) {
                    plugin.getLogger().info("Skin of player " + playerName + " update with success !");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You have not the permission for this.");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Only online players can be use that command !");
        }
    }
}
