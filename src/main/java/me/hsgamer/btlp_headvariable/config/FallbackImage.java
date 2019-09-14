package me.hsgamer.btlp_headvariable.config;

import com.bobacadodl.imgmessage.ImageMessage;
import me.hsgamer.btlp_headvariable.HeadVariable;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;

public class FallbackImage {
    private ImageMessage imageMessage;

    public FallbackImage(HeadVariable plugin) {
        final String FALLBACK_PATH = plugin.getDataFolder() + File.separator + "fallback.png";

        File image = new File(FALLBACK_PATH);

        if (!image.exists()) {
            try (InputStream in = plugin.getResourceAsStream("fallback.png")) {
                Files.copy(in, image.toPath());
            } catch (IOException e) {
                plugin.getLogger().log(Level.FINEST, "Cannot load fallback image");
            }
        }

        try {
            this.imageMessage = new ImageMessage(ImageIO.read(image), 8, HeadVariable.IMAGE_CHAR.getChar());
        } catch (Exception e) {
            plugin.getLogger().warning("Error retrieving fallback image");
        }
    }

    public ImageMessage get() {
        return imageMessage;
    }

}
