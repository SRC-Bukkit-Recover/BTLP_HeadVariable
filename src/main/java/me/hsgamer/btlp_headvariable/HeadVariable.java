package me.hsgamer.btlp_headvariable;

import codecrafter47.bungeetablistplus.api.bungee.BungeeTabListPlusAPI;
import com.bobacadodl.imgmessage.ImageChar;
import me.hsgamer.btlp_headvariable.config.FallbackImage;
import me.hsgamer.btlp_headvariable.task.TaskManager;
import net.md_5.bungee.api.plugin.Plugin;

public final class HeadVariable extends Plugin {
    private static HeadVariable instance;
    private TaskManager taskManager;

    public static String url;
    public static final ImageChar IMAGE_CHAR = ImageChar.BLOCK;
    public FallbackImage fallbackImage;

    @Override
    public void onEnable() {
        instance = this;

        if (this.getProxy().getConfig().isOnlineMode()) {
            url = "https://minepic.org/avatar/8/%uuid%";
        } else {
            url = "https://minepic.org/avatar/8/%pname%";
        }

        if (!getDataFolder().exists()) getDataFolder().mkdir();
        fallbackImage = new FallbackImage(instance);

        taskManager = new TaskManager();

        getProxy().getPluginManager().registerListener(this, new Listeners());

        for (int i = 0; i <= 7; i++) {
            BungeeTabListPlusAPI.registerVariable(this, new Variable(i));
        }
    }

    @Override
    public void onDisable() {
        instance = null;

        taskManager = null;

        getProxy().getPluginManager().unregisterListeners(this);
    }

    public static HeadVariable getInstance() {
        return instance;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }
}
