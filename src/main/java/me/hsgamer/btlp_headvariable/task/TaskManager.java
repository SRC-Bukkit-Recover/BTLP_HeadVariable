package me.hsgamer.btlp_headvariable.task;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.HashMap;

public class TaskManager {
    private HashMap<ProxiedPlayer, Task> tasks = new HashMap<>();

    public void addPlayer(ProxiedPlayer player) {
        tasks.put(player, new Task(player));
    }

    public void removePlayer(ProxiedPlayer player) {
        tasks.remove(player);
    }

    public Task getTask(ProxiedPlayer player) {
        return tasks.get(player);
    }
}
