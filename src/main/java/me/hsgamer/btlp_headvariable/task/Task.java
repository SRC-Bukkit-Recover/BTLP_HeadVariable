package me.hsgamer.btlp_headvariable.task;

import com.bobacadodl.imgmessage.ImageMessage;
import me.hsgamer.btlp_headvariable.HeadVariable;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.scheduler.ScheduledTask;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private static int imageDimensions = 8;
    private ScheduledTask currentTask;
    private ImageMessage imageMessage;
    private ProxiedPlayer player;
    private HeadVariable instance = HeadVariable.getInstance();

    Task(ProxiedPlayer player) {
        this.player = player;
        imageMessage = instance.fallbackImage.get();
        currentTask = instance.getProxy().getScheduler().schedule(instance, this, 0, 5, TimeUnit.SECONDS);
    }

    @Override
    public void run() {
        if (!player.isConnected()) currentTask.cancel();

        BufferedImage image = getImage(player);
        if (image == null) return;

        this.imageMessage = new ImageMessage(image, imageDimensions, HeadVariable.IMAGE_CHAR.getChar());
    }

    private URL newURL(String uuid, String name) {
        String url = HeadVariable.url
                .replace("%uuid%" , uuid)
                .replace("%pname%", name);

        try {
            return new URL(url);
        } catch (Exception e) { return null; }
    }

    private BufferedImage getImage(ProxiedPlayer player) {
        URL image = newURL(player.getUniqueId().toString(), player.getName());

        if (image != null) {
            try {
                return ImageIO.read(image);
            } catch (Exception e) {
                instance.getLogger().warning("Error retrieving avatar for " + player.getName());
            }
        }

        return null;
    }

    public ImageMessage getImageMessage() {
        return imageMessage;
    }
}
