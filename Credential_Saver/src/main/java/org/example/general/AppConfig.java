package org.example.general;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public final class AppConfig {
    private AppConfig() {}

    public static final Path SECRET_FILE_PATH = loadSecretFilePath();

    private static Path loadSecretFilePath() {
        try (var in = AppConfig.class.getResourceAsStream("/config.properties")) {
            if (in == null) {
                throw new IllegalStateException("config.properties not found");
            }
            var props = new Properties();
            props.load(in);

            String value = props.getProperty("secret.file.path");
            if (value == null || value.isBlank()) {
                throw new IllegalStateException("secret.file.path missing/blank");
            }
            return Path.of(value.trim());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load config.properties", e);
        }
    }
}
