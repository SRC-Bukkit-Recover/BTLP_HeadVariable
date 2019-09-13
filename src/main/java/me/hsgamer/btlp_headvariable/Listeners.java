package me.hsgamer.btlp_headvariable;

import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Listeners implements Listener {
    private HeadVariable instance = HeadVariable.getInstance();

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        instance.getTaskManager().addPlayer(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerDisconnectEvent event) {
        instance.getTaskManager().removePlayer(event.getPlayer());
    }
}
