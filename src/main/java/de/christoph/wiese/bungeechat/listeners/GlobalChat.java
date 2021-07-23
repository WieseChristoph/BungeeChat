package de.christoph.wiese.bungeechat.listeners;

import de.christoph.wiese.bungeechat.BungeeChat;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class GlobalChat implements Listener {
    BungeeChat main;

    public GlobalChat(BungeeChat main) {
        this.main = main;
    }

    @EventHandler
    public void onChatEvent(ChatEvent e) {
        if(e.getSender() instanceof ProxiedPlayer && !e.isCommand()) {
            ProxiedPlayer player = (ProxiedPlayer) e.getSender();
            Server pServer = ProxyServer.getInstance().getPlayer(player.getUniqueId()).getServer();
            main.sendToOthers(
                    pServer,
                    new ComponentBuilder(ChatColor.GOLD + "[" + ChatColor.BLUE + pServer.getInfo().getName() + ChatColor.GOLD + "] " + ChatColor.WHITE + "<" + player.getDisplayName() + "> " + e.getMessage()).create()
            );
        }
    }
}
