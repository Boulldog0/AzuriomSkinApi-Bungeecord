package fr.Boulldogo.AzuriomSkinApiBungeecord;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.common.io.ByteStreams;

public class Main extends Plugin {

    private String skinApiUrl;
    private Configuration config;

    @Override
    public void onEnable() {
        getLogger().info("Le plugin AzuriomSkinApi a été chargé.");

        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        File configFile = new File(getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            try {
                InputStream is = getResourceAsStream("config.yml");
                OutputStream os = new FileOutputStream(configFile);
                ByteStreams.copy(is, os);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        skinApiUrl = config.getString("skin_api_url");

        getProxy().getPluginManager().registerCommand(this, new SkinUpdateCommand(this));
        getProxy().getPluginManager().registerCommand(this, new ForceUpdateSkinCommand(this));
        getProxy().getPluginManager().registerListener(this, new JoinListener(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("Le plugin AzuriomSkinApi a été désactivé.");
    }

    public String getSkinApiUrl() {
        return skinApiUrl;
    }

    public Configuration getConfigManager() {
        return config;
    }
}
