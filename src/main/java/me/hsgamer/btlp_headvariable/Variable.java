package me.hsgamer.btlp_headvariable;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Variable extends codecrafter47.bungeetablistplus.api.bungee.Variable {
    private int line;
    Variable(int line) {
        super("head_image_" + line);
        this.line = line;
    }

    @Override
    public String getReplacement(ProxiedPlayer proxiedPlayer) {
        return HeadVariable.getInstance().getTaskManager().getTask(proxiedPlayer).getImageMessage().getLines()[line];
    }
}
