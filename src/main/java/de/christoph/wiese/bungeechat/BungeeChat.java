package de.christoph.wiese.bungeechat;

import de.christoph.wiese.bungeechat.listeners.GlobalChat;
import de.christoph.wiese.bungeechat.listeners.GlobalDisconnect;
import de.christoph.wiese.bungeechat.listeners.GlobalJoin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Plugin;

public final class BungeeChat extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getProxy().getPluginManager().registerListener(this, new GlobalChat(this));
        getProxy().getPluginManager().registerListener(this, new GlobalJoin(this));
        getProxy().getPluginManager().registerListener(this, new GlobalDisconnect(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void sendToOthers(Server excludedServer, BaseComponent[] message) {
        // get all servers as a stream
        getProxy().getServersCopy().values().stream()
                // remove server of the connected player
                .filter(serverInfo -> !serverInfo.getName().equals(excludedServer.getInfo().getName()))
                // get all players and iterate trough them and send them the message
                .forEach(serverInfo -> serverInfo.getPlayers().stream()
                        .forEach(proxiedPlayer -> proxiedPlayer.sendMessage(ChatMessageType.CHAT, message)
                        )
                );
    }
}
