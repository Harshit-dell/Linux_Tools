package org.example.general;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Validation {
    private Validation() {}

    public static boolean isPresent(String value) {
        return value != null && !value.isBlank();
    }
    public static boolean namePresent(String value) throws IOException {
        if (!isPresent(value)) return false;
        Path baseDir = AppConfig.SECRET_FILE_PATH.getParent();
        if (baseDir != null && !Files.exists(baseDir)){ //here here
            Files.createDirectories(baseDir);
        }

        String input = baseDir+"/"+value.trim();

        if (Path.of(input).isAbsolute()) {
            return fileExists(Path.of(input));
        }
        return fileExists(baseDir.resolve(input));
    }

    private static boolean fileExists(Path path) {
        try {
            return Files.exists(path);
        } catch (Exception e) {
            return false;
        }
    }


    public static void requirePresent(String value, String fieldName) {
        if (!isPresent(value)) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
    }
}
