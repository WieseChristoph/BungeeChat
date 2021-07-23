package de.christoph.wiese.bungeechat.listeners;

import de.christoph.wiese.bungeechat.BungeeChat;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.event.EventHandler;

public class GlobalJoin implements Listener {
    BungeeChat main;

    public GlobalJoin(BungeeChat main) {
        this.main = main;
    }

    @EventHandler
    public void onServerConnected(ServerConnectedEvent e) {
        main.sendToOthers(
                e.getServer(),
                new ComponentBuilder(ChatColor.YELLOW + e.getPlayer().getDisplayName() + " joined "+ ChatColor.RED + e.getServer().getInfo().getName()).create()
        );
    }
}
