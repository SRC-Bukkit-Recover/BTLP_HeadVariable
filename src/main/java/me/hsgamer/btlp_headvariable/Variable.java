package me.hsgamer.btlp_headvariable;

import me.hsgamer.btlp_headvariable.task.Task;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.HashMap;

public class Variable extends codecrafter47.bungeetablistplus.api.bungee.Variable {
    private int line;
    Variable(int line) {
        super("head_image_" + line);
        this.line = line;
    }

    @Override
    public String getReplacement(ProxiedPlayer proxiedPlayer) {
        HashMap<ProxiedPlayer, Task> tasks = HeadVariable.getInstance().getTaskManager().getTasks();
        if (tasks.containsKey(proxiedPlayer)) {
            return tasks.get(proxiedPlayer).getImageMessage().getLines()[line];
        } else {
            return HeadVariable.getInstance().fallbackImage.get().getLines()[line];
        }
    }
}
