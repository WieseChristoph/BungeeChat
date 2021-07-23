package de.christoph.wiese.bungeechat.listeners;

import de.christoph.wiese.bungeechat.BungeeChat;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.event.EventHandler;

public class GlobalDisconnect implements Listener {
    BungeeChat main;

    public GlobalDisconnect(BungeeChat main) {
        this.main = main;
    }

    @EventHandler
    public void onServerDisconnect(PlayerDisconnectEvent e) {
        main.sendToOthers(
                e.getPlayer().getServer(),
                new ComponentBuilder(e.getPlayer().getDisplayName() + " left the game").color(ChatColor.YELLOW).create()
        );
    }
}
