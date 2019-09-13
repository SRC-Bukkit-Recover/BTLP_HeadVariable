package me.hsgamer.btlp_headvariable.config;

import me.hsgamer.btlp_headvariable.HeadVariable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;

public class FallbackImage {
    private HeadVariable plugin;
    private File image;

    public FallbackImage(HeadVariable plugin) {
        this.plugin = plugin;

        final String FALLBACK_PATH = plugin.getDataFolder() + File.separator + "fallback.png";

        File image = new File(FALLBACK_PATH);

        if (!image.exists()) {
            try (InputStream in = plugin.getResourceAsStream("fallback.png")) {
                Files.copy(in, image.toPath());
            } catch (IOException e) {
                plugin.getLogger().log(Level.FINEST, "Cannot load fallback image");
            }
        }
    }

    public File get() {
        return image;
    }

}
